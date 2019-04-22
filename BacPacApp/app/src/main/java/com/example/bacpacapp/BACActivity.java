package com.example.bacpacapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.android.rides.RideRequestButton;
import com.uber.sdk.core.client.SessionConfiguration;

import java.util.concurrent.TimeUnit;

/**
 * This class creates the Home activity where the user can view their current BAC and time left
 * And the user can navigate to the user profile and drink page
 */
public class BACActivity extends AppCompatActivity {
    // Declaring animated aspects
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;
    Animation buttonAnim;
    Animation buttonAnim2;
    Animation buttonAnim3;

    // Declaring page buttons and layouts
    EditText timerDisplay;
    EditText BACDisplay;
    String timerVal = "0:00";
    Button profile;
    Button addDrink;
    Button refresh;
    bacCalculator BAC;
    TextView warnerText;
    RideRequestButton uberButton;

    // Declaring other variables
    long secsPassed = 0;

    /**
     * Creates the home/BAC activity when loaded
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        Sets up the activity layouts and buttons
         */
        setContentView(R.layout.activity_bac);
        TextView BACHeader = findViewById(R.id.BACHeader);
        BACHeader.setText("Current BAC");

        /*
        Sets up Uber
         */
        SessionConfiguration config = new SessionConfiguration.Builder()
                // mandatory
                .setClientId("T22JNnaxpssR4mBOu4sglqRdI9UXByGX")
                // required for enhanced button features
                .setServerToken("xvutZjeuFfA8gvcWfp5sLoDxw622MVVrzzcq78KL")
                .build();
        UberSdk.initialize(config);


        /*
        Controls Button animations
         */
        buttonAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttonAnim2 = AnimationUtils.loadAnimation(BACActivity.this, R.anim.fadein);
        buttonAnim3 = AnimationUtils.loadAnimation(BACActivity.this, R.anim.fadein);

        /*
        Controls background animation
         */
        HomeActivity = findViewById(R.id.HomeActivity);
        warnerText = findViewById(R.id.Warner);
        uberButton = findViewById(R.id.uberButton);
        uberButton.setVisibility(View.INVISIBLE);
        warnerText.setText("Going somewhere?");
        warnerText.setVisibility(View.INVISIBLE);
        // initializing animation
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

        /*
        Initializes display views
         */
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


        /*
        Sets up listeners
         */
        addDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                addDrink.startAnimation(buttonAnim);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        goToDrinks();
                    }
                }, 100);

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                profile.startAnimation(buttonAnim);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        goToProfile();
                    }
                }, 100);

            }
        });


        /*
        Sets up the timer to update when BAC is updated and makes the Uber button visible
         */
        if (bacCalculator.getBAC() > 0) {
            warnerText.setVisibility(View.VISIBLE);
            warnerText.startAnimation(buttonAnim2);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    uberButton.setVisibility(View.VISIBLE);
                    uberButton.startAnimation(buttonAnim3);
                }
            }, 3000);

            new CountDownTimer(bacCalculator.getTimeLeft(), 1000) {
                @Override
                public void onTick(long millisInFuture) {
                    long hour = TimeUnit.MILLISECONDS.toHours(millisInFuture);
                    long min = TimeUnit.MILLISECONDS.toMinutes(millisInFuture) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisInFuture));
                    long secs = TimeUnit.MILLISECONDS.toSeconds(millisInFuture) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisInFuture));
                    timerVal = hour + ":" + min + ":" + secs;
                    timerDisplay.setText(timerVal);
                    //BACDisplay = findViewById(R.id.BACDisplay);
                    bacCalculator.updateBAC();
                    BACDisplay.setText(String.format("%.3f", bacCalculator.getBAC()));
                    bacCalculator.addMinutes(secsPassed);
                    secsPassed++;
                }

                @Override
                public void onFinish() {
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

    /*
    Restarts animation on resume
     */
    protected void onResume() {
        super.onResume();
        if (defaultBackground != null && !defaultBackground.isRunning()) {
            // start the animation
            defaultBackground.start();
        }

    }

    /*
    Pauses animation when activity is left
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (defaultBackground != null && defaultBackground.isRunning()) {
            // stop the animation
            defaultBackground.stop();
        }
    }


    /**
     * Controls what happens when user selects +Drink
     */
    private void goToDrinks() {
        Intent intent = new Intent(BACActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Controls what happens when user selects Profile
     */
    private void goToProfile() {
            Intent intent = new Intent(BACActivity.this, UserDisplay.class);
            startActivity(intent);
            finish();
    }

}
