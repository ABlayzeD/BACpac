package com.example.bacpacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDrinkActivity extends AppCompatActivity {
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

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(percentAlc != null && ounces != null && numberDrank != null)
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
            bacCalculator.addDrinkToBAC(Double.parseDouble(percentAlc.getText().toString()), Double.parseDouble(ounces.getText().toString()));
        }
        Intent intent = new Intent(CustomDrinkActivity.this , DrinksActivity.class);
        startActivity(intent);
        finish();
    }
}
