package bacpac;

/**
 * This class is an abstract class that contains displays that get implemented 
 * by other classes. It keeps track of the current state that the app is in and 
 * by doing so can call upon the correct display class to present the user with 
 * the proper GUI for the specific page. 
 * @author Ryan Supple
 */
public abstract class StateDisplayer {
    
    // This variable keeps track of the current State of the Displayer.
    // Set to private and can be gotten from getDisplayState() method
    protected Object currentState;
     
    // This is suppose to be a have all the possible states in an easy access 
    // array and just changes the array index.
    protected final Object[] displayStates;
    
    // These create Object references to all the possible states
    LogInPage LoginPageObj = new LogInPage();
    UserProfilePage UserProfilePageObj = new UserProfilePage();
    SplashPage SplashPageObj = new SplashPage();
    DrinksPage DrinksPageObj = new DrinksPage();
    
    // contructs the currentState variable and the displayStates array
    public  StateDisplayer() 
    {
        this.displayStates = new Object[] {LoginPageObj, UserProfilePageObj, SplashPageObj, DrinksPageObj};
        this.currentState = displayStates[0];
    }
    
    // returns the current displayState
    public Object getDisplayState()
    {
        return currentState;
    }
    
    public void updateChecking()
    {
        currentState.displayPage();
        currentState.handleUpdate();
    }
    
    // both of these absract methods are implemneted in each page's class
    public abstract void handleUpdate();
    public abstract void displayPage();
}
