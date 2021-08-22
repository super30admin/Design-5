
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class ParkingLot {

    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> queue;

    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
        queue = new PriorityQueue<>((a,b) -> a.floor == b.floor? a.spot - b.spot : a.floor - b.floor);
    }

    public void addParkingSpot(int floor, int spot) throws IllegalStateException {

        if(floor > maxFloors) {
            throw new IllegalStateException("Invalid Floor");
        }
        if(spot > spotsPerFloor) {
            throw new IllegalStateException("Invalid Spot");
        }
        ParkingSpot newSpot = new ParkingSpot(floor,spot);
        queue.add(newSpot);
    }

    public ParkingSpot park() throws Exception {
        getNextAvailable();
        return queue.poll();
    }

    public void unpark(int floor, int spot) throws Exception {
        queue.add(new ParkingSpot(floor,spot));
    }

    public ParkingSpot getNextAvailable() throws Exception {
        if(queue.isEmpty()) {
            throw new Exception("Parking is Full");
        }
        return queue.peek();
    }

}

class ParkingSpot {
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

// "static void main" must be defined in a public class.
public class Main {
public static void main(String[] args) throws Exception{
ParkingLot pl = new ParkingLot(10,20);
pl.addParkingSpot(1, 1);
pl.addParkingSpot(2, 1);
pl.addParkingSpot(3, 1);
pl.addParkingSpot(1, 2);
pl.addParkingSpot(2, 2);
pl.addParkingSpot(3, 2);
ParkingSpot n = pl.getNextAvailable();
System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
pl.park();

        ParkingSpot n2 = pl.getNextAvailable();
    	System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unpark(1,1);

        ParkingSpot n3 = pl.getNextAvailable();
    	System.out.println("Parked at Floor: " + n3.getFloor() + ", Slot: " + n3.getSpot());
    }

}