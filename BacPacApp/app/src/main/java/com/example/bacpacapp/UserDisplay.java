package com.example.bacpacapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.io.FileOutputStream;
import java.io.IOException;

public class UserDisplay extends AppCompatActivity{
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
        Button cancelButton=findViewById(R.id.cancel4);
        cancelButton.setText("Back");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
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
