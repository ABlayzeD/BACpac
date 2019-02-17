package bacpac;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rsuppl1
 */
public class main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    Button loginButton;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BACpac");
        
        loginButton = new Button();
        
    }
    
}
