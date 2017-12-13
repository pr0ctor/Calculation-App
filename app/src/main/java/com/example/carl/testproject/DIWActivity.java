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

public class DIWActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_diw);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultButton = (Button)findViewById(R.id.resultButton);

        resultButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText actualConc = (EditText)findViewById(R.id.actualConc);
                EditText targetConc = (EditText)findViewById(R.id.targetConc);
                EditText tankVolume = (EditText)findViewById(R.id.tankVolume);

                TextView resultText = (TextView)findViewById(R.id.resultText);

                TextView actualConcLabel = (TextView)findViewById(R.id.actualConcLabel);
                TextView targetConcLabel = (TextView)findViewById(R.id.targetConcLabel);
                TextView tankVolumeLabel = (TextView)findViewById(R.id.tankVolumeLabel);

                TextView errorLabel = (TextView)findViewById(R.id.errorLabel);

                String actualConcText = actualConc.getText().toString(); //heelFeedText
                String targetConcText = targetConc.getText().toString();  //batchSizeText
                String tankVolumeText = tankVolume.getText().toString(); //targetConcText


                DecimalFormat fmt = new DecimalFormat("###,###.####");

                double result;

                try
                {
                    Double valActualConc = Double.valueOf(actualConcText);

                    try
                    {
                        actualConcLabel.setTextColor(Color.BLACK);

                        Double valTargetConc = Double.valueOf(targetConcText);

                        try
                        {
                            targetConcLabel.setTextColor(Color.BLACK);
                            Double valtankVolume = Double.valueOf(tankVolumeText);

                            tankVolumeLabel.setTextColor(Color.BLACK);
                            errorLabel.setVisibility(View.INVISIBLE);

                            result = ((valActualConc -valTargetConc)*valtankVolume) / (valTargetConc);
                            //Double finalResult = new Double(result);
                            resultText.setText(fmt.format(result));

                        }
                        catch(ArithmeticException ex)
                        {
                            errorLabel.setVisibility(View.VISIBLE);
                            errorLabel.setText("Calculation Error.");
                        }
                        catch(Exception ex) {
                            errorLabel.setText("Please enter a value for the item(s) in red.");
                            tankVolumeLabel.setTextColor(Color.RED);
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
                 catch(Exception ex)
                {
                    errorLabel.setText("Please enter a value for the item(s) in red.");
                    actualConcLabel.setTextColor(Color.RED);
                    errorLabel.setVisibility(View.VISIBLE);
                }


            }


        });
    }
}
