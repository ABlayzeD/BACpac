package com.example.bacpacapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BACActivity extends AppCompatActivity {

    TextView timerDisplay;
    TextView BACDisplay;
    String timerVal;
    Button profile;
    Button addDrink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);
        timerDisplay = findViewById(R.id.TimeLeftDisplay);
        BACDisplay = findViewById(R.id.BACDisplay);
        timerVal = "0:00";
        setTimerDisplay();
        BACDisplay.setText(String.format("%.2f", bacCalculator.getBAC()));
        timerDisplay.setText(timerVal);
        profile = findViewById(R.id.ProfileButton);
        addDrink = findViewById(R.id.AddDrinkButton);

        addDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDrinks();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
            }
        });

    }


    /**
     * This is the countdown timer for the time left till BAC = 0. It is called from the addDrinktoBAC
     * method so that it starts the timer each time a drink is added by the user.
     */

    public String setTimerDisplay(){
        CountDownTimer : new CountDownTimer(bacCalculator.getTimeLeft()  * 60000,1000) {
            @Override
            public void onTick(long millisInFuture) {
                timerVal = Long.toString(millisInFuture/60000) + Long.toString(millisInFuture/1000);
                if((millisInFuture/1000) % 5 == 0)
                    bacCalculator.addFiveMinutes();
            }

            @Override
            public void onFinish() {
                bacCalculator.resetBAC();
                timerVal = "Congrats You Are Sober!!";
            }
        };
        return timerVal;
    }

    private void goToDrinks() {
        Intent intent = new Intent(BACActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToProfile() {
        Intent intent = new Intent(BACActivity.this, ProfileActivity.class);
        startActivity(intent);
        finish();
    }
}
