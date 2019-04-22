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

/**
 * This class reads a CSV file to gather drink info of all types
 */
class DrinksReader {

    /**
     * Reads a CSV that contains drink names and info and collects it into an array
     * @param activity
     * @param nameOfFile
     * @return An array of drink names and info
     */
    static protected ArrayList<Drink> pullDrinkFromCSV(Context activity, String nameOfFile){
        ArrayList<Drink> DrinkList=new ArrayList<>();
        try {
            Reader reader = new InputStreamReader(activity.getAssets().open(nameOfFile));
            CSVReader csvReader = new CSVReader(reader,',','/',1);
            String[] values;
            while((values=csvReader.readNext())  != null) {
                System.out.println(values[0]+", "+values[1]);
                    DrinkList.add(new Drink(values[0], values[1]));
            }
            csvReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return DrinkList;
    }
}
