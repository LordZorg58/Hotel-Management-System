package hotel;

import java.io.*;
import java.util.*;
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


public class Rooms  {

 
    private Rooms room;
    private guest Guest;
    private int roomNumber;
    private RoomCategory category;
    private boolean availability;
    private List<Booking> reservation;
    private double revenue;

    private static List<Rooms> listRooms;
    private static Map<Integer, Rooms> roomsByNumber;   //room number (room number,Object room:)

    static {
        listRooms = new ArrayList<>();
        roomsByNumber = new HashMap<>();
    }
    
   public Rooms() {

    }
    
    public Rooms(int roomNumber, RoomCategory category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.availability = true;
        this.reservation = new ArrayList<>();
        this.revenue = 0.0;
        listRooms.add(this);
        roomsByNumber.put(roomNumber, this);
    }

    public Rooms(guest Guest, int roomNumber, RoomCategory category) {
        this.Guest = Guest;
        this.roomNumber = roomNumber;
        this.category = category;
    }

    public Rooms(int roomNumber, Rooms room) {
        this.roomNumber = roomNumber;
        this.category = room.category;
        this.availability = true;
        this.reservation = new ArrayList<>();
        this.revenue = 0.0;
        listRooms.add(this);
        roomsByNumber.put(roomNumber, this);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomCategory getCategory() {
        return category;
    }

    public void setCategory(RoomCategory category) {
        this.category = category;
    }

    public boolean isAvailability(int roomnum) {
        
        if(roomsByNumber.containsKey(roomnum)){
             Rooms room = roomsByNumber.get(roomnum);
             if(room.getReservation()==null){
                return room.availability=true;
             }
             else{
                 return room.availability=false;
             }
            
        }
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

    public void addRoom(int roomNumber, RoomCategory room, guest Guest, Date checkInDate, Date checkOutDate) {
        Rooms newRoom = new Rooms(roomNumber, room);
        Booking reservation = new Booking(Guest, checkInDate, checkOutDate, room, roomNumber); ///////////////////////////////////////
        reservation.addBooking(Guest, checkInDate, checkOutDate, room, roomNumber);
        newRoom.availability=false;
        System.out.println("Room " + roomNumber + " added successfully.");
    }

    public void editRoom(int roomNumber, RoomCategory newCategory, boolean newAvailability) {
        if (roomsByNumber.containsKey(roomNumber)) {
            Rooms room = roomsByNumber.get(roomNumber);
            room.setCategory(newCategory);                                                          /// call in guest
            room.setAvailability(newAvailability);
            System.out.println("Room that Has number: " + roomNumber + "-->edited successfully for user <--");
        } else {
            System.out.println("Room that Has number: " + roomNumber + "->>NOT FOUND ");
        }
    }

    public void removeRoom(int roomNumber) {
        if (roomsByNumber.containsKey(roomNumber)) {
            roomsByNumber.remove(roomNumber);
            
            System.out.println("Room that Has number: " + roomNumber + "-->Removed successfully<--");
        } else {
            System.out.println("Room that Has number: " + roomNumber + "->>NOT FOUND ");
        }
    }

    private static Rooms findUserRoom(int roomNumber, guest guest) {
        for (Map.Entry<Integer, Rooms> entry : roomsByNumber.entrySet()) {
            Rooms room = entry.getValue();
            if (room != null && room.getRoomNumber() == roomNumber) {
                if (room.getReservation() != null) {
                    for (Booking reservation : room.getReservation()) {
                        if (reservation.getGuest().equals(guest)) {
                            return room;
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<Rooms> listRooms() {             
        return new ArrayList<>(listRooms);
      
    }

    public List<Rooms> createRoomsList() {
        List<Rooms> roomsList = new ArrayList<>();
        for (Map.Entry<Integer, Rooms> entry : roomsByNumber.entrySet()) {             /// set    add in map
            roomsList.add(new Rooms(entry.getKey(), entry.getValue()));
        }
        return roomsList;
    }

    public Rooms searchByNum(int f) {
        for (Rooms room : listRooms)        //in list
            if (room.getRoomNumber() == f) {
                return room;
            }
        return null;
    }

    public List<Rooms> searchRoomsByCategory(RoomCategory category) {
        List<Rooms> matchingRooms = new ArrayList<>();
        for (Rooms room : listRooms) {
            if (room.getCategory()==category)  {
                matchingRooms.add(room);
            }
        }
        return matchingRooms;
    }

    public Rooms searchRoomByNumberhashmap(int roomNumber) {
        return roomsByNumber.get(roomNumber);
    }

    public List<Rooms> searchRoomsinhashmap(RoomCategory category) {
        List<Rooms> matchingRooms = new ArrayList<>();
        for (Rooms room : roomsByNumber.values()) {
            if (room.getCategory()==category) {
                matchingRooms.add(room);
            }
        }
        return matchingRooms;
    }

    public Rooms getRoomDetails(int roomNumber) {
        if (roomsByNumber.containsKey(roomNumber)) {
            return new Rooms(roomNumber, roomsByNumber.get(roomNumber));
        } else {
            Rooms newRoom = new Rooms(roomNumber, this);
            roomsByNumber.put(roomNumber, newRoom);
            return newRoom;
        }
    }

    public double calculateRevenue() {
        double totalRevenue = 0.0;
        if (this.reservation != null) {
            for (Booking reservation : this.reservation) {
                totalRevenue += calculateReservationCost(reservation);
            }
        }
        return totalRevenue;
    }

      private double calculateReservationCost(Booking reservation) {
        double ratepernight = 0;
        switch (reservation.getBookedRoom().getCategory()) {
            case SINGLE:
                ratepernight = 150.0;
                break;
            case DOUBLE:
                ratepernight = 200.0;
                break;
            case TRIPLE:
                ratepernight = 250.0;
                break;
            case SWEET:
                ratepernight = 300.0;
                break;
           default:
        throw new IllegalArgumentException("Unexpected category: " + reservation.getBookedRoom().getCategory());
        }
        
        long numberOfNights = reservation.calculateNumberOfNights();
        return numberOfNights * ratepernight;
    }


    public static void writelistRooms(String filename) {
        try (PrintWriter write=new PrintWriter(new FileOutputStream(filename))) {
           
            for( Rooms room:listRooms){
            write.println("Room number: "+room.getRoomNumber()+"     "+room.getCategory()+"    "+room.isAvailability(room.getRoomNumber()));
           
            }
               System.out.println("List of rooms saved to text file successfully.");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
public static void writeRoomsHashMap(String mapFilename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(mapFilename))) {
            // write information from the HashMap
            for (Map.Entry<Integer, Rooms> entry : roomsByNumber.entrySet()) {
                Rooms room = entry.getValue();
                writer.println(
                        room.getRoomNumber() + " " +
                                room.getCategory() + " " +
                                room.isAvailability(room.getRoomNumber())
                );
            }

            System.out.println("HashMap of rooms saved to text file successfully.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
public static void readRoomsListFromText(String listFilename) {// 3malt zy ma khadna fe 2l lecture lma 3malna count le 2l words in paragraph
    try (Scanner scanner = new Scanner(new File(listFilename))) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");///parts: This variable is created by splitting the line using the split(" ") method, which splits 
            int roomNumber = Integer.parseInt(parts[0]);
            RoomCategory category = RoomCategory.valueOf(parts[1].toUpperCase());
            boolean availability = Boolean.parseBoolean(parts[2]);
            Rooms room = new Rooms(roomNumber, category);
            room.setAvailability(availability);
        }
        System.out.println("List of rooms read from text file successfully.");
    } catch (FileNotFoundException e) {
        System.out.println("List text file not found.");
    }
}
                                                                     

    public static void readRoomsHashMapFromText(String mapFilename) {
        try (Scanner scanner = new Scanner(new File(mapFilename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int roomNumber = Integer.parseInt(parts[0]);//parseInt: this Function from  String to int 
               RoomCategory category = RoomCategory.valueOf(parts[1].toUpperCase());//value of btreturn content bta3 el enum 
                boolean availability = Boolean.parseBoolean(parts[2]);
                Rooms room = new Rooms(roomNumber, category);
                room.setAvailability(availability);
                roomsByNumber.put(roomNumber, room);
            }
            System.out.println("HashMap of rooms read from text file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("HashMap text file not found.");
        }
    }

    public Rooms findmostrevenue() {
        if (listRooms.isEmpty()) {
            System.out.println("Rooms are not available");
            return null;
        }
        Rooms max = listRooms.get(0);
        for (Rooms room : listRooms) {
            if (room.calculateRevenue() > max.calculateRevenue()) {
                max = room;
            }
        }
        System.out.println("Room with the highest revenue: " + max.getRevenue());
        System.out.println("Category: " + max.getCategory());
        System.out.println("Revenue: " + max.calculateRevenue());

        return max;
    }
}
