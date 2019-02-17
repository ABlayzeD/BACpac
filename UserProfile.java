
package bacpac;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lterro1
 */
public class UserProfile 
{
    private ArrayList favorites;
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
        
        favorites = new ArrayList();
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
    private double calcBMI(double weight, double height){
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
    /**
     * Gives a double representing the current BMI
     * @return the User's Current BMI
     */
    public double getBMI(){
        return calcBMI(getWeight(), getHeight());
    }
    
    public void addToFavorites(Object newAdd) 
    {
        favorites.add(newAdd);
    }
    
    public String printFavorites()
    {
        return Arrays.toString(getFavorites());
    }
    public Object[] getFavorites()
    {
        return favorites.toArray();
    }
    
}
