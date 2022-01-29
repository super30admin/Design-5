// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We design this using a custom class ParkingLot which has max floors, spots per floor and Priority queue
// We also define another class ParkingSpot that has floor and spot
// we make use of these classes to perform the operations required.

// "static void main" must be defined in a public class.
public class Main {
    public static class ParkingLot {
        int maxFloors, spotsperfloor;
        PriorityQueue<ParkingSpot> pq;

        public ParkingLot(int floors, int spotsperfloor) {
            this.maxFloors = floors;
            this.spotsperfloor = spotsperfloor;
            pq = new PriorityQueue<>((a, b) -> {
                if (a.floor == b.floor) {
                    return a.spot - b.spot;
                }
                return a.floor - b.floor;
            });
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor > maxFloors) {
                throw new IllegalArgumentException("Invalid floor");
            }
            if (spot > spotsperfloor) {
                throw new IllegalArgumentException("Invalid spot");
            }
            pq.add(new ParkingSpot(floor, spot));
        }

        public ParkingSpot getNextAvailable() {
            return pq.peek();
        }

        public ParkingSpot park() {
            if (pq.isEmpty()) {
                throw new IllegalArgumentException(" No Parking is Available");
            }
            return pq.poll();
        }

        public void unpark(int floor, int spot) {
            pq.add(new ParkingSpot(floor, spot));
        }
    }

    public static class ParkingSpot {
        int floor, spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        int getFloor() {
            return this.floor;
        }

        int getSpot() {
            return this.spot;
        }

    }

    public static void main(String[] args) {
        ParkingLot plot = new ParkingLot(10, 10);
        plot.addParkingSpot(0, 1);
        plot.addParkingSpot(0, 5);
        plot.addParkingSpot(5, 7);
        plot.addParkingSpot(2, 5);
        plot.addParkingSpot(4, 1);
        plot.addParkingSpot(9, 1);
        plot.addParkingSpot(1, 1);

        ParkingSpot spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
        spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
        spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
        spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
        spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
        spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
        plot.unpark(0, 5);
        spot = plot.park();
        System.out.println("Parked at floor :" + spot.getFloor() + " spot: " + spot.getSpot());
    }
}