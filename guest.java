
package hotel;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class guest extends person { 
private ArrayList<Booking> bookingHistory; 

public guest(String name, String email, String phone,ArrayList<Booking> bookingHistory) {
        super(name, email, phone);
        this.bookingHistory = bookingHistory;
    }


 public void setBookingHistory(ArrayList<Booking> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }
    
//view from BookingList     
    public void viewHistory() {

     for (int i = 0; i < bookingHistory.size(); i++) {
         Booking booking = bookingHistory.get(i);
         System.out.println(booking); // show  the booking information

    }
}
    
//rating
  public int rate(String bookingId, String value) {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue >= 1 && intValue <= 10) {
                // Find the booking with the given bookingId and set its rating
                for (Booking booking : bookingHistory) {
                    if (booking.getBookingId().equals(bookingId)) {
                        booking.setRating(intValue);
                        break;
                    }
                }
                return intValue;
            } else {
                System.out.println("Rating should be from 1 to 10.");
                Scanner scanner = new Scanner(System.in);
                String newValue = scanner.nextLine();
                return rate(bookingId, newValue);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a NUMBER.");
            Scanner scanner = new Scanner(System.in);
            String newValue = scanner.nextLine();
            return rate(bookingId, newValue);
        }
        catch (Exception e) {
            System.out.println("Something went wrong.");
            Scanner scanner = new Scanner(System.in);
            String newValue = scanner.nextLine();
            return rate(bookingId, newValue);
        }
    }
    }

