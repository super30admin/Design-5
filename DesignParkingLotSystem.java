// Time Complexity : O(h) where h = ht of BST
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Start at the root node and traverse down the tree.
//   - If both p and q values are less than root, LCA lies in the left subtree.
//   - If both p and q values are greater than root, LCA lies in the right subtree.
//   - If p and q are on opposite sides (or one equals the root), then the current root is the LCA.

import java.util.*;
public class DesignParkingLotSystem {
    public static void main (String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
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

    static class ParkingSpot{
        int floor; int spot;

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

    static class ParkingLot {
        int maxFloors; int spotsPerFloor;
        PriorityQueue <ParkingSpot> pq  = new PriorityQueue<>((a,b) -> {
            if(a.floor == b.floor) return a.spot - b.spot;
            return a.floor - b.floor;
        });

        public ParkingLot(int maxFloors, int spotsPerFloor){
            this.maxFloors = maxFloors; this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park(){
            if(pq.isEmpty()){
                throw new IllegalStateException("Parking lot is full");
            }
            ParkingSpot re = pq.remove();
            return re;
        }

        public ParkingSpot getNextAvailable(){
            return pq.peek();
        }

        public void unpark(int floor, int spot){
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }

        public void addParkingSpot(int floor, int spot){
            if(floor > maxFloors){
                throw new IllegalArgumentException("floor input greater than max allowed");
            }

            if(spot > spotsPerFloor){
                throw new IllegalArgumentException("spots input greater than max allowed");
            }

            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }
}
