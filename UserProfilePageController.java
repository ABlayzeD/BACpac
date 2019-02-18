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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author lterr
 */
public class UserProfilePageController {
    
    UserProfile user = new UserProfile();
    String tempFave = "tempFave, tempFav";
    
    @FXML
    private TextField height;
    
    @FXML
    private TextField weight;
    
    @FXML
    private TextField BMI;
    
    @FXML
    private TextField Favorite;
    

    private boolean start = true;
    
    @FXML
    private void handleFavorite()
    {
        Favorite.setOnAction(new EventHandler<ActionEvent>() {
            
        @Override
        public void handle(ActionEvent event) 
        {
            Favorite.setText(tempFave);
        }
    }); 
    }
    
    /**
     *
     * @param event
     */
    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            BMI.setText("");
            start = false;
        }
        BMI.setText(BMI.getText());

    }
    
    @FXML
    public void processBMI(ActionEvent event){
       double output = user.getBMI(Double.parseDouble(weight.getText()),Double.parseDouble(height.getText()));
       BMI.setText(String.valueOf(output));
    }
}
