package hotel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc2
 */
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class AdditionalService {
    private String name;
    private int requests;
    private double revenue;
    
    public AdditionalService(String name) {
        this.name = name;
        this.requests = 0;
        this.revenue = 0.0;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRequests() {
        return requests;
    }
    
    public double getRevenue() {
        return revenue;
    }
    
    public void incrementRequests() {
        requests++;
    }
    
    public void addRevenue(double amount) {
        revenue += amount;
    }
        private Map<String, AdditionalService> services;
    
         services = new HashMap<>();
    
    
    public void addService(String serviceName) {
        AdditionalService service = new AdditionalService(serviceName);
        services.put(serviceName, service);
    }
    public void removeService(String Name){
        services.remove(Name);
    }
    public void editService(AdditionalService Service){
        
    }
    public void recordRequest(String serviceName) {
        AdditionalService service = services.get(serviceName);
        if (service != null) {
            service.incrementRequests();
        }
    }
    
    public void recordRevenue(String serviceName, double amount) {
        AdditionalService service = services.get(serviceName);
        if (service != null) {
            service.addRevenue(amount);
        }
    }
    
    public int getNumberOfRequests(LocalDate startDate, LocalDate endDate) {
        int totalRequests = 0;
        for (AdditionalService service : services.values()) {
            totalRequests += service.getRequests();
        }
        return totalRequests;
    }
    
    public String getMostRequestedService(LocalDate startDate, LocalDate endDate) {
        String mostRequestedService = null;
        int maxRequests = 0;
        for (AdditionalService service : services.values()) {
            int requests = service.getRequests();
            if (requests > maxRequests) {
                mostRequestedService = service.getName();
                maxRequests = requests;
            }
        }
        return mostRequestedService;
    }
    
    public String getMostRevenueService(LocalDate startDate, LocalDate endDate) {
        String mostRevenueService = null;
        double maxRevenue = 0.0;
        for (AdditionalService service : services.values()) {
            double revenue = service.getRevenue();
            if (revenue > maxRevenue) {
                mostRevenueService = service.getName();
                maxRevenue = revenue;
            }
        }
        return mostRevenueService;
    }
}




