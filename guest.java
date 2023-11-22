import java.util.List;
import java.util.Scanner;
import java.util.ArrayList; // Import ArrayList from java.util package

public class guest extends person {
 
    private ArrayList<Booking> bookingHistory; // Define the ArrayList to store booking history

public guest(String name, String email, String phone, AccountType accountType,ArrayList<Booking> bookingHistory) {
        super(name, email, phone, accountType);
        this.bookingHistory = bookingHistory;

    }


 public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    public void viewHistory() {
 if (bookingHistory.isEmpty()) {
            System.out.println("No booking history available.");//mhgzsh abl keda 2wl marh yro7
        } else {
     for (int i = 0; i < bookingHistory.size(); i++) {
         Booking booking = bookingHistory.get(i);
         System.out.println(booking); // show  the booking information
}
    }
}
    public int rate(String value) {
        try {
            int intValue = Integer.parseInt(value);//parseint btconvert the string to inteager.
            if (intValue >= 1 && intValue <= 10) {
                return intValue;
            } else {
                System.out.println("Rating should be from 1 to 10.");
                Scanner scanner = new Scanner(System.in);
                String newValue = scanner.nextLine();
                return rate(newValue);
            }
        }
       
        catch (NumberFormatException e)//lw da5l letters
        {
            System.out.println("Please enter a NUMBER.");
            Scanner scanner = new Scanner(System.in);
            String newValue = scanner.nextLine();
            return rate(newValue);
        }
        catch (Exception e) {
            System.out.println("Something went wrong.");
            Scanner scanner = new Scanner(System.in);
            String newValue = scanner.nextLine();
            return rate(newValue);
        }
    }
}