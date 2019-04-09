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

public class BACActivity extends AppCompatActivity {
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;
    Animation buttonAnim;
    EditText timerDisplay;
    EditText BACDisplay;
    String timerVal = "0:00";
    Button profile;
    Button addDrink;
    Button refresh;
    bacCalculator BAC;
    TextView warnerText;
    RideRequestButton uberButton;
    Animation buttonAnim2;
    Animation buttonAnim3;
    long secsPassed = 0;



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


        buttonAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        buttonAnim2 = AnimationUtils.loadAnimation(BACActivity.this, R.anim.fadein);
        buttonAnim3 = AnimationUtils.loadAnimation(BACActivity.this, R.anim.fadein);

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

            /**
             * This is the countdown timer for the time left till BAC = 0. It is called from the addDrinktoBAC
             * method so that it starts the timer each time a drink is added by the user.
             */
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

    protected void onResume() {
        super.onResume();
        if (defaultBackground != null && !defaultBackground.isRunning()) {
            // start the animation
            defaultBackground.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (defaultBackground != null && defaultBackground.isRunning()) {
            // stop the animation
            defaultBackground.stop();
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
