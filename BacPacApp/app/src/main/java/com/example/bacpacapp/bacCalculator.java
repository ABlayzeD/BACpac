package com.example.bacpacapp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.TimeUnit;

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
    public static void addDrinkToBAC(float percentAlc, float fluidOunces)
    {
        ouncesAlc = ouncesAlc.add((BigDecimal.valueOf((percentAlc/100) * fluidOunces)));
        totalOunces = totalOunces.add(BigDecimal.valueOf(fluidOunces));
        decimalPercentAlc = ouncesAlc.divide(totalOunces, MathContext.DECIMAL128);
        BAC = (((totalOunces.multiply(decimalPercentAlc)).divide(BigDecimal.valueOf(user.getBMI()),MathContext.DECIMAL32))); //.subtract((timePassed.divide(BigDecimal.valueOf(60),MathContext.DECIMAL32)).multiply(BigDecimal.valueOf(.015))));
    }

    public static void addMinutes(long passed)
    {
        timePassed.add(BigDecimal.valueOf(TimeUnit.SECONDS.toMinutes(passed)));
    }

    public static float getBAC()
    {
        return BAC.setScale(3,BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static void updateBAC(){
        BAC = BAC.subtract((timePassed.divide(BigDecimal.valueOf(60),MathContext.DECIMAL32)).multiply(BigDecimal.valueOf(.015)));
    }

    public static void resetBAC(){
        BAC = BigDecimal.valueOf(0);
        totalOunces = BigDecimal.valueOf(0);
        decimalPercentAlc = BigDecimal.valueOf(0);
        timePassed = BigDecimal.valueOf(0);
        ouncesAlc = BigDecimal.valueOf(0);
    }

    public static long getTimeLeft(){
        BigDecimal timeLeft;
        timeLeft = BAC.divide(BigDecimal.valueOf(.015),MathContext.DECIMAL128);
        return timeLeft.multiply(BigDecimal.valueOf(3600000)).longValue();
    }

    //divide(BigDecimal.valueOf(60),MathContext.DECIMAL32)
}
