// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
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
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copycurr = copyHead;
        while(curr != null){
            if(curr.next != null){
                 copycurr.next = clone(curr.next);
            }
           if(curr.random != null){
                copycurr.random = clone(curr.random); 
           }
           curr = curr.next;
           copycurr =copycurr.next;
        }
        return copyHead;
    }
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
            Node copy = new Node(node.val);
            map.put(node,copy);
            return copy;
    }
}

// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
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
        if(head == null) return null;
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = curr.next.next; 
        }
        //connecting random pointers to deep copy
        curr = head;
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
                curr = curr.next.next;
        }
        //split the original and deep copy list
        curr = head;
        Node copyHead =head.next; 
        Node copyCurr = head.next;
        while(curr !=null){
            curr.next = copyCurr.next;
            if(copyCurr.next!=null){
                copyCurr.next = copyCurr.next.next;
            }
            curr= curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}
// Time Complexity :O(1) for park and to get next available spot
//Time Complexity :log(N) for unpark(as heapify happens when we need to put unparked location into priorityqueue)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :N/A
//Parling Lot level
import java.util.PriorityQueue;

public class Parkinglot {
	int floor;
	int spot;
	PriorityQueue<Parkingspot> pq = new PriorityQueue<>((a,b)->{
		if(a.floor == b.floor) {
			return a.spot - b.spot;
		}
		return a.floor - b.floor;
	});
		public Parkinglot(int floor, int spot) {
			this.floor = floor;
			this.spot = spot;
		}
	public void addSpot(int floor, int spot) {
		Parkingspot sp = new Parkingspot(floor,spot);
		pq.add(sp);
	}
	public Parkingspot park(int floor, int spot) {
		if(pq.isEmpty()) {
			throw new IllegalArgumentException("No Space Available");
		}
		Parkingspot p = pq.poll();
		return p;
	}
	public Parkingspot getNextAvailable() {
		if(pq.isEmpty()) {
			throw new IllegalArgumentException("No Space Available");
		}
		return pq.peek();
	}
	public void unpark(){
		Parkingspot up = new Parkingspot(floor,spot);
		pq.add(up);
	}
}
//Parking Dpot

public class Parkingspot {
		int floor;
		int spot;
		public Parkingspot(int floor, int spot) {
			this.floor = floor;
			this.spot = spot;
		}
		public int getFloor() {
			return floor;
		}
		public int getSpot() {
			return spot;
		}
		
		
}
//Main

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parkinglot pl = new Parkinglot(4,5);
		pl.addSpot(1,2);
		pl.addSpot(1,4);
		pl.addSpot(2,2);
		pl.addSpot(1,3);
		pl.addSpot(3,2);
		pl.park(1, 2);
		Parkingspot ps = pl.getNextAvailable();
		System.out.println("the floor:"+ ps.getFloor() + "the spot:"+ ps.getSpot());
		pl.park(ps.getFloor(), ps.getSpot());
		ps = pl.getNextAvailable();
		System.out.println("the floor:"+ ps.getFloor() + "the spot:"+ ps.getSpot());
		
	}

}
