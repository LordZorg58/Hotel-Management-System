package hotel;

import java.util.ArrayList;
import java.util.Date;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
public class Booking  {
    
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private String bookingId; 
    private String roomType; 
    private int roomnumber;
    public  Date checkIn;
    public Date checkOut;
    private Integer rating;
    // Constructor
    public Booking(guest Guest,Date checkIn, Date checkOut, Rooms roomType) {
        this.bookingId =Guest.getName()+Guest.getPhone();  
        this.roomType = roomType.getCategory();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.rating = rating;
    }
    public Booking(guest Guest,Date checkIn, Date checkOut, Rooms roomType,Rooms roomnumber) {
        this.bookingId =Guest.getName()+Guest.getPhone();  
        this.roomType = roomType.getCategory();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.rating = rating;
        this.roomnumber=roomnumber.getRoomNumber();
    }
    public Booking(Date checkIn, Date checkOut, Rooms roomType) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType.getCategory();
    }


    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public Date getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public static ArrayList<Booking> getBookings() {
        return bookings;
    }
    public static void setBookings(ArrayList<Booking> bookings) {
        Booking.bookings = bookings;
    }
    public int getRoomnumber() {
        return roomnumber;
    }
    public void setRoomnumber(int roomnumber) {
        this.roomnumber = roomnumber;
    }

    public static void displayBookings() {
        
        if (bookings.isEmpty()) {
            System.out.println("No bookings.");
        }
        else 
        { 
           System.out.println("All Bookings:");            
            for (Booking booking : bookings) {
                System.out.println(booking);
            }

        }

    }

    public void addBooking(guest Guest, Date checkIn, Date checkOut, Rooms roomType, Rooms roomnumber) {

    if (roomnumber.isAvailability()) {
        Booking newBooking = new Booking(Guest, checkIn, checkOut, roomType, roomnumber);
        bookings.add(newBooking);
        roomnumber.setAvailability(false);
        System.out.println("Booking added successfully.");

    } else {
        System.out.println("Room is not available for booking.");
    }

}
public void editBooking(String bookingId, Date checkIn, Date checkOut) {

        Booking bookingToEdit = null;
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingId)) {
                bookingToEdit = booking;
                break;
            }
        }

        if (bookingToEdit != null) {
            bookingToEdit.setCheckIn(checkIn);
            bookingToEdit.setCheckOut(checkOut);
            System.out.println("Booking edited successfully.");
        } else {
            System.out.println("Invalid booking ID. No booking edited.");
        }

    }

public void removeBooking(String bookingId, Rooms roomnumber) {
    Booking bookingToRemove = null;
    for (Booking booking : bookings) {
        if (booking.getBookingId().equals(bookingId)) {
            bookingToRemove = booking;
            break;
        }
    }

    if (bookingToRemove != null) {
        bookings.remove(bookingToRemove);
        roomnumber.setAvailability(false);
        System.out.println("Booking removed successfully.");
    } else {
        System.out.println("Invalid booking ID. No booking removed.");
    }
}
// Override toString method to print booking details
        public long calculateNumberOfNights()  
    {
        long diffInMilliseconds = checkOut.getTime() - checkIn.getTime();
        return MILLISECONDS.toDays(diffInMilliseconds);
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", roomType=" + roomType + ", roomnumber=" + roomnumber + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", rating=" + rating + '}';
    }
    

  
    
}
//////////////////////////running ///////////////////////////////
//        public static void main(String[] args) {
//     
//        Date checkIn = new Date(2023, 0, 1);  // January 1, 2023
//        Date checkOut = new Date(2023, 0, 5);  // January 5, 2023
//
//     
//        Booking booking = new Booking("1", "Deluxe", checkIn, checkOut);
//
//     
//        System.out.println(booking);
//
//        long numberOfNights = booking.calculateNumberOfNights();
//        System.out.println("Number of nights: " + numberOfNights);
//    }


