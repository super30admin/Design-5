/*
* Assumptions:
*  1. Order of filling: parking lot with priority on smallest floor and smallest slot
*       (Priority Queue)
*  2. Park: get next available slot in priority queue
* 
*  3. Unpark: add slot to priority queue
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: 
    addslot: O(logn)
    park: O(1)
    unpark: O(logn)
* 
*/

import java.util.PriorityQueue;

class ParkingSlot {
    int floor;
    
    int slot;
    
    ParkingSlot next;

    public ParkingSlot(int floor, int slot) {
        this.floor = floor;
        this.slot = slot;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getSlot() {
        return this.slot;
    }
}

public class ParkingLot {
    int maxFloors;

    int maxSlotsPerFloor;

    PriorityQueue<ParkingSlot> availableSlots = new PriorityQueue<>((a, b) -> {
        if (a.floor == b.floor)
            return a.slot - b.slot;

        return a.floor - b.floor;
    });

    public ParkingLot(int maxFloors, int maxSlotsPerFloor) {
        this.maxFloors = maxFloors;
        this.maxSlotsPerFloor = maxSlotsPerFloor;
    }

    public void addParkingSpot(int floor, int slot) {
        if (floor > maxFloors) {
            System.out.println("Floor greater than max floors");
        }

        if (slot > maxSlotsPerFloor) {
            System.out.println("slot greater than max slots per floor");
        }

        availableSlots.add(new ParkingSlot(floor, slot));
    }

    public ParkingSlot park() {
        if (availableSlots.isEmpty()) {
            System.out.println("Parking Lot full");
        }

        return availableSlots.poll();
    }

    public ParkingSlot getAvailableSlot() {
        if (availableSlots.isEmpty()) {
            System.out.println("Parking Lot full");
        }

        return availableSlots.peek();
    }

    public void unpark(int floor, int slot) {
        addParkingSpot(floor, slot);
    }
}
