package ProjectManagementSystem;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class Task extends Stage {

private StringProperty taskName = new SimpleStringProperty();

    private StringProperty member_id= new SimpleStringProperty();
    
private StringProperty description=new SimpleStringProperty();

private StringProperty deadline=new SimpleStringProperty();

private StringProperty status=new SimpleStringProperty();
    public void setMember_id(String member_id) {
        this.member_id.set(member_id);
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    

    public StringProperty member_idProperty() {
        return member_id;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public StringProperty deadlineProperty() {
        return deadline;
    }

    public StringProperty statusProperty() {
        return status;
    }



    public void setDeadline(String deadline) {
        this.deadline.set(deadline);
    }

    public Task(){

    }
 public Task(StringProperty name, StringProperty member_id, StringProperty description, StringProperty deadLine, StringProperty status ) {
     this.taskName =name;
     this.status=status;
     this.deadline=deadLine;
     this.description=description;
     this.member_id=member_id;
    }

    public StringProperty getTaskName() {
        return taskName;
    }

    public StringProperty getStatus() {
        return status;
    }

    
    public void setTaskName(StringProperty taskName) {
        this.taskName = taskName;
    }
    public StringProperty taskNameProperty() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName.set(taskName);
    }

    // private State Status; Define Enum Here check the tutorial :)
    
//Make consturctors here
    
    public void DisplayInfo() {
    }

}
