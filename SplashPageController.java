/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author rsuppl1
 */
public class SplashPageController {
SplashPage inSplash = new SplashPage();
    
    @FXML
    private Button profileBtn;
    
    @FXML
    private Button plusDrinkBtn;
    
    public SplashPageController(){}
    
    @FXML
    private void initialze(){}
    
    @FXML
    private void handleProfile()
    {
       profileBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try{
                inSplash.setUserProfileTrue();
                System.out.println("loadProfile = true");
                String fxmlResource = "UserProfilePage.fxml";
                Parent panel = null;
                panel = FXMLLoader.load(getClass().getResource(fxmlResource));
                Scene scene = new Scene(panel);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(SplashPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
    }
    
    @FXML
    private void handlePlusDrink()
    {
       plusDrinkBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                inSplash.setDrinkPageTrue();
                System.out.println("AddDrink = true");
                String fxmlResource = "DrinksPage.fxml";
                Parent panel = null;
                panel = FXMLLoader.load(getClass().getResource(fxmlResource));
                Scene scene = new Scene(panel);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(SplashPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
