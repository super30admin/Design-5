// Time Complexity : 
//      park -> O(1)
//      unpark -> O(log(m*n))
//    m: number of floor
//    n: number of spots on floor
// Space Complexity : O(m*n)
//   Priority Queue size
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

import java.util.PriorityQueue;

// Your code here along with comments explaining your approach

// Definition of ParkingLot
class ParkingLot{

    // member variables
    int numberOfFloor;
    int floorSize;

    PriorityQueue<ParkingSpot> myQueue;

    // constructor
    public ParkingLot(int numberOfFloor, int floorSize){
        this.numberOfFloor = numberOfFloor;
        this.floorSize = floorSize;
        myQueue = new PriorityQueue<>((a, b)-> {
            if(a.getFloor() == b.getFloor())
                return a.getSpotId() - b.getSpotId();
            else
                return a.getFloor()-b.getFloor();
        });
        
    }

    public ParkingSpot park(){
        return myQueue.poll();
    }

    public void unPark(int floor, int spot){
        addParkingSpot(floor, spot);
    }
    
    public void addParkingSpot(int floor, int spot){

        if(floor > numberOfFloor || spot > floorSize)
            System.err.println(" Out of Range");
        else{
            ParkingSpot newSpot = new ParkingSpot(spot, floor);
            myQueue.add(newSpot);
        }

    }

    public ParkingSpot getNextParkingSpot(){
        return myQueue.peek();
    }

}

// Definition of ParkingSpot
class ParkingSpot{
    private int spotId;
    private int floor;

    public ParkingSpot(int spotId, int floor){
        this.spotId = spotId;
        this.floor = floor;
    }

    public int getSpotId() {
        return spotId;
    }
    public int getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        
        return "ParkingSpot { Floor: " +getFloor()+", SpotId: "+getSpotId()+ " }";
    }
}

class Problem1{

    // driver code
    public static void main(String[] args) {
        ParkingLot parkingLot =  new ParkingLot(10, 20);
        for(int floor=1; floor<4; floor++){
            for(int spot = 1;  spot<5; spot++)
                parkingLot.addParkingSpot(floor, spot);
        }
        System.out.println("Next Available: ");
        System.out.println(parkingLot.getNextParkingSpot());

        parkingLot.park();
        System.out.println("After Parking 1 Spot, Next Available: ");
        System.out.println(parkingLot.getNextParkingSpot());

        parkingLot.unPark(1, 1);
        System.out.println("After Unparking (1, 1) Spot, Next Available: ");
        System.out.println(parkingLot.getNextParkingSpot());

    }
}