package com.example.bacpacapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.core.client.SessionConfiguration;

public class BACActivity extends AppCompatActivity {
    ConstraintLayout HomeActivity;
    AnimationDrawable geauxTigers;
    EditText timerDisplay;
    EditText BACDisplay;
    String timerVal = "0:00";
    Button profile;
    Button addDrink;
    Button refresh;
    bacCalculator BAC;
    TextView warnerText;
    RideRequestButton uberButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bac);
        TextView BACHeader = findViewById(R.id.BACHeader);
        BACHeader.setText("Current BAC");

        SessionConfiguration config = new SessionConfiguration.Builder()
                // mandatory
                .setClientId("T22JNnaxpssR4mBOu4sglqRdI9UXByGX")
                // required for enhanced button features
                .setServerToken("xvutZjeuFfA8gvcWfp5sLoDxw622MVVrzzcq78KL")
                .build();
        UberSdk.initialize(config);



        HomeActivity = findViewById(R.id.HomeActivity);

        warnerText = findViewById(R.id.Warner);
        uberButton = findViewById(R.id.uberButton);
        uberButton.setVisibility(View.INVISIBLE);
        warnerText.setText("Going somewhere?");
        warnerText.setVisibility(View.INVISIBLE);
        // initializing animation
        geauxTigers = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(null);
        // enter fade animation duration 5 seconds
        geauxTigers.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        geauxTigers.setExitFadeDuration(1000);

        TextView TimeHeader = findViewById(R.id.TimeHeader);
        TimeHeader.setText("Time Left Till Sober:");

        timerDisplay = findViewById(R.id.TimeLeftDisplay);
        timerDisplay.setText(timerVal);

        BACDisplay = findViewById(R.id.BACDisplay);
        BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));

        profile = findViewById(R.id.ProfileButton);
        profile.setText("Profile");
        addDrink = findViewById(R.id.AddDrinkButton);
        addDrink.setText("+Drink");


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


        if (bacCalculator.getBAC() > 0) {
            HomeActivity.setBackground(geauxTigers);;
            uberButton.setVisibility(View.VISIBLE);
            warnerText.setVisibility(View.VISIBLE);
            /**
             * This is the countdown timer for the time left till BAC = 0. It is called from the addDrinktoBAC
             * method so that it starts the timer each time a drink is added by the user.
             */
            new CountDownTimer(bacCalculator.getTimeLeft(), 1000) {
                @Override
                public void onTick(long millisInFuture) {
                    int hour = (int) (millisInFuture / 3600000);
                    int min = (int) ((millisInFuture - (3600000 * hour)) / 60000);
                    int secs = (int) (((millisInFuture - (3600000 * hour)) - (60000 * min)) / 1000);
                    timerVal = hour + ":" + min + ":" + secs;
                    timerDisplay.setText(timerVal);
                    BACDisplay = findViewById(R.id.BACDisplay);
                    BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));
                    if ((millisInFuture / 60000) % 5 == 0)
                        bacCalculator.addFiveMinutes();
                }

                @Override
                public void onFinish() {
                    HomeActivity.setBackground(null);
                    uberButton.setVisibility(View.INVISIBLE);
                    warnerText.setVisibility(View.INVISIBLE);
                    bacCalculator.resetBAC();
                    timerVal = "Congrats You Are Sober!!";
                    BACDisplay = findViewById(R.id.BACDisplay);
                    BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));
                    timerDisplay.setText(timerVal);
                }
            }.start();
        }

    }
    protected void onResume() {
        super.onResume();
        if (geauxTigers != null && !geauxTigers.isRunning()) {
            // start the animation
            geauxTigers.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (geauxTigers != null && geauxTigers.isRunning()) {
            // stop the animation
            geauxTigers.stop();
        }
    }


    private void goToDrinks() {
        Intent intent = new Intent(BACActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToProfile() {
        Intent intent = new Intent(BACActivity.this, UserDisplay.class);
        startActivity(intent);
        finish();
    }

}
