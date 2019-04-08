package com.example.bacpacapp;




public class UserProfile {

    static  double height, weight;

    public UserProfile() {
        weight = 170;
        height = 68;
    }
    public UserProfile(double weight, double height) {
        this.height = height;
        this.weight = weight;

    }
    private double calcBMI(double weight, double height) {
        return  (703 * (weight / (height * height)));
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight){this.weight = weight;}
    public double getHeight() {
        return height;
    }
    public void setHeight(double height){this.height = height;}
    public float getBMI() {
        return (float) calcBMI(getWeight(), getHeight());
    }


}