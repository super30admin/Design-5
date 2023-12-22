/* Time Complexity : O(log mn)
 *  m - no. of floors 
 *  n - no. of spots per floor */
/* Space Complexity : O(m*n)
 * size of the priority queue */
// Did this code successfully run on Leetcode : Not available on leetcode, validated it against the boiler plate code below
// Any problem you faced while coding this : 

import java.io.*;
public class Main {
    
    static class ParkingSpot{
        int floor;
        int spot;
        
        public ParkingSpot(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }
        
        public int getFloor(){
            return this.floor;
        }
        
        public int getSpot(){
            return this.spot;
        }
    }
    
    static class ParkingLot{
        int maxFloors;
        int spotsPerFloor;
        //First come first serve
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
            if(a.floor == b.floor) return a.spot - b.spot;
            return a.floor - b.floor;
        });
        
        public ParkingLot(int maxFloors, int spotsPerFloor){
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }
        
        public ParkingSpot park(){
            if(pq.isEmpty()){
                throw new IllegalStateException("Parking lot is full.");
            }
            ParkingSpot spotDetails = pq.remove();
            return spotDetails;
        }
        
        public void unPark(int floor, int spot){
            ParkingSpot releasedSpot = new ParkingSpot(floor, spot);
            pq.add(releasedSpot);
        }
        
        public ParkingSpot nextAvailableSpot(){
            return pq.peek();
        }
        
        public void addParkingSpot(int floor, int spot){
            if(floor > maxFloors){
                throw new IllegalStateException("Parking lot is full.");
            }
            
            if(spot > spotsPerFloor){
                throw new IllegalStateException("Parking lot is full.");
            }
            
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }            
    }
    
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);
        pl.addParkingSpot(1, 3);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(3, 2);
        
        ParkingSpot ps = pl.nextAvailableSpot();
        System.out.println("Next parking available on floor '" + ps.getFloor() + "' at location '" + ps.getSpot() + "'.");
        pl.park();
        System.out.println("Parked on floor '" + ps.getFloor() + "' at location '" + ps.getSpot() + "'.");
        ps = pl.nextAvailableSpot();
        System.out.println("Next parking available on floor '" + ps.getFloor() + "' at location '" + ps.getSpot() + "'.");
        pl.unPark(1, 1);
        
        ps = pl.nextAvailableSpot();
        System.out.println("Next parking available on floor '" + ps.getFloor() + "' at location '" + ps.getSpot() + "'.");               
    }
}