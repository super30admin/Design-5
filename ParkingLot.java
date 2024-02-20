import java.util.PriorityQueue;

public class ParkingLot {
    int floors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq;

    public ParkingLot(int floors, int spotsPerFloor) {
        this.floors = floors;
        this.spotsPerFloor = spotsPerFloor;

        pq = new PriorityQueue<>((a, b) -> {
            if (a.getFloor() == b.getFloor()) {
                return a.getSpot() - b.getSpot();
            }
            return a.getFloor() - b.getFloor();
        });
    }

    public void addParkingSpot(int floor, int spot) {
        pq.add(new ParkingSpot(floor, spot));
    }

    public ParkingSpot getNextAvailable() {
        return pq.peek();
    }

    public ParkingSpot park() {
        return pq.poll();
    }

    public void unpark(int row, int col) {
        pq.add(new ParkingSpot(row, col));
    }
}
