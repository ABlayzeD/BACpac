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

/**
 * This class creates the Custom Drink activity where the user can select a custom drink
 */
public class CustomDrinkActivity extends AppCompatActivity {
    // Declaring animated background
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;

    // Declaring page buttons and layouts
    Button cancelBtn;
    Button addBtn;
    EditText percentAlc;
    EditText ounces;
    EditText numberDrank;


    /**
     * Creates the Custom Drink activity when loaded
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Sets up the activity layouts and buttons
         */
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

        /*
        Controls background animation
         */
        HomeActivity = findViewById(R.id.HomeActivity);
        // initializing animation
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

        /*
        Sets up button listeners
         */
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

    /**
     * Controls what happens when cancel button is clicked
     */
    private void goBack() {
        Intent intent = new Intent(CustomDrinkActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when add button is clicked
     */
    private void addDrink() {
        for(int i = Integer.parseInt(numberDrank.getText().toString()); i != 0; i--){
            bacCalculator.addDrinkToBAC(Float.parseFloat(percentAlc.getText().toString()), Float.parseFloat(ounces.getText().toString()));
        }
        Intent intent = new Intent(CustomDrinkActivity.this , BACActivity.class);
        startActivity(intent);
        finish();
    }
}
