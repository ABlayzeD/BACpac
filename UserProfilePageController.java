/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bacpac;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author lterr
 */
public class UserProfilePageController implements Initializable {

    private TextField height;
    private TextField weight;
    private Label BMI;
    private boolean start = true;
    UserProfile user = new UserProfile();

    @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    public void processBMI(ActionEvent event){
       double output = user.getBMI(Double.parseDouble(height.getText()),Double.parseDouble(weight.getText()));
       BMI.setText(String.valueOf(output));
    }
}
