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
    private TextInputEditText heightTV;
    private TextView bmi;
    private Button calculate;
    private double height, weight;

    public UserProfile() {
        weight = 170;
        height = 68;
    }
    public UserProfile(double weight, double height) {
        this.height = height;
        this.weight = weight;
    }
    private double calcBMI(double weight, double height) {
        return  (703 * (weight / (height * height)));
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight){this.weight = weight;}
    public double getHeight() {
        return height;
    }
    public void setHeight(double height){this.height = height;}
    public float getBMI() {
        return (float) calcBMI(getWeight(), getHeight());
    }@Override
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
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(UserProfile.this);
        if (acct != null){
            String personName= acct.getDisplayName();
            nameTV.setText("Name: "+personName);
        }
        heightTV = findViewById(R.id.h);
        weightTV = findViewById(R.id.w);
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
                heightTV.setText(String.valueOf(height));
                weightTV.setText(String.valueOf(weight));
            }
        });
    }
    private void cancel() {
        Intent intent = new Intent(UserProfile.this, BACActivity.class);
        startActivity(intent);
        finish();
    }
}