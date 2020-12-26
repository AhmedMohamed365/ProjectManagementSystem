package ProjectManagementSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;

public class Main extends Application {
    TableScene mainPage = new TableScene();
    CreatingTaskScene CreationScene = new CreatingTaskScene(mainPage);
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Task [] tasks = {new Task("Laptop", 1,"we can do it",new Date(),"done"),
                         new Task("Laptop", 1,"we can do it",new Date(),"done"),
                         new Task("Laptop", 1,"we can do it",new Date(),"done"),
                         new Task("Laptop", 1,"we can do it",new Date(),"done")};
        //giving Create Task page a refernce to the already Created tasks : 
       CreatingTaskScene.existedTasks = tasks;
        TableScene mainPage=new TableScene();
        mainPage.IntializeCoulmns();
        mainPage.tableView.setItems(mainPage.getTasks(tasks));
                
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
