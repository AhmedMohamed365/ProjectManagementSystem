package ProjectManagementSystem;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginController {

    public TextField userField;
    public PasswordField passwordField;
    public Label errorLabel;
    TeamMember member [] = new TeamMember[5];
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
        }
        else if(validateNull(userField)) {
            errorLabel.setText("Please fill in name");
        } else if(validateNull(passwordField)) {
            errorLabel.setText("Please fill in password");
        } else {
            LoadUsers();
            ValidateData();


            errorLabel.setText("");
            System.out.println("User allowed to login\n");
            //loadAfterLoginFXML();
            // if the login is successful
            //goToTaskTable();
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


public void LoadUsers() throws IOException {
    Scanner scanner = new Scanner(Paths.get("accounts.txt"), StandardCharsets.UTF_8.name());
    int counter = 0;

    while(scanner.hasNext())
    {
        String content = scanner.useDelimiter("\\;").next();
        String[] details = content.split(",");
        member[counter] = new TeamMember();
        member[counter].setName(details[0]+details[1]);
        member[counter].setEmail(details[2]);
        member[counter].setPassword(details[3]);
        member[counter].setMobileNumber(details[4]);
        member[counter].setGender(details[5]);

        counter++;
    }
    scanner.close();

}
public void ValidateData()
{
    for ( TeamMember  user : member)
    {
        //We don't wanna get null pointer exception for not defined user :(
        if(user == null)
            break;
        if(userField.getText().equals(user.getEmail()))
        {
            if (passwordField.getText().equals(user.getPassword()))
            {
                goToTaskTable();
            }
            else
            {
                passwordField.setText("");
                errorLabel.setText("Invalid password");
            }
        }
    }
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