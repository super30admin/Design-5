package Dec9;

import java.util.PriorityQueue;

// System level entity: Parking lot
public class ParkingLot {

	int maxFloors;
	int spotsPerFloor;
	PriorityQueue<ParkingSpot> pq;

	public ParkingLot(int maxFloors, int spotsPerFloor) {
		this.maxFloors = maxFloors;
		this.spotsPerFloor = spotsPerFloor;
		pq = new PriorityQueue<>((a, b) -> {
			if (a.floor == b.floor)
				return a.spot - b.spot;
			return a.floor - b.floor;
		});
	}

	public ParkingSpot park() {
		// no empty parking spot
		if (pq.isEmpty()) {
			throw new IllegalStateException("Parking lot is full");
		}
		ParkingSpot toPark = pq.poll();
		return toPark;
	}

	public void unpark(int floor, int spot) {
		addParkingSpot(floor, spot);
	}

	public void addParkingSpot(int floor, int spot) {
		if (floor > maxFloors) {
			throw new IllegalArgumentException("floor input greater than max allowed");
		}
		if (spot > spotsPerFloor) {
			throw new IllegalArgumentException("floor input greater than max allowed");
		}
		ParkingSpot newSpot = new ParkingSpot(floor, spot);
		pq.add(newSpot);
	}

	public ParkingSpot getNextAvailable() {
		return pq.peek();
	}
}

// Entity inside system level entity: Parking spot
class ParkingSpot {
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

class Main {
	public static void main(String[] args) {
		ParkingLot pl = new ParkingLot(10, 20);
		pl.addParkingSpot(1, 1);
		pl.addParkingSpot(2, 1);
		pl.addParkingSpot(2, 2);
		pl.addParkingSpot(3, 1);
		pl.addParkingSpot(1, 2);
		pl.addParkingSpot(3, 2);

		ParkingSpot n = pl.getNextAvailable();
		System.out.println("Parked at floor " + n.getFloor() + " slot: " + n.getSpot());
		pl.park();
		pl.park();
		pl.park();

	}
}
