package com.example.bacpacapp;


/**
 * Controls User Data by storing height and weight, and calculating BMI
 */
public class UserProfile {

    // Declares height and weight variables
    static  double height, weight;

    /**
     * Constructor that creates the default user
     */
    public UserProfile() {
        weight = 170;
        height = 68;
    }

    /**
     * Constructor that recreates the user once data is entered
     * @param weight
     * @param height
     */
    public UserProfile(double weight, double height) {
        this.height = height;
        this.weight = weight;

    }

    /**
     * Calculates a user's BMI based off given height or weight
     * @param weight
     * @param height
     * @return a BMI value based off user data
     */
    private double calcBMI(double weight, double height) {
        return  (703 * (weight / (height * height)));
    }

    /**
     * Method to get user's stored weight
     * @return User's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Updates the user's stored weight value
     * @param weight
     */
    public void setWeight(double weight){this.weight = weight;}

    /**
     * Method to get user's stored height
     * @return User's height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Updates the user's stored height value
     * @param height
     */
    public void setHeight(double height){this.height = height;}

    /**
     * Method to get user's BMI
     * @return User's BMI
     */
    public float getBMI() {
        return (float) calcBMI(getWeight(), getHeight());
    }


}