package com.example.bacpacapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textView = (TextView) findViewById(R.id.BACpacTitle);
        textView.setText("BACpac");

        ImageView SplashImage = findViewById(R.id.SplashImage);
        SplashImage.setImageResource(R.drawable.splash);

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

