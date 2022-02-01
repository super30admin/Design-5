//Question:
//Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for
// the space closest to the entrance. When someone leave you need update this space as empty. What data structures will
// you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.

// Time Complexity : O(log n), since we add all the parking spots once which would cost log n to construct the min heap
// Space Complexity : O(n), where n is the number of parking spots
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
import java.io.*;
import java.util.*;

class GFG {

    public static class ParkingLot {
        int maxFloors, spotsPerFloor;
        PriorityQueue<ParkingSpot> pq;

        public ParkingLot (int floors, int spotsPerFloor) {
            this.maxFloors = floors;
            this.spotsPerFloor = spotsPerFloor;
            pq = new PriorityQueue<>((a, b) -> {
                if(a.floor == b.floor) {
                    return a.spot - b.spot;
                }

                return a.floor - b.floor;
            });
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor > maxFloors) {
                throw new IllegalArgumentException("Invalid floor");
            }
            if (spot > spotsPerFloor) {
                throw new IllegalArgumentException("Invalid spot");
            }

            pq.add(new ParkingSpot(floor, spot));
        }

        public ParkingSpot getNextAvailableSpot() {
            return pq.peek();
        }

        public ParkingSpot park() {
            if (pq.isEmpty()) {
                throw new IllegalArgumentException("Parking full !");
            }
            return pq.poll();
        }

        public void unpark(int floor, int spot) {
            pq.add(new ParkingSpot(floor, spot));
        }
    }

    public static class ParkingSpot {
        int floor, spot;

        public ParkingSpot (int floor, int spot) {
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

    public static void main (String[] args) {
        ParkingLot lot = new ParkingLot(10, 10);
        lot.addParkingSpot(0,1);
        lot.addParkingSpot(0,2);
        lot.addParkingSpot(4,4);
        lot.addParkingSpot(5,9);
        lot.addParkingSpot(8,3);

        ParkingSpot spot = lot.park();
        System.out.println("Parked at floor: " + spot.getFloor() + " and spot: " + spot.getSpot());

        spot = lot.park();
        System.out.println("Parked at floor: " + spot.getFloor() + " and spot: " + spot.getSpot());

        spot = lot.park();
        System.out.println("Parked at floor: " + spot.getFloor() + " and spot: " + spot.getSpot());

        spot = lot.park();
        System.out.println("Parked at floor: " + spot.getFloor() + " and spot: " + spot.getSpot());

        lot.unpark(0,2);

        spot = lot.park();
        System.out.println("Parked at floor: " + spot.getFloor() + " and spot: " + spot.getSpot());
    }
}