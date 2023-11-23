import java.util.ArrayList;
import java.util.List;
public class reservation {
   


    private guest guest;
    private Rooms roomCategory;
    private List<String> services;
    private boolean checkedIn;

    public Reservation(Guest guest, Rooms roomCategory) {
        this.guest = guest;
        this.roomCategory = roomCategory;
        this.services = new ArrayList<>();
        this.checkedIn = false;
    }

    public guest getGuest() {
        return guest;
    }

    public Rooms getRoomCategory() {
        return roomCategory;
    }

    public List<String> getServices() {
        return services;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void addService(String service) {
        services.add(service);
    }

    public void checkout() {
        checkedIn = false;
        // Additional checkout logic goes here
    }
}

