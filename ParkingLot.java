import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingLot {
    private class ParkingSpot {
        int level;
        int number;

        public ParkingSpot(int level, int number) {
            this.level = level;
            this.number = number;
        }
    }

    private Queue<ParkingSpot> parkingGarage;
    int levelCapacity;
    int floors;

    public ParkingLot(int levelCapacity, int floors) {
        this.levelCapacity = levelCapacity;
        this.floors = floors;

        parkingGarage = new PriorityQueue<ParkingSpot>((a, b) -> {
            if (a.level != b.level) {
                return a.level - b.level;
            }
            return a.number - b.number;
        });

        // initializing the parking garage by adding all the vacant spots
        for (int i = 0; i < floors; i++) {
            for (int j = 0; j < levelCapacity; j++) {
                parkingGarage.add(new ParkingSpot(i, j));
            }
        }
    }

    // O(log(n))
    public ParkingSpot park() {
        if (parkingGarage.size() != 0) {
            return parkingGarage.poll();
        }
        return null;
    }

    // O(log(n))
    public void unpark(ParkingSpot spot) {
        parkingGarage.add(spot);
    }
}
