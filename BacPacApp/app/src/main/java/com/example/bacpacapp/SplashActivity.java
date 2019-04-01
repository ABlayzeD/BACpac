package com.example.bacpacapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView textView = (TextView) findViewById(R.id.BACpacTitle);
        textView.setText("BACpac");
        ImageButton splashButton = findViewById(R.id.splashButton);
        splashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToLogIn();

            }


        });
    }
    private void goToLogIn() {
        Intent intent = new Intent(SplashActivity.this, GLoginActivity.class);
        startActivity(intent);
        finish();
    }

}

