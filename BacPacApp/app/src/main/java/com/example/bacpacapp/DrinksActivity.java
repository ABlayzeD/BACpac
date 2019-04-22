package com.example.bacpacapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class creates the drink activity where the user can select a category
 */
public class DrinksActivity extends AppCompatActivity {
    // Declaring animated background
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;
    Animation buttonAnim;

    // Declaring page buttons and layouts
    TextView DrinkHeader;
    Button cancelBtn;
    Button beerBtn;
    Button wineBtn;
    Button liqBtn;
    Button customBtn;


    /**
     * Creates the Drink Menu activity when loaded
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Sets up the activity layouts and buttons
         */
        setContentView(R.layout.activity_drinks);
        buttonAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        DrinkHeader=findViewById(R.id.DrinksPageHeader);
        DrinkHeader.setText("Pick a drink!");

        /*
         * initializing all buttons in activity
         */
        cancelBtn = findViewById(R.id.CancelButton);
        cancelBtn.setText("Cancel");
        beerBtn = findViewById(R.id.BeerButton);
        beerBtn.setText("Beer");
        wineBtn = findViewById(R.id.WineButton);
        wineBtn.setText("Wine");
        liqBtn = findViewById(R.id.LiqButton);
        liqBtn.setText("Liquor");
        customBtn = findViewById(R.id.CustomButton);
        customBtn.setText("Custom");

        /*
        Controls background animation
         */
        HomeActivity = findViewById(R.id.HomeActivity);
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

        /*
         * all listeners for buttons
         */
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                cancelBtn.startAnimation(buttonAnim);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        goBack();
                    }
                }, 500);
            }
        });
        beerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBeer();
            }
        });
        wineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWine();
            }
        });
        liqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLiq();
            }
        });
        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCustom();
            }
        });
    }

    /**
     * Controls what happens when cancel button is clicked
     */
    private void goBack() {
        Intent intent = new Intent(DrinksActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when beer button is clicked
     */
    private void goToBeer() {
        Intent intent = new Intent(DrinksActivity.this, BeerActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when wine button is clicked
     */
    private void goToWine() {
        Intent intent = new Intent(DrinksActivity.this, WineActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when liquor button is clicked
     */
    private void goToLiq() {
        Intent intent = new Intent(DrinksActivity.this, LiqActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when custom button is clicked
     */
    private void goToCustom() {
        Intent intent = new Intent(DrinksActivity.this, CustomDrinkActivity.class);
        startActivity(intent);
        finish();
    }
}
