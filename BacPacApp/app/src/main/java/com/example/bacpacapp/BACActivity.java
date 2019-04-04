package com.example.bacpacapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BACActivity extends AppCompatActivity {

    EditText timerDisplay;
    EditText BACDisplay;
    String timerVal = "0:00";
    Button profile;
    Button addDrink;
    Button refresh;
    bacCalculator BAC;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);
        TextView BACHeader=findViewById(R.id.BACHeader);
        BACHeader.setText("Current BAC");

        TextView TimeHeader=findViewById(R.id.TimeHeader);
        TimeHeader.setText("Time Left Till Sober:");

        timerDisplay = findViewById(R.id.TimeLeftDisplay);
        timerDisplay.setText(timerVal);

        BACDisplay = findViewById(R.id.BACDisplay);
        BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));

        profile = findViewById(R.id.ProfileButton);
        profile.setText("Profile");
        addDrink = findViewById(R.id.AddDrinkButton);
        addDrink.setText("+Drink");
        refresh = findViewById(R.id.refreshButton);
        refresh.setText("Refresh");

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

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refresh();
            }
        });

        if(bacCalculator.getBAC() > 0) {
            new CountDownTimer(bacCalculator.getTimeLeft(), 1000) {
                @Override
                public void onTick(long millisInFuture) {
                    int hour = (int) (millisInFuture / 3600000);
                    int min = (int) ((millisInFuture - (3600000 * hour)) / 60000);
                    int secs = (int) (((millisInFuture - (3600000 * hour) )- (60000 * min))/ 1000);
                    timerVal = hour + ":" + min + ":" + secs;
                    timerDisplay.setText(timerVal);
                    BACDisplay = findViewById(R.id.BACDisplay);
                    BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));
                    if ((millisInFuture / 1000) % 5 == 0)
                        bacCalculator.addFiveMinutes();
                }

                @Override
                public void onFinish() {
                    bacCalculator.resetBAC();
                    timerVal = "Congrats You Are Sober!!";
                    BACDisplay = findViewById(R.id.BACDisplay);
                    BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));
                    timerDisplay.setText(timerVal);
                }
            }.start();
        }

    }


    /**
     * This is the countdown timer for the time left till BAC = 0. It is called from the addDrinktoBAC
     * method so that it starts the timer each time a drink is added by the user.
     */


    private void goToDrinks() {
        Intent intent = new Intent(BACActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToProfile() {
        Intent intent = new Intent(BACActivity.this, UserProfile.class);
        startActivity(intent);
        finish();
    }

    private void refresh() {
        Intent intent = new Intent(BACActivity.this, BACActivity.class);
        startActivity(intent);
    }
}
