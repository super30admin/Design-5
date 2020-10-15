import java.io.*;
import java.util.PriorityQueue;


// Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
// When someone leave you need update this space as empty. 
// What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.

// Priority Queue to get the lowest parking spot, updated any time. PQ always returns the minimum.


class ParkingLot {
    // ParkingLot - combination of floors and spots
        // -Floors
        // -spots
    // ParkingSpot - individial parking unit
        // - Floor No.
        // - Spot No.
    // Park a car
    // Unpark a car
    // Next available parking
    // Adding new parking spots
    
    int maxFloors, spotsPerFloor;
    
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor)  return a.spot - b.spot;
        return a.floor - b.floor;
    });
    
    public ParkingLot(int maxFloors, int spotsPerFloor){
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }
                                                        
    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot tokenObj = pq.remove();
        return tokenObj;
    }
    
    public void unpark(int floor, int spot){
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }
                                                        
    public ParkingSpot getNextAvailable(){
        return pq.peek();
    }

    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors){
            throw new IllegalArgumentException("floor input greater than max allowed");
        }
         if(spot > spotsPerFloor){
            throw new IllegalArgumentException("spots input greater than max allowed");
        }
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }
}
class ParkingSpot{
    int floor, spot;
    public ParkingSpot(int floor, int spot){
        this.floor = floor;
        this.spot = spot;
    }
    
    public int getFloor(){
        return this.floor;
    }
    
    public int getSpot(){
        return this.spot;
    }
}
    
public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
		pl.addParkingSpot(1, 1);
 		pl.addParkingSpot(2, 1);
 		pl.addParkingSpot(3, 1);
 		pl.addParkingSpot(1, 2);
 		pl.addParkingSpot(2, 2);
 		pl.addParkingSpot(3, 2);
		ParkingSpot n = pl.getNextAvailable();
        
 		System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
 		pl.park();
 		ParkingSpot n2 = pl.getNextAvailable();
 		System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
 		pl.unpark(1, 1);
 		ParkingSpot n1 = pl.getNextAvailable();
 		System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());


    }
}