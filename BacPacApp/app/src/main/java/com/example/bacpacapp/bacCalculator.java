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
    private double ouncesAlc;
    UserProfile user = new UserProfile();
    BACActivity displayReference = new BACActivity();

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
        ouncesAlc =+ (percentAlc/100) * fluidOunces;
        totalOunces =+ fluidOunces;
        decimalPercentAlc = ouncesAlc/totalOunces;
        BAC =+ ((totalOunces * decimalPercentAlc)/user.getBMI()) - 1.5 * timePassed/60;
        displayReference.start();
    }

    public void addFiveMinutes()
    {
        timePassed =+ 5;
    }

    public double getBAC()
    {
        return BAC;
    }

    public void resetBAC(){
        BAC = 0.0;
        totalOunces = 0.0;
        decimalPercentAlc = 0.0;
        timePassed = 0.0;
    }

    public long getTimeLeft(){
        long timeLeft = 0;
        long tmpBAC = (long) getBAC();
        timeLeft = (long) (tmpBAC/1.5);
        return timeLeft * 60;
    }
}
