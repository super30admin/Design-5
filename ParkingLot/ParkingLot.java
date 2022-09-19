import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// Time complexity: O(n)
// Space Complexity: O(n^2)

public class ParkingLot {
    private int maxFloors;
    private int spotsPerFloor;
    List<ParkingSpot> occList = new ArrayList<>();

    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor) return a.spot - b.spot;
        else return a.floor - b.floor;
    });

    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors) throw new IllegalStateException("Floor beyond capacity provided!");
        if(spot > spotsPerFloor) throw new IllegalStateException("Spot beyond max capacity provided");
        ParkingSpot ps = new ParkingSpot(floor, spot);
        if(pq.contains(ps)) throw new IllegalStateException("Already occupied!");
         else pq.add(ps);
    }
    public ParkingSpot getNextSpot(){
        if(pq.isEmpty()) throw new IllegalStateException("Parking lot is Full");
        return pq.peek();
    }

    public void park(){
        pq.remove();
    }

    public void unpark(ParkingSpot ps){
        // 1. remove from occupied data struct
        occList.remove(ps);
        pq.add(ps);
    }

    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public int getMaxFloors() {
        return maxFloors;
    }

    public void setMaxFloors(int maxFloors) {
        this.maxFloors = maxFloors;
    }

    public int getSpotsPerFloor() {
        return spotsPerFloor;
    }

    public void setSpotsPerFloor(int spotsPerFloor) {
        this.spotsPerFloor = spotsPerFloor;
    }

    public static class ParkingSpot{
        private int floor;
        private int spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

    }
    public static void main (String[] args) {
        ParkingLot parking = new ParkingLot(20, 100);
        parking.addParkingSpot(1, 20);
        parking.addParkingSpot(8, 12);
        parking.addParkingSpot(3, 20);
        parking.addParkingSpot(1, 11);
        parking.addParkingSpot(9, 7);
        parking.addParkingSpot(3, 1);

        ParkingSpot n = parking.getNextSpot();

        System.out.println("Floor: " + n.floor + ", Slot: " + n.spot);
        parking.park();
        n = parking.getNextSpot();
        System.out.println("Floor: " + n.floor + ", Slot: " + n.spot);
        ParkingSpot ps = new ParkingSpot(1,11);
        parking.unpark(ps);
        n = parking.getNextSpot();
        System.out.println("Floor: " + n.floor + ", Slot: " + n.spot);
    }
}
