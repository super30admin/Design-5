# Design-5

## Problem 1:

This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance.
When someone leave you need update this space as empty.
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.

class ParkingLot {

    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> queue;

    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
        queue = new PriorityQueue<>((a,b) -> a.floor == b.floor? a.spot - b.spot : a.floor - b.floor);
    }

    public void addParkingSpot(int floor, int spot) throws IllegalStateException {

        if(floor > maxFloors) {
            throw new IllegalStateException("Invalid Floor");
        }
        if(spot > spotsPerFloor) {
            throw new IllegalStateException("Invalid Spot");
        }
        ParkingSpot newSpot = new ParkingSpot(floor,spot);
        queue.add(newSpot);
    }

    public ParkingSpot park() throws Exception {
        getNextAvailable();
        return queue.poll();
    }

    public void unpark(int floor, int spot) throws Exception {
        queue.add(new ParkingSpot(floor,spot));
    }

    public ParkingSpot getNextAvailable() throws Exception {
        if(queue.isEmpty()) {
            throw new Exception("Parking is Full");
        }
        return queue.peek();
    }

}

class ParkingSpot {
int floor;
int spot;

    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getSpot() {
        return this.spot;
    }

}

// "static void main" must be defined in a public class.
public class Main {
public static void main(String[] args) throws Exception{
ParkingLot pl = new ParkingLot(10,20);
pl.addParkingSpot(1, 1);
pl.addParkingSpot(2, 1);
pl.addParkingSpot(3, 1);
pl.addParkingSpot(1, 2);
pl.addParkingSpot(2, 2);
pl.addParkingSpot(3, 2);
ParkingSpot n = pl.getNextAvailable();
System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
pl.park();

        ParkingSpot n2 = pl.getNextAvailable();
    	System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unpark(1,1);

        ParkingSpot n3 = pl.getNextAvailable();
    	System.out.println("Parked at Floor: " + n3.getFloor() + ", Slot: " + n3.getSpot());
    }

}

## Problem 2: Copy List with Random Pointer

https://leetcode.com/problems/copy-list-with-random-pointer/

//Time complexity = O(N)
//Space Complexity = O(1)

/\*
// Definition for a Node.
class Node {
int val;
Node next;
Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

}
\*/

class Solution {

    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        Node current = head;

        while(current != null) {
            Node currentCopy = new Node(current.val);
            currentCopy.next = current.next;
            current.next = currentCopy;
            current = current.next.next;
        }
        current = head;

        while(current != null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        current = head;
        Node copyHead = head.next;
        Node currentCopy = copyHead;
        while(current != null) {
            current.next = current.next.next;
            if(currentCopy.next != null) {
                currentCopy.next = currentCopy.next.next;
            }
            current = current.next;
            currentCopy = currentCopy.next;
        }
        return copyHead;
    }

}
