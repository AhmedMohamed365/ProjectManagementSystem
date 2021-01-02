package ProjectManagementSystem;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import com.sun.org.apache.xpath.internal.operations.Number;
import javafx.scene.chart.*;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

import javafx.scene.*;

import javafx.scene.text.*;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;



import javafx.scene.layout.*;

import javafx.stage.Stage;


class CreatingTaskScene extends Pane
{
    protected final AnchorPane grid = new AnchorPane();
    protected final Scene scene ;
    protected final TextField MemberId = new TextField();
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
            //here got excuted when it's edit page not add page
            if(AddButton.getText().equals("Save Changes"))
            {
               
                saveEditedTask();
              Task [] allTasks =  tasksTable.tableView.getItems().toArray(new Task[0]);
              boolean append = false;
              // delete all tasks from file then write it again after editing one task at a time
              for(Task oneTask : allTasks)
              {
                  //this to not to write the old task to the file
                  if(tasksTable.oldTask.getTaskName().get().equals(oneTask.getTaskName().get())
                          && tasksTable.oldTask.member_idProperty().get().equals(oneTask.member_idProperty().get())
                          && tasksTable.oldTask.descriptionProperty().get().equals(oneTask.descriptionProperty().get())
                          && tasksTable.oldTask.deadlineProperty().get().equals(oneTask.deadlineProperty().get()))
                      continue;
                  
                  saveTaskAferEdit(oneTask, true);
                 
              }
              
              //let's read the table again to update the  table list for the user
                try {
                    tasksTable.Readtable();
                } catch (IOException ex) {
                    Logger.getLogger(CreatingTaskScene.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        else
        {
            try {
                FileWriter myWriter = new FileWriter("table.txt",true);
                myWriter.write(TaskName.getText());
                myWriter.write(',');
                myWriter.write(MemberId.getText());
                myWriter.write(',');
                myWriter.write("going on");
                myWriter.write(',');
                myWriter.write(String.valueOf(Deadline.getValue()));
                myWriter.write(',');
                myWriter.write(DescriptionTextArea.getText());
                myWriter.write(";");
                myWriter.flush();
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
           
            
            
            
           
          
           
        }
            
              //This to update the table after pressing add button , or save button
           try{
                         tasksTable.Readtable();
  
           }
           catch(IOException e)
           {
               e.printStackTrace();
           }
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
    
     //function to  tasks before the edited task
      public void saveTaskAferEdit(Task task,boolean append)
        {
             try {
                FileWriter myWriter = new FileWriter("table.txt",append);
                myWriter.write(task.taskNameProperty().get());
                myWriter.write(',');
                myWriter.write(task.member_idProperty().get());
                myWriter.write(',');
                myWriter.write("going on");
                myWriter.write(',');
                myWriter.write(String.valueOf(task.deadlineProperty().getValue()));
                myWriter.write(',');
                myWriter.write(task.descriptionProperty().get());
                myWriter.write(";");
                myWriter.flush();
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /* This function takes data from the creation window not from task object
        like previous functions

        */
        public void saveEditedTask()
        {
             try {
                FileWriter myWriter = new FileWriter("table.txt",false);
                myWriter.write(TaskName.getText());
                myWriter.write(',');
                myWriter.write(MemberId.getText());
                myWriter.write(',');
                myWriter.write("going on");
                myWriter.write(',');
                myWriter.write(String.valueOf(Deadline.getValue().toString()));
                myWriter.write(',');
                myWriter.write(DescriptionTextArea.getText());
                myWriter.write(";");
                myWriter.flush();
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      
}
