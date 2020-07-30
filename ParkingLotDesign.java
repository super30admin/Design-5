// Time Complexity : for park(): O(log n) where n is the spot object; unpark: O(log n); for getNextAvailable: O(1), for addParkingspot: O(log n) for each of the calls
// Space Complexity : O(n) for maintaining n pairs of Floors and Spots objects

import java.util.PriorityQueue;
class ParkingLot {
    int maxFloors, spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor) return a.spot-b.spot;
        return a.floor-b.floor;
    });
    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }
    public ParkingSpot park() {
        if(pq.isEmpty()) {
            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot re = pq.remove();
        return re;
    }
    public ParkingSpot getNextAvailable() {
        return pq.peek();
    }
    public void unpark(int floor,int spot) {
        ParkingSpot newSpot = new ParkingSpot(floor,spot);
        pq.add(newSpot);
    }
    public void addParkingSpot(int floor,int spot) {
        if(floor > maxFloors) {
            throw new IllegalArgumentException("floor limit exceeded");
        }
        if(spot > spotsPerFloor) {
            throw new IllegalArgumentException("spot limit exceeded");
        }
        ParkingSpot newSpot = new ParkingSpot(floor,spot);
        pq.add(newSpot);
    }
}

class ParkingSpot {
    int floor; int spot;
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

class ParkingLotDesign {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10,20);
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