package hotel;

import java.io.*;
import java.util.*;

public class Authentication {

    public static void login(String user, String pass) {
        if (user.equals("Admin") && pass.equals("Admin123")) {
            System.out.println("Admin logged in successfully!");
            // Go to admin class
        } else if (user.equals("Receptionist") && pass.equals("Receptionist123")) {
            System.out.println("Receptionist logged in successfully!");
            // Go to Receptionist class
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
            PrintWriter out = new PrintWriter(new FileWriter("UserAndPass.txt", true));
            out.println(user + " " + pass);
            out.close();
        } catch (IOException e) {
            System.out.println("Unable to register user.");
        }
    }
}
