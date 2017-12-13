package com.example.carl.testproject;

import android.graphics.Color;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        resultButton = (Button)findViewById(R.id.calcButton);

        resultButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText heelFeed = (EditText)findViewById(R.id.heelFeed);
                EditText batchSize = (EditText)findViewById(R.id.batchSize);
                EditText targetConc = (EditText)findViewById(R.id.targetConc);
                EditText otConc = (EditText)findViewById(R.id.otConc);

                TextView resultText = (TextView)findViewById(R.id.resultText);

                TextView heelFeedLabel = (TextView)findViewById(R.id.heelFeedLabel);
                TextView batchSizeLabel = (TextView)findViewById(R.id.batchSizeLabel);
                TextView targetConcLabel = (TextView)findViewById(R.id.targetConcLabel);
                TextView otConcLabel = (TextView)findViewById(R.id.otConcLabel);
                TextView errorLabel = (TextView)findViewById(R.id.errorLabel);

                String heelFeedText = heelFeed.getText().toString();
                String batchSizeText = batchSize.getText().toString();
                String targetConcText = targetConc.getText().toString();
                String otConcTect = otConc.getText().toString();

                DecimalFormat fmt = new DecimalFormat("###,###.####");

                double result;



                try
                {
                    Double valHeelFeed = Double.valueOf(heelFeedText);

                    try
                    {
                        heelFeedLabel.setTextColor(Color.BLACK);
                        Double valBatchSize = Double.valueOf(batchSizeText);

                        try
                        {
                            batchSizeLabel.setTextColor(Color.BLACK);
                            Double valTargetConc = Double.valueOf(targetConcText);

                            try
                            {
                                targetConcLabel.setTextColor(Color.BLACK);
                                Double valOTConc = Double.valueOf(otConcTect);

                                otConcLabel.setTextColor(Color.BLACK);
                                errorLabel.setVisibility(View.INVISIBLE);

                                result = ((valBatchSize.doubleValue() - valHeelFeed.doubleValue()) * valTargetConc) / valOTConc.doubleValue();
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
                            targetConcLabel.setTextColor(Color.RED);
                            errorLabel.setVisibility(View.VISIBLE);
                        }
                    }
                    catch(Exception ex)
                    {
                        errorLabel.setText("Please enter a value for the item(s) in red.");
                        batchSizeLabel.setTextColor(Color.RED);
                        errorLabel.setVisibility(View.VISIBLE);
                    }
                }
                catch(Exception ex)
                {
                    errorLabel.setText("Please enter a value for the item(s) in red.");
                    heelFeedLabel.setTextColor(Color.RED);
                    errorLabel.setVisibility(View.VISIBLE);
                }


            }


        });
    }
}
