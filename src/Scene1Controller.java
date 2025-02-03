import java.io.IOException;

import javax.sound.midi.SysexMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Scene1Controller {

    @FXML
    TextField nametextfield;

    @FXML
    TextField passwordtextfield;

    @FXML
    Button loginButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginButtonHandler(ActionEvent event) throws IOException {

        // Get text from text field
        String username = nametextfield.getText();
        String password = passwordtextfield.getText();  

        System.out.println(username + " " + password);

        if(DatabaseHandler.validateLogin(username, password))
        {
            System.out.println("Successful");

            // Load Scene2.fxml when login button is clicked
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            // Load Scene2Controller
            root = loader.load();
            Scene2Controller scene2Controller = loader.getController();
            // Pass username from textfield to displayName() method
            scene2Controller.displayName(username);

            // Load stage and scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            System.out.println("Unsuccessful");
        }
    }
}