package com.example.carl.testproject;

import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SCGActivity extends AppCompatActivity {

    private Button resultButton;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultButton = (Button)findViewById(R.id.resultButton);

        resultButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText targetConc = (EditText)findViewById(R.id.targetConc);
                EditText actualConc = (EditText)findViewById(R.id.actualConc);
                EditText tankVolume = (EditText)findViewById(R.id.tankVolume);
                EditText otConc = (EditText)findViewById(R.id.otConc);

                TextView resultText = (TextView)findViewById(R.id.resultText);

                TextView targetConcLabel = (TextView)findViewById(R.id.targetConcLabel);
                TextView actualConcLabel = (TextView)findViewById(R.id.actualConcLabel);
                TextView tankVolumeLabel = (TextView)findViewById(R.id.tankVolumeLabel);
                TextView otConcLabel = (TextView)findViewById(R.id.otConcLabel);
                TextView errorLabel = (TextView)findViewById(R.id.errorLabel);

                String targetConcText = targetConc.getText().toString();
                String actualConcText = actualConc.getText().toString();
                String tankVolumeText = tankVolume.getText().toString();
                String otConcTect = otConc.getText().toString();

                DecimalFormat fmt = new DecimalFormat("###,###.####");

                double result;



                try
                {
                    Double valTargetConc = Double.valueOf(targetConcText);

                    try
                    {
                        targetConcLabel.setTextColor(Color.BLACK);
                        Double valActualConc = Double.valueOf(actualConcText);

                        try
                        {
                            actualConcLabel.setTextColor(Color.BLACK);
                            Double valTankVolume = Double.valueOf(tankVolumeText);

                            try
                            {
                                tankVolumeLabel.setTextColor(Color.BLACK);
                                Double valOTConc = Double.valueOf(otConcTect);

                                otConcLabel.setTextColor(Color.BLACK);
                                errorLabel.setVisibility(View.INVISIBLE);

                                result = ((valTargetConc - valActualConc)*valTankVolume) / (valOTConc - valTargetConc);
                                //Double finalResult = new Double(result);
                                resultText.setText(fmt.format(result));

                            }
                            catch(ArithmeticException ex)
                            {
                                errorLabel.setVisibility(View.VISIBLE);
                                errorLabel.setText("Calculation Error.");
                            }
                            catch(Exception ex)
                            {
                                errorLabel.setText("Please enter a value for the item(s) in red.");
                                otConcLabel.setTextColor(Color.RED);
                                errorLabel.setVisibility(View.VISIBLE);
                            }
                        }
                        catch(Exception ex)
                        {
                            errorLabel.setText("Please enter a value for the item(s) in red.");
                            tankVolumeLabel.setTextColor(Color.RED);
                            errorLabel.setVisibility(View.VISIBLE);
                        }
                    }
                    catch(Exception ex)
                    {
                        errorLabel.setText("Please enter a value for the item(s) in red.");
                        actualConcLabel.setTextColor(Color.RED);
                        errorLabel.setVisibility(View.VISIBLE);
                    }
                }
                catch(Exception ex)
                {
                    errorLabel.setText("Please enter a value for the item(s) in red.");
                    targetConcLabel.setTextColor(Color.RED);
                    errorLabel.setVisibility(View.VISIBLE);
                }


            }


        });

    }
}
