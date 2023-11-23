import java.util.ArrayList;
import java.util.List;

public class receptionist extends person {
    
    private int id;
    private int shiftTime;
    private String username;
    private String password;
    private double salary;
    private List<reservation> Reservations;

    public receptionist(String name, String email, String phone, AccountType accountType, int id, int shiftTime,
                        String username, String password, double salary) {
        super(name, email, phone, accountType);
        this.id = id;
        this.shiftTime = shiftTime;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.Reservations = new ArrayList<>();
    }

    public reservation createReservation(guest Guest, Rooms category) {
        reservation reservation = new reservation(Guest, category);
        Reservations.add(reservation);
        return reservation;
    }

    public void addAdditionalService(reservation reservation, String service) {
        reservation.addService(service);
    }

    public boolean cancelReservation(reservation reservation) {
        return Reservations.remove(reservation);
    }

    public void checkout(reservation reservation) {
        reservation.checkout();
        Reservations.remove(reservation);
    }

    public void displayReservations() {
        System.out.println("Reservations:");
        for (reservation reservation : Reservations) {
            System.out.println("Guest: " + reservation.getGuest().getName());
            System.out.println("Room Category: " + reservation.getRoomCategory());
            System.out.println("Preferences: " + reservation.getPreferences());
            System.out.println("Services: " + reservation.getServices());
            System.out.println("Checked-in: " + reservation.isCheckedIn());
            System.out.println();
        }
    }
}
