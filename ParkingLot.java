/**
 * Time Complexity : for park(): O(log n) where n is the Spot object, for unpark: O(log n), for getNextAvailable: O(1), for addParkingspot: O(log n) for each of the calls
 * Space Complexity : O(n)
 */

import java.util.PriorityQueue;
public class ParkingLot {
    int maxSpots, maxfloors;
    ParkingLot(int maxf, int maxs){
        this.maxSpots =  maxs;                                                                     
        this.maxfloors = maxf;
    }
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor){
            return a.spot - b.spot;                                                                     
        }
        return a.floor - b.floor;                                                                       
    });
    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking Lot is full.");
        } 
        return pq.poll();                                                                               
    }
    public ParkingSpot getNextAvailable(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking Lot is full.");
        }   
        return pq.peek();                                                                                   
    }

    public void unpark(int floor, int spot){
            addParkingSpot(floor, spot);                                                            
    }
    public void addParkingSpot(int floor, int spot){
        if(floor > maxfloors){                                                                      
            throw new IllegalStateException("Parking Lot is full.");
        } 
        ParkingSpot s = new ParkingSpot(floor, spot);                                               
        if(spot > maxSpots){
            addParkingSpot(floor + 1, spot);                                                        
        }
        pq.add(s);                                                                                     
    }
}
class ParkingSpot{
    int floor, spot;
    ParkingSpot(int f, int s){
        this.floor = f;
        this.spot = s;                                                                 
    }
    public int getFloor(){return this.floor;}                                                           
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