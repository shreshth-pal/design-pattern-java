package Lecture7DesignParkingLot;


//should be a singleton
public enum  ParkingSpaceManager {
    UNIQUE_INSTANCE;
    


}


class ParkingSpace{

    //Location to be added
   private boolean isEmpty;
    private Vehicle vehicle;
    final private Location location;
    private int price;

    public ParkingSpace(Location location,int price) {
        isEmpty=true;
        this.location=location;
        this.price=price;
    }

    

    public void park(Vehicle vehicle){
        isEmpty=false;
        this.vehicle=vehicle; 
               
    }

    public void remove(){
        isEmpty=true;
        this.vehicle=null;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


class Location{
    int row;
    int col;
    
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
}