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
    private TextInputEditText w;
    private TextView nameTV;
    private TextView emailTV;
    private TextInputEditText h;
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
        return (703 * (weight / (height * height)));
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

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
        //nameTV = findViewById(R.id.name);
        emailTV = findViewById(R.id.email);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(UserProfile.this);
        if (acct != null){
            String personName= acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            nameTV.setText("Name: "+personName);
            emailTV.setText("Email: "+personEmail);
        }
        calculate = findViewById(R.id.calc);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = findViewById(R.id.h);
                w = findViewById(R.id.w);
                String he = h.getText().toString();
                String we = w.getText().toString();

                if (!he.isEmpty()) {
                    if (!we.isEmpty()) {
                        {
                            double hei = Double.parseDouble(he);
                            double wei = Double.parseDouble(we);
                            UserProfile user = new UserProfile(wei, hei);
                            bmi = findViewById(R.id.bmi);
                            bmi.setText(String.valueOf(user.getBMI()));

                        }
                    }
                }
            }
        });

    }
}