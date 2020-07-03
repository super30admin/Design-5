import java.io.*;
import java.util.PriorityQueue;
class ParkingLot {
    
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
        if(a.floor == b.floor) {
            return a.spot - b.spot;
        }
        return a.floor - b.floor;
        });
        
    int maxFloors;
    int maxSpots;
    
    public ParkingLot(int maxFloors, int maxSpots) {
        this.maxFloors = maxFloors;
        this.maxSpots = maxSpots;
    }
    
    public ParkingSpot park(){
        if(pq.isEmpty()) {
            throw new IllegalStateException("Parking lot is full");
        }
        return pq.poll();
    }
    
    public ParkingSpot getNextAvailable(){
        if(pq.isEmpty()) {
            throw new IllegalStateException("Parking lot is full");
        }
        return pq.peek();
    }
    
    public void unpark(int floor, int spot){
        ParkingSpot ps = new ParkingSpot(floor, spot);
        pq.add(ps);
    }
    
    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors) {
            throw new IllegalStateException("floor is greater than maxFloor number");
        }
        if(spot > maxSpots) {
            throw new IllegalStateException("spot is greater than maxSpot number");
        }
        ParkingSpot ps = new ParkingSpot(floor, spot);
        pq.add(ps);
    }
}

class ParkingSpot{
    int floor;
    int spot;
    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }
    public int getFloor() {
        return floor;
    }
    public int getSpot() {
        return spot;
    }
}

public class GFG {
	public static void main (String[] args) {
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