package com.example.bacpac;

import android.nfc.Tag;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserProfile extends AppCompatActivity {
    private TextInputEditText w;
    private TextInputEditText h;
    private TextView bmi;
    private Button calculate;
    private double height, weight;
    public UserProfile(){
        weight = 170;
        height = 68;
    }
    public UserProfile(double weight, double height){
        this.height = height;
        this.weight = weight;
    }
    private double calcBMI(double weight, double height){
        return(703*(weight/(height*height)));
    }
    public double getWeight(){
        return weight;
    }
    public double getHeight(){
        return height;
    }
    public double getBMI(){
        return calcBMI(getWeight(),getHeight());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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