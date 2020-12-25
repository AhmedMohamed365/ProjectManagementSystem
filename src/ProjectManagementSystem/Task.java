package ProjectManagementSystem;

import java.util.Date;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Task extends Stage {


private String name;


//Needed to be changed to  Enum not String ! @Ahmed abu alfarh
private String status;

private Date deadLine;
private  String Description ;
private String TeamLeader;
public static int nOfTasks=0;
    
 public Task(String name,Date date , String status , String TeamLeader ) {
     
     setMaxWidth(500);
     setMaxHeight(500);
     nOfTasks++;
     
     this.name=name;
     
       this.deadLine=date;
       this.status = status;
       this.TeamLeader = TeamLeader;
     
    }

    public String getName() {
        return name;
    }

    public Date getDeadLine() {
        return deadLine;
    }
 public String getStatus() {
        return status;
    }
    
   // private State Status; Define Enum Here check the tutorial :)
    
//Make consturctors here
    
    public void DisplayInfo()
    
    {
        
        
    }
}
