import java.util.PriorityQueue;

class ParkingSpot {
    int floor;
    int spot;

    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }

}

public class designParkingLot {
    int maxFloors;
    int spotsPerFloor;

    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
        if (a.floor == b.floor)
            return a.spot - b.spot;
        return a.floor - b.floor;
    });

    public designParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public ParkingSpot park() {
        if (pq.isEmpty()) {
            throw new IllegalArgumentException("Parking Lot is full");
        }
        ParkingSpot result = pq.remove();
        return result;
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
            throw new IllegalArgumentException("Floor input greater than max floors.");
        }

        if (spot > spotsPerFloor) {
            throw new IllegalArgumentException("Spot input greater than max spots.");
        }

        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }

    public static void main(String[] args) {
        designParkingLot p1 = new designParkingLot(10, 10);
        p1.addParkingSpot(1, 1);
        p1.addParkingSpot(2, 1);
        p1.addParkingSpot(3, 1);
        p1.addParkingSpot(1, 2);
        p1.addParkingSpot(2, 2);
        p1.addParkingSpot(3, 2);

        ParkingSpot n = p1.getNextAvailable();
        System.out.println("Parked at floor: " + n.getFloor() + " at spot: " + n.getSpot());
        p1.park();
        ParkingSpot n2 = p1.getNextAvailable();
        System.out.println("Parked at floor: " + n2.getFloor() + " at spot: " + n2.getSpot());
        p1.unpark(1, 1);
        ParkingSpot n3 = p1.getNextAvailable();
        System.out.println("Parked at floor: " + n3.getFloor() + " at spot: " + n3.getSpot());
    }
}
