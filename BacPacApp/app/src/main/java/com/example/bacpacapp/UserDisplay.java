package com.example.bacpacapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class UserDisplay extends AppCompatActivity{
    ConstraintLayout HomeActivity;
    AnimationDrawable defaultBackground;
    Animation buttonAnim;
    GoogleSignInClient mGoogleSignInClient;
    private TextInputEditText weightTV;
    private TextView nameTV;
    private TextInputEditText heightTV;
    private TextView bmi;
    private Button calculate;
    UserProfile user = new UserProfile(UserProfile.weight,UserProfile.height);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        final Button cancelButton=findViewById(R.id.cancel4);
        cancelButton.setText("Back");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                cancelButton.startAnimation(buttonAnim);
                handler.postDelayed(new Runnable() {
                    public void run() {
                        cancel();
                    }
                }, 100);
            }
        });
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        nameTV = findViewById(R.id.name);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(UserDisplay.this);
        if (acct != null){
            String personName= acct.getDisplayName();
            nameTV.setText("Name: "+personName);
        }

        HomeActivity = findViewById(R.id.HomeActivity);
        buttonAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        // initializing animation
        defaultBackground = (AnimationDrawable) HomeActivity.getBackground();
        HomeActivity.setBackground(defaultBackground);
        // enter fade animation duration 5 seconds
        defaultBackground.setEnterFadeDuration(5000);
        // exit fade animation duration 1 second
        defaultBackground.setExitFadeDuration(1000);

        heightTV = findViewById(R.id.h);
        weightTV = findViewById(R.id.w);
        calculate = findViewById(R.id.calc);
        //bmi.setText(String.valueOf(user.getBMI()));
        heightTV.setText(String.valueOf(user.getHeight()));
        weightTV.setText(String.valueOf(user.getWeight()));
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double heightD = Double.parseDouble(heightTV.getText().toString());
                double weightD = Double.parseDouble(weightTV.getText().toString());
                user.setWeight(weightD);
                user.setHeight(heightD);
                bmi = findViewById(R.id.bmi);
                bmi.setText(String.valueOf(user.getBMI()));
                heightTV.setText(String.valueOf(user.getHeight()));
                weightTV.setText(String.valueOf(user.getWeight()));

            }
        });
    }
    private void cancel() {
        Intent intent = new Intent(UserDisplay.this, BACActivity.class);
        startActivity(intent);
        finish();
    }
}
