// Time Complexity : O(1) - For Park, Unpark , getNextAvailableSlot operations
// Space Complexity : O(n) - Heap to maintain available parking spots

import java.util.PriorityQueue;

public class ParkingLotSystem {

    //smaller entity
    class ParkingSpot{
        int floor;
        int spot;

        public ParkingSpot(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }

        //getter and setters
        public  int getFloor(){
            return this.floor;
        }

        public  int getSpot(){
            return this.spot;
        }

    }

    //bigger entity data members
    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
        if(a.floor == b.floor) return a.spot - b.spot;
        else return a.floor - b.floor;
    });

    public ParkingLotSystem(int maxFloors, int spotsPerFloor){
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalArgumentException("Parking lot is full");
        }
        ParkingSpot sp = pq.poll();
        return sp;
    }

    public ParkingSpot getNextAvailable(){
        if(pq.isEmpty()){
            throw new IllegalArgumentException("Parking lot is full");
        }
        return pq.peek();
    }

    public void unpark(int floor, int spot){
        addParkingSpot(floor, spot);
    }

    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors){
            throw new IllegalArgumentException("Given Floor greater than max allowed");
        }
        if(spot > spotsPerFloor){
            throw new IllegalArgumentException("Given Spot cannot be placed in a floor");
        }
        ParkingSpot sp = new ParkingSpot(floor, spot);
        pq.add(sp);

    }

    public static void main(String[] args) {
        ParkingLotSystem pl = new ParkingLotSystem(10,10);
        pl.addParkingSpot(1,1);
        pl.addParkingSpot(1,2);
        pl.addParkingSpot(1,3);
        pl.addParkingSpot(2,1);

        ParkingSpot nextAvailableSpot = pl.getNextAvailable();
        System.out.println("Parking at floor : " + nextAvailableSpot.getFloor() + " and spot : " + nextAvailableSpot.getFloor());
        pl.park();
    }

}
