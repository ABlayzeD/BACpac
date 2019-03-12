package bacpac;

/**
 *
 * @author rsuppl1
 */
public class DrinksPage implements CurrentState{
    boolean backButton;
    StateDisplayer displayState;
    
    public DrinksPage(StateDisplayer displayState)
    {
        this.displayState = displayState;
    }
    
    @Override
    public void handleUpdate(){
        if (backButton = true)
            displayState.setDisplayState((CurrentState) displayState.getSplashPageState());
    }
    
    @Override
    public void displayPage(){
        System.out.print("drinks");
        backButton = true;
    }
}
