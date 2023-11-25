// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


// ## Problem 2: Copy List with Random Pointer

// https://leetcode.com/problems/copy-list-with-random-pointer/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        if(head == null) return null;
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        Node curr = head;
        Node copyCurr = copyHead;

        while(curr.next != null){
            Node newNode = new Node(curr.next.val);
            copyCurr.next = newNode;
            curr = curr.next;
            copyCurr = copyCurr.next;
            map.put(curr, copyCurr);
        }

        curr = head;
        copyCurr = copyHead;
        while(curr != null){
            if(curr.random != null){
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}


class Main{
    static class ParkingSpot{
        int floor;
        int spot;
        public ParkingSpot(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }

        public int getSpot(){
            return this.spot;
        }

        public int getFloor(){
            return this.floor;
        }
    }

    static class ParkingLot{
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) ->{ 
        if(a.floor == b.floor) return a.spot-b.spot;
        return a.floor - b.floor; 
    });

    public ParkingLot(int maxFloors, int spotsPerFloor){
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot result = pq.remove();
        return result;
    }

    public ParkingSpot unpark(int floor, int spot){
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
    }

    public ParkingSpot getNextAvailable(){
        return pq.peek();
    }

    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors){
            throw new IllegalStateException("Floor input greater than max allowed");
        }
        if(spot > spotsPerFloor){
            throw new IllegalStateException("Spots greater than max allowed");
        }
        ParkingSpot newSpot = new ParkingSpot(floor, spot){
            pq.add(newSpot);
        }
    }
}
}