package bacpac;

/**
 *
 * @author rsuppl1
 */
public class SplashPage extends StateDisplayer {

    @Override
    public void handleUpdate(){
        if (profileButton == true)
            currentState = displayStates[1];
        if (drinkButton == true)
            currentState = displayStates[3];
    }
    
    @Override
    public void displayPage(){
        
    }
}
