

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

 

public class Booking {

    public Booking() {
    }

    private static List<Booking> bookings = new ArrayList<>();

    private guest g;
private Rooms room;
    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private int numberOfGuests;

    private Rooms bookedRoom;

   

    // Other fields and methods...

 

    public Booking(LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, Rooms bookedRoom) {

        this.checkInDate = checkInDate;

        this.checkOutDate = checkOutDate;

        this.numberOfGuests = numberOfGuests;

        this.bookedRoom = bookedRoom;

    }

    public Booking(guest g, Rooms room) {
        this.g = g;
        this.room = room;
    }

   

 

    // Getters and setters for fields...

 

    public static List<Booking> getBookings() {

        return bookings;

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

 

    public static void displayBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No bookings.");

        } else {

            System.out.println("All Bookings:");

            for (Booking booking : bookings) {

                System.out.println(booking);

            }

        }

    }

 

    @Override

    public String toString() {

        return "Booking{" +

                "checkInDate=" + checkInDate +

                ", checkOutDate=" + checkOutDate +

                ", numberOfGuests=" + numberOfGuests +

                ", bookedRoom=" + bookedRoom +

                '}';

    }

   

}