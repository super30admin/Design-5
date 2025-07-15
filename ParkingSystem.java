// Time complexity: O(1) 
// Space complexity: O(1)
// LeetCode 1603. Design Parking System
// https://leetcode.com/problems/design-parking-system/
// Intuition: We can use an array to keep track of the number of available parking slots for each type of car.
// Approach: Initialize an array with the number of slots for each car type. 
// For each addCar call, check if the slot is available and decrement it if so.
public class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Index 0 is unused; use 1 for big, 2 for medium, 3 for small
        slots = new int[4];
        slots[1] = big;
        slots[2] = medium;
        slots[3] = small;
    }

    public boolean addCar(int carType) {
        if (slots[carType] > 0) {
            slots[carType]--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);

        System.out.println(parkingSystem.addCar(1)); // true
        System.out.println(parkingSystem.addCar(2)); // true
        System.out.println(parkingSystem.addCar(3)); // false
        System.out.println(parkingSystem.addCar(1)); // false
    }

}
