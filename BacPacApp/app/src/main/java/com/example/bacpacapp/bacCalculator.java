package com.example.bacpacapp;

import java.util.concurrent.atomic.AtomicLong;

public class bacCalculator {
    /**
     * This class is used to calculate the BAC. To use create an Object reference for Each BAC you
     * want calculated. Example Once BAC <= 0 then create a new reference to start as the user is
     * now sober.
     */
    private static double BAC = 20;
    private static double totalOunces;
    private static double decimalPercentAlc;
    private static double timePassed;
    private static double ouncesAlc;
    static UserProfile user = new UserProfile();
    static BACActivity displayReference = new BACActivity();


    public bacCalculator() {
        totalOunces = 0;
        decimalPercentAlc = 0;
        timePassed = 0;
        ouncesAlc = 0;
    }

    /**
     * Calculates BAC once you are adding drinks
     * @param percentAlc
     * @param fluidOunces
     */
    public static void addDrinkToBAC(int percentAlc, double fluidOunces)
    {
        ouncesAlc =+ (percentAlc/100) * fluidOunces;
        totalOunces =+ fluidOunces;
        decimalPercentAlc = ouncesAlc/totalOunces;
        BAC =+ ((totalOunces * decimalPercentAlc)/user.getBMI()) - (1.5 * timePassed/60);
    }

    public static void addFiveMinutes()
    {
        timePassed =+ 5;
    }

    public static double getBAC()
    {
        return BAC;
    }

    public static void resetBAC(){
        BAC = 0.0;
        totalOunces = 0.0;
        decimalPercentAlc = 0.0;
        timePassed = 0.0;
        ouncesAlc = 0.0;
    }

    public static long getTimeLeft(){
        long timeLeft = 0;
        long tmpBAC = (long) getBAC();
        timeLeft = (long) (tmpBAC / 1.5);
        return timeLeft * 60;
    }
}
