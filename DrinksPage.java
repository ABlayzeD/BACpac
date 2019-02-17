package bacpac;

/**
 *
 * @author rsuppl1
 */
public class DrinksPage implements CurrentState{
    boolean beerButton,wineButton, liquorButton;
    StateDisplayer displayState;
    
    public DrinksPage(){}
    public DrinksPage(StateDisplayer displayState)
    {
        this.displayState = displayState;
    }
    
    @Override
    public void handleUpdate(){
        if (wineButton = true)
            displayState.setDisplayState((CurrentState) displayState.getWinePageState());
        if (beerButton = true)
            displayState.setDisplayState((CurrentState) displayState.getBeerPageState());
        if (wineButton = true)
            displayState.setDisplayState((CurrentState) displayState.getLiquorPageState());
    }
    
    @Override
    public void displayPage(){
        System.out.print("drinks=true");
    }
    public boolean setWinePageTrue()
    {
        return wineButton = true;
    }
    
    public boolean setBeerPageTrue()
    {
        return beerButton = true;
    }
    public boolean setLiquorPageTrue(){
        return liquorButton=true;
}

}
