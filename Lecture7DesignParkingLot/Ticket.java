package Lecture7DesignParkingLot;

public class Ticket {
    private String id;
    private String vehicleID;
    private String entryTime;
    private Vehicle vehicle;
    
    public Ticket(String id, String vehicleID, String entryTime, Vehicle vehicle) {
        this.id = id;
        this.vehicleID = vehicleID;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
    public String getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    

}
