package bacpac;

/**
 *
 * @author rsuppl1
 */
public class WinePage implements CurrentState{
    boolean someButton;
    StateDisplayer displayState;
    
    public WinePage(){}
    public WinePage(StateDisplayer displayState)
    {
        this.displayState = displayState;
    }
    
    @Override
    public void handleUpdate(){
        if (someButton = true)
            displayState.setDisplayState((CurrentState) displayState.getWinePageState());
    }
    
    @Override
    public void displayPage(){
        System.out.print("drinks=true");
    }
}
