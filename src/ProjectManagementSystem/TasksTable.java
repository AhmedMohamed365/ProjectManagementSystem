package ProjectManagementSystem;



import javafx.scene.Scene;

import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public  class TasksTable extends SplitPane {

    protected final AnchorPane grid;
    protected final TableView tableView;
    protected final TableColumn name;
    protected final TableColumn Status;
    protected final TableColumn DeadLine;
    protected final TableColumn Description;
    protected final TableColumn TeamLeader;
    protected final AnchorPane anchorPane0;
    protected final Scene scene ;
    public TasksTable() {

        grid = new AnchorPane();
        tableView = new TableView();
        name = new TableColumn();
        Status = new TableColumn();
        DeadLine = new TableColumn();
        Description = new TableColumn();
        TeamLeader = new TableColumn();
        anchorPane0 = new AnchorPane();

        setDividerPositions(0.8819095477386935);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setOrientation(javafx.geometry.Orientation.VERTICAL);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        grid.setId("AnchorPane");
        grid.setPrefHeight(162.0);
        grid.setPrefWidth(598.0);

        AnchorPane.setBottomAnchor(tableView, -14.0);
        AnchorPane.setLeftAnchor(tableView, 0.0);
        AnchorPane.setRightAnchor(tableView, 0.0);
        AnchorPane.setTopAnchor(tableView, 14.0);
        tableView.setLayoutY(14.0);
        tableView.setPrefHeight(348.0);
        tableView.setPrefWidth(598.0);

        name.setPrefWidth(75.0);
        name.setText("Name");

        Status.setPrefWidth(75.0);
        Status.setText("Status");

        DeadLine.setPrefWidth(75.0);
        DeadLine.setText("DeadLine");

        Description.setPrefWidth(75.0);
        Description.setText("Description");

        TeamLeader.setPrefWidth(75.0);
        TeamLeader.setText("TeamLeader");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(100.0);
        anchorPane0.setPrefWidth(160.0);

        tableView.getColumns().add(name);
        tableView.getColumns().add(Status);
        tableView.getColumns().add(DeadLine);
        tableView.getColumns().add(Description);
        tableView.getColumns().add(TeamLeader);

        grid.getChildren().addAll(tableView);

        scene = new Scene(grid,640,400);
    }
}
