package ProjectManagementSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.io.*;

import java.nio.charset.StandardCharsets;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.scene.control.TableView;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.control.TableColumn;


import javafx.stage.Stage;

public class TableScene extends VBox {
    protected Scene scene ;
    protected final MenuBar menuBar;
    protected final Menu menu;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final Menu menu0;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem menuItem1;
    protected final MenuItem menuItem2;
    protected final MenuItem menuItem3;
    protected final MenuItem menuItem4;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem menuItem5;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem menuItem6;
    protected final Menu menu1;
    protected final MenuItem menuItem7;
    protected final MenuItem menuItem8;
    protected final SeparatorMenuItem separatorMenuItem2;
    protected final MenuItem menuItem9;
    protected final MenuItem menuItem10;
    protected final MenuItem menuItem11;
    protected final MenuItem menuItem12;
    protected final SeparatorMenuItem separatorMenuItem3;
    protected final MenuItem menuItem13;
    protected final MenuItem menuItem14;
    protected final Menu menu2;
    protected final MenuItem menuItem15;
    protected final AnchorPane grid;
    protected final TableView<Task> tableView;
    protected final TableColumn<Task, String> Task_Name_Column,Member_Id_Column,Task_Status_Column,Deadline_Column,Task_Description_Column;
    protected final Button addBt,editBt,deleteBt,doneBt;
    
    //get reference for the main window of the application
     Stage primaryWindow;
         // make an object to store old data when editing task and passing it to another class

