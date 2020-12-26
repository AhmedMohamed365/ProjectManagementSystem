package ProjectManagementSystem;

import java.util.Date;

import javafx.stage.Stage;

public class Task extends Stage {

private String taskName;
private int member_id;
private String description;
private Date deadline;
private String status;
 public Task(String name, int member_id, String description, Date deadLine, String status ) {
     this.taskName =name;
     this.status=status;
     this.deadline=deadLine;
     this.description=description;
     this.member_id=member_id;
    }

    public String getTaskName() {
        return taskName;
    }

 public String getStatus() {
        return status;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getDescription() {
        return description;
    }
    // private State Status; Define Enum Here check the tutorial :)
    
//Make consturctors here
    
    public void DisplayInfo() {
    }
}
