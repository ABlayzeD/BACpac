package com.example.bacpacapp;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textView = (TextView) findViewById(R.id.BACpacTitle);
        textView.setText("BACpac");

        ImageView SplashImage = findViewById(R.id.SplashImage);
        SplashImage.setImageResource(R.drawable.splash);

        HomeActivity = findViewById(R.id.HomeActivity);
        // initializing animation
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

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
    private void goToLogIn() {
        Intent intent = new Intent(SplashActivity.this, GLoginActivity.class);
        startActivity(intent);
        finish();
    }

}

