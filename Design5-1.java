// Design a Parking Lot

// Any problem you faced while coding this : -

// Your code here along with comments explaining your approach

import java.util.PriorityQueue;

class GFG {
	public static void main (String[] args) {
		ParkingLot pl = new ParkingLot(10,20);
		pl.addParkingSpot(1,1);
		pl.addParkingSpot(2,1);
		pl.addParkingSpot(3,1);
		pl.addParkingSpot(1,2);
		pl.addParkingSpot(2,2);
		pl.addParkingSpot(3,2);
		
		ParkingSpot n = pl.getNextAvailable();
		System.out.println("Parked at floor: " + n.getFloor() + ", slot: " + n.getSpot());
		pl.park();
		ParkingSpot n2 = pl.getNextAvailable();
		System.out.println("Parked at floor: " + n2.getFloor() + ", slot: " + n2.getSpot());
		pl.unpark(1,1);
		ParkingSpot n1 = pl.getNextAvailable();
		System.out.println("Parked at floor: " + n1.getFloor() + ", slot: " + n1.getSpot());
	}
	static class ParkingSpot{
	    int floor;
	    int spot;
	    public ParkingSpot(int floor, int spot){
	        this.floor = floor;
	        this.spot = spot;
	    }
	    public int getSpot(){
	        return this.spot;
	    }
	    public int getFloor(){
	        return this.floor;
	    }
	}
	static class ParkingLot{
	    int maxFloors;
	    int spotsPerFloor;
	    PriorityQueue <ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
	        if(a.floor == b.floor)
	            return a.spot - b.spot;
	        return a.floor - b.floor;
	    });
	    public ParkingLot(int maxFloors, int spotsPerFloor){
	        this.maxFloors = maxFloors;
	        this.spotsPerFloor = spotsPerFloor;
	    }
        // Time Complexity : O(1)
        // Space Complexity : O(1)
	    public ParkingSpot park(){
	        if(pq.isEmpty()){
	            throw new IllegalStateException("Parking lot is full");
	        }
	        ParkingSpot re = pq.remove();
	        return re;
	    }
        // Time Complexity : O(logn)
        // Space Complexity : O(1)
	    public void unpark(int floor, int spot){
	        ParkingSpot newSpot = new ParkingSpot(floor, spot);
	        pq.add(newSpot);
	    }
        // Time Complexity : O(1)
        // Space Complexity : O(1)
	    public ParkingSpot getNextAvailable(){
	        return pq.peek();
	    }
        // Time Complexity : O(logn)
        // Space Complexity : O(1)
	    public void addParkingSpot(int floor, int spot){
	        if(floor > maxFloors)
	            throw new IllegalArgumentException("Floor input greater than max allowed");
	        if(spot > spotsPerFloor)
	            throw new IllegalArgumentException("Spot input greater than max allowed");
	        ParkingSpot newSpot = new ParkingSpot(floor, spot);
	        pq.add(newSpot);
	    }
	}
}