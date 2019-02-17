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
public class LoginPageController {
    
    LogInPage LoggedIn = new LogInPage();
    
    @FXML
    private Button goBtn;
    
    public LoginPageController(){}
    
    @FXML
    private void initialze(){}
    
    @FXML
    private void handle()
    {
       goBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                LoggedIn.setLogInTrue();
                System.out.println("login = true");
            }
        }); 
    }
}
