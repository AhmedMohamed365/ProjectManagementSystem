/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagementSystem;
import java.beans.DesignMode;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class MainClass extends Application {
    
    
    
    
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
             
    }
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
  FXMLLoader loader=new FXMLLoader();
  loader.setLocation(getClass().getResource("TableView_tasks.fxml"));
        Parent root = loader.load();
        
      Task tasks[] = {new Task("OOP",new Date(),"Done","Ahmed Mohamed Hassan") ,
                      new Task("Data Base ",new Date(),"Still","No one") 
                    , new Task("LOGIC Design ",new Date() ,"Still","No one" ),
                      new Task("Report Writing",new Date() , "Going","No one")} ;
      
        Scene scene = new Scene(root);
        
        
        
           // stage.setResizable(false);
            TableView_tasksController cont =loader.getController();
            
            cont.IntializeColumns();
            cont.table.setItems(cont.FillRows(tasks));
            cont.TaskScene = scene;
            
          // cont.changenameTask("oop",  "29 /1","On");
//              int x=0;
//           for (Task task: tasks)
//           {
//               String [] data  =  {"Name: "+task.getName(),"DeadLine: "+task.getDeadLine().toString(),"Status: "+task.getStatus()};
//               
//                             cont.FillTasksData(data,Task.nOfTasks,x);
//                        x++;
//           }
                 //Load The scene for the task info 
//       FXMLLoader Taskloader=new FXMLLoader();
//  Taskloader.setLocation(getClass().getResource("TaskDetailsScene.fxml"));
//        Parent Taskroot = Taskloader.load();
//        Scene taskScene = new Scene(Taskroot);
//        tasks[0].setScene(taskScene);
        
      //cont.taskDetailsWindow = tasks[0];
        
        //Open the task Viewer window
        stage.setScene(scene);
             
        stage.show();
        
//        TableView_tasksController tableController = new TableView_tasksController();
//        tableController.TaskScene = scene;
   
    }

 
    
}
