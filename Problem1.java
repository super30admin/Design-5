package gfg;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ParkingLot {
    int floors, spots;
    PriorityQueue<ParkingSpot> q;

    ParkingLot(int floors, int spots) {
        this.floors = floors;
        this.spots = spots;
        createSpots(floors, spots);
    }

    // Time Complexity : O(mn)
    private void createSpots(int floors, int spots) {
        q = new PriorityQueue<>(new ParkingSpotComparator());
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < spots; j++)
                q.offer(new ParkingSpot(i, j));
        }
    }

    // Time Complexity : O(1)
    private ParkingSpot park() {
        if (q.size() == 0) {
            throw new IllegalStateException("Parking Lot Is Full!");
        } else
            return q.poll();
    }

    // Time Complexity : O(log(mn))
    private void unpark(int floor, int spot) {
        if (floor >= floors || spot >= spots)
            throw new IllegalStateException("Parking Spot Not Available");
        else
            q.offer(new ParkingSpot(floor, spot));
    }

    // Time Complexity : O(1)
    private ParkingSpot getNextAvailabelSpot() {
        return q.peek();
    }

    class ParkingSpotComparator implements Comparator<ParkingSpot> {
        public int compare(ParkingSpot p1, ParkingSpot p2) {
            if (p1.floor == p2.floor)
                return p1.getSpot() - p2.getSpot();
            else
                return p1.getFloor() - p2.getFloor();
        }
    }

    class ParkingSpot {
        int floor, spot;

        ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        private int getFloor() {
            return this.floor;
        }

        private int getSpot() {
            return this.spot;
        }

        public String toString() {
            return "Floor : " + getFloor() + "\n" + "Spot : " + getSpot() + "\n";
        }
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(5, 10);
        System.out.print(pl.getNextAvailabelSpot());
        pl.park();
        System.out.print(pl.getNextAvailabelSpot());
        pl.unpark(0, 0);
        System.out.print(pl.getNextAvailabelSpot());
    }
}