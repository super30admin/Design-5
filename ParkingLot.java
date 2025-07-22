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

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;

        }
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            map.put(current, copy);
            current = current.next;
        }
        // reset to head
        current = head;
        while (current != null) {
            Node copynode = map.get(current);
            copynode.next = map.get(current.next);
            copynode.random = map.get(current.random);
            current = current.next;

        }
        return map.get(head);

    }
}

//
import java.util.*;

public class ParkingLot {
    private PriorityQueue<Integer> availableSpaces; // Min-heap for closest space
    private Set<Integer> occupiedSpaces; // Set for occupied spaces
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        availableSpaces = new PriorityQueue<>();
        occupiedSpaces = new HashSet<>();
        for (int i = 1; i <= capacity; i++) {
            availableSpaces.offer(i);
        }
    }

    // Park a car and return the token (space number), or -1 if full
    public int park() {
        if (availableSpaces.isEmpty()) {
            System.out.println("Parking Lot Full");
            return -1;
        }
        int space = availableSpaces.poll();
        occupiedSpaces.add(space);
        System.out.println("Parked at space: " + space);
        return space;
    }

    // Leave a parking space, making it available again
    public void leave(int space) {
        if (occupiedSpaces.remove(space)) {
            availableSpaces.offer(space);
            System.out.println("Space " + space + " is now available.");
        } else {
            System.out.println("Space " + space + " was not occupied.");
        }
    }

    // Get all currently occupied spaces
    public Set<Integer> getOccupiedSpaces() {
        return new HashSet<>(occupiedSpaces);
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);

        int t1 = lot.park(); // Should assign 1
        int t2 = lot.park(); // Should assign 2
        lot.leave(t1); // Space 1 becomes available
        int t3 = lot.park(); // Should assign 1 again (closest)
        System.out.println("Occupied: " + lot.getOccupiedSpaces());
    }
}