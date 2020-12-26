package ProjectManagementSystem;

import java.time.LocalDate;
import com.sun.org.apache.xpath.internal.operations.Number;
import javafx.scene.chart.*;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;

import java.lang.*;
import static java.sql.Date.valueOf;
import java.time.LocalDate;
import java.util.Date;
import javafx.collections.ObservableList;

import javafx.scene.layout.*;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static java.sql.Date.valueOf;
import static java.sql.Date.valueOf;
import static java.sql.Date.valueOf;

class CreatingTaskScene extends Pane
{
    protected final AnchorPane grid = new AnchorPane();
    protected final Scene scene ;
    protected final TextField MemberId = new TextField();;
    protected final TextField TaskName = new TextField();
    protected final DatePicker Deadline = new DatePicker();
    protected final TextArea DescriptionTextArea= new TextArea();
    protected final Button AddButton= new Button();
    protected final Button CancelButton= new Button();
    
    // Reference to table View scene to add the new tasks to it --> ok :)
    static Stage primaryWindow;
     static TableScene tasksTable;
      
     
     //existedTasks before
     
   static  Task [] existedTasks;
    public CreatingTaskScene(TableScene tasksTable)
    {
        
        //set the reference to table
        this.tasksTable = tasksTable;
        // Task name
        TaskName.setAlignment(javafx.geometry.Pos.CENTER);
        TaskName.setLayoutX(41.0);
        TaskName.setLayoutY(28.0);
        TaskName.setPromptText("Task name");
        TaskName.setOnKeyPressed(event ->
        {
            if (event.getCode()== KeyCode.ENTER || event.getCode()==KeyCode.DOWN)
            {
                MemberId.requestFocus();
            }
        });
        //Member ID
        MemberId.setAlignment(javafx.geometry.Pos.CENTER);
        MemberId.setLayoutX(41.0);
        MemberId.setLayoutY(63.0);
        MemberId.setPromptText("member id");
        MemberId.setOnKeyPressed(event ->
        {
            if (event.getCode()== KeyCode.ENTER || event.getCode()==KeyCode.DOWN)
                Deadline.requestFocus();
            else if (event.getCode()== KeyCode.UP||event.getCode()==KeyCode.ESCAPE)
                TaskName.requestFocus();
        });
        //Deadline
        Deadline.setLayoutX(41.0);
        Deadline.setLayoutY(99.0);
        Deadline.setPrefHeight(25.0);
        Deadline.setPrefWidth(149.0);
        Deadline.setValue(LocalDate.now());
        Deadline.setPromptText("Deadline");
        Deadline.setOnKeyPressed(event ->
        {
            if (event.getCode()== KeyCode.ENTER )
                DescriptionTextArea.requestFocus();
            else if (event.getCode()==KeyCode.ESCAPE)
            {
                MemberId.requestFocus();
            }
        });
        //Description
        DescriptionTextArea.setLayoutX(16.0);
        DescriptionTextArea.setLayoutY(136.0);
        DescriptionTextArea.setPrefHeight(200.0);
        DescriptionTextArea.setPrefWidth(200.0);
        DescriptionTextArea.setPromptText("task descripsion");
        DescriptionTextArea.setFont(new Font(14.0));
        DescriptionTextArea.setOnKeyPressed(event ->
        {
            if ( event.getCode()==KeyCode.DOWN)
                AddButton.requestFocus();
            else if (event.getCode()== KeyCode.UP||event.getCode()==KeyCode.ESCAPE)
                Deadline.requestFocus();
        });
        //AddButton
        AddButton.setLayoutX(41.0);
        AddButton.setLayoutY(350.0);
        AddButton.setMnemonicParsing(false);
        AddButton.setPrefHeight(36.0);
        AddButton.setPrefWidth(68.0);
        AddButton.setText("Add");
        AddButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        AddButton.setFont(new Font("Elephant", 15.0));
        AddButton.setOnAction(event ->
        {
          // I think there is better solution but this should work now
            //so we will get all the tasks 
            //then add the new task to it :
          ObservableList<Task> updatedList =  tasksTable.getTasks(existedTasks);
          
          
          
            
            
            
          updatedList.add(new Task(TaskName.getText(), 
          
                                   Integer.parseInt(MemberId.getText()),
                                   "Done",
                                   valueOf(Deadline.getValue()),
                                   DescriptionTextArea.getText()        ));
            tasksTable.tableView.setItems(updatedList );
           primaryWindow.setScene(tasksTable.scene);
           
            TaskName.setText("");
            MemberId.setText("");
            Deadline.setValue(LocalDate.now());
            DescriptionTextArea.setText(""); 
        });
        AddButton.setOnKeyPressed(event ->
                {
                    if (event.getCode()==KeyCode.ENTER)
                    {
                    }
                }
        );
        //CancelButton
        CancelButton.setLayoutX(122.0);
        CancelButton.setLayoutY(350.0);
        CancelButton.setMnemonicParsing(false);
        CancelButton.setPrefHeight(36.0);
        CancelButton.setPrefWidth(68.0);
        CancelButton.setText("Cancel");
        CancelButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        CancelButton.setFont(new Font("Elephant", 14.0));
        CancelButton.setOnAction(event ->
        {
            TaskName.setText("");
            MemberId.setText("");
            Deadline.setValue(LocalDate.now());
            DescriptionTextArea.setText("");
            
        });
        CancelButton.setOnKeyPressed(event ->
                {
                    if (event.getCode()==KeyCode.ENTER)
                    {
                        TaskName.setText("");
                        MemberId.setText("");
                        Deadline.setValue(LocalDate.now());
                        DescriptionTextArea.setText("");
                    }
                }
        );
        //grid and scene properties
        grid.getChildren().addAll(TaskName,MemberId,DescriptionTextArea,AddButton,CancelButton,Deadline);
        scene = new Scene(grid,230,400);


    }
}
