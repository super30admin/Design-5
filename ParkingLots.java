package Design5;

import java.util.PriorityQueue;

/*
-------------------------------------------------------------------------------------------------------
Time complexity :O(N) 
space complexity:O(N) 
Approach:
Did this code run successfully in leetcode : yes
problems faces : no*/

class ParkingLots {

    int maxFloors;
    int maxSpots;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
        if (a.floor == b.floor)
            return a.spot - b.spot;
        else
            return (a.floor - b.floor);
    });

    public ParkingLots(int maxFloors, int maxSpots) {

        this.maxFloors = maxFloors;
        this.maxSpots = maxSpots;

    }

    public ParkingSpot park() {
        if (pq.size() == 0) {

            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot top = pq.poll();
        return top;
    }

    public ParkingSpot getNextAvailable() {

        return pq.peek();
    }

    public void unPark(int floor, int spot) {

        addParkingSpot(floor, spot);
    }

    public void addParkingSpot(int floor, int spot) {

        if (floor > maxFloors) {

            throw new IllegalStateException("give input is greater than number of max floors");
        }

        if (spot > maxSpots) {

            throw new IllegalStateException("give input is greater than number of max spots");
        }

        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);

    }
}

class ParkingSpot {

    int floor;
    int spot;

    public ParkingSpot(int floor, int spot) {

        this.floor = floor;
        this.spot = spot;
    }
}


