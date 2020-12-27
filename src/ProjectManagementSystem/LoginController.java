package ProjectManagementSystem;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginController {

    public TextField userField;
    public PasswordField passwordField;
    public Label errorLabel;
    
    Account signUp;
    
    //Reference to the main window and scene to change it.
    Stage mainWindow;
    Scene TasksScene;
    
    @FXML
    private HBox loginRoot;

    public boolean validateNull(TextField field) { //Validates if no data was typed in field
        if(field.getText().equals("")) {
            return true;
        }
        return false;
    }

    public boolean validateNull(PasswordField field) { //Validates if no data was typed in field
        if(field.getText().equals("")) {
            return true;
        }
        return false;
    }

    public void loginButtonClick() throws IOException { //Login button click function
        System.out.println("Login button clicked");

        //Validate input
        if(validateNull(userField) && validateNull(passwordField)) {
            errorLabel.setText("Please fill in name and password");
        } else if(validateNull(userField)) {
            errorLabel.setText("Please fill in name");
        } else if(validateNull(passwordField)) {
            errorLabel.setText("Please fill in password");
        } else {
            //Add code to check if user exists in database/file/array and if they are team leader

            errorLabel.setText("");
            System.out.println("User allowed to login\n");
            //loadAfterLoginFXML();
            // if the login is successful
            goToTaskTable();
        }
    }
    
    private void checkUserData() { //Checks if input data matches a stored user data
        
    }

    public void signUpButtonClick() throws IOException { //Loads the FXML file for sign up page
        //loadSignUpFXML();
        
        goToSignUp();
    }
    
    
    public void goToTaskTable()
    {
       mainWindow.setScene(TasksScene);
    }
public void goToSignUp()
{
       mainWindow.setScene(signUp.scene);
        

}
    //Functions to switch to other FXML files
    /*
    private void loadAfterLoginFXML() throws IOException {
        System.out.println("Loading FXML");
        HBox pane = FXMLLoader.load(getClass().getResource("InsertNameOfNextFXML.fxml")); //Loads the inputted FXML file
        loginRoot.getChildren().setAll(pane);
    }
    
    private void loadSignUpFXML() throws IOException {
        System.out.println("Loading sing up FXML");
        HBox pane = FXMLLoader.load(getClass().getResource("InsertNameOfSignupFXML.fxml")); //Loads the inputted FXML file
        loginRoot.getChildren().setAll(pane);
    }*/
}