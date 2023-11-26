
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
         Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for sign-in (Admin,Guest,Receptionist),2 for sign-up(Guest ONLY)");
        String choice = input.next();
     input.nextLine(); // Lw shlnh hyb2h yzhar username: wa b3d kdh password 3ltool wa byt3ml cin ll pass .
try{
        switch (choice) {
            case "1":
                System.out.println("Enter username:");
                String user = input.nextLine();

                System.out.println("Enter password:");
                String pass = input.nextLine();
                login(user, pass);
                break;
            case "2":
                boolean isConfirmed = false;
                while (!isConfirmed) {
                    System.out.println("Enter new username:");
                    String newUser = input.nextLine();
                    System.out.println("Enter new password:");
                    String newPass = input.nextLine();
                    System.out.println("For confirmation write password again .");
                    String passConf = input.nextLine();
                    if (passConf.equals(newPass)) {
                        signUp(newUser, newPass);
                        System.out.println("Username and Password is created successfully");
                        isConfirmed = true;
                    } else {
                        System.out.println("You entered the password wrong. Take care of upper and lowercase.");
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
}
 catch (Exception e) {
    System.out.println("Something went wrong. Please try again.");
}

    }

    public static void login(String user, String pass) {
        if (user.equals("Admin") && pass.equals("Admin123")) {
            System.out.println("Admin logged in successfully!");
          // Go to admin class
         // Create an instance of the Admin class
        //Admin admin = new Admin();
       // Call a method from the Admin class
      //admin.someMethod();
            
            
        } else if (user.equals("Receptionist") && pass.equals("Receptionist123")) {
            System.out.println("Receptionist logged in successfully!");
           // Go to Receptionist class
          // Create an instance of the Receptionist class
         //   Receptionist receptionist = new Receptionist();
        // Call a method from the Receptionist class
       // receptionist.someMethod();
            
        } else {
            checkGuestLogin(user, pass);
        }
    }

    public static void checkGuestLogin(String user, String pass) {
        try {
            Scanner scanner = new Scanner(new File("UserAndPass.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String usernameFromFile = parts[0];
                String passwordFromFile = parts[1];
                if (user.equals(usernameFromFile) && pass.equals(passwordFromFile)) {
                    System.out.println("Guest logged in successfully!");
           // Go to Guest class
          // Create an instance of the Receptionist class
          ArrayList<Booking> bookingHistory = new ArrayList<>();
// Create a Calendar instance
Calendar calendar = Calendar.getInstance();
calendar.set(2023, 0, 1);//0=jan
Date checkIn = calendar.getTime();
calendar.set(2023, 0, 4);
Date checkOut = calendar.getTime();

//Booking booking = new Booking("Mina+123", "Single", checkIn, checkOut, 3);
//guest guest = new guest("Mina", "Mina@gmail.com", "123",  bookingHistory);
//guest.rate("5");
//guest.viewHistory();

                    return;
                }
            }
            System.out.println("Username or password is wrong.");
        } catch (FileNotFoundException e) {
            System.out.println("UserAndPass file not found.");
        }
    }

    public static void signUp(String user, String pass) {
        try {

            /*FileWriter fileWriter = new FileWriter("UserAndPass.txt", true);
PrintWriter out = new PrintWriter(fileWriter);
             */
            PrintWriter out = new PrintWriter(new FileWriter("UserAndPass.txt", true));
            out.println(user + " " + pass);
            out.close();
        } catch (IOException e) {
            System.out.println("Unable to register user.");
        }
    }

        
        
        
    }
    

    

