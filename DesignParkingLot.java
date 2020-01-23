/*
Algorithm:
    1. We have a 2D matrix which is equivalent to parkinglot
    2. We have a priority queue which has the nearest empty space.
    3, Based on the nearest parking space we will park, if parked the entry is removed from priority queue, if parking spot becomes free it is added to priority queue.
    
    Did the code run? Yes

*/

import java.util.PriorityQueue;

class ParkingLot{
	int maxFloors = 5;
	int maxSpots = 10;
	
	PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((ParkingSpot a, ParkingSpot b)->{
		if(a.floor==b.floor)
			return a.spot-b.spot;
		return a.floor-b.floor;
	});
	
	public ParkingSpot park() {
		ParkingSpot s = getNextAvailable();
		pq.remove();
		return s;
		
	}
	public ParkingSpot getNextAvailable() {
		if(pq.isEmpty()) {
			throw new IllegalStateException("Parking lot is full");
		}
		return pq.peek();
	}
	void unpark(int floor, int spot) {
		ParkingSpot toUnpark = new ParkingSpot(floor, spot);
		pq.add(toUnpark);
	}
	
	void addParkingSpot(int floor, int spot) {
		if(floor>maxFloors) {
			throw new IllegalStateException("Floor is more than max floors");
			
		}
		else if(spot>maxSpots) {
			throw new IllegalStateException("Spot is more than max spots");
		}
		ParkingSpot toAdd = new ParkingSpot(floor, spot);
		pq.add(toAdd);
	}
	 public class ParkingSpot{
		int floor;
		int spot;
		
		ParkingSpot(int floor, int spot){
			this.floor = floor;
			this.spot = spot;
			
		}
		
		int getFloor() {
			return floor;
		}
		int getSpot() {
			return spot;
		}
	}
	
}

public class Design_ParkingLot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParkingLot pl = new ParkingLot();
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);
        ParkingLot.ParkingSpot n = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Spot: " + n.getSpot());
        pl.park();
        pl.unpark(1,1);
        ParkingLot.ParkingSpot m = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + m.getFloor() + ", Spot: " + m.getSpot());
        pl.unpark(2, n.getSpot());

	}

}
