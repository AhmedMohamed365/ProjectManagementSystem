package ProjectManagementSystem;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


import java.io.FileWriter;
import java.io.IOException;


public class Account  {

    Stage window;
   TeamLeader leader;
   TeamMember member;
   Scene scene;
    TextField firstName = new TextField();
    TextField lastName = new TextField();
    TextField emailInput = new TextField();
    PasswordField passInput = new PasswordField();
    TextField mobilNumberIn = new TextField();
    ToggleGroup genderGroup , TeamGroup;
    RadioButton box1=new RadioButton("Male");
    RadioButton box2=new RadioButton("Female");
    RadioButton box3=new RadioButton("Team Leader");
    RadioButton box4=new RadioButton("Team member");
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

        GridPane.setConstraints(firstName,1,1);

        Label lastNamel = new Label("Last Name:");
        GridPane.setConstraints(lastNamel , 0,2);

        GridPane.setConstraints(lastName,1,2);

        Label email = new Label("Email:");
        GridPane.setConstraints(email , 0,3);

        emailInput.setPromptText("inpox@example.com");
        GridPane.setConstraints(emailInput,1,3);
        emailInput.getText();

        Label mobileNumber = new Label("Mobile Number:");
        GridPane.setConstraints(mobileNumber , 0,4);

        mobilNumberIn.setPromptText("+02***********");
        GridPane.setConstraints(mobilNumberIn,1,4);

        Label passLabel = new Label("password:");
        GridPane.setConstraints(passLabel , 0,5);

        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,5);

        genderGroup = new ToggleGroup();

        GridPane.setConstraints(box1,1,6);


        GridPane.setConstraints(box2,2,6);

        box1.setToggleGroup(genderGroup);
        box2.setToggleGroup(genderGroup);
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


        GridPane.setConstraints(box3,1,8);


        GridPane.setConstraints(box4,2,8);
TeamGroup = new ToggleGroup();
        box3.setToggleGroup(TeamGroup);
        box4.setToggleGroup(TeamGroup);
       Button signUpButton = new Button("    Sign Up    ");
      GridPane.setConstraints(signUpButton,1,9);
       signUpButton.setStyle("-fx-background-color: #8C8CFF");
       
       //new button here added
       Button signInButton = new Button("    Sign In    ");
       GridPane.setConstraints(signInButton,2,9);
       signUpButton.setStyle("-fx-background-color: #8C8CFF");
       
       signUpButton.setOnAction(e -> { 
            WriteData();
        });


        grid.getChildren().addAll(SignIn,firstName,firstNamel,lastName,lastNamel,email,emailInput,mobileNumber,mobilNumberIn, passLabel,
                BirthDay,year,month,day,passInput,box1,box2,box3,box4, signUpButton,signInButton);

        scene=new Scene(grid,720,480);
        window.setScene(scene);
        window.show();
    }
    public void WriteData ()
    {
        if (NotNull()) {
            try {
                FileWriter myWriter = new FileWriter("accounts.txt", true);
                myWriter.write(firstName.getText());
                myWriter.write(',');
                myWriter.write(lastName.getText());
                myWriter.write(',');
                myWriter.write(emailInput.getText());
                myWriter.write(',');
                myWriter.write(passInput.getText());
                myWriter.write(',');
                myWriter.write(mobilNumberIn.getText());
                myWriter.write(',');
                if (box1.isSelected())
                    myWriter.write(box1.getText());
                else
                    myWriter.write(box2.getText());
                myWriter.write(',');
                if (box3.isSelected())
                    myWriter.write(box3.getText());
                else
                    myWriter.write(box4.getText());
                myWriter.write(";");
                myWriter.write('\n');
                myWriter.flush();
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    boolean NotNull()
    {
        boolean flag = true ;
        if (firstName.getText().equals("") || lastName.getText().equals("") || passInput.getText().equals("")
                || emailInput.getText().equals("")||mobilNumberIn.getText().equals("") ||genderGroup.getSelectedToggle()==null
                ||TeamGroup.getSelectedToggle()==null)
                    flag = false ;
        for (char c : firstName.getText().toCharArray())
            if(Character.isDigit(c))
                flag = false;
        for (char c : lastName.getText().toCharArray())
            if(Character.isDigit(c))
                flag = false;
        for (char c : mobilNumberIn.getText().toCharArray())
            if(Character.isAlphabetic(c))
                flag = false;
        if(!(emailInput.getText().contains("@") && emailInput.getText().contains(".com")))
            flag = false;
        return flag ;
    }
    }
