import java.util.*;

class ParkingLot {
    private PriorityQueue<Integer> availableSpaces;
    private Set<Integer> occupiedSpaces;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        availableSpaces = new PriorityQueue<>();
        occupiedSpaces = new HashSet<>();

        // Initially, all spots are available
        for (int i = 1; i <= capacity; i++) {
            availableSpaces.offer(i);
        }
    }

    // Allocate the closest spot
    public Integer park() {
        if (availableSpaces.isEmpty()) {
            System.out.println("Parking Full");
            return null;
        }
        int spot = availableSpaces.poll();
        occupiedSpaces.add(spot);
        return spot;
    }

    // Free up a spot
    public void leave(int spot) {
        if (!occupiedSpaces.contains(spot)) {
            System.out.println("Spot " + spot + " is already empty or invalid");
            return;
        }
        occupiedSpaces.remove(spot);
        availableSpaces.offer(spot);
    }

    // Get all occupied spots
    public Set<Integer> getOccupiedSpots() {
        return new HashSet<>(occupiedSpaces); // Return a copy to avoid external mutation
    }
}
