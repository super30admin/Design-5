import java.util.*;

public class ParkingLot {
    private PriorityQueue<Integer> availableSpots; // Min-heap of free spots
    private Set<Integer> occupiedSpots; // Tracks currently used spots
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        availableSpots = new PriorityQueue<>();
        occupiedSpots = new HashSet<>();

        // Initialize all spots as available
        for (int i = 1; i <= capacity; i++) {
            availableSpots.offer(i);
        }
    }

    // Park a car and return the token (spot number)
    public Integer park() {
        if (availableSpots.isEmpty()) return null; // Parking full

        int spot = availableSpots.poll(); // Closest available
        occupiedSpots.add(spot);
        return spot;
    }

    // Free up a parking spot
    public void leave(int spot) {
        if (occupiedSpots.remove(spot)) {
            availableSpots.offer(spot); // Make it available again
        }
    }

    // Return a list of all occupied spots
    public List<Integer> getOccupiedSpots() {
        return new ArrayList<>(occupiedSpots);
    }
}
/*
Time Complexity:
----------------
park(): O(log n)
leave(): O(log n)
getOccupiedSpots(): O(k)
----------------
Space Complexity: O(n)
*/