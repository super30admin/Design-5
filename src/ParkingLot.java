import java.util.*;
//Time Complexity :Park : O(1), unpark: O(log mn), addParkingSpot: O(mn), getNextAvailable: O(1) 
//Space Complexity : O(m,n), Priority queue used, no of floors and spots
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : No

class ParkingLot {
	int maxFloors;
	int spotsPerFloor;
	PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
		if(a.floor == b.floor)
			return a.spot - b.spot;
		else
			return a.floor - b.floor;	
	});
	//constructor
	public ParkingLot(int maxFloors, int spotsPerFloor) {
		this.maxFloors = maxFloors;
		this.spotsPerFloor = spotsPerFloor;
	}

	public ParkingSpot park() {
		if(!pq.isEmpty())
			return pq.poll();

		throw new IllegalStateException("Parking Lot is full");
	}

	public void unpark(int floor, int spot) {
		addParkingSpot(floor, spot);
	}

	public void addParkingSpot(int floor, int spot) {
		//sanity check
		if(floor > maxFloors)
			throw new IllegalStateException("The provided floor is out of range of maxFloors");

		if(spot > spotsPerFloor)
			throw new IllegalStateException("The provided spot is out of range of spotsPerFloor");

		ParkingSpot newSpot = new ParkingSpot(floor, spot);
		pq.add(newSpot);
	}

	public ParkingSpot getNextAvailable() {
		return pq.peek();
	}

	//parking spot definition
	class ParkingSpot{
		int floor;
		int spot;
		public ParkingSpot(int floor, int spot) {
			this.floor = floor;
			this.spot = spot;
		}
		public int getFloor() {
			return this.floor;
		}
		public int getSpot() {
			return this.spot;
		}
	}

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
