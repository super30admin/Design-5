// Time Complexity : For Parking: O(1); For Unparking: O(log(m*n)) --> where m and n are the lengths of parking lot
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.LinkedList;
import java.util.PriorityQueue;

public class ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
        if (a.floor == b.floor) return a.spot - b.spot;
        else return a.floor - b.floor;
    });

    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public ParkingSpot park() {
        if (pq.isEmpty()) throw new IllegalStateException("Parking lot is full");
        return pq.remove();
    }

    public void unPark(int floor, int spot) {
       addParkingSpot(floor, spot);
    }

    public ParkingSpot getNextAvailable() {
        if (pq.isEmpty()) throw new IllegalStateException("Parking lot is full");
        return pq.peek();
    }

    public void addParkingSpot(int floor, int spot) {
        if (floor > maxFloors) throw new IllegalStateException("Provided input of floor is greater than maxFloor");
        if (spot > spotsPerFloor) throw new IllegalStateException("Provided input of spot is greater than spotsPerFloor");
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }
}


class ParkingSpot{
    int floor;
    int spot;

    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public int getFloor() {
        return floor;
    }

    public int getSpot() {
        return spot;
    }
}

class GFG {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1,1);
        pl.addParkingSpot(2,1);
        pl.addParkingSpot(3,1);
        pl.addParkingSpot(1,2);
        pl.addParkingSpot(2,2);
        pl.addParkingSpot(3,2);

        ParkingSpot n = pl.getNextAvailable(); // {Output: 1,1}
        System.out.println("Parked at floor: " + n.getFloor() + " Spot: " + n.getSpot());
        pl.park();

        ParkingSpot n2 = pl.getNextAvailable(); // {Output: 1,2}
        System.out.println("Parked at floor: " + n2.getFloor() + " Spot: " + n2.getSpot());
        pl.unPark(1, 1);

        ParkingSpot n1 = pl.getNextAvailable(); // {Output: 1,1}
        System.out.println("Parked at floor: " + n1.getFloor() + " Spot: " + n1.getSpot());
    }
}