package com.example.bacpacapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;

/**
 * This class creates the beer activity where the user can select a beer of choice
 */
public class BeerActivity extends AppCompatActivity {
    // Declaring animated background
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;

    // Declaring page buttons and layouts
    Button[] drinkButtonList;
    Button cancelButton;
    LinearLayout LL;

    // Declaring wine array
    ArrayList<Drink> drinkList;

    // Declaring other variables
    int counter;

    /**
     * Creates the beer activity when loaded
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Sets up the activity layouts and buttons
         */
        setContentView(R.layout.activity_beer);
        LL = findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        cancelButton = findViewById(R.id.cancel3);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
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
        Generates the beer list for display and selection
         */
        drinkList = DrinksReader.pullDrinkFromCSV(BeerActivity.this, "Beers.csv");
        drinkButtonList=new Button[drinkList.size()];
        counter=0;
        for (Drink adrink : drinkList) {
            final float AlContent=adrink.AlContent;
            drinkButtonList[counter] = new Button(this);
            String buttonText=adrink.name + "|" + String.format("%.2f",adrink.AlContent);
            drinkButtonList[counter].setText(buttonText);
            LL.addView(drinkButtonList[counter], params);
            drinkButtonList[counter].setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bacCalculator.addDrinkToBAC(AlContent, Drink.getVolume());
                    userDrank();
            }
            }));
            counter++;
        }
    }

    /**
     * Controls what happens when user selects cancel
     */
    private void cancel() {
        Intent intent = new Intent(BeerActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when user selects a beer
     */
    private void userDrank() {
        Intent intent = new Intent(BeerActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }

}
