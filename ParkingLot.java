import java.util.PriorityQueue;

public class ParkingLot {
    int maxFloors;
    int floorCapacity;
    PriorityQueue<ParkingSpot> queue;

    public ParkingLot(int maxFloors, int floorCapacity) {
        this.maxFloors = maxFloors;
        this.floorCapacity = floorCapacity;
        this.queue = new PriorityQueue<ParkingSpot>(
                (spot1, spot2) -> spot1.floor == spot2.floor ? spot1.spot - spot2.spot : spot1.floor - spot2.floor);
    }

    public void addParkingSpot(int floor, int spot) throws IllegalStateException {
        if (floor > maxFloors || spot > floorCapacity) {
            throw new IllegalStateException("Invalid Input");
        }
        ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
        queue.add(parkingSpot);
    }

    public ParkingSpot getNextAvailable() throws Exception {
        if (queue.isEmpty()) {
            throw new Exception("Parking Lot is full.");
        }
        return queue.peek();
    }

    public ParkingSpot park() throws Exception {
        getNextAvailable();
        ParkingSpot spot = queue.poll();
        return spot;
    }

    public void unpark(int floor, int spot) {
        addParkingSpot(floor, spot);
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10, 20);

        try {
            lot.addParkingSpot(0, 1);
            lot.addParkingSpot(1, 2);
            lot.addParkingSpot(2, 3);
            lot.addParkingSpot(1, 13);
            lot.addParkingSpot(0, 5);
            lot.addParkingSpot(4, 11);
            lot.addParkingSpot(7, 10);
            lot.addParkingSpot(2, 16);
            ParkingSpot spot = lot.getNextAvailable();
            System.out.println("Parked at floor \'" + spot.getFloor() + "\' and spot \'" + spot.getSpot()
                    + "\'.");
            lot.park();

            spot = lot.getNextAvailable();
            System.out.println("Parked at floor \'" + spot.getFloor() + "\' and spot \'" + spot.getSpot()
                    + "\'.");
            lot.park();

            spot = lot.getNextAvailable();
            System.out.println("Parked at floor \'" + spot.getFloor() + "\' and spot \'" + spot.getSpot()
                    + "\'.");
            lot.park();

            System.out.println("Unparking Floor 0 Spot 13.");
            lot.unpark(0, 13);
        } catch (Exception e) {
            e.printStackTrace();
        }
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