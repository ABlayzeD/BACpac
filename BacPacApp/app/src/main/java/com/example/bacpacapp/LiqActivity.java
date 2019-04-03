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

        ArrayList<Drink> drinkList=DrinksReader.pullDrinkFromCSV(LiqActivity.this, "liquors.csv");

        for(Drink adrink:drinkList) { //should be a while loop
            Button dynamicDrinkButton = new Button(this);
            dynamicDrinkButton.setText(adrink.name+"|"+adrink.AlContent);
            LL.addView(dynamicDrinkButton, params);
        }

        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });
    }
    private void cancel() {
        Intent intent = new Intent(LiqActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }
}
