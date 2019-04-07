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





public class UserProfile {

    static  double height, weight;

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
    }

}