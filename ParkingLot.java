// Time Complexity : 
// addParkingSpot: O(log n)
//  park: O(log n)
//  unpark: O(log n) 
// isFull: O(1), 
// getNextAvailableSpot: O(1)
// Space Complexity : O(n) where n is the total number of parking spots
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use min heap to store the closest available parking spot to entrance (0,0)
// add all available spots to the min heap
// park return the closest spot from heap and unpark adds to the heap

import java.util.PriorityQueue;

class Main {
    static class ParkingSpot{
        int floor;
        int spotId;
        public ParkingSpot(int floor, int spotId){
            this.floor = floor;
            this.spotId = spotId;
        }
        public int getFloor() {
            return floor;
        }
        public int getSpotId() {
            return spotId;
        }
        @Override
        public int hashCode() {
            return floor * 100 + spotId;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ParkingSpot that = (ParkingSpot) obj;
            return floor == that.floor && spotId == that.spotId;
        }
    }

    static class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> availableSpots;

        public ParkingLot(int maxFloors, int spotsPerFloor) {
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
            availableSpots = new PriorityQueue<>( 
                (a,b)  -> {
                    if(a.getFloor() == b.getFloor()) 
                        return a.getSpotId() - b.getSpotId();
                    else 
                        return a.getFloor() - b.getFloor();
            });
        }

        public void addParkingSpot(int floor, int spotId) {
            if(floor < maxFloors && spotId < spotsPerFloor) {
                availableSpots.offer(new ParkingSpot(floor, spotId));
            } else {
                throw new IllegalArgumentException("Invalid floor or spotId");
            }
        }

        public ParkingSpot park() {
            if(availableSpots.isEmpty()) {
                throw new IllegalStateException("No available parking spots");
            }
            return availableSpots.poll();
        }

        public void unpark(int floor, int spotId) {
            if(floor < maxFloors && spotId < spotsPerFloor) {
                ParkingSpot spot = new ParkingSpot(floor, spotId);
                availableSpots.offer(spot);
            } else {
                throw new IllegalArgumentException("Invalid parking spot");
            }
        }

        public boolean isFull() {
            return availableSpots.isEmpty();
        }

        public ParkingSpot getNextAvailableSpot() {
            if(availableSpots.isEmpty()) {
                throw new IllegalStateException("No available parking spots");
            }
            return availableSpots.peek();
        }

    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 10);
        parkingLot.addParkingSpot(0, 0);
        parkingLot.addParkingSpot(0, 1);
        parkingLot.addParkingSpot(1, 0);
        parkingLot.addParkingSpot(1, 1);
        parkingLot.addParkingSpot(2, 0);
        parkingLot.addParkingSpot(2, 1);

        System.out.println("Next available spot: " + parkingLot.getNextAvailableSpot().getFloor() + "-" + parkingLot.getNextAvailableSpot().getSpotId());
        ParkingSpot parkedSpot = parkingLot.park();
        System.out.println("Parked at: " + parkedSpot.getFloor() + "-" + parkedSpot.getSpotId());
        System.out.println("Next available spot: " + parkingLot.getNextAvailableSpot().getFloor() + "-" + parkingLot.getNextAvailableSpot().getSpotId());

        parkingLot.unpark(0, 0);
        System.out.println("Unparked from: 0-0");
        System.out.println("Next available spot: " + parkingLot.getNextAvailableSpot().getFloor() + "-" + parkingLot.getNextAvailableSpot().getSpotId());
    }
}
