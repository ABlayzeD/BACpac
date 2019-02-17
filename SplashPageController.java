/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacpac;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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
                inSplash.setUserProfileTrue();
                System.out.println("login = true");
            }
        }); 
    }
    
    @FXML
    private void handlePlusDrink()
    {
       plusDrinkBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                inSplash.setDrinkPageTrue();
                System.out.println("AddDrink = true");
            }
        });
    }
}
