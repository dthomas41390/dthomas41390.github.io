import java.io.File;
import java.util.Scanner;
import java.lang.*;
import java.io.IOException;

public class FileReading {
    
    //Private Instance Variables
    private File file;
    private Scanner scanner;
    
    public FileReading()
    {
        try
        {
            this.file = new File("/Users/noebrito/OneDrive/UCIJava1/workspace/CourseRegistrationSystem/team-b/Documentation/Courses.txt");
            this.scanner = new Scanner(file,"UTF-8");
            this.scanner.useDelimiter("\",\"");
        }
        catch (IOException e)
        {
            System.out.println("File Not Found Exception");
        }
    }
    
    public void readFile()
    {

        while (this.scanner.hasNext())
        {
        	
        	System.out.println(this.scanner.next());
            
        }
        
        // System.out.println(this.scanner.next());
        // System.out.println(this.scanner.next());
        // System.out.println(this.scanner.next());
        // System.out.println(this.scanner.next());
    }
    
    
    
    
}