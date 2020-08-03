/*package whatever //do not write package name here */

import java.util.PriorityQueue;

class ParkingLot{
	int floors;
	int spots;

	PriorityQueue<ParkingSpot> freeSpot;

	public ParkingLot(int floors, int spots){
		this.floors = floors;
		this.spots = spots;
		this.freeSpot = new PriorityQueue<>((a, b) -> {
			if(a.getFloor() == b.getFloor()){
				return a.getSpot() - b.getSpot();
			}else {
				return a.getFloor() - b.getFloor();
			}
		});
	}

	public ParkingSpot park() {
		if(freeSpot.isEmpty()){
			throw new IllegalStateException("Parking full");
		}else {
			return freeSpot.remove();
		}
	}

	public ParkingSpot getNextAvailableSpot() {
		if(freeSpot.isEmpty()){
			throw new IllegalStateException("Parking full");
		}else {
			return freeSpot.peek();
		}
	}

	public void unPark(int floor, int spot) {
		addSpot(floor, spot);
	}

	public void addSpot(int floor, int spot) {
		if(floor > this.floors || floor < 0 || spot > this.spots || spot < 0) {
			throw new IllegalStateException("wrong values passsed");
		}else {
			freeSpot.add(new ParkingSpot(floor, spot));
		}
	}
}

class ParkingSpot{
	private int floor;
	private int spot;

	public ParkingSpot(int floor, int spot){
		this.floor = floor;
		this.spot = spot;
	}

	public int getFloor(){
		return this.floor;
	}

	public int getSpot(){
		return this.spot;
	}
}
class ParkingLotDesign {
	public static void main (String[] args) {
		ParkingLot pl = new ParkingLot(10,20);
		pl.addSpot(1, 1);
		pl.addSpot(2, 1);
		pl.addSpot(2, 2);
		ParkingSpot n = pl.getNextAvailableSpot();
		System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
		pl.park();
		ParkingSpot n2 = pl.getNextAvailableSpot();
		System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
		pl.unPark(1, 1);
		ParkingSpot n1 = pl.getNextAvailableSpot();
		System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
	}
}