/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacpac;

/**
 *
 * @author lterro1
 */
public class UserProfile 
{
    /**
     * Returns the weight of the user
     */
    private double weight;
    /**
     * Returns the height of the user
     */
    private double height;
    /**
     * Returns the name of the user
     */
    private String name; 
    /**
     * Creates an object for representing Luis with 170lb and 68(inch)
     */
    public UserProfile(){
        weight = 170;
        height = 68;
        name = "Luis";
    }
    /**
     * Creates a valid User
     * @param name name of user
     * @param weight weight of user 
     * @param height height of user
     */
    public UserProfile(String name, double weight, double height){
        this.name = name;
        this.weight = weight;
        this.height = height;
        
    }
    /**
     * Calculates the Body Mass Index(BMI) of User.
     * @param weight weight of user
     * @param height height of user
     * @return the BMI of user
     */
    public double getBMI(double weight, double height){
        
        return(703*(weight/(height*height)));
    }
    /**
     * Gives a double representing the current Weight
     * @return the User's current Weight
     */
    public double getWeight(){
        return weight;
    }
    /**
     * Gives a double representing the current Height
     * @return the User's current Height
     */
    public double getHeight(){
        return height;
    }
    /**
     * Gives a string representing the current name
     * @return  the User's Current Name
     */
    public String getName(){
        return name;
    }
    
  
}
