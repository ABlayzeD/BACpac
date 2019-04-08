package com.example.bacpacapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import java.util.ArrayList;

public class BeerActivity extends AppCompatActivity {

    Button[] drinkButtonList;
    int counter;
    Button cancelButton;
    LinearLayout LL;
    ArrayList<Drink> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    private void cancel() {
        Intent intent = new Intent(BeerActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }
    private void userDrank() {
        Intent intent = new Intent(BeerActivity.this, BACActivity.class);
        startActivity(intent);
        finish();
    }

}
