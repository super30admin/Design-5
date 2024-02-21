import java.util.PriorityQueue;

class ParkingCell {
    private Integer floor;
    private Integer spot;

    public ParkingCell(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public Integer getFloor() {
        return this.floor;
    }

    public Integer getSpot() {
        return this.spot;
    }
}

class ParkingLot {
    private Integer totalFloors;
    private Integer spotsPerFloor;
    private PriorityQueue<ParkingCell> pq;

    public ParkingLot(Integer floors, Integer spots) {
        this.totalFloors = floors;
        this.spotsPerFloor = spots;

        this.pq = new PriorityQueue<>((a, b) -> {
            if (a.getFloor() == b.getFloor())
                return a.getSpot() - b.getSpot();
            return b.getFloor() - a.getFloor();
        });
    }

    public void addParkingSpot(int floor, int spot) {
        if (floor > totalFloors) {
            System.out.println("Invalid floor number");
        }

        if (spot > spotsPerFloor) {
            System.out.println("Invalid spot number");
        }

        pq.add(new ParkingCell(floor, spot));
    }

    public ParkingCell getNextAvailable() {
        return pq.peek();
    }

    public ParkingCell park() {
        return pq.poll();
    }

    public void unpark(int floor, int spot) {
        addParkingSpot(floor, spot);
    }
}

public class DesignParkingLot {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);
        ParkingCell n = pl.getNextAvailable(); // 1,1
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        pl.park();
        ParkingCell n2 = pl.getNextAvailable(); // 1,2
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unpark(1, 1);
        ParkingCell n1 = pl.getNextAvailable(); // 1 1
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    }
}