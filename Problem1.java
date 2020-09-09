/* Design Parking Lot */

//Time Complexity: 0(1)

//Design
//In parking Lot, we will be considering various requirements(from interviewer) and few assumptions
//Requirements: 1. Number of people or vehicles(small, big)
//2. Number of entrance / exits
//3. Finding empty space/slot
//4. Number of floors and number of spots
//5. Optional: Cost(cash or credit) time based

//First explain to the interviewer about your assumptions
//Create diagram Parking Lot and Parking Spot classes
//1.Parking Lot is the main class consisting of max number of floors and number of spots
//Initialise Priority queue that will help O(1)time complexity and easily assign parking spots by optimising
//2.Then define Parking Spot class to initialise number of floors and number of spots
//3. Define all methods and functions: park(), unpark(), getNextAvailable() and addParkingSpot()

import java.io.*;
import java.util.*;

//1.Parking Lot class
public class ParkingLot {
    //initialising max no. of floors and no. of spots
    private static int noOfFloors = 5;
    private static int noOfSpotsPerFloors = 10;

    //defining PQ
    PriorityQueue <ParkingSpot> pq = new PriorityQueue<>((ParkingSpot a, ParkingSpot b) -> {
        if(a.floor == b.floor) return a.spot - b.spot;
        return a.floor - b.floor;
    });
    
    //Methods
    //1.1 park()
    public ParkingSpot park() {
        //getting next available parking spot
        ParkingSpot s = getNextAvailable();
        pq.remove();
        return s;
    }
    //1.2 unpark()
    public void unpark(int floor, int spot) {
        ParkingSpot toRemove = new ParkingSpot(floor, spot);
        pq.add(toRemove);
    }

    //1.3 getNextAvailable()
    public ParkingSpot getNextAvailable() {
        if(pq.isEmpty()){
            System.out.println("The parking lot is fun");
        }
        return pq.peek();
    }

    //1.4 addParkingSpot()
    public void addParkingSpot(int floor, int spot) {
        //check for boundary conditions
        if(floor > noOfFloors) System.out.println("Number of available floors is 5 only");
        if(spot > noOfSpotsPerFloors) System.out.println("Number of allowed spots per floors is 10 only");
        ParkingSpot toAdd = new ParkingSpot(floor, spot);
        pq.add(toAdd);
    }

    //2. ParkingSpot class
    public class ParkingSpot {
        //initialising floor and spot
        private int floor;
        private int spot;
        ParkingSpot(int floor, int spot){
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
}

//main function
class Defined {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        pl.addParkingSpot(1,1);
        pl.addParkingSpot(2,1);
        pl.addParkingSpot(3,1);
        pl.addParkingSpot(1,2);
        pl.addParkingSpot(2,2);
        pl.addParkingSpot(3,2);
        ParkingLot.ParkingSpot n = pl.getNextAvailable();
 		System.out.println("Parked at Floor: " + n.getFloor() + ", Spot: " + n.getSpot());
 		pl.unpark(2, n.getSpot());
    }
}