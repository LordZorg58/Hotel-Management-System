package hotel;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Rooms extends Booking implements Serializable{   //The Serializable interface is a marker interface. It has no methods
     Rooms room;
     guest Guest;
      private int roomNumber;
      private String category;
      private boolean availability;
      List<Booking> reservation;
      private double revenue;
     private static List<Rooms> listRooms ;//de 3shan 23mel list feha kol 2l rooms ta2reban lazm tb2a fe 2l admin class

          private static Map<Integer, Rooms> roomsByNumber = new HashMap<>();



    public Rooms(Rooms room, guest Guest, int roomNumber, Date checkIn, Date checkOut, Rooms roomType) {
        super(checkIn, checkOut, roomType);
        this.room = room;
        this.Guest = Guest;
        this.roomNumber = roomNumber;
    }
   

 

    public Rooms( int roomNumber, String category) {
       
        this.roomNumber = roomNumber;
        this.category = category;
        this.availability = availability;
        this.reservation = reservation;
        this.revenue = revenue;
        listRooms.add(this); // Add the room to the list of rooms
        roomsByNumber.put(roomNumber,this );
    }

    public Rooms(guest Guest, int roomNumber, String category) {
        this.Guest = Guest;
        this.roomNumber = roomNumber;
        this.category = category;
    }

   
    public Rooms(int roomNumber, Rooms room) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.availability = true;
        this.reservation = new ArrayList<>();
        this.revenue = 0.0;
        listRooms.add(this); // Add the room to the list of rooms
        roomsByNumber.put(roomNumber,this);

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
    
    
 

    
    
    
    ///////////////////////////  ADD , REMOVE , EDIT FUNCTIONS /////////////////////////////////
   

 
        public void addRoom(int roomNumber, Rooms room, guest Guest,Date checkInDate, Date checkOutDate) {
         
          Rooms newRoom = new Rooms(roomNumber, room);
          Booking reservation = new Booking(Guest,checkInDate,checkOutDate, newRoom,roomNumber);
      //    newRoom.addReservation(reservation);
      //checkInDate, checkOutDate,room.getCategory(),  roomNumber
      //    public void addBooking(guest Guest, Date checkIn, Date checkOut, Rooms roomType, Rooms roomnumber) {

      reservation.addBooking( Guest,  checkInDate,  checkOutDate, room.getcategory(),roomNumber);//enum
      
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
         
         

     
      
      ///////////// Function to find user room ///////////////////////
   
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
            roomsList.add(new Rooms(entry.getKey(), entry.getValue()));                 // check if this functions important 
        }
        return roomsList;
    }
  
  

     
      ///////////////////////////  search in the list by number and category /////////////////////////////
  
     public Rooms searchByNum(int f){
         for(Rooms room:listRooms )
         if(room.getRoomNumber()==f) {
             return room;
             
         }
             return null;
         
         
     }    
       public List<Rooms> searchRoomsByCategory(String category) {
    List<Rooms> matchingRooms = new ArrayList<>();
    for (Rooms room : listRooms) {
        if (room.getCategory().equalsIgnoreCase(category)) {
            matchingRooms.add(room);
        }
    }
    return matchingRooms;

}  
       
       
       
       //////////search in the hash map////////////////
     
    public Rooms searchRoomByNumberhashmap(int roomNumber) {
    return roomsByNumber.get(roomNumber);
} 
  
     
    public List<Rooms> searchRoomsinhashmap(String category) {
    List<Rooms> matchingRooms = new ArrayList<>();
    for (Rooms room : roomsByNumber.values()) {
        if (room.getCategory().equalsIgnoreCase(category)) {
            matchingRooms.add(room);
        }
    }
    return matchingRooms;
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
   
        
       //fakrii fe el enum 
    private double calculateReservationCost(Booking reservation) {   // 3d array roomnumber , category , counter for reservation  add re
      double ratepernight;
      switch (reservation.getBookedRoom().getCategory()) {//get bookedroom
        case "Single":
            ratepernight = 150.0; 
            break;
        case "Double":
            ratepernight = 200.0; 
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
            case "Presidential Suites":
            ratepernight = 700.0;
            break;
       
        default:
            ratepernight = 1000.0; // Default rate if category is not recognized
            break;
        }  
      long numberOfNights = reservation.calculateNumberOfNights();
     return numberOfNights * ratepernight;
}

       
     /////////////// Binary File //////////
     
     public static void saveRoomsBin(String filename )
     {
         try(ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream(filename))) {
             o.writeObject(roomsByNumber);

           //  o.close();
         }catch(IOException e){
             System.out.println(e);
         }
     }
     
     public static void readRoomsfromBin(String filename )
     {
         try(ObjectInputStream o=new ObjectInputStream(new FileInputStream(filename))){ 
             roomsByNumber=(Map<Integer,Rooms>)o.readObject();

          //  o.close();
            System.out.println("");
            }  catch(IOException  |ClassNotFoundException e){
             System.out.println(e);
    }
     }
     
     
     
     ///////////////////find most revenue room/////////////////////
     
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