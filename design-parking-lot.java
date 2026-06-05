// Time Complexity :
// addParkingSpot() -> O(log n)
// park() -> O(log n)
// unpark() -> O(log n)
// getNextAvailable() -> O(1)
// Space Complexity : O(n) where n is the number of parking spots
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use a PriorityQueue to always retrieve the nearest available parking spot.
// Spots are ordered first by floor number and then by spot number.
// Parking removes a spot from the heap, while unparking adds it back, keeping availability updated efficiently.

class Main {

    static class ParkingSpot {
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

    static class ParkingLot {
        int maxFloors;
        int maxSpots;

        // min heap ordered by floor then spot
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
            if(a.floor == b.floor) {
                return a.spot - b.spot;
            }
            return a.floor - b.floor;
        });

        public ParkingLot(int maxFloors, int maxSpots) {
            this.maxFloors = maxFloors;
            this.maxSpots = maxSpots;
        }

        // allocate nearest available spot
        public ParkingSpot park() {
            if(pq.isEmpty()) {
                throw new IllegalStateException("Parking lot is full");
            }

            return pq.remove();
        }

        // make spot available again
        public void unpark(int floor, int spot) {
            pq.add(new ParkingSpot(floor, spot));
        }

        // peek next available spot
        public ParkingSpot getNextAvailable() {
            return pq.peek();
        }

        // add valid parking spot
        public void addParkingSpot(int floor, int spot) {
            if(floor > maxFloors) {
                throw new IllegalStateException("Input Floor greater than max allowed");
            }

            if(spot > maxSpots) {
                throw new IllegalStateException("Input Spot greater than max allowed");
            }

            pq.add(new ParkingSpot(floor, spot));
        }
    }
}