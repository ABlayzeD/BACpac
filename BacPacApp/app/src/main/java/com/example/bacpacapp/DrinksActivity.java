package com.example.bacpacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DrinksActivity extends AppCompatActivity {
    TextView DrinkHeader;
    Button cancelBtn;
    Button beerBtn;
    Button wineBtn;
    Button liqBtn;
    Button customBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        DrinkHeader=findViewById(R.id.DrinksPageHeader);
        DrinkHeader.setText("Pick a drink!");
        /**
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
