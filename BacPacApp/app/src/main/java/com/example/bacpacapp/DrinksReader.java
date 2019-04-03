package com.example.bacpacapp;

import android.content.Context;
import android.widget.Toast;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

class DrinksReader {

    static protected ArrayList<Drink> pullDrinkFromCSV(Context activity, String nameOfFile){
        ArrayList<Drink> DrinkList=new ArrayList<>();
        try {
            Reader reader = new InputStreamReader(activity.getAssets().open(nameOfFile));
            CSVReader csvReader = new CSVReader(reader,',','/',1);
            String[] values;
            while((values=csvReader.readNext())  != null) {
                    values = csvReader.readNext();
                    DrinkList.add(new Drink(values[0], Double.parseDouble(values[1])));
            }
            csvReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }


        return DrinkList;
    }
}
