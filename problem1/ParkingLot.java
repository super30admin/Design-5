// Time Complexity : O(1) for park and unpark, O(n) for initialization
// Space Complexity : O(n), n -> Capacity of parking lot
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.PriorityQueue;

public class ParkingLot {
	int maxFloors;
	int floorCapacity;
	PriorityQueue<ParkingSpot> queue;

	public ParkingLot(int maxFloors, int floorCapacity) {
		this.maxFloors = maxFloors;
		this.floorCapacity = floorCapacity;
		this.queue = new PriorityQueue<ParkingSpot>(
				(spot1, spot2) -> spot1.floor == spot2.floor ? spot1.spot - spot2.spot : spot1.floor - spot2.floor);
	}

	public void addParkingSpot(int floor, int spot) throws IllegalStateException {
		if (floor > maxFloors || spot > floorCapacity) {
			throw new IllegalStateException("Input greater than maximum allowed value.");
		}
		ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
		queue.add(parkingSpot);
	}

	public ParkingSpot getNextAvailable() throws Exception {
		if (queue.isEmpty()) {
			throw new Exception("Parking Lot is full.");
		}
		return queue.peek();
	}

	public ParkingSpot park() throws Exception {
		getNextAvailable();
		ParkingSpot spot = queue.poll();
		return spot;
	}

	public void unpark(int floor, int spot) {
		addParkingSpot(floor, spot);
	}

	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot(10, 20);

		try {
			lot.addParkingSpot(0, 5);
			lot.addParkingSpot(1, 2);
			lot.addParkingSpot(2, 1);
			lot.addParkingSpot(1, 16);
			lot.addParkingSpot(0, 1);
			lot.addParkingSpot(4, 17);
			lot.addParkingSpot(7, 12);
			lot.addParkingSpot(2, 10);
			ParkingSpot spot = lot.getNextAvailable();
			System.out.println("Parked at floor \'" + spot.getFloor() + "\' and spot \'" + spot.getSpot()
					+ "\'. Token = \'" + spot.getToken() + "\'.");
			lot.park();

			spot = lot.getNextAvailable();
			System.out.println("Parked at floor \'" + spot.getFloor() + "\' and spot \'" + spot.getSpot()
					+ "\'. Token = \'" + spot.getToken() + "\'.");
			lot.park();

			spot = lot.getNextAvailable();
			System.out.println("Parked at floor \'" + spot.getFloor() + "\' and spot \'" + spot.getSpot()
					+ "\'. Token = \'" + spot.getToken() + "\'.");
			lot.park();

			System.out.println("Unparking Floor 0 Spot 1.");
			lot.unpark(0, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
