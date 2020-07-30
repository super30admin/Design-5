// Time Complexity : O(log(m*n)) where m is the number of floors and n is the number of spots per floor
// Space Complexity : O(m*n) where m is the number of floors and n is the number of spots per floor

import java.util.PriorityQueue;

class ParkingLot {
	int maxFloors;
	int maxSpotsPerFloor;
	int id;	// id of parking lot
	PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
		if (a.floor == b.floor) {
			return a.spot - b.spot;
		} else {
			return a.floor - b.floor;
		}
	});

	public ParkingLot(int maxFloors, int maxSpotsPerFloor) {
		this.maxFloors = maxFloors;
		this.maxSpotsPerFloor = maxSpotsPerFloor;
	}

	public ParkingSpot park() {
		if (pq.isEmpty()) {
			throw new IllegalStateException("Parking lot is full!");
		}
		return pq.poll();	
	}

	public void unpark(int floor, int spot) {		
		addParkingSpot(floor, spot);
	}

	public void addParkingSpot(int floor, int spot) {
		if (floor > maxFloors || spot > maxSpotsPerFloor) {
			throw new IllegalStateException("Not a valid space to add a parking spot.");
		}
		ParkingSpot ps = new ParkingSpot(floor, spot);
		pq.add(ps);
	}

	public ParkingSpot getNextAvailable() {
		if (pq.isEmpty()) {
			throw new IllegalStateException("Parking lot is full!");
		}
		return pq.peek();
	}

	class ParkingSpot {
		boolean isAvailable;
		int floor;
		int spot;

		public ParkingSpot(int floor, int spot) {
			this.floor = floor;
			this.spot = spot;
			isAvailable = true;
		}

		public int getFloor() {
			return this.floor;
		}

		public int getSpot() {
			return this.spot;
		}
	}

	public static void main(String[] args) {
		ParkingLot pl = new ParkingLot(5, 10);
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 10; j++) {
				pl.addParkingSpot(i, j);
			}
		}
		pl.park();
		pl.park();
		pl.park();
		ParkingSpot ps = pl.getNextAvailable();
		System.out.println("Next available location is-> Floor: " + ps.getFloor() + " Spot: " + ps.getSpot());
		pl.unpark(1,1);
		ParkingSpot ps1 = pl.getNextAvailable();
		System.out.println("Next available location is-> Floor: " + ps1.getFloor() + " Spot: " + ps1.getSpot());
	}
}