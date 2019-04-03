package com.example.bacpacapp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class BeerActivity extends AppCompatActivity {

    private class Drink{
        String name;
        double AlContent;
        double volume=12;
        Drink(String name,double AlContent){
            this.name=name;
            this.AlContent=AlContent;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);



        Button listOfDrinks[]=new Button[4];
        LinearLayout LL = (LinearLayout)findViewById(R.id.buttonlayout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Button cancelButton=findViewById(R.id.cancel3);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });
        ArrayList<Drink> beerList=this.pullBeerFromCSV("./assets/beers.csv");



        for(Drink abeer:beerList) { //should be a while loop
            Button dynamicBeerButton = new Button(this);
            dynamicBeerButton.setText(abeer.name+"|"+abeer.AlContent);
            LL.addView(dynamicBeerButton, params);
        }


    }
    private void cancel() {
        Intent intent = new Intent(BeerActivity.this, DrinksActivity.class);
        startActivity(intent);
        finish();
    }
    private ArrayList<Drink> pullBeerFromCSV(String nameOfFile){
        ArrayList<Drink> DrinkList=new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(nameOfFile));
            CSVReader csvReader = new CSVReader(reader);
            String[] values=csvReader.readNext();
            while((values=csvReader.readNext())  != null) {
                values = csvReader.readNext();
                DrinkList.add(new Drink(values[0], Double.parseDouble(values[1])));
            }
            csvReader.close();
        }catch(IOException e){
            Toast.makeText(BeerActivity.this, "FAILED TO LOAD CSV", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


        return DrinkList;
    }


    }
