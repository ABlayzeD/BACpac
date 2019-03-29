package com.example.bacpacapp;

public class bacCalculator {
    /**
     * This class is used to calculate the BAC. To use create an Object reference for Each BAC you
     * want calculated. Example Once BAC <= 0 then create a new reference to start as the user is
     * now sober.
     */
    private double BAC;
    private double totalOunces;
    private double decimalPercentAlc;
    private double timePassed;
    UserProfile user = new UserProfile();

    public bacCalculator()
    {
        BAC = 0.0;
        totalOunces = 0.0;
        decimalPercentAlc = 0.0;
        timePassed = 0.0;
    }

    /**
     * Calculates BAC once you are adding drinks
     * @param percentAlc
     * @param fluidOunces
     */
    public void addDrinktoBAC(int percentAlc, double fluidOunces)
    {
        decimalPercentAlc =+ percentAlc/100;
        totalOunces =+ fluidOunces;
        BAC =+ ((totalOunces * decimalPercentAlc)/user.getBMI()) - 1.5 * timePassed/60;
    }

    public void addFiveMinutes()
    {
        timePassed =+ 5;
    }

    public double getBAC()
    {
        return BAC;
    }


}
