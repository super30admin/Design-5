// Time Complexity :O(logn)(for method park, unpark. addParkingSpot )where n is no of available spots
// Space Complexity :constant as we only consider extra space used inside method
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :no
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ParkingLot pl = new ParkingLot(3, 5);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(3, 5);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(0, 0);
        pl.addParkingSpot(0, 1);

    }

}

class ParkingLot {// parking lot class will have
    // maximum floors
    private int maxFloor;
    // maximum spots per floor
    private int maxSpotPerFloor;
    private PriorityQueue<ParkingSpot> precedence = new PriorityQueue<>((a, b) -> {
        if (a.getFloor() == b.getFloor()) {
            return a.getSpot() - b.getSpot();
        } else {
            return a.getFloor() - b.getFloor();
        }
    });

    // constructor
    ParkingLot(int maxfloor, int maxspot) {
        this.maxFloor = maxfloor;
        this.maxSpotPerFloor = maxspot;
    }

    // we;ll need to add parking spots in start
    public void addParkingSpot(int floor, int spot) {
        if (floor > this.maxFloor) {
            throw new IllegalArgumentException("floor input is greater than max value");
        }
        if (spot > this.maxSpotPerFloor) {
            throw new IllegalArgumentException("spot input is greater than max value");
        }
        ParkingSpot ps = new ParkingSpot(floor, spot);
        precedence.add(ps);
    }

    // to park the vehicle
    public ParkingSpot park() {
        if (precedence.isEmpty()) {
            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot temp = precedence.poll();
        return temp;
    }

    // to unpark the vehicle
    public void unpark(int floor, int spot) {
        ParkingSpot ps1 = new ParkingSpot(floor, spot);
        precedence.add(ps1);
    }

    // get next valid spot
    public ParkingSpot getValidSpot() {
        return precedence.peek();
    }
}

class ParkingSpot {
    private int floor;
    private int spot;

    ParkingSpot(int floor, int spot) {
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