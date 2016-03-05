import java.io.File;
import java.util.Scanner;
import java.lang.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Application {
    
    //Private Instance Variables
    private ArrayList<Course> courseList = new ArrayList<Course>();
    private ArrayList<Account> accountList = new ArrayList<Account>();
    Account activeUser;
    private Scanner scanner;
    private Scanner lineScanner;
    
    /*
    This main Constructor acts as an "initialization" of the entire application. It will initialize the data by calling the
    loadCoursesData() and loadAccountsData() methods, and printout out the Login Screen.
    */
    public Application()
    {
        this.loadCoursesData();
        this.loadAccountsData();
        this.displayLoginScreen(); //Prints out the Login Screen for Logging In or Creating a New Account
        
    }
    
    
    /*
    *********************************
    Private Utility Methods
    *********************************
    */
    
    
    /*
    -This private utility method is used to load the Course data from the Courses.txt database. The first line of Courses.txt contains
    the column header names. They can either be ignored or removed from the Courses.txt file. Each subsequent line in the Courses.txt file
    represents a Course object. This method will read in each line and create a new Course object. The new Course object will  
    be added to this.courseList.
    -If the Courses.txt database does not exist, this method will terminate the program.
    -After this.courseList has been populated, sort the Courses so that it is in alphabetical order.
    -ASSIGNEE: Sam
    */
    private void loadCoursesData()
    {
        //stub
    }
    
    /*
    -This private utility method is used to load the Account data from AccountRecords.txt. If AccountRecords.txt does not already exist,
    it will be created. Each line in Account Records represents an Account object. This method will read in each line and create a
    new Account object. The new Account object will be stored in this.accountList.
    -ASSIGNEE: Noe
    */
    private void loadAccountsData()
    {
        //Check to see if AccountRecords.txt exists. If it doesn't, create it.
        File accountsFile = new File("AccountRecords.txt");
        if (accountsFile.exists() == false)
        {
            //Create the file
            try
            {
                PrintWriter pw = new PrintWriter("AccountRecords.txt","UTF-8");
                pw.close();
            }
            catch (IOException e)
            {
                System.out.println("Exception!");
            }
        }
        else //load in the data from AccountRecords.txt
        {
            try
            {
                scanner = new Scanner(accountsFile);
                while (scanner.hasNext())
                {
                        
                    ArrayList<String> tempAccountArrayList = new ArrayList<String>();
                    ArrayList<String> tempCourseIDArrayList = new ArrayList<String>();
                    ArrayList<Course> tempCourseArrayList = new ArrayList<Course>();
                        
                    
                    //Read in a line.
                    lineScanner = new Scanner(scanner.nextLine());
                    lineScanner.useDelimiter(",");
                    //Read in firstName, lastName, age, gender, ssn, username, password, studentID
                    for (int ii = 0; ii < 8; ii++)
                    {
                        tempAccountArrayList.add(lineScanner.next());
                    }
                    //Read in the registered coursesIDs.
                    while (lineScanner.hasNext())
                    {
                        tempCourseIDArrayList.add(lineScanner.next());
                    }
                    
                    //Populate tempCourseArrayList based on tempCourseIDArrayList
                    for (int ii = 0; ii < tempCourseIDArrayList.size(); ii++)
                    {
                        for (int jj = 0; jj < this.courseList.size(); jj++)
                        {
                            if (this.courseList.get(jj).getCourseID().equals(tempCourseIDArrayList.get(ii)))
                            {
                                tempCourseArrayList.add(this.courseList.get(jj));
                                break; //break out of the inner-loop and continue outer-loop
                            }
                        }
                    }
                    
                    //Create the Account object and add to this.accountList
                    this.accountList.add(new Account(tempAccountArrayList.get(0),
                                                     tempAccountArrayList.get(1),
                                                     Integer.parseInt(tempAccountArrayList.get(2)),
                                                     tempAccountArrayList.get(3),
                                                     tempAccountArrayList.get(4),
                                                     tempAccountArrayList.get(5),
                                                     tempAccountArrayList.get(6),
                                                     tempAccountArrayList.get(7)));
                    this.accountList.get(this.accountList.size() - 1).setRegisteredCourses(tempCourseArrayList);
                    lineScanner.close();
                }
                scanner.close();
                
            }
            catch (IOException e)
            {
                System.out.println("Exception!");
            }
            
        }
    }
    
    
    /*
    -This private utility method will be used when a user selects to create a new account at the login screen. This method will be
    executed AFTER all the data has been read in from the user.
    -The first step will be to validate that the studentID does not already exist.
        -If the studentID already exists, an error will be presented to the user that the studentID already exists and will be taken back to the initial 
        login screen.
        -If the studentID does not already exist, a new Account will be created and added to this.accountList. Then this method
        will add the new Account will be added as a new entry to AccountRecords.txt.
    -ASSIGNEE: Dave
    */
    private void createAccount(String firstName, 
                               String lastName, 
                               int age, 
                               String gender, 
                               String socialSecurityNumber,
                               String userName,
                               String password,
                               String studentID)

    {
        //Stub
    }
    
    /*
    -This private utility method will be called from the displayLoginScreen() method when a user attempts to login. The displayLoginScreen() method will read 
    in a userName and password and pass the values to this method. This method will validate that the userName and password pair is valid. if it is valid,
    it returns true, otherwise it returns false.
    -ASSIGNEE: Dave
    */
    private boolean loginUser(String userName, String password)
    {
        //stub
    }
    
    /*
    -This private utility method attempts to register a Course for the user. Based on the courseID provided, this method will call the
    activeUser.addCourse() method.
    -The addCourse() method will return true if the registration is successful and false if it is not.
    -This method will return the same true/false value.
    -ASSIGNEE: John
    */
    private boolean registerCourse(String courseID)
    {
        //identify the Course from this.courseList
        
        
    }
    
    /*
    -This private utility method attempts to unregister a Course for the user. Based on the courseID provided, this method will call the
    activeUser.removeCourse() method.
    -The removeCourse() method will return true if the registration is successful and false if it is not.
    -This method will return the same /true/false value.
    -ASSIGNEE: Noe
    */
    private boolean unRegisterCourse(String courseID)
    {
        //stub
    }
    
    /*
    -This private utility method displays the initial screen to the user. 
    -It may have a welcome message such as "Welcome to the Course Registration System"
    -It will prompt the user if he/she is an existing user.
        -If yes, the user will be prompted to enter userName and password, then this.loginUser() will be called.
        -If no, the user will be taken to the createAccountScreen(
    -If this.loginUser() returns false, then the user is prompted to reenter the userName and password.
    -If this.loginUser() returns true, then the user is presented with the following navigation options:
        -1 Course Registration
        -2 Profile
        -3 Logout
    -If the user selects "1" then display the Course Registration Screen.
    -If the user selects "2" then display the Profile Screen.
    -If the user selects "3" then display the Login Screen.
    -ASSIGNEE: Dave
    */
    private void displayLoginScreen()
    {
        //stub
    }
    
    /*
    -This private utility method displays the "Create Account" screen after the user has prompted that they do not have an existing account.
    -This method will read in firstName, lastName, age, gender, socialSecurityNumber, userName, password, and studentID
    -Once the data has been acquired, the data will be passed to the this.createAccount() method.
    -ASSIGNEE: Dave
    */
    private void displayCreateAccountScreen()
    {
        //stub
    }
    
    /*
    -This private utility method will display the "Course Registration" screen on successful login to the application and user selection.
    -This screen lists out all of the available courses from this.courseList.
    -This method will read in a courseID for the course in which the user intends to register to and pass it to this.registerCourse()
    -this.registerCourse() will return true or false depending on if the registration was successful or it failed.
        -If true is returned, display this.displayCourseRegistrationStatusScreen() with a successful Registration message.
        -If false is returned, display this.displayCourseRegistrationStatusScreen() with a failure Registration message.
    -ASSIGNEE: Alberto
    */
    private void displayCourseRegistrationScreen()
    {
        //stub
    }
    
    /*
    -This private utility method will display the "Course Registration Status" screen which informs the user if a registration or 
    unregistration is successful or if it failed.
    -After the message is displayed to the user, the user must "Enter any Key" to confirm. Then the user is displayed with navigation options.
        -1 Course Registration
        -2 Profile
        -3 Logout
    -If the user selects "1" then display the Course Registration Screen.
    -If the user selects "2" then display the Profile Screen.
    -If the user selects "3" then display the Login Screen.
    -ASSIGNEE: Alberto
    */
    private void displayCourseRegistrationStatusScreen()
    {
        //stub
    }
    
    /*
    -This private utility method will display the this.activeUser Profile Screen.
    -This screen will display this.activeUser's data by calling this.activeUser.toString()
    -This screen will display a list of all courses that this.activeUser is registered to using this.activeUser.getRegisteredCourses()
    -This method will read in a courseID from the user for the course in which the user intends to unregister, and then pass it to this.unRegisterCourse()
    -this.unRegisterCourse() will return true or false depending on if the unregistration was successful or it failed.
        -If true is returned, display this.displayCourseRegistrationStatusScreen() with a successful Unregistration message.
        -If false is returned, display this.displayCourseRegistrationStatusScreen() with a failure unregistration message.
    -ASSIGNEE: Alberto
    */
    private void displayProfileScreen()
    {
        //stub
    }
    
    
    
}