package com.example.bacpacapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDrinkActivity extends AppCompatActivity {
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;
    Button cancelBtn;
    Button addBtn;
    EditText percentAlc;
    EditText ounces;
    EditText numberDrank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_drink);

        cancelBtn = findViewById(R.id.cancelButton2);
        addBtn = findViewById(R.id.AddButton);
        percentAlc = findViewById(R.id.addPercentAlc);
        ounces = findViewById(R.id.addOunces);
        numberDrank = findViewById(R.id.NumberDrank);

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });

        HomeActivity = findViewById(R.id.HomeActivity);
        // initializing animation
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(percentAlc.getText() != null && ounces.getText() != null && numberDrank.getText() != null)
                    addDrink();
                else
                    Toast.makeText(CustomDrinkActivity.this, "Complete All Fields", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void goBack() {
        Intent intent = new Intent(CustomDrinkActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }

    private void addDrink() {
        for(int i = Integer.parseInt(numberDrank.getText().toString()); i != 0; i--){
            bacCalculator.addDrinkToBAC(Float.parseFloat(percentAlc.getText().toString()), Float.parseFloat(ounces.getText().toString()));
        }
        Intent intent = new Intent(CustomDrinkActivity.this , BACActivity.class);
        startActivity(intent);
        finish();
    }
}
