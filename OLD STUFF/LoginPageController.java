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
public class LoginPageController  {
    
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
                try {
                    LoggedIn.setLogInTrue();
                    System.out.println("login = true");
                    String fxmlResource = "SplashPage.fxml";
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
