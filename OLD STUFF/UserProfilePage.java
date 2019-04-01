package bacpac;

/**
 *
 * @author rsuppl1
 */
public class UserProfilePage implements CurrentState {
    boolean backButton;
    StateDisplayer displayState;
    
    public UserProfilePage(StateDisplayer displayState)
    {
        this.displayState = new StateDisplayer();
    }
    
    @Override
    public void handleUpdate(){
        
        if (backButton = true)
            displayState.setDisplayState((CurrentState) displayState.getSplashPageState());
    }
    
    @Override
    public void displayPage(){
        
    }
}
