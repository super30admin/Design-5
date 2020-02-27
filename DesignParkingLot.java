/*
 Algorithm:
 	1. Parking Lot can be taken as a 2D matrix
 	2. We will create parking spots within maximum number floors and maximum number of spots.
 	3. We have a priority queue which will have the nearest spot available and the nearest spot will be returned
 	
 	Time Complexity: O(log(mn))

 	
 	Space Complexity: O(mn)
 
 
 */

import java.util.PriorityQueue;

class ParkingLot{
	int maxFloors = 5;
	int maxSpots = 10;
	
	
	PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((ParkingSpot a, ParkingSpot b)-> {
		
		if(a.floor == b.floor) {
			return a.spot-b.spot;
		}
		return a.floor-b.floor;
	});
	
	ParkingSpot parkVehicle() {
		ParkingSpot park = getNextAvailable();
		pq.remove();
		
		return park;
	}
	
	
	void unPark(ParkingSpot a){
		addParkingSpot(a.floor, a.spot);
		
	}
	
	ParkingSpot getNextAvailable() {
		if(pq.isEmpty())
			throw new IllegalStateException("No Parking Spots availabe");
		
		return pq.peek();
	}
	
	
	 void addParkingSpot(int floor, int spot) {
		if(floor>maxFloors) {
			throw new IllegalStateException("Floor number is more than the allowed number of max floors");
		}
		else if(spot>maxSpots) {
			throw new IllegalStateException("Spot number is more than the allowed number of spots");
		}
		
		ParkingSpot ps = new ParkingSpot(floor, spot);
		
		pq.add(ps);
		
	}
	
	
	public class ParkingSpot{
		int floor;
		int spot;
		
		public ParkingSpot(int floor, int spot) {
			this.floor = floor;
			this.spot = spot;
		}
		
		int getFloor() {
			return this.floor;
			
		}
		
		int getSpot() {
			return this.spot;
		}
	}
	
	
}

public class Design_ParkingLot{
	
	public static void main(String[] args) {
		ParkingLot parkingLot = new ParkingLot();
		
		parkingLot.addParkingSpot(1, 1);
		parkingLot.addParkingSpot(1, 2);
		parkingLot.addParkingSpot(1, 3);
		parkingLot.addParkingSpot(2, 1);
		parkingLot.addParkingSpot(2, 2);
		parkingLot.addParkingSpot(2, 3);
		parkingLot.addParkingSpot(3, 1);
		parkingLot.addParkingSpot(3, 2);
		parkingLot.addParkingSpot(3, 3);
		
		ParkingLot.ParkingSpot a = parkingLot.getNextAvailable();
		
		System.out.println("Available Floor: "+a.floor+", Available Spot: "+a.spot);
		
		parkingLot.parkVehicle();
		
		ParkingLot.ParkingSpot b = parkingLot.getNextAvailable();
		System.out.println("Available Floor: "+b.floor+", Available Spot: "+b.spot);
		
		parkingLot.unPark(a);
		
		ParkingLot.ParkingSpot c = parkingLot.getNextAvailable();
		System.out.println("Available Floor: "+c.floor+", Available Spot: "+c.spot);
		
	}
	
	
	
	
}