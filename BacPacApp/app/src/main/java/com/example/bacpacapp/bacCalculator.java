package com.example.bacpacapp;

import java.math.BigDecimal;
import java.math.MathContext;

public class bacCalculator {
    /**
     * This class is used to calculate the BAC. To use create an Object reference for Each BAC you
     * want calculated. Example Once BAC <= 0 then create a new reference to start as the user is
     * now sober.
     */
    private static BigDecimal BAC = BigDecimal.valueOf(0);
    private static BigDecimal totalOunces= BigDecimal.valueOf(0);
    private static BigDecimal decimalPercentAlc = BigDecimal.valueOf(0);
    private static BigDecimal timePassed = BigDecimal.valueOf(0);
    private static BigDecimal ouncesAlc = BigDecimal.valueOf(0);
    static UserProfile user = new UserProfile();
    static BACActivity displayReference = new BACActivity();


    public bacCalculator() {
        totalOunces = BigDecimal.valueOf(0);
        decimalPercentAlc =BigDecimal.valueOf(0);
        timePassed = BigDecimal.valueOf(0);
        ouncesAlc = BigDecimal.valueOf(0);
    }


    /**
     * Calculates BAC once you are adding drinks
     * @param percentAlc
     * @param fluidOunces
     */
    public static void addDrinkToBAC(double percentAlc, double fluidOunces)
    {
        ouncesAlc = ouncesAlc.add((BigDecimal.valueOf((percentAlc/100) * fluidOunces)));
        totalOunces = totalOunces.add(BigDecimal.valueOf(fluidOunces));
        decimalPercentAlc = ouncesAlc.divide(totalOunces, MathContext.DECIMAL32);
        BAC = (((totalOunces.multiply(decimalPercentAlc)).divide(BigDecimal.valueOf(user.getBMI()),MathContext.DECIMAL32)).subtract((timePassed.divide(BigDecimal.valueOf(60),MathContext.DECIMAL32)).multiply(BigDecimal.valueOf(.015))));
    }

    public static void addFiveMinutes()
    {
        timePassed.add(BigDecimal.valueOf(5));
    }

    public static double getBAC()
    {
        return BAC.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void resetBAC(){
        BAC = BigDecimal.valueOf(0);
        totalOunces = BigDecimal.valueOf(0);
        decimalPercentAlc = BigDecimal.valueOf(0);
        timePassed = BigDecimal.valueOf(0);
        ouncesAlc = BigDecimal.valueOf(0);
    }

    public static long getTimeLeft(){
        float timeLeft;
        timeLeft = (float) (getBAC()/.015);
        return (long) timeLeft * 3600000;
    }

    //divide(BigDecimal.valueOf(60),MathContext.DECIMAL32)
}
