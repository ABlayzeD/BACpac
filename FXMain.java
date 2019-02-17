package bacpac;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rsuppl1
 */
public class FXMain extends Application {
    
    LogInPage LoggedIn = new LogInPage();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        String fxmlResource = "LoginPage.fxml";
        Parent panel;
        panel = FXMLLoader.load(getClass().getResource(fxmlResource));
        Scene scene = new Scene(panel);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Button goBtn = new Button();
        goBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                LoggedIn.setLogInTrue();
                System.out.println("login = true");
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
