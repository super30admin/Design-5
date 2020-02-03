import java.io.*;
import java.util.*; 
public class DesignParkingLot {
	public static void main (String[] args) {
    ParkingLot pl = new ParkingLot();
		pl.addParkingSpot(1, 1);
 		pl.addParkingSpot(2, 1);
 		pl.addParkingSpot(3, 1);
 		pl.addParkingSpot(1, 2);
 		pl.addParkingSpot(2, 2);
 		pl.addParkingSpot(3, 2);
 		ParkingLot.ParkingSpot n = pl.getNextAvailable();
 		System.out.println("Next Available at Floor: " + n.getFloor() + ", Spot: " + n.getSpot());
 		pl.park();
 		pl.park();
 		pl.park();
 		pl.unpark(1,1);
	}
}
class ParkingLot{
    private static int noOfFloors = 5;
    private static int noOfSpotsPerFloor = 10;
    // pq
    PriorityQueue <ParkingSpot> pq = new PriorityQueue<>((ParkingSpot a, ParkingSpot b) -> {
        if(a.floor == b.floor) return a.spot - b.spot;
        return a.floor - b.floor;
    });
    // park
    public ParkingSpot park(){
        // get the next available ParkingSpot
        ParkingSpot s = getNextAvailable();
        System.out.println("Car Parked at floor "+s.getFloor() +" spot "+ s.getSpot());
        pq.remove(s);
        return s;
    }
    // unpark
    public void unpark(int floor, int spot){
        ParkingSpot toRemove = new ParkingSpot(floor, spot);
        //pq.add(toRemove);
        if(!pq.contains(toRemove)){
        	pq.add(toRemove);
        	System.out.println("Car Unparked from floor "+toRemove.getFloor() +" Spot "+toRemove.getSpot());
        } else {
             throw new IllegalStateException("Invalid ParkingSpot");
         }
    }
    // getNextAvailable
    public ParkingSpot getNextAvailable(){
        if(pq.isEmpty()){
            throw new IllegalStateException("The parking lot is full");
        }
        return pq.peek();
    }
    // addParkingSpot
    public void addParkingSpot(int floor, int spot){
        if(floor > noOfFloors) throw new IllegalStateException("No of allowed floors is 5 only");
         if(spot > noOfSpotsPerFloor) throw new IllegalStateException("No of allowed spots per floor is 10 only");
         ParkingSpot toAdd = new ParkingSpot(floor, spot);
         pq.add(toAdd);
    }
    // class ParkingSpot
    class ParkingSpot{
        private int floor; // 1 2
        private int spot; // 2 2
        ParkingSpot(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }
        public int getFloor(){
            return floor;
        }
        public int getSpot(){
            return spot;
        }
    }
}

