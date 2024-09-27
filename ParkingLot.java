/*package whatever //do not write package name here */

/*
 * Time complexity : O(log mn)
 * Space complexity : O(mn)
 */
import java.io.*;
import java.util.*;

class ParkingLot {
	int maxFloor;
	int maxCapacity;

	ParkingLot(int maxFloor, int maxCapacity){
	    this.maxFloor = maxFloor;
	    this.maxCapacity = maxCapacity;
	}
	
	PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
	    if(a.floor == b.floor){
	        return a.spot - b.spot;
	    }else{
	        return a.floor - b.floor;
	    }
	});
	
    private ParkingSpot park(){
        ParkingSpot ps = getNextAvailable();
        if(ps == null){
            throw new IllegalStateException("Parking is full"); 
        }
        pq.remove();
        return ps;
    }	
    
    private void unpark(int floor, int spot){
        this.addSpots(floor, spot);
    }
    
    private ParkingSpot getNextAvailable(){
        return pq.peek();
    }
    
    private void addSpots(int floor, int spot){
        
        if(floor > maxFloor){
            throw new IllegalStateException("Max floors reached");
        }
        
        if(spot > maxCapacity){
            throw new IllegalStateException("Max spots filled for particular floor");
        }
        
        ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
        pq.add(parkingSpot);
    }
    
	class ParkingSpot{
	    private int floor;
	    private int spot;
	    
	    ParkingSpot(int floor, int spot){
	        this.floor = floor;
	        this.spot = spot;
	    }
	    
	    public void setFloor(int floor){
	        this.floor = floor;
	    }
	    
	    public void setSpot(int spot){
	        this.spot = spot;
	    }
	    
	    public int getFloor(){
	        return this.floor;
	    }
	    
	    public int getSpot(){
	        return this.spot;
	    }
	}
	
	
	
	
	public static void main (String[] args) {
		System.out.println("GfG!");
		
		ParkingLot parkingLot = new ParkingLot(5, 10);
		parkingLot.addSpots(1, 1);
		parkingLot.addSpots(2, 1);
		parkingLot.addSpots(3, 1);
        parkingLot.addSpots(1, 2);
        parkingLot.addSpots(2, 2);
        parkingLot.addSpots(3, 2);
        
        ParkingSpot ps = parkingLot.getNextAvailable();
        System.out.println("Next available parking is : "+ps.getFloor()+" spot : "+ps.getSpot());

        parkingLot.park();
        parkingLot.unpark(1, 1);
        
        ps = parkingLot.getNextAvailable();
        System.out.println("Next available parking is : "+ps.getFloor()+" spot : "+ps.getSpot());

	}
}