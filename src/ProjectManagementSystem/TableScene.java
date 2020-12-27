package ProjectManagementSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;

import java.io.*;
import java.lang.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.*;
import javafx.scene.text.*;
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
    protected final Button AddTaskButton,EditTaskButton,DeleteTaskButton,button2;
     Stage primaryWindow;
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
        AddTaskButton = new Button();
        EditTaskButton = new Button();
        DeleteTaskButton = new Button();
        button2 = new Button();
        File DATA = new File("C:/Users/ahmed/OneDrive/Desktop/table.txt");

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

        AddTaskButton.setLayoutX(20.0);
        AddTaskButton.setLayoutY(336.0);
        AddTaskButton.setMnemonicParsing(false);
        AddTaskButton.setPrefHeight(31.0);
        AddTaskButton.setPrefWidth(90.0);
        AddTaskButton.setText("Add task");
        AddTaskButton.setOnAction(event -> {
            this.scene = createTask.scene;
        });

        EditTaskButton.setLayoutX(204.0);
        EditTaskButton.setLayoutY(336.0);
        EditTaskButton.setMnemonicParsing(false);
        EditTaskButton.setPrefHeight(31.0);
        EditTaskButton.setPrefWidth(90.0);
        EditTaskButton.setText("Edit task");

        DeleteTaskButton.setLayoutX(370.0);
        DeleteTaskButton.setLayoutY(336.0);
        DeleteTaskButton.setMnemonicParsing(false);
        DeleteTaskButton.setPrefHeight(31.0);
        DeleteTaskButton.setPrefWidth(90.0);
        DeleteTaskButton.setText("Delete task");

        button2.setLayoutX(530.0);
        button2.setLayoutY(336.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(31.0);
        button2.setPrefWidth(90.0);
        button2.setText("DoneButton");

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

        grid.getChildren().addAll(menuBar,tableView,AddTaskButton,EditTaskButton,DeleteTaskButton,button2);
        scene = new Scene(grid,640,380);
        AddTaskButton.setOnAction(event -> {
            primaryWindow.setScene(createTask.scene);
        });
        createTask.CancelButton.setOnAction(event -> {
            primaryWindow.setScene(scene);
            createTask.TaskName.setText("");
            createTask.MemberId.setText("");
            createTask.Deadline.setValue(LocalDate.now());
            createTask.DescriptionTextArea.setText("");

        });
        DeleteTaskButton .setOnAction(event -> {
            tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());
            try {
            File file = new File("C:/Users/ahmed/OneDrive/Desktop/file.txt");


                if (!file.isFile()) {
                    System.out.println("file was not created");
                    return;
                }
                BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA) );
                PrintWriter printWriter = new PrintWriter(new FileWriter(file));

            } catch (IOException e) {
                e.printStackTrace();
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
//        Collection<Task> list = Files.read(new File("C:/Users/ahmed/OneDrive/Desktop/table.txt").toPath())
//                .stream()
//                .map(line -> {
//

        Scanner scanner = new Scanner(Paths.get("C:/Users/ahmed/OneDrive/Desktop/table.txt"), StandardCharsets.UTF_8.name());
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

}
