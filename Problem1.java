//Time = O(n), n is the capacity of the parking lot.
//Space = O(n), worst case

import java.util.*;

// Parking lot class
class ParkingLot {
    private int capacity; // Total capacity of the parking lot
    private List<Integer> emptySpaces; // List to track empty parking spaces
    private Map<Integer, String> occupiedSpaces; // Map to track occupied parking spaces

    // Constructor to initialize the parking lot with the given capacity
    public ParkingLot(int capacity) {
        this.capacity = capacity;
        emptySpaces = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            emptySpaces.add(i);
        }
        occupiedSpaces = new HashMap<>();
    }

    // Method to park a vehicle and return the token with the parking space number
    public int parkVehicle(String vehicleNumber) {
        if (emptySpaces.isEmpty()) {
            return -1; // Parking lot is full, cannot park vehicle
        }

        // Find the closest empty parking space to the entrance
        int parkingSpace = emptySpaces.remove(0);

        // Assign the parking space to the vehicle and add it to the occupied spaces map
        occupiedSpaces.put(parkingSpace, vehicleNumber);

        // Return the token with the parking space number
        return parkingSpace;
    }

    // Method to remove a parked vehicle and update the corresponding parking space as empty
    public boolean removeVehicle(int parkingSpace) {
        if (!occupiedSpaces.containsKey(parkingSpace)) {
            return false; // Parking space is already empty, or invalid parking space number
        }

        // Remove the vehicle from the occupied spaces map and add the parking space back to the empty spaces list
        occupiedSpaces.remove(parkingSpace);
        emptySpaces.add(parkingSpace);
        Collections.sort(emptySpaces); // Sort the empty spaces list in ascending order

        return true;
    }

    // Method to get the list of all occupied parking spaces
    public List<Integer> getOccupiedSpaces() {
        return new ArrayList<>(occupiedSpaces.keySet()); // Return a copy of the keys of the occupied spaces map
    }

    // Method to get the list of all empty parking spaces
    public List<Integer> getEmptySpaces() {
        return emptySpaces; // Return the empty spaces list
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a new parking lot with capacity 10
        ParkingLot parkingLot = new ParkingLot(10);

        // Park some vehicles and print the corresponding parking space tokens
        int token1 = parkingLot.parkVehicle("ABC123");
        System.out.println("Vehicle parked at space number: " + token1);
        int token2 = parkingLot.parkVehicle("XYZ789");
        System.out.println("Vehicle parked at space number: " + token2);

        // Print the list of occupied spaces and empty spaces
        System.out.println("Occupied spaces: " + parkingLot.getOccupiedSpaces());
        System.out.println("Empty spaces: " + parkingLot.getEmptySpaces());

        // Remove a parked vehicle and print the result
        boolean removed = parkingLot.removeVehicle(token1);
        if (removed) {
            System.out.println("Vehicle parked at space number " + token1 + " has been removed");
        } else {
            System.out.println("Invalid parking space number or parking space is already empty");
        }

        // Print the list of occupied spaces and empty spaces after removal
        System.out.println("Occupied spaces: " + parkingLot.getOccupiedSpaces());
        System.out.println("Empty spaces: " + parkingLot.getEmptySpaces());
    }
}
