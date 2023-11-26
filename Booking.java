package hotel;

import java.util.Date;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Booking {

    private String bookingId;// name of guest+phone FROM guest class 
    private String roomType;//enumeration  rooms htb2h (room roomtype)
    public  Date checkIn;//(day ,month,year)//note el months from zero 
    public Date checkOut;//(day ,month,year)
    private Integer rating; // Changed from int to Integer to allow null values


    public long calculateNumberOfNights() //we can use it later to calulate the price of room 
    {
        long diffInMilliseconds = checkOut.getTime() - checkIn.getTime();
        return MILLISECONDS.toDays(diffInMilliseconds);
    }

    // Constructor
    public Booking(guest Guest, String roomType, Date checkIn, Date checkOut,Integer rating) {
        this.bookingId =Guest.getName()+Guest.getPhone();  
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.rating = rating;
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

    // Override toString method to print booking details

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", roomType=" + roomType + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", rating=" + rating + '}';
    }
  
    

}




















///////////////////////this is the old one try to build something better 
/*
public class Booking {

    private static List<Booking> bookings = new ArrayList<>();
    private Rooms room;
    
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Rooms bookedRoom;
    private int numberOfNights;

    
    
////////////////////////////////////////CONSTRUCTOR ///////////////////////////////////////////////////////////////////////////
    public Booking(guest g, Rooms room,LocalDate checkInDate, LocalDate checkOutDate, Rooms bookedRoom) {
       
        this.g = g;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.bookedRoom = bookedRoom;

    }
  
    
/////////////////////////////////SETTERS AND GETTERS////////////////////////////////////////////////////////////////////////
    
    public static List<Booking> getBookings() {
        return bookings;
    }
    public static void setBookings(List<Booking> bookings) {
        Booking.bookings = bookings;
    }

    public guest getG() {
        return g;
    }
    public void setG(guest g) {
        this.g = g;
    }

    public Rooms getRoom() {
        return room;
    }
    public void setRoom(Rooms room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
  
    public Rooms getBookedRoom() {
        return bookedRoom;
    }
  public void setBookedRoom(Rooms bookedRoom) {
        this.bookedRoom = bookedRoom;
    }
 

  
  
  
  //////////////////////////////////ADD,REMOVE,EDIT///////////////////////////////////////////////////////////////////////
    public void addBooking(LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {

        if (bookedRoom.isAvailability()) {
            Booking newBooking = new Booking(checkInDate, checkOutDate, numberOfGuests, bookedRoom);
            bookings.add(newBooking);
            bookedRoom.setAvailability(false);
            System.out.println("Booking added successfully.");

        } else {
            System.out.println("Room is not available for booking.");
        }

    }
    public void removeBooking(int index) {

        if (index >= 0 && index < bookings.size()) {

            Booking removedBooking = bookings.remove(index);

            bookedRoom.setAvailability(true);

            System.out.println("Booking removed successfully.");

        } else {
            System.out.println("Invalid index. No booking removed.");
        }
    }
    public void editBooking(int index, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {

        if (index >= 0 && index < bookings.size()) {

            Booking booking = bookings.get(index);

            booking.setCheckInDate(checkInDate);

            booking.setCheckOutDate(checkOutDate);

            booking.setNumberOfGuests(numberOfGuests);

            System.out.println("Booking edited successfully.");

        } else {

            System.out.println("Invalid index. No booking edited.");

        }

    } 

    
    
    
    //////////////////////////////////DISPLAY BOOKING////////////////////////////////////////////////////////////////////////
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

 


}*/



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