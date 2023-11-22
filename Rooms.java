
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */

public class Rooms extends Booking{
     Rooms room;
     guest guest;
      private int roomNumber;
      private String category;
      private boolean availability;
      List<Booking> reservation;
      private double revenue;
     private static List<Rooms> listRooms ;//de 3shan 23mel list feha kol 2l rooms ta2reban lazm tb2a fe 2l admin class

     private static List<Integer> roomNumbers ;  // hena 2na hawelt 23mel list 2hot feha kol 2l room numbers 3shan tsa3edny fe 2ny 23mel add le new room
     private static Map<Integer, Rooms> roomsByNumber = new HashMap<>();
   

    public Rooms( Rooms room,int roomNumber, String category, boolean availability, List<Booking> reservation, double revenue) {
       
        this.roomNumber = roomNumber;
        this.category = category;
        this.availability = availability;
        this.reservation = reservation;
        this.revenue = revenue;
        roomNumbers.add(roomNumber); // Add the room number to the list
        listRooms.add(this); // Add the room to the list of rooms
        roomsByNumber.put(roomNumber,this );
    }

    public Rooms(guest guest, int roomNumber, String category) {
        this.guest = guest;
        this.roomNumber = roomNumber;
        this.category = category;
    }

    public Rooms(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
    }

   
    public Rooms(int roomNumber, Rooms room) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.availability = true;
        this.reservation = new ArrayList<>();
        this.revenue = 0.0;
         roomNumbers.add(roomNumber); // Add the room number to the list
        listRooms.add(this); // Add the room to the list of rooms
        roomsByNumber.put(roomNumber,this);

    }

    public Rooms() {
    }
   

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Booking> getReservation() {
        return reservation;
    }

    public void setReservation(List<Booking> reservation) {
        this.reservation = reservation;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

 

    public static Map<Integer, Rooms> getRoomsByNumber() {
        return roomsByNumber;
    }
     
   
        public void addReservation(Booking reservation) {
      room.addBooking(reservation.getCheckInDate(),reservation.getCheckOutDate(),reservation.getNumberOfGuests());
        System.out.println("Reservation added successfully.");
     }
 
      public void addRoom(int roomNumber, String room, guest guest) {
         
          Rooms newRoom = new Rooms(roomNumber, room);
          Booking reservation = new Booking(guest, newRoom);
          newRoom.addReservation(reservation);
        System.out.println("Room " + roomNumber + " added successfully.");
    }
         
         
         
         
         

      public void editRoom(int roomNumber, String newCategory, boolean newAvailability) {
         
      //hena 2na badwer 3la 2l room
        if(roomsByNumber.containsKey(roomNumber)){
            roomsByNumber.replace(roomNumber,room);
            setCategory(newCategory);
            setAvailability(newAvailability);
             System.out.println("Room that Has number: "+roomNumber+"-->edited succussfully for user <--");
          }
          else{
              System.out.println("Room that Has number: "+roomNumber+"->>NOT FOUND ");
            }
       
        }
     
      public void removeRoom(int roomNumber) {
      //hena 2na badwer 3la 2l room
          if (roomsByNumber.containsKey(roomNumber)) {
            roomsByNumber.remove(roomNumber);
           
           System.out.println("Room that Has number: "+roomNumber+"-->Removed succussfully<--");
          }
          else{
              System.out.println("Room that Has number: "+roomNumber+"->>NOT FOUND ");
          }
         
     
      }
 //Helper method to find a room by room number
   private static Rooms findRoom(int roomNumber) {
    return roomsByNumber.get(roomNumber);
   }
  private static Rooms findUserRoom(int roomNumber, guest guest) {
        for (Map.Entry<Integer, Rooms> entry : roomsByNumber.entrySet()) {
           
            Rooms room = entry.getValue();
            if (room != null && room.getRoomNumber() == roomNumber) {
                for (Booking reservation : room.getReservation()) {
                    if (reservation.getG().equals(guest)) {
                        return room;
                    }
                }
            }
        }
        return null;
    }

     public List<Rooms> listRooms() {
      return new ArrayList<>(listRooms);
  }
     private List<Rooms> createRoomsList() {
        List<Rooms> roomsList = new ArrayList<>();
        for (Map.Entry<Integer, Rooms> entry : roomsByNumber.entrySet()) {
            roomsList.add(new Rooms(entry.getKey(), entry.getValue()));
        }
        return roomsList;
    }
     
      public Rooms getRoomDetails(int roomNumber) {
          if(roomsByNumber.containsKey(roomNumber)){
               return new Rooms(roomNumber, roomsByNumber.get(roomNumber));
          }
           else {
            Rooms newRoom = new Rooms(roomNumber, room);
            roomsByNumber.put(roomNumber, room);
            return newRoom;
        }
   
      }

      public double calculateRevenue() {
        double totalRevenue = 0.0;

     for (Booking reservation : reservation) {
            totalRevenue += calculateReservationCost(reservation);      
        }

        return totalRevenue;
 
       }
       
        public boolean isAvilable(int roomNumber){
           return roomsByNumber.containsKey(roomNumber);  
       }
   
    private double calculateReservationCost(Booking reservation) {                   // 3d array roomnumber , category , counter for reservation  add re
      double ratepernight;
      switch (reservation.getBookedRoom().getCategory()) {
        case "Single":
            ratepernight = 150.0; // Set the rate for the Single category
            break;
        case "Double":
            ratepernight = 200.0; // Set the rate for the Double category
            break;
            case "Studio Rooms":
            ratepernight = 250.0;
            break;
            case "Deluxe Rooms":
            ratepernight = 300.0;
            break;
            case "Rooms with a View ":
            ratepernight = 400.0;
            break;
            case "Suites":
            ratepernight = 650.0;
            break;
            case "Presidential Suites ":
            ratepernight = 700.0;
            break;
       
        default:
            ratepernight = 1000.0; // Default rate if category is not recognized
            break;
        }  int numberOfNights = calculateNumberOfNights(reservation);
     return numberOfNights * ratepernight;
}

     private int calculateNumberOfNights(Booking reservation) {
     return (int) reservation.getCheckInDate().until(reservation.getCheckOutDate()).getDays();
}
       
     
     
     public static void saveRoomstofile(String filename )
     {
         try{
             ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(filename)) ;
             o.writeObject(roomsByNumber);
             
         }catch(IOException e){
             System.out.println(e);
         }
     }
     public static void readRoomsfromfile(String filename )
     {
         try{
             ObjectInputStream o=new ObjectInputStream(new FileInputStream(filename)) ;
             roomsByNumber=(Map<Integer,Rooms>)o.readObject();
             System.out.println("");
            }  catch(IOException  |ClassNotFoundException e){
             System.out.println(e);
    }
     }
     
     public  Rooms findmostrevenue(){
         if(listRooms.isEmpty()){
             System.out.println("Rooms are not available");
             return null;
         }
         Rooms max=listRooms.get(0);
         for(Rooms room:listRooms){
         if(room.calculateRevenue()>max.calculateRevenue()){
             max=room;
         }
             System.out.println("Room with the highest revenue: "+max.getRevenue());
             System.out.println("category: "+max.getCategory());
             System.out.println("Revenue: "+max.calculateRevenue());
         }
             
         
         return max;
     }
}