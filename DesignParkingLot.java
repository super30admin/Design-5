package design5;

import java.util.PriorityQueue;

public class DesignParkingLot {
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
	
	int maxFloors;
	int spotsPerFloor;
	PriorityQueue<ParkingSpot> minHeap;
	
	public DesignParkingLot(int floors, int spotsPerFloor) {
		this.maxFloors = floors;
		this.spotsPerFloor  = spotsPerFloor;
		minHeap = new PriorityQueue<>((a, b) -> {
			return a.floor == b.floor ? a.spot - b.spot : a.floor - b.floor;
		});
	}
	
	// O(log n)
	public void addParkingSpot(int floor, int spot) {
		if(floor > maxFloors)
			throw new IllegalArgumentException("Floor is greater than maximum floors allowed");
		if(spot > spotsPerFloor)
			throw new IllegalArgumentException("Spot is greater than maximum spots allowed");
		ParkingSpot parkSpot = new ParkingSpot(floor, spot);
		minHeap.offer(parkSpot);
	}
	
	// O(1)
	public ParkingSpot park() {
		if(minHeap.isEmpty())
			throw new IllegalArgumentException("Parking Lot is full");
		return minHeap.poll();
	}
	
	// O(log n)
	public void unpark(int floor, int spot) {
		addParkingSpot(floor, spot);
	}
	
	// O(1)
	public ParkingSpot getNextAvailable() {
		if(minHeap.isEmpty())
			throw new IllegalArgumentException("Parking Lot is full");
		return minHeap.peek();
	}
}
