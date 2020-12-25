/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagementSystem;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mercy
 */
public class TableView_tasksController implements Initializable {

    /**
     * Initializes the controller class.
     */
     public TableView<Task> table;
    public TableColumn<Task,String> Name,Status,Description,TeamLeader;
    public TableColumn<Task,Date> DeadLine;
    
 
    public Button gridView;
    
    public FXMLLoader gridLoader;
    public Scene TaskScene;
//    @FXML
//    private TableColumn<?, ?> name;
    public void switchToGridView() throws IOException
    {
       // System.out.println("What ? ");
        gridLoader = new FXMLLoader();
          gridLoader.setLocation(getClass().getResource("TaskViewer.fxml"));
         Parent root =  gridLoader.load();
          
         TaskScene.setRoot(root);
         

    }
    
    
    
    public ObservableList<Task> FillRows(Task []task)
    {
        ObservableList<Task> tasks = FXCollections.observableArrayList();
        
        for(Task one : task)
        tasks.add(one);
        
        
        return tasks;
        
    }
    
    public  void IntializeColumns()
    {
        Name.setCellValueFactory(new PropertyValueFactory("name"));
                Status.setCellValueFactory(new PropertyValueFactory("status"));

                        Description.setCellValueFactory(new PropertyValueFactory("Description"));

                                TeamLeader.setCellValueFactory(new PropertyValueFactory("TeamLeader"));

                                        DeadLine.setCellValueFactory(new PropertyValueFactory("deadLine"));


    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
