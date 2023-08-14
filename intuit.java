import java.util.*;

class ParkingLot {
    private int capacity;
    private PriorityQueue<Integer> emptySpaces; // Min Heap to store empty spaces
    private HashSet<Integer> occupiedSpaces;    // HashSet to track occupied spaces
    
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        emptySpaces = new PriorityQueue<>();
        occupiedSpaces = new HashSet<>();
        
        // Initially, all spaces are empty
        for (int i = 1; i <= capacity; i++) {
            emptySpaces.offer(i);
        }
    }
    
    // Park a car and return the parking space number (or -1 if full)
    public int parkCar() {
        if (emptySpaces.isEmpty()) {
            return -1; // Parking lot is full
        }
        
        int parkingSpace = emptySpaces.poll(); // Get the closest empty space
        occupiedSpaces.add(parkingSpace); // Mark space as occupied
        return parkingSpace;
    }
    
    // Remove a car and mark the space as empty
    public void removeCar(int parkingSpace) {
        if (occupiedSpaces.contains(parkingSpace)) {
            occupiedSpaces.remove(parkingSpace); // Mark space as empty
            emptySpaces.offer(parkingSpace);     // Add space back to empty spaces
        }
    }
    
    // Get a list of occupied spaces at a given time
    public List<Integer> getOccupiedSpaces() {
        return new ArrayList<>(occupiedSpaces);
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10); // Initialize parking lot with 10 spaces
        
        int token1 = parkingLot.parkCar();
        int token2 = parkingLot.parkCar();
        int token3 = parkingLot.parkCar();
        
        System.out.println("Occupied Spaces: " + parkingLot.getOccupiedSpaces());
        
        parkingLot.removeCar(token2);
        
        System.out.println("Occupied Spaces after removing token2: " + parkingLot.getOccupiedSpaces());
    }
}

