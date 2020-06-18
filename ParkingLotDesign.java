// Time Complexity : for park(): O(log n) where n is the Spot object, for unpark: O(log n), for getNextAvailable: O(1), for addParkingspot: O(log n) for each of the calls
// Space Complexity : O(n) for maintaining n pairs of Floors and Spots objects
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with the bigger picture and granularising into smaller components 
/* Algorithm: Whenever, you ened to add a parking spot, maintian a queue that maints the spots you have in your parking lot. As a car arrives, give them
the next available spot by checking the priority queue that is maintained by floor priority and then by spot priority. As you give the driver the
next available spot, poll the spot out of the queue as it gets reserved. As an unpark happens, again you can add a new spot object with floor and spot
coordinates to the queue as the spot becomes available to be reserved again.
*/
import java.io.*;
import java.util.PriorityQueue;
class ParkingLot {
    int maxSpots, maxfloors;
    ParkingLot(int maxf, int maxs){
        this.maxSpots =  maxs;                                                                      // Max number of floors and spots
        this.maxfloors = maxf;
    }
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor){
            return a.spot - b.spot;                                                                     // Prioritising by spots if same floor
        }
        return a.floor - b.floor;                                                                       // Prioritising by floors first and then spots
    });
    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking Lot is full.");
        } 
        return pq.poll();                                                                               // Returning the next available spot to get reserved
    }
    public ParkingSpot getNextAvailable(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking Lot is full.");
        }   
        return pq.peek();                                                                                   // Check the next available spot for parking
    }

    public void unpark(int floor, int spot){
            addParkingSpot(floor, spot);                                                            // Parking spot is free, add it back to priority queue
    }
    public void addParkingSpot(int floor, int spot){
        if(floor > maxfloors){                                                                      // Max no of floor are occupied, it must be a sunday
            throw new IllegalStateException("Parking Lot is full.");
        } 
        ParkingSpot s = new ParkingSpot(floor, spot);                                               // You are lucky, get a new spot!
        if(spot > maxSpots){
            addParkingSpot(floor + 1, spot);                                                        // Don't worry, this floor is full, goto next floor
        }
        pq.add(s);                                                                                      // Add the spot to the queue
    }
}
class ParkingSpot{
    int floor, spot;
    ParkingSpot(int f, int s){
        this.floor = f;
        this.spot = s;                                                                                  // Pair of floor and spot
    }
    public int getFloor(){return this.floor;}                                                           // OOP principles getter
    public int getSpot(){return this.spot;}
}
class ParkingLotDesign {
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