package com.example.bacpacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrinksActivity extends AppCompatActivity {

    Button cancelBtn;
    Button beerBtn;
    Button wineBtn;
    Button liqBtn;
    Button customBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        /**
         * initializing all buttons in activity
         */
        cancelBtn = findViewById(R.id.CancelButton);
        beerBtn = findViewById(R.id.BeerButton);
        wineBtn = findViewById(R.id.WineButton);
        liqBtn = findViewById(R.id.LiqButton);
        customBtn = findViewById(R.id.CustomButton);

        /**
         * all listeners for buttons
         */
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
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

    private void goBack() {
        Intent intent = new Intent(DrinksActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToBeer() {
        Intent intent = new Intent(DrinksActivity.this, BeerActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToWine() {
        Intent intent = new Intent(DrinksActivity.this, WineActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToLiq() {
        Intent intent = new Intent(DrinksActivity.this, LiqActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToCustom() {
        Intent intent = new Intent(DrinksActivity.this, CustomDrinkActivity.class);
        startActivity(intent);
        finish();
    }
}
