package com.recommender;

import java.util.PriorityQueue;

class ParkingSpot {
	int floor;
	int spot;

	public ParkingSpot(int floor, int spot) {
		super();
		this.floor = floor;
		this.spot = spot;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getSpot() {
		return spot;
	}

	public void setSpot(int spot) {
		this.spot = spot;
	}

}

public class ParkingLot {
	int maxFloors, maxSpotsPerFloor;

	PriorityQueue<ParkingSpot> pq;

	public ParkingLot() {
	}

	ParkingLot(int maxFloors, int maxSpotsPerFloor) {
		super();
		this.maxFloors = maxFloors;
		this.maxSpotsPerFloor = maxSpotsPerFloor;

		pq = new PriorityQueue<ParkingSpot>((a, b) -> {
			return a.floor == b.floor ? a.spot - b.spot : a.floor - b.floor;
		});

	}

	public void addParkingSpots(int floor, int spot) {
		validate(floor, spot);
		ParkingSpot sp = new ParkingSpot(floor, spot);
		pq.add(sp);
	}

	public ParkingSpot getAvailableParkingSpot() {
		if (pq.size() == maxFloors) {
			throw new IllegalStateException("Parking is Full");
		}
		return pq.peek();
	}

	public ParkingSpot park() {
		if (pq.isEmpty()) {
			throw new IllegalStateException("Parking is Full");
		}
		ParkingSpot spot = pq.remove();
		return spot;
	}

	public void unpark(int floor, int spot) {
		validate(floor, spot);
		ParkingSpot sp = new ParkingSpot(floor, spot);
		pq.add(sp);

	}

	public void validate(int floor, int spot) {
		if (floor > maxFloors) {
			throw new IllegalStateException("floor " + floor + " is greater than " + this.maxFloors);
		}
		if (spot > maxSpotsPerFloor) {
			throw new IllegalStateException("spot" + spot + " is greater than " + this.maxSpotsPerFloor);
		}
	}

	public static void main(String args[]) {

	}

}
