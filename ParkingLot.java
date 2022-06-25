// Time: Park O(LogMN) | UnPark O(Log MN)

import java.util.PriorityQueue;

public class ParkingLot {
    int maxfloors;
    int maxSpotsPerFloor;
    //spot creation obj
    static class ParkingSpot {
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
    }

    //prioritizing slots upon insertion
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor) return a.spot - b.spot;
        return a.floor - b.floor;
    });

    public ParkingLot(int maxfloors, int maxSpotsPerFloor) {
        this.maxfloors = maxfloors;
        this.maxSpotsPerFloor = maxSpotsPerFloor;
    }
    private ParkingSpot park() {
        if(pq.isEmpty()) {
            throw new IllegalStateException("Parking is full");
        }
        ParkingSpot currSpot = pq.poll();
        return currSpot;
    }

    private void unPark(int spot, int floor) {
        if(!addSpots(spot, floor)) {
            throw new IllegalArgumentException("Invalid floor and spot");
        }
    }

    private ParkingSpot getNextAvailableSpot() {
        return pq.peek();
    }
    private boolean addSpots(int spot, int floor) {
        if(spot > this.maxSpotsPerFloor || floor > this.maxfloors) return false;
        pq.add(new ParkingSpot(floor, spot));
        return true;
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(2,3);
        System.out.println(pl.addSpots(0,0)); // true
        System.out.println(pl.addSpots(100,100)); // false
        pl.addSpots(1,2);
        pl.addSpots(0,1);
        pl.addSpots(0,2);
        ParkingSpot ps3 = pl.getNextAvailableSpot();
        System.out.println("Next Available at "+ps3.getFloor()+" "+ps3.getSpot());//Next Available at 0 0

        ParkingSpot ps = pl.park();
        System.out.println("Parked at "+ps.getFloor()+" "+ps.getSpot()); //Parked at 0 0
        ParkingSpot ps1 = pl.getNextAvailableSpot();
        System.out.println("Next Available at "+ps1.getFloor()+" "+ps1.getSpot());//Next Available at 1 0
        pl.unPark(0,0);
        ParkingSpot ps2 = pl.getNextAvailableSpot();
        System.out.println("Next Available at "+ps2.getFloor()+" "+ps2.getSpot());//Next Available at 0 0
    }

}
