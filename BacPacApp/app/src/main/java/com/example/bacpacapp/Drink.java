package com.example.bacpacapp;

/**
 * This class is for creating drink objects when reading CSV files
 */
class Drink {
    /*
    Declaring and initializing necessary variables
     */
    String name;
    float AlContent;
    static float volume = 12;

    /**
     * Constructor that creates the drink object
     * @param name
     * @param AlContent
     */
    Drink(String name, String AlContent) {
        this.name = name;
        this.AlContent = Float.parseFloat(AlContent);
    }

    /**
     * Can call upon this method to get volume of drink
     * @return Volume of the drink
     */
    static float getVolume() {
        return volume;
    }
}
