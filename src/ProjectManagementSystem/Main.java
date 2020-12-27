package ProjectManagementSystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class Main extends Application {
    TableScene mainPage = new TableScene();
    CreatingTaskScene CreationScene = new CreatingTaskScene(mainPage);

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        //giving Create Task page a refernce to the already Created tasks :

        TableScene mainPage=new TableScene();
        mainPage.Readtable();
        //we need the main window to transfere between create task scene and table view  scene
        //also  we give the create task the addresss to the scene of table view
        // somehow not good thing to do.
    CreatingTaskScene.primaryWindow = primaryStage;
//CreateTask.tasksTable = mainPage;
        primaryStage.setTitle("ProjectManagmentSystem");
      //  primaryStage.setScene(mainPage.scene);

    mainPage.primaryWindow = primaryStage;
    
        //load Login window first
        FXMLLoader loginLoader = new FXMLLoader();
         loginLoader.setLocation(getClass().getResource("LoginFXML.fxml"));
        Parent root = loginLoader.load();
   //get the controller for login window
    LoginController loginController = loginLoader.getController();
     Scene loginScene = new Scene(root);
     
     // give it the reference so we don't get errors :) 
    loginController.mainWindow = primaryStage;
    loginController.TasksScene = mainPage.scene;
    
      TeamLeader leader = new TeamLeader();
      TeamMember member = new TeamMember();
      
      //Intialize signUp Scene to be ready
    Account signUp = new Account(primaryStage);
    signUp.leader = leader;
    signUp.member = member;
    
    loginController.signUp = signUp;
    
    //defualt scene
     primaryStage.setScene(loginScene);
       
        
      
        

        
        
    

        

//Show the window
        primaryStage.show();
        primaryStage.setResizable(false);

    }
    public static void main(String[] args) {

        launch(args);
    }

}
