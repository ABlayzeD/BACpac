package bacpac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adupr29
 */
public class DrinksPageController  {
    
    DrinksPage chooseDrink = new DrinksPage();
    
    @FXML
    private Button BeerButton;
    @FXML
    private Button WineButton;
    @FXML
    private Button LiquorButton;
    
    public DrinksPageController(){}
    
    @FXML
    private void initialze(){}
    
    @FXML
    private void handleBeerButton()
    {
       BeerButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
            
                chooseDrink.setBeerPageTrue();
                System.out.println("AddBeer = true");
                String fxmlResource = "BeerPage.fxml";
                Parent panel = null;
                panel = FXMLLoader.load(getClass().getResource(fxmlResource));
                Scene scene = new Scene(panel);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    }
    @FXML
    private void handleWineButton()
    {
       WineButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
            
                chooseDrink.setWinePageTrue();
                System.out.println("AddWine= true");
                String fxmlResource = "WinePage.fxml";
                Parent panel = null;
                panel = FXMLLoader.load(getClass().getResource(fxmlResource));
                Scene scene = new Scene(panel);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    }
    @FXML
    private void handleLiquorButton()
    {
       LiquorButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
            
                chooseDrink.setLiquorPageTrue();
                System.out.println("AddLiquor = true");
                String fxmlResource = "LiquorPage.fxml";
                Parent panel = null;
                panel = FXMLLoader.load(getClass().getResource(fxmlResource));
                Scene scene = new Scene(panel);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    }
}
