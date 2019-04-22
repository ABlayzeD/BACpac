package com.example.bacpacapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class creates the Splash page
 */
public class SplashActivity extends AppCompatActivity {

    // Declaring animation variables
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        Sets up activity display layout views
         */
        setContentView(R.layout.activity_splash);

        TextView textView = (TextView) findViewById(R.id.BACpacTitle);
        textView.setText("BACpac");

        ImageView SplashImage = findViewById(R.id.SplashImage);
        SplashImage.setImageResource(R.drawable.splash);

        /*
        Controls teh background animation
         */
        HomeActivity = findViewById(R.id.HomeActivity);
        // initializing animation
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

        /*
        Controls the timer for Splash page before transition
         */
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                    goToLogIn();
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Controls the transfer to home page once timer runs out
     */
    private void goToLogIn() {
        Intent intent = new Intent(SplashActivity.this, GLoginActivity.class);
        startActivity(intent);
        finish();
    }

}

