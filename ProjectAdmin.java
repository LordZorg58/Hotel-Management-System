/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

/**
 *
 * @author pc2
 */
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;

public class Admin {
Rooms r=new Rooms();
Booking b=new Booking();

public void ADD(int roomNumber, String room, Guest guest){
    
    r.addRoom(roomNumber, room,guest);
}

    public void ADD(LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests){
    r.addBooking(LocalDate.MIN, LocalDate.EPOCH, 0);
    }
public void REMOVE_room(int roomNumber){
    r.removeRoom(roomNumber);
}
public void REMOVE_booking(int index){
    
    b.removeBooking(index);
}
    public void EDIT(int roomNumber, String newCategory, boolean newAvailability){
        r.editRoom(roomNumber, newCategory, newAvailability);
    
    }
    public void EDIT(int index, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests){
        b.editBooking(index, checkInDate, checkOutDate, numberOfGuests);
    }
    public void ListRooms (){
        for(int i=0;i<r.listRooms().size();i++){
       r.listRooms().listIterator(i);
        }        
    }
    public void ListBooking(){
        b.displayBookings();
        
    }
private void ViewReport(){
    System.out.println(r.getRoomNumber()+"   " + r.getCategory() );
    System.out.println(r.getReservation()+"  "+r.getCheckInDate() + " until " + r.getCheckOutDate() );
    //most reserved room--->-->loop to loop on all of the rooms and return the most reserved 
   //room by the room number though out a reservation counter in the room class
    System.out.println(r.findmostrevenue());
    
} 
    
    
}
