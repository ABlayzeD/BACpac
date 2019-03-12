
package bacpac;

/** This class constructs a custom drink object that the user can then add. 
 *  The object is constructed using 3 variables 1 string(the name) 
 * and 2 integers(%Alcohol, Volume)
 * @author Ryan Supple
 */
public class CustomDrinks {
    
    public Object customDrink;
    
    private String name;
    
    private int percentAlc;
    
    private int volume;
    
    
    public CustomDrinks ()
    {
        name = null;
        percentAlc = 0;
        volume = 0;
    }
    
    public CustomDrinks(String name, int percentAlc, int volume) 
    {
        
        this.name = name;
        this.percentAlc = percentAlc;
        this.volume = volume;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getPercentAlc()
    {
        return percentAlc;
    }
    
    public int getVolume()
    {
        return volume;
    }
}