      Task oldTask  =  new Task();
    public TableScene() {
        CreatingTaskScene createTask = new CreatingTaskScene(this);
        menuBar = new MenuBar();
        menu = new Menu();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menu0 = new Menu();
        separatorMenuItem = new SeparatorMenuItem();
        menuItem1 = new MenuItem();
        menuItem2 = new MenuItem();
        menuItem3 = new MenuItem();
        menuItem4 = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        menuItem5 = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        menuItem6 = new MenuItem();
        menu1 = new Menu();
        menuItem7 = new MenuItem();
        menuItem8 = new MenuItem();
        separatorMenuItem2 = new SeparatorMenuItem();
        menuItem9 = new MenuItem();
        menuItem10 = new MenuItem();
        menuItem11 = new MenuItem();
        menuItem12 = new MenuItem();
        separatorMenuItem3 = new SeparatorMenuItem();
        menuItem13 = new MenuItem();
        menuItem14 = new MenuItem();
        menu2 = new Menu();
        menuItem15 = new MenuItem();
        grid = new AnchorPane();
        tableView = new TableView();
        Task_Name_Column  = new TableColumn<Task,String>();
        Member_Id_Column = new TableColumn();
        Task_Status_Column = new TableColumn();
        Deadline_Column = new TableColumn();
        Task_Description_Column = new TableColumn();
        addBt = new Button();
        editBt = new Button();
        deleteBt = new Button();
        doneBt = new Button();

        setMinHeight(400.0);
        setMinWidth(640.0);
        setPrefHeight(400.0);
        setPrefWidth(640.0);

        VBox.setVgrow(menuBar, Priority.NEVER);

        menu.setMnemonicParsing(false);
        menu.setText("File");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("New");

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Open�");

        menu0.setMnemonicParsing(false);
        menu0.setText("Open Recent");

        separatorMenuItem.setMnemonicParsing(false);

        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Close");

        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("Save");

        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("Save As�");

        menuItem4.setMnemonicParsing(false);
        menuItem4.setText("Revert");

        separatorMenuItem0.setMnemonicParsing(false);

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Preferences�");

        separatorMenuItem1.setMnemonicParsing(false);

        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Quit");

        menu1.setMnemonicParsing(false);
        menu1.setText("Edit");

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Undo");

        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("Redo");

        separatorMenuItem2.setMnemonicParsing(false);

        menuItem9.setMnemonicParsing(false);
        menuItem9.setText("Cut");

        menuItem10.setMnemonicParsing(false);
        menuItem10.setText("Copy");

        menuItem11.setMnemonicParsing(false);
        menuItem11.setText("Paste");

        menuItem12.setMnemonicParsing(false);
        menuItem12.setText("Delete");

        separatorMenuItem3.setMnemonicParsing(false);

        menuItem13.setMnemonicParsing(false);
        menuItem13.setText("Select All");

        menuItem14.setMnemonicParsing(false);
        menuItem14.setText("Unselect All");

        menu2.setMnemonicParsing(false);
        menu2.setText("Help");

        menuItem15.setMnemonicParsing(false);

        tableView.setLayoutX(20.0);
        tableView.setLayoutY(27.0);
        tableView.setPrefHeight(300.0);
        tableView.setPrefWidth(600.0);
        
        //Adding multiple Selection Feature :)  @AhmedMohamed
        
        tableView.getSelectionModel().setSelectionMode(
                                     SelectionMode.MULTIPLE
                                                            );

        Task_Name_Column.setMinWidth(80.0);
        Task_Name_Column.setPrefWidth(100.0);
        Task_Name_Column.setText("Task name");

        Member_Id_Column.setMinWidth(100.0);
        Member_Id_Column.setPrefWidth(100.0);
        Member_Id_Column.setText("members id");

        Task_Status_Column.setMinWidth(80.0);
        Task_Status_Column.setPrefWidth(100.0);
        Task_Status_Column.setText("Task status");

        Deadline_Column.setMinWidth(50.0);
        Deadline_Column.setPrefWidth(100.0);
        Deadline_Column.setText("Deadline");

        Task_Description_Column.setMinWidth(100.0);
        Task_Description_Column.setPrefWidth(200.0);
        Task_Description_Column.setText("Task description");
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        addBt.setLayoutX(20.0);
        addBt.setLayoutY(336.0);
        addBt.setMnemonicParsing(false);
        addBt.setPrefHeight(31.0);
        addBt.setPrefWidth(90.0);
        addBt.setText("Add task");
//        addBt.setOnAction(event -> {
//            this.scene = createTask.scene;
//        });

        editBt.setLayoutX(204.0);
        editBt.setLayoutY(336.0);
        editBt.setMnemonicParsing(false);
        editBt.setPrefHeight(31.0);
        editBt.setPrefWidth(90.0);
        editBt.setText("Edit task");

        deleteBt.setLayoutX(370.0);
        deleteBt.setLayoutY(336.0);
        deleteBt.setMnemonicParsing(false);
        deleteBt.setPrefHeight(31.0);
        deleteBt.setPrefWidth(90.0);
        deleteBt.setText("Delete task");

        doneBt.setLayoutX(530.0);
        doneBt.setLayoutY(336.0);
        doneBt.setMnemonicParsing(false);
        doneBt.setPrefHeight(31.0);
        doneBt.setPrefWidth(90.0);
        doneBt.setText("DoneButton");

        menu.getItems().addAll(menuItem,menuItem0,menu0,separatorMenuItem,menuItem1,menuItem2,menuItem3,menuItem4,separatorMenuItem0,menuItem6);

        menuBar.getMenus().add(menu);
        menu1.getItems().add(menuItem7);
        menu1.getItems().add(menuItem8);
        menu1.getItems().add(separatorMenuItem2);
        menu1.getItems().add(menuItem9);
        menu1.getItems().add(menuItem10);
        menu1.getItems().add(menuItem11);
        menu1.getItems().add(menuItem12);
        menu1.getItems().add(separatorMenuItem3);
        menu1.getItems().add(menuItem13);
        menu1.getItems().add(menuItem14);
        menuBar.getMenus().add(menu1);
        menu2.getItems().add(menuItem15);
        menuBar.getMenus().add(menu2);


        tableView.getColumns().addAll(Task_Name_Column,Member_Id_Column,Task_Status_Column,Deadline_Column,Task_Description_Column);

        grid.getChildren().addAll(menuBar,tableView,addBt,editBt,deleteBt,doneBt);
        scene = new Scene(grid,640,380);
        
        addBt.setOnAction(event -> {
            primaryWindow.setScene(createTask.scene);
        });
        
        createTask.CancelButton.setOnAction(event -> {
            primaryWindow.setScene(scene);
            createTask.TaskName.setText("");
            createTask.MemberId.setText("");
            createTask.Deadline.setValue(LocalDate.now());
            createTask.DescriptionTextArea.setText("");

        });
        
        //edit Button functionality
        
         editBt .setOnAction(event -> {
             
                //Convert ObservableList to the task object again to save changes.     
                       //            try {
                   
             
               Task[] selectedTask = tableView.getSelectionModel().getSelectedItems().toArray(new Task[0]);
               createTask.TaskName.setText(selectedTask[0].getTaskName().get());
                              createTask.MemberId.setText(selectedTask[0].member_idProperty().get()); 
                                             createTask.DescriptionTextArea.setText(selectedTask[0].descriptionProperty().get()); 
                                             createTask.Deadline.setValue(LocalDate.parse(selectedTask[0].deadlineProperty().get()));

               /*  we changed it's name to make it behave in different way in the createing page */
               
                createTask.AddButton.setText("Save Changes");
                
                /*this code is for have the old info of the task before editing it 
                and to check for it in th creating task window to not to write 
                it again into the file
                */
                
                oldTask.getTaskName().setValue(createTask.TaskName.getText());
                oldTask.member_idProperty().setValue(createTask.MemberId.getText());
                oldTask.deadlineProperty().setValue(createTask.Deadline.getValue().toString());
                oldTask.descriptionProperty().setValue(createTask.DescriptionTextArea.getText());
                
               // System.out.println("oldTask name : " + oldTask.getTaskName().get());
              primaryWindow.setScene(createTask.scene);
              
                    
             
                     
                     
                     
         
                                                                                                                 
                                                                                                                   
                                                                                                                   
                                                                                                                   
                                                                                                                   
                                                                                                                   
        });
        
        //done Button functionality
        doneBt .setOnAction(event -> {
          
                       //Convert ObservableList to the task object again to save changes.     
                       //            try {
                   
                    //list that contains done tasks only
                    Task[] doneList = tableView.getSelectionModel().getSelectedItems().toArray(new Task[0]);
                    
                      tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
                      // to get the on going list
                       Task[] leftedList =   tableView.getItems().toArray(new Task[0]) ;  
                    //this to ensure  that first time we remove all the content from the file then we append to it 
                    //we don't want to remove the content every time ! 
                     boolean append = false;
                    
                    
                     
                     
                     for(Task oneTask : leftedList)
                     {
                         UpdateStatus(oneTask, append, oneTask.getStatus().get());
                         append = true;    
                     }
                     
                   
                   
                     for(Task oneTask : doneList)                                                                                                                    
                     {   
                         UpdateStatus(oneTask, true,"Done");                                                                                                           
                       
                                                                                                                
                     }
                     
                     
                     
            try {
                Readtable();
            } catch (IOException ex) {
                Logger.getLogger(TableScene.class.getName()).log(Level.SEVERE, null, ex);
            }
                                                                                                                 
                                                                                                                   
                                                                                                                   
                                                                                                                   
                                                                                                                   
                                                                                                                   
        });
        
        deleteBt .setOnAction(event -> {
            tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
                       //Convert ObservableList to the task object again to save changes.     
                       //            try {
                    Task[] list =   tableView.getItems().toArray(new Task[0]) ;  
                    //this to ensure  that first time we remove all the content from the file then we append to it 
                    //we don't want to remove the content every time ! 
                     boolean append = false;                                                                                            
                     for(Task oneTask : list)                                                                                                                    
                     {                                                                     
                         UpdateAferDeletion(oneTask, append);                                                                                                           
                         append = true;                                                                                                             
                                                                                                                   
                     }                                                                                              
                                                                                                                 
                                                                                                                   
                                                                                                                   
                                                                                                                   
                                                                                                                   
                                                                                                                   
        });
        tableView.setOnKeyPressed(event ->
                {
                    if (event.getCode()== KeyCode.DELETE)
                    {
                        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
                    }
                    if (event.getCode()== KeyCode.INSERT)
                    {
                        this.scene = createTask.scene;
                    }
                });
    }

