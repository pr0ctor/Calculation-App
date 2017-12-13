package com.example.carl.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class selectionActivity extends AppCompatActivity {

    private TextView sizingToAdd, diwText, scgText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        sizingToAdd = (TextView)findViewById(R.id.sizingToAdd);

        sizingToAdd.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(selectionActivity.this, MainActivity.class);
                startActivity(intent);

            }

        }
        );

        diwText = (TextView)findViewById(R.id.diwText);

        diwText.setOnClickListener( new View.OnClickListener(){

                                        @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(selectionActivity.this, DIWActivity.class);
                startActivity(intent);

            }

        }
        );

        scgText = (TextView)findViewById(R.id.scgText);

        scgText.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(selectionActivity.this, SCGActivity.class);
                startActivity(intent);

            }

        }
        );








    }
}
