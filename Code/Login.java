import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Login {

    public static void main(String[] args) {
        File file;
        Scanner scannerRead, scannerInput;
        String name, password, nameInput, passwordInput;
        ArrayList<String> nameArrayList = new ArrayList<String>();
        ArrayList<String> passwordArrayList = new ArrayList<String>();
        scannerInput = new Scanner(System.in);

        try {
            file = new File("Place Location of NameAndPassword.txt here");
            scannerRead = new Scanner(file);
            scannerRead.useDelimiter(",");

            //Stores the names and passwords from the .txt file into a name and password ArrayList
            while (scannerRead.hasNext()) {
                name = scannerRead.next();
                password = scannerRead.next();
                nameArrayList.add(name);
                passwordArrayList.add(password);
            }
            
            scannerRead.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        //Compares user input to the contents of the name and password ArrayLists
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter your name: ");
            nameInput = scannerInput.next();
            System.out.println("Please enter your password: ");
            passwordInput = scannerInput.next();
            if (nameArrayList.contains(nameInput) && passwordArrayList.contains(passwordInput)) {
                System.out.println("Login Successful");
                break;
            } else {
                System.out.println("Name and Password do not match, please try again" + "\n");
            }

        }

    }

}
