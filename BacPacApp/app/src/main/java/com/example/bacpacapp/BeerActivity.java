package com.example.bacpacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class BeerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        LinearLayout LL = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button cancelButton=findViewById(R.id.cancel3);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        ArrayList<Drink> drinkList=DrinksReader.pullDrinkFromCSV(BeerActivity.this,"beers.csv");

        for(Drink adrink:drinkList) {
            Button dynamicDrinkButton = new Button(this);
            dynamicDrinkButton.setText(adrink.name+"|"+adrink.AlContent);
            LL.addView(dynamicDrinkButton, params);
        }
    }
    private void cancel() {
        Intent intent = new Intent(BeerActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }



    }
