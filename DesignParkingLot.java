// Time Complexity : O(log(mn)) for all operations except getNextAvailable() -> O(1)
// Space Complexity : O(mn) , m floors , n spots
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We have a sub class to manage parking spots with floor and spot fields. We have a parking lot class which manages
total number of floors and allotted slots per floor. In addition, we have a priority queue of parking spots which
basically allots nearby parking spot in a floor to the user if same floor, if not nearby floor in form of a
min heap. When parking happens, we simply pop that spot from the queue and when unpark happens, we want to make
it available to the user, so we add it back to the queue and let heapify control the computation of nearby slot.
Similarly, if we want to understand the availability, we peek through the queue.
 */
import java.util.*;
class DesignParkingLot {
    static class ParkingSpot {
        int floor;
        int spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        public int getSpot() {
            return this.spot;
        }

        public int getFloor() {
            return this.floor;
        }
    }

    static class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
            if(a.floor == b.floor)
                return a.spot - b.spot;
            else
                return a.floor - b.floor;
        });

        public ParkingLot(int maxFloors, int spotsPerFloor) {
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park() {
            if (pq.isEmpty()) {
                throw new IllegalStateException("Error: Parking lot is full");
            }
            ParkingSpot re = pq.remove();
            return re;
        }

        public void unpark(int floor, int spot) {
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }

        public ParkingSpot getNextAvailable() {
            return pq.peek();
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor > maxFloors) {
                throw new IllegalArgumentException("Error floor input greater than max allowed");
            }
            if (spot > spotsPerFloor) {
                throw new IllegalArgumentException("Error: spots input greater than max allowed");
            }
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(3, 2);
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
