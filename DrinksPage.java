package bacpac;

/**
 *
 * @author rsuppl1
 */
public class DrinksPage extends StateDisplayer {
    @Override
    public void handleUpdate(){
        if (backButton == true)
            currentState = displayStates[2];
    }
    
    @Override
    public void displayPage(){
        
    }
}
