/**
 * Simulates a parking lot using a 2D boolean grid, scanning floor-by-floor to find the first available spot.
 * Key idea: maintain a grid where each cell represents availability and always pick the earliest free slot.
 * Time: O(F * S) per operation (scan), Space: O(F * S)
 */
class Main {
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
        boolean[][] available; // true = free, false = occupied

        public ParkingLot(int maxFloors, int spotsPerFloor) {
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;

            // 1-based indexing simplifies mapping to real-world floor/spot numbers
            this.available = new boolean[maxFloors + 1][spotsPerFloor + 1];
        }

        public ParkingSpot park() {
            // Greedy: always pick the first available spot (lowest floor, then lowest spot)
            for (int floor = 1; floor <= maxFloors; floor++) {
                for (int spot = 1; spot <= spotsPerFloor; spot++) {
                    if (available[floor][spot]) {
                        available[floor][spot] = false; // invariant: false = occupied
                        return new ParkingSpot(floor, spot);
                    }
                }
            }
            throw new IllegalStateException("Error: Parking lot is full");
        }

        public void unpark(int floor, int spot) {
            // No validation → assumes valid input (common interview simplification)
            available[floor][spot] = true;
        }

        public ParkingSpot getNextAvailable() {
            // Same scan logic reused → can be refactored to avoid duplication
            for (int floor = 1; floor <= maxFloors; floor++) {
                for (int spot = 1; spot <= spotsPerFloor; spot++) {
                    if (available[floor][spot]) {
                        return new ParkingSpot(floor, spot);
                    }
                }
            }
            return null; // edge case: no spots available
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor > maxFloors) {
                throw new IllegalArgumentException("Error floor input greater than max allowed");
            }
            if (spot > spotsPerFloor) {
                throw new IllegalArgumentException("Error: spots input greater than max allowed");
            }

            // Explicit initialization → only added spots are usable
            available[floor][spot] = true;
        }
    }
}