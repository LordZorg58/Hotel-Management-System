import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Admin extends person {



    public Admin(String name, String email, String phone, AccountType accountType) {
        super(name, email, phone, accountType);
    }
    
Rooms r=new Rooms();
Booking b=new Booking();
AdditionalService Service =new AdditionalService(" ");
ReportGenerator rg=new ReportGenerator();
public void ADD(int roomNumber, String room, Guest guest){
    
    r.addRoom(roomNumber, room,guest);
}

    public void ADD(LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests){
    r.addBooking(LocalDate.MIN, LocalDate.EPOCH, 0);
    }
    
    public void ADD(String serviceName){
       rg.addService(serviceName);
    }
    public void VRUsers(){
        
    }
    public void VRService(){
        System.out.println(Service.getMostRevenueService(LocalDate startDate, LocalDate endDate));   
        
        System.out.println(Service.getMostRequestedService(LocalDate startDate, LocalDate endDate));
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

private void VRReservation(){
    b.displayBookings();
    
    
}    

 private void VRRooms(){
     for(int i=0;i<r.getRoomsByNumber().size();i++){
    System.out.println(r.getRoomNumber()+"   " + r.getCategory() );
     }
    //num of reservation
    int count=0;
    for(int i=0;i<b.getBookings().size();i++){
if(b.isCalled=true){
    count++;
}
        System.out.println(r.getReservation()+"  "+r.getCheckInDate() + " until " + r.getCheckOutDate()+ "  "+ count );
        
    }
   
    System.out.println(r.findmostrevenue());  
//Most Reserved Room
     Map<Integer,Integer> RequestedRoom =new HashMap<>();
     int counter=0;
     int maxCount=0;
     ArrayList<Integer> KeyList=new ArrayList();
      for(int i=0;i<KeyList.size();i++){
          KeyList.add(Parseint(r.getRoomsByNumber().keySet()));
      }
      for(int i=0;i<RequestedRoom.size();i++){
   RequestedRoom.put(KeyList.get(i),counter);

   if(r.isCalled=true){
         RequestedRoom.put(r.getRoomNumber(),counter+1);
     }
     }
   int RoomNum=0;
             for(int i=0;i<KeyList.size();i++){
                 
         if(maxCount>RequestedRoom.get(KeyList.get(i))) ;{
          maxCount=RequestedRoom.get(KeyList.get(i));
      RoomNum=KeyList.get(i);
             }
             }
        System.out.println("the Most Reserved Room is "+ RoomNum  +"the Number of reservation = "+ maxCount);     
      
   
       
     
     
 }

    private Integer Parseint(Set<Integer> keySet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    


}