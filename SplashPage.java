package bacpac;

/**
 *
 * @author rsuppl1
 */
public class SplashPage implements CurrentState {
    StateDisplayer displayState;
    boolean userProfileButton;
    boolean drinkPageButton;
    
    public SplashPage(StateDisplayer displayState)
    {
        this.displayState = displayState;
    }
    
    @Override
    public void handleUpdate()
    {
        
        if (userProfileButton == true){
            displayState.setDisplayState((CurrentState) displayState.getUserProfilePageState());
        }
        
        if (drinkPageButton == true){
            displayState.setDisplayState((CurrentState) displayState.getDrinksPageState());
        }
    }
    @Override
    public void displayPage()
    {
        System.out.print("Fuck you");
    }

}
