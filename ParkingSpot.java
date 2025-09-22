package Parking;

public class ParkingLotManager {

    ParkingLot lot;

    private Object object = new Object();

    ParkingLotManager() {
        lot = new ParkingLot();
        lot.spots.add(new ParkingSpot(1, 3));
        lot.spots.add(new ParkingSpot(1, 2));
        lot.spots.add(new ParkingSpot(1, 1));
        lot.spots.add(new ParkingSpot(1, 4));
        lot.spots.add(new ParkingSpot(2, 4));
        lot.spots.add(new ParkingSpot(2, 1));
        lot.spots.add(new ParkingSpot(2, 3));
        lot.spots.add(new ParkingSpot(2, 2));
    }

    private ParkingLot parkingLot;

    ParkingSpot park() {
        synchronized (object) {
            ParkingSpot spot = getAvailableSlot();
            if(spot==null) {
                System.out.println("Parking lot is full");
            }
            return lot.spots.poll();
        }
    }

    private ParkingSpot getAvailableSlot() {
        return this.lot.spots.peek();
    }

    void unPark(ParkingSpot spot) {
        lot.spots.add(spot);
    }

    public static void main(String[] args) {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        ParkingSpot availableSlot = parkingLotManager.getAvailableSlot();
        // Check if the available spot is in the first floor at position 1
        System.out.println("Available slot at floor: "+availableSlot.floor+" and spot number: "+availableSlot.spot);

        ParkingSpot parkedSpot = parkingLotManager.park();
        // Park the vehicle
        System.out.println("Parked at floor: "+parkedSpot.floor+" and spot number: "+parkedSpot.spot);

        ParkingSpot parkedSpot2 = parkingLotManager.park();
        // Park the vehicle
        System.out.println("Parked at floor: "+parkedSpot2.floor+" and spot number: "+parkedSpot2.spot);

        // unPark first vehicle
        parkingLotManager.unPark(parkedSpot);
        ParkingSpot parkedSpot3 = parkingLotManager.park();
        // Park the vehicle
        System.out.println("Re-Parked at floor: "+parkedSpot3.floor+" and spot number: "+parkedSpot3.spot);
    }
}


public class ParkingLot {

    PriorityQueue<ParkingSpot> spots;

    public ParkingLot() {
        spots = new PriorityQueue<ParkingSpot>((a,b)-> a.floor== b.floor? a.spot-b.spot:a.floor-b.floor);
    }
}

public class ParkingSpot {
    int floor;
    int spot;

    ParkingSpot(int floor, int spot) {
        this.floor=floor;
        this.spot=spot;
    }
}
