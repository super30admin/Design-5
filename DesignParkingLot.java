import java.util.PriorityQueue;

class ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
       if(a.getFloor() == b.getFloor()) {
           return a.getSpot() - b.getSpot();
       }
       return a.getFloor() - b.getFloor();
    });

    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public ParkingSpot park() {
        if(pq.isEmpty()) {
            throw new IllegalStateException("Parking Lot is full");
        }
        ParkingSpot spot = pq.poll();
        return spot;
    }

    public ParkingSpot getNextAvailable() {
        return pq.peek();
    }

    public void unaprk(int floor, int spot) {
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }

    public void addParkingSpot(int floor, int spot) {
        if(floor > this.maxFloors) {
            throw new IllegalArgumentException("Floor input greater than max allowed");
        }
        if(spot > this.spotsPerFloor) {
            throw new IllegalArgumentException("Spots input greater than max allowed");
        }
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }
}

class ParkingSpot {
    private int floor;
    private int spot;
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
class DesignParkingLot {

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);

        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: "+n1.getSpot());
        pl.park();
        ParkingSpot n2 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: "+n2.getSpot());
        pl.unaprk(1, 1);
        ParkingSpot n3 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n3.getFloor() + ", Slot: "+n3.getSpot());
    }
}