
package hotel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class Hotel {


    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
  
        System.out.println("Welcome to the Hotel System!");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                // Call the login method
                System.out.println("Please enter your username:");
                String username = scanner.nextLine();
                System.out.println("Please enter your password:");
                String password = scanner.nextLine();
                Authentication.login(username, password);
                break;
            case "2":
                // Call the sign-up method
                System.out.println("Please enter your new username:");
                String newUser = scanner.nextLine();
                System.out.println("Please enter your new password:");
                String newPass = scanner.nextLine();
                Authentication.signUp(newUser, newPass);
                break;
            case "3":
                System.out.println("Thank you for using the Hotel System. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
       
        
        
 

    

