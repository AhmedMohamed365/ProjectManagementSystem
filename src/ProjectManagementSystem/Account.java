package ProjectManagementSystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;


public class Account  {

    Stage window;
   TeamLeader leader;
   TeamMember member;
   Scene scene;
    public Account(Stage window)
    {
        window.setTitle("sign up");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(50,100,200,100));
        grid.setHgap(8);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color:#626262");
        grid.setStyle("-fx-font_color:pink");

        Label SignIn = new Label("Sign In");
        GridPane.setConstraints( SignIn, 0,0);

        Label firstNamel = new Label("First Name:");
        GridPane.setConstraints(firstNamel , 0,1);
        TextField firstName = new TextField();
        GridPane.setConstraints(firstName,1,1);

        Label lastNamel = new Label("Last Name:");
        GridPane.setConstraints(lastNamel , 0,2);
        TextField lastName = new TextField();
        GridPane.setConstraints(lastName,1,2);

        Label email = new Label("Email:");
        GridPane.setConstraints(email , 0,3);
        TextField emailInput = new TextField();
        emailInput.setPromptText("inpox@example.com");
        GridPane.setConstraints(emailInput,1,3);
        emailInput.getText();

        Label mobileNumber = new Label("Mobile Number:");
        GridPane.setConstraints(mobileNumber , 0,4);
        TextField mobilNumberIn = new TextField();
        mobilNumberIn.setPromptText("+02***********");
        GridPane.setConstraints(mobilNumberIn,1,4);

        Label passLabel = new Label("password:");
        GridPane.setConstraints(passLabel , 0,5);
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,5);

        RadioButton box1=new RadioButton("Male");
        GridPane.setConstraints(box1,1,6);

        RadioButton box2=new RadioButton("Female");
        GridPane.setConstraints(box2,2,6);

        Label BirthDay = new Label("Birthday :");
        GridPane.setConstraints(BirthDay,0,7);




        ComboBox year = new ComboBox();
        year.getItems().addAll("2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990");
        year.setPromptText("Year");
        GridPane.setConstraints(year,1,7);

        ComboBox month = new ComboBox();
        month.getItems().addAll("January","Feb","March","April","May","June","July","August","September","October","November","December");
        month.setPromptText("Month");
        GridPane.setConstraints(month,2,7);

        ComboBox day = new ComboBox();
        day.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24",
                "25","26","27","28","29","30","31");
        day.setPromptText("Day");
        GridPane.setConstraints(day,3,7);

        RadioButton box3=new RadioButton("Team Leader");
        GridPane.setConstraints(box3,1,8);

        RadioButton box4=new RadioButton("Team member");
        GridPane.setConstraints(box4,2,8);

       Button signUpButton = new Button("    Sign Up    ");
      GridPane.setConstraints(signUpButton,1,9);
       signUpButton.setStyle("-fx-background-color: #8C8CFF");
       
       //new button here added
       Button signInButton = new Button("    Sign In    ");
       GridPane.setConstraints(signInButton,2,9);
       signUpButton.setStyle("-fx-background-color: #8C8CFF");
       
       signUpButton.setOnAction(e -> { 
            leader.setPassword(passInput.getText());
           leader.setEmail(emailInput.getText());   
            
        });


        grid.getChildren().addAll(SignIn,firstName,firstNamel,lastName,lastNamel,email,emailInput,mobileNumber,mobilNumberIn, passLabel,
                BirthDay,year,month,day,passInput,box1,box2,box3,box4, signUpButton,signInButton);

        scene=new Scene(grid,720,480);
        window.setScene(scene);
        window.show();
    
//    public static void main(String[] args) {
//        launch(args);
//    }
    }
    
    }
