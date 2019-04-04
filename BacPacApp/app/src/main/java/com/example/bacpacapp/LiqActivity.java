package com.example.bacpacapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class LiqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liq);
        LinearLayout LL = (LinearLayout) findViewById(R.id.buttonlayout2);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

        ArrayList<Drink> drinkList=DrinksReader.pullDrinkFromCSV(LiqActivity.this, "Liquors.csv");
        Button[] drinkButtonList=new Button[drinkList.size()];
        int counter=0;
        for (final Drink adrink : drinkList) {
            drinkButtonList[counter]= new Button(this);
            drinkButtonList[counter].setText(adrink.name + "|" + adrink.AlContent);
            drinkButtonList[counter].setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bacCalculator.addDrinkToBAC(adrink.getAlContent(), Drink.getVolume() - 10);
                    userDrank();
                }
            }));
            LL.addView(drinkButtonList[counter], params);
            counter++;
        }
    }
    private void userDrank() {
        Intent intent = new Intent(LiqActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }
    private void cancel() {
        Intent intent = new Intent(LiqActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }
}
