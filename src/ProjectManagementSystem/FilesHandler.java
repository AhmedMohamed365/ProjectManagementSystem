package ProjectManagementSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class FilesHandler {
 
    
  FileReader input;
  PrintWriter output;
  FileWriter file;
  char [] c;
    public FilesHandler() throws FileNotFoundException, IOException {
        
//        this.output = new PrintWriter("Tasks.txt");
//                 output.write("Hello to file stream in java");
// 

       input = new FileReader("Tasks.txt");
       input.read();
    }
    
}
