package bacpac;

/**
 *
 * @author rsuppl1
 */
public class LogInPage extends StateDisplayer {
    @Override
    public void handleUpdate(){
        if (login == true)
            currentState = displayStates[2];
    }
    
    @Override
    public void displayPage(){
        
    }
}
