package bacpac;

/**
 * 
 * @author rsuppl1
 */
public class StateDisplayer  {

    private final CurrentState LogInPage;
    private final CurrentState UserProfilePage;
    private final CurrentState SplashPage;
    private final CurrentState DrinksPage;
    
    private CurrentState State;
   
    public  StateDisplayer() 
    {
        DrinksPage = new DrinksPage(this);
        LogInPage = new LogInPage(this);
        SplashPage = new SplashPage(this);
        UserProfilePage = new UserProfilePage(this);
       
        State = LogInPage;
    }
    
    public void setDisplayState(CurrentState newState)
    {
        this.State = newState;
    }
    public void handleUpdate()
    {
        State.handleUpdate();
    }
    
    public void displayPage()
    {
        State.displayPage();
    }
    
    // returns the current displayState
    public Object getDisplayState()
    {
        return State;
    }
    
    public Object getDrinksPageState()
    {
        return DrinksPage;
    }
    
    public Object getSplashPageState()
    {
        return SplashPage;
    }
    
    public Object getUserProfilePageState()
    {
        return UserProfilePage;
    }

    public Object getLogInPageState()
    {
        return LogInPage;
    }
}
