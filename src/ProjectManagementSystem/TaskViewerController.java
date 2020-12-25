/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectManagementSystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author hp
 */
public class TaskViewerController implements Initializable {

    /**
     * somethings need to be removed don't forget
     */
    public Label label;
    public GridPane TaskPane;
    
    public VBox box1;
    //to be used Later
    public StringProperty x = new SimpleStringProperty("");
  
    public Stage taskDetailsWindow;
   
    @FXML
   public Label name1;
     public Label ahmed;
     public Label Deadline1;
      public Label status1;
   
   
   
     public TaskViewerController() 
     
    {
 
    }

    public void ShowTaskDetails( )
    {
        
      taskDetailsWindow.show();
    }
    public void handleLabel(MouseEvent event) { 
     //System.out.println("You clicked me!");
     
     ShowTaskDetails();
  //  name1.setText("sdds");
}
    
    
        public void Do(MouseEvent event) { 
     System.out.println("You clicked me!");
     
     //name1.setText("sdds");
}
        
        //Change one task only
    public  void changeTaskData (String Name,String Deadline,String Status){
          name1.setText(Name);
          Deadline1.setText(Deadline);
          status1.setText(Status);
          
    }
    
    //Put the tasks info into gridpane cells 
    public void FillTasksData (String s[],int noftasks,int r ){
        for (int x=0+r;x<noftasks;x++)
        {
            
        VBox Tp = (VBox)TaskPane.getChildren().get(x);
        //change 3 labels inside each VBox
     for (int i=0;i<3;i++)
     {
          Label l =(Label)Tp.getChildren().get(i);
            System.out.println(l);
         l.setText(s[i]);
         
     }
     
               }
    }
    
    
    //Don't focus here 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    void setLocation(URL resource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
