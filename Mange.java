/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Mange {
 private int ServiceCounter=0;
 
 
 
    private Object  [][][] MostReservedRoom=new Object [RoomNumber][category][counter];
    ArrayList<Rooms> room=new ArrayList;
    ArrayList<Services> service=new ArrayList;
    
    public Rooms AddRoom(String Category,int RoomNumber,String GuestName,String PhoneNumber){
return  room.add(this);

    }
public Rooms RemoveRoom(int RoomNumber){
return room.remove(this);
}

public Rooms EditRoom(){
    System.out.println("what do you want to edit? ");
Scanner s=new Scanner(System.in);
String response=s.next() ;
 String newcateg;
 int newRoomNum;
if(response.equalsIgnoreCase("Category")){
    newcateg=s.next();
// el newcateg hyt3mlaha save 3ala el file bta3 el room 3ala toul
}
else if (response.equalsIgnoreCase("room number")){
    newRoomNum=s.nextInt();
//el new room number hyt3melo edit fel file bat3 el room brdo
}
//el return mtnsa4
}

public Service AddService(String Name,int RoomNumber,String GuestName){
return service.add(this);
ServiceCounter++;
}



    
}
