import java.util.PriorityQueue;

public class Main {

    public static class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq;

        public ParkingLot(int floors, int spotsPerFloor) {
            this.maxFloors = floors;
            this.spotsPerFloor = spotsPerFloor;
            this.pq = new PriorityQueue<>((a, b) -> {
                if (a.getFloor() == b.getFloor()) {
                    return a.getSpot() - b.getSpot();
                }
                return a.getFloor() - b.getFloor();
            });
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor >= maxFloors) {
                throw new IllegalArgumentException("Floor exceeds max floors");
            }
            if (spot >= spotsPerFloor) {
                throw new IllegalArgumentException("Spot exceeds max spots per floor");
            }
            ParkingSpot pspot = new ParkingSpot(floor, spot);
            pq.add(pspot);
        }

        public ParkingSpot getAvailableSpot() {
            if (pq.isEmpty()) {
                throw new IllegalStateException("Parking lot is full");
            }
            return pq.peek();
        }

        public ParkingSpot park() {
            if (pq.isEmpty()) {
                throw new IllegalStateException("Parking lot is full");
            }
            return pq.poll();
        }

        public void unpark(int floor, int spot) {
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }

    public static class ParkingSpot {
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

        @Override
        public String toString() {
            return "Floor: " + floor + ", Spot: " + spot;
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3, 10); // 3 floors, 10 spots per floor
    
        // Add parking spots
        lot.addParkingSpot(0, 3);
        lot.addParkingSpot(1, 2);
        lot.addParkingSpot(0, 1); // this will be first in priority
    
        // Get next available
        System.out.println("Next available: " + lot.getAvailableSpot());
    
        // Park a vehicle
        ParkingSpot parked1 = lot.park();
        System.out.println("Parked at: " + parked1);
    
        // Park another vehicle
        ParkingSpot parked2 = lot.park();
        System.out.println("Parked at: " + parked2);
    
        // Check next available again
        System.out.println("Next available: " + lot.getAvailableSpot());
    
        // Unpark spot (put it back)
        lot.unpark(parked1.getFloor(), parked1.getSpot());
        System.out.println("Unparked and added back: " + parked1);
    
        // Check next available again
        System.out.println("Next available: " + lot.getAvailableSpot());
    
        // Park again
        ParkingSpot parked3 = lot.park();
        System.out.println("Parked at: " + parked3);
    }
    
}
