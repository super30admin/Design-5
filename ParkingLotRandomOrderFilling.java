/*
* Assumptions:
*  1. Order of filling: Random Order(maintaining a linkedlist of queue)

*  2. Park: get next available slot in queue O(1)
* 
*  3. Unpark: add slot to queue
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: 
    addslot: O(1)
    park: O(1)
    unpark: O(1)
* 
*/

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

public class ParkingLotRandomOrderFilling {
    int maxFloors;

    int maxSlotsPerFloor;

    ParkingSlot head;

    public ParkingLotRandomOrderFilling(int maxFloors, int maxSlotsPerFloor) {
        this.maxFloors = maxFloors;
        this.maxSlotsPerFloor = maxSlotsPerFloor;
        head = null;
    }

    public void addParkingSpot(int floor, int slot) {
        ParkingSlot parkingSlot = new ParkingSlot(floor, slot);

        if (head == null) {
            head = parkingSlot;
            return;
        }

        // adding at front of queue
        parkingSlot.next = head;
        head = parkingSlot;
    }

    public ParkingSlot park() {
        if (head == null) {
            System.out.println("Parking Lot full");
            return null;
        }

        ParkingSlot available = head;

        head = head.next;

        return available;
    }

    public ParkingSlot getAvailableSlot() {
        if (head == null) {
            System.out.println("Parking Lot full");
            return null;
        }

        return head;
    }

    public void unpark(int floor, int slot) {
        addParkingSpot(floor, slot);
    }
}
