import java.util.ArrayList;

public class Account extends Person {
    
    //Private Instance Variables
    private String userName;
    private String password;
    private String id;
    ArrayList<Course> registeredCourses = new ArrayList<Course>();
    
    //Main Constructor
    public Account(String firstName,
                  String lastName,
                  int age,
                  String gender,
                  String socialSecurityNumber,
                  String userName,
                  String password,
                  String id)
    {
        super(firstName,lastName,age,gender,socialSecurityNumber); //Calls the Constructor in the super class.
        this.userName = userName;
        this.password = password;
        this.id = id;
                   
    }
    
    /*
    *********************************
    Setter Methods
    *********************************
    */
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setRegisteredCourses(ArrayList<Course> registeredCourses)
    {
        this.registeredCourses = registeredCourses;
    }
    
    /*
    *********************************
    Getter Methods
    *********************************
    */
    
    public String getUserName()
    {
        return this.userName;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public ArrayList<Course> getRegisteredCourses()
    {
        return this.registeredCourses;
    }
    
    
    /*
    *********************************
    Class Methods
    *********************************
    */
  
    
   /* 
    -Attempts to add course to this.registeredCourses
        -Return false if course is duplicate or Course is at max Enrollment Limit.
        -If true, add course to this.registeredCourses
        -Then call course.incrementEnrollment() to increase enrollment of course by 1.
        -Then call this.updateAccountRecord() to update AccountRecords.txt with the new Course.
        -Then call this.updateCoursesRecord() to update Courses.txt with the "numEnrolled" Update.
            -Return true.
    -ASSIGNEE: John
   */
    public boolean addCourse(Course course)
    {
        return true; //stub
    }
    
   /* 
    -Attempts to remove course from this.registeredCourses
        -Return false if user is not registered to Course
        -If true, remove Course from this.registeredCourses
        -Then call course.decrementEnrollment() to decrease enrollment of course by 1.
        -Then call this.updateAccountRecord() to update AccountRecords.txt with the removal of the Course.
        -Then call this.updateCoursesRecord() to update Courses.txt with the "numEnrolled" update.
            -Return true.
    -ASSIGNEE: Noe
   */
    public boolean removeCourse(Course course)
    {
        if (!this.registeredCourses.contains(course)) // if Account is not registered to class, return false.
        {
            return false;
        }
        
        //Remove course from registeredCourses
        this.registeredCourses.remove(course);
        //Decrement Enrollment
        course.decrementEnrollment();
        //Update databases
        updateAccountRecord(remove,course);
        updateCoursesRecord(course);
        
        return true;

    }
    
    /*
    *********************************
    Private Utility Methods
    *********************************
    */


    /*
    -This private utility method will update the AccountRecords.txt file with the addition or removal of a Course for this Account.
    -ASSIGNEE: John
    */
    private void updateAccountRecord(String cmd, Course course)
    {
        if (cmd.toUpperCase().equals("REMOVE"))
        {
            //Remove Registered Course in AccountRecord.txt for this Account
        }
        else if (cmd.toUpperCase().equals("ADD"))
        {
            //Add Registered Course in AccountRecord.txt for this Account
        }
    }
    
    /*
    -This private utility method will update the Courses.txt file with the "numEnrolled" update due to an addition or removal of a registered Course.
    -ASSIGNEE: Noe
    */
    private void updateCoursesRecord(Course course)
    {
        //re-print this course record in Courses.txt. The numEnrolled value will be updated.
    }
    
    
    
}