    public void IntializeCoulmns()
    {
        Task_Name_Column.setCellValueFactory(data -> data.getValue().getTaskName());
        Member_Id_Column.setCellValueFactory(data -> data.getValue().member_idProperty());
        Task_Status_Column.setCellValueFactory(data -> data.getValue().statusProperty());
        Deadline_Column.setCellValueFactory(data -> data.getValue().deadlineProperty());
        Task_Description_Column.setCellValueFactory(data -> data.getValue().descriptionProperty());
    }
    public void  Readtable () throws IOException {
        Scanner scanner = new Scanner(Paths.get("table.txt"), StandardCharsets.UTF_8.name());
        int counter=0;

        Task task[]  = new Task[100] ;
        ObservableList<Task> list = FXCollections.observableArrayList();
        IntializeCoulmns();
        while(scanner.hasNext())
        {
            String content = scanner.useDelimiter("\\;").next();
            String[] details = content.split(",");
            task[counter] = new Task();
            task[counter].setTaskName(details[0]);
            task[counter].setMember_id(details[1]);
            task[counter].setStatus(details[2]);
            task[counter].setDeadline(details[3]);
            task[counter].setDescription(details[4]);
            list.add(task[counter]);
            counter++;
        }
        tableView.setItems(list);
        scanner.close();






    }

     public void UpdateStatus(Task task,boolean append,String status)
    {
        try {
                FileWriter myWriter = new FileWriter("table.txt",append);
                myWriter.write(task.taskNameProperty().get());
                myWriter.write(',');
                myWriter.write(task.member_idProperty().get());
                myWriter.write(',');
                myWriter.write(status);
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
    public void UpdateAferDeletion(Task task,boolean append)
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
}
