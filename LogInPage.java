package bacpac;

/**
 *
 * @author rsuppl1
 */
public class LogInPage implements CurrentState {
    boolean login = false;
    StateDisplayer displayState;
    public LogInPage(){}
    
    public LogInPage(StateDisplayer displayState)
    {
        this.displayState = displayState;
    }
    @Override
    public void handleUpdate(){
        if (login = true)
            displayState.setDisplayState((CurrentState) displayState.getSplashPageState());
    }
    
    @Override
    public void displayPage(){
        System.out.print("Fuck you");
    }
    
    public boolean setLogInTrue()
    {
        return login = true;
    }
}
