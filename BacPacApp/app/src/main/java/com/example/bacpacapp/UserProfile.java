package com.example.bacpacapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;





public class UserProfile extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    private TextInputEditText weightTV;
    private TextView nameTV;
    private TextView emailTV;
    private TextInputEditText heightTV;
    private TextView bmi;
    private Button calculate;
    private double height, weight, uBMI;

    public UserProfile() {
        weight = 0;
        height = 0;
        uBMI = getBMI();
    }
    public UserProfile(double weight, double height) {
        this.height = height;
        this.weight = weight;
        this.uBMI = getBMI();
    }
    private double calcBMI(double weight, double height) {
        return (703 * (weight / (height * height)));
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight){this.weight = weight;}
    public double getHeight() {
        return height;
    }
    public void setHeight(double height){this.height = height;}
    public double getBMI() {
        return calcBMI(getWeight(), getHeight());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        nameTV = findViewById(R.id.name);
        emailTV = findViewById(R.id.email);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(UserProfile.this);
        if (acct != null){
            String personName= acct.getDisplayName();
            String personEmail = acct.getEmail();
            nameTV.setText("Name: "+personName);
            emailTV.setText("Email: "+personEmail);
        }
        heightTV = findViewById(R.id.h);
        weightTV = findViewById(R.id.w);
        heightTV.setText(String.valueOf(getHeight()));
        weightTV.setText(String.valueOf(getWeight()));
        calculate = findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double heightD = Double.parseDouble(heightTV.getText().toString());
                double weightD = Double.parseDouble(weightTV.getText().toString());
                setWeight(weightD);
                setHeight(heightD);
                bmi = findViewById(R.id.bmi);
                bmi.setText(String.valueOf(getBMI()));
            }
        });
    }
}