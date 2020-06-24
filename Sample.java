// Problem -1: Parking lot design 

import java.io.*;
import java.util.PriorityQueue;

class parkingLotDesign {
    PriorityQueue<ParkingSpot> q;
    int maxFloor;
    int maxSpot;

    public parkingLotDesign(int floors, int spots){
        maxFloor = floors;
        maxSpot = spots;
        q = new PriorityQueue<>((a, b) -> {
            if(a.floor == b.floor){ // if parking or unparking on the same floor that is at the top of the queue
                return a.spot - b.spot; // then I want the earliest spot availaible
            }

            return a.floor - b.floor;
        });
    }
    
    // TC = O(1)
    public ParkingSpot park(){
        if(q.isEmpty()) throw new IllegalStateException("Parking lot is full");
        ParkingSpot parkingSpotToBeTaken = q.poll();

        return parkingSpotToBeTaken;
    }
    public ParkingSpot getNextAvailable(){

        return q.peek();
    }
    // TC = O(l0g m*n)
    public void unpark(int floor, int spot){
        if(floor > maxFloor || spot > maxSpot) { throw new IllegalStateException(" Invalid parking spot");}
        ParkingSpot freeingSpot = new ParkingSpot(floor, spot);
        q.add(freeingSpot); // presence of the spot in the pq means it is avaialaible
    }
    // TC = O(l0g m*n)
    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloor || spot > maxSpot) { throw new IllegalStateException(" Invalid parking spot");}
        ParkingSpot parkingSpotToAdd = new ParkingSpot(floor, spot);
        q.add(parkingSpotToAdd);
    }
}
class ParkingSpot{
    int spot;
    int floor;

    ParkingSpot(int fl, int sp){
        spot = sp;
        floor = fl;
    }

    public int getFloor() {
        return floor;
    }

    public int getSpot() {
        return spot;
    }
}
class GFG {
    public static void main (String[] args) {
        parkingLotDesign pl = new parkingLotDesign(10, 20);
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
        pl.unpark(1, 1);
        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    }
}

// Problem -2: Copy List with Random Pointer
/*
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
*/
// TC = O(n)
// SC = O(1)

class Solution {
    HashMap<Node, Node> map; // map to store original node and its clone
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        map = new HashMap<>();
        Node currentOriginal = head;
        Node currentCopy = clone(head); // making a copy of the head pointer 
        
        while(currentOriginal != null){
            currentCopy.random = clone(currentOriginal.random); // cloning the random pointer of the current node from original that is being copied
            currentCopy.next = clone(currentOriginal.next); // cloning the random pointer of the current node from original that is being copied
            currentOriginal = currentOriginal.next; // moving to the next original node to be copied
            currentCopy = currentCopy.next;
        }
        return map.get(head); 
    }
    
    private Node clone(Node original){
        if(original == null) return null; // if the node to copy is null . eg: next pointer is null or the random pointer is null
        Node nodeToBeCopied = map.get(original);
        if(nodeToBeCopied == null){ // if the copy of the original node doesn't exist yet
            nodeToBeCopied = new Node(original.val); // create a clone
            map.put(original, nodeToBeCopied); // then add to its corresponding original node
        }
        
        return nodeToBeCopied;
    }
}

