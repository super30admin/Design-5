
//time - N * M log(N * M))
//space - N*M

import java.util.PriorityQueue;

public class ParkingLot {
    class ParkingSpot {
        int floor;
        int spot;
        ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }
    }

    int spotCapacity;
    int floors;
    PriorityQueue<int[]> minHeap;

    ParkingLot(int spotCapacity, int floors) {
        this.spotCapacity = spotCapacity;
        this.floors = floors;
        this.minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        // Initialize minHeap with all spots
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < spotCapacity; j++) {
                minHeap.add(new int[]{i, j});
            }
        }
    }

    private boolean isParkingLotFull() {
        return minHeap.isEmpty();
    }

    private int[] park() {
        if (!isParkingLotFull()) {
            int[] closestSpot = minHeap.poll();
            return new int[]{closestSpot[0], closestSpot[1]};
        } else {
            return new int[]{-1, -1}; // Indicate that the parking lot is full
        }
    }

    private boolean unPark(int floor, int spot) {
        minHeap.add(new int[]{floor, spot});
        return true; // Indicate that the spot was successfully added back
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10, 3); // 10 spots per floor, 3 floors
        int[] spot1 = parkingLot.park();
        int[] spot2 = parkingLot.park();
        System.out.println("Parked at: Floor " + spot1[0] + ", Spot " + spot1[1]);
        System.out.println("Parked at: Floor " + spot2[0] + ", Spot " + spot2[1]);
        parkingLot.unPark(spot1[0], spot1[1]);
        System.out.println("Unparked spot at: Floor " + spot1[0] + ", Spot " + spot1[1]);
    }
}
