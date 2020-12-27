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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //giving Create Task page a refernce to the already Created tasks :

        TableScene mainPage=new TableScene();
        mainPage.Readtable();
        //we need the main window to transfere between create task scene and table view  scene
        //also  we give the create task the addresss to the scene of table view
        // somehow not good thing to do.

    CreatingTaskScene.primaryWindow = primaryStage;
//CreateTask.tasksTable = mainPage;
        primaryStage.setTitle("project");
        primaryStage.setScene(mainPage.scene);

    mainPage.primaryWindow = primaryStage;


        primaryStage.show();
        primaryStage.setResizable(false);

    }
    public static void main(String[] args) {

        launch(args);
    }

}
