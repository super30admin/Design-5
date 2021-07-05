//Problem 113: Design Parking Lot
//TC: O(1) for finding getNextAvailableSpot(), 
//   O(logN) for addParkingSpot, park and unpark
//SC: O(total capacity), which is number of floors*number of spots

/*
Q Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance.
When someone leave you need update this space as empty.
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
https://www.careercup.com/question?id=5084295966228480
*/

/*
Steps: 
 Bruteforce : TC:O(m*n) for finding next available, but for parking and unparking it will be O(1);
              Create a boolean 2d array for floor and spots. Then for searching next available, do linear search. If array size is m*n, the traversal will be also m*n

 Optimized: 
  Questions To be asked: 1)Capacity of Parking Lot
                         2) How many floors
                         3) How many spots on each floor
                         4) Parking Spot Assignment/Filling Criteria: Random or Any Pattern such as FCFS
                         5) Number of Entrance or Exit, If multiple entrance and exit then priority should be basis on that or not or in future you can say that we can use the concept of synchronization using multithreading
                         Multiple entry gates: multithreading|concurrency|synchronization mutex;
                         
   Solution: Major Class: ParkingLot() and its functions: addParkingSpot(), park(), unpark(), getNextAvailable()
             Minor      : ParkingSpot-> Floors and Spot will be of that type. If price of spot, duration, type of parking such as for VIPS or disabled or non-disabled person. will be added to the ParkingSpot
             
    For finding the next parking spots availability near to the entrace gate, use the concept of heap, i.e min heap. If floor of two parking spots are same, then sort the parking on basis of spot, otherwise sort on the basis of floor
    
    Make sure, in interview for invalid cases throw exception

*/


import java.util.*;

class ParkingLot{
        int maxFloors;
        int maxSpots;
        PriorityQueue<ParkingSpot> minHeap = new PriorityQueue<>((a,b)->{
            if(a.getFloor()==b.getFloor()){
                return a.getSpot()-b.getSpot();
            }
            return a.getFloor()-b.getFloor();//ascending order
        });
    
        ParkingLot(int maxFloors,int maxSpots){
            this.maxFloors = maxFloors;
            this.maxSpots  = maxSpots;
        }
        
        //add parking spots
        public boolean addParkingSpot(ParkingSpot parkingSpot){
            
            if(parkingSpot.getFloor()<0 || parkingSpot.getFloor()>maxFloors) throw new IllegalArgumentException("Floor should be between 0 and maxFloors which is "+maxFloors);
            
             if(parkingSpot.getSpot()<0 || parkingSpot.getSpot()>maxSpots) throw new IllegalArgumentException("Floor should be between 0 and maxSpots which is "+maxSpots);
            
            return minHeap.add(parkingSpot);
        }
        
        //park
        //will return floor and spot id
        public ParkingSpot park(){
            if(getNextAvailableSpot()==null) return null;
            return minHeap.poll();
        }
        
        //unpark
        public boolean unpark(ParkingSpot parkingSpot){
            if(minHeap.isEmpty()) return false;
            return addParkingSpot(parkingSpot);
        }
        
        //getNextAvailableSpot()
        //will return floor and the spot id
        public ParkingSpot getNextAvailableSpot(){
            return minHeap.peek();
        }
        
    }
    
    
    class ParkingSpot{
        private int floor;
        private int spot;
        
        ParkingSpot(int floor,int spot){
            this.floor = floor;
            this.spot  = spot;
        }
        
        public void setFloor(int floor){
            this.floor = floor;
        }
        
        public int getFloor(){
            return this.floor;
        }
        
        public void setSpot(int spot){
            this.spot = spot;
        }
        
        public int getSpot(){
            return this.spot;
        } 
        
        @Override
        public String toString(){
            return  "Floor "+floor+" Spot - "+spot;
        }
    }

    class Solution113 {
        public static void main(String[] args) {
            System.out.println("Hello World!");
            //Bruteforce can be just create a 2D matrix and iterate over it for finding next available, then TC will be O(m*n)
            //Optimize: Use Priority Queue, then gettingNext available would be O(1), but parking the car and unparking it would be O(logN) 
             ParkingLot parkingLot = new ParkingLot(10,10);
             ParkingSpot spot00 = new ParkingSpot(0,0);
             ParkingSpot spot01 = new ParkingSpot(0,1);
             ParkingSpot spot02 = new ParkingSpot(0,2);
             ParkingSpot spot03 = new ParkingSpot(0,3);
             ParkingSpot spot04 = new ParkingSpot(0,4);
             ParkingSpot spot10 = new ParkingSpot(1,0);
             ParkingSpot spot11 = new ParkingSpot(1,1);
             ParkingSpot spot12 = new ParkingSpot(1,2);
             ParkingSpot spot13 = new ParkingSpot(1,3);
             ParkingSpot spot14 = new ParkingSpot(1,4);
             ParkingSpot spot20 = new ParkingSpot(2,0);
             ParkingSpot spot21 = new ParkingSpot(2,1);
             ParkingSpot spot22 = new ParkingSpot(2,2);
             ParkingSpot spot23 = new ParkingSpot(2,3);
             ParkingSpot spot24 = new ParkingSpot(2,4);
            
            
             parkingLot.addParkingSpot(spot00);
             parkingLot.addParkingSpot(spot01);
             parkingLot.addParkingSpot(spot02);
             parkingLot.addParkingSpot(spot03);
             parkingLot.addParkingSpot(spot04);
            
             parkingLot.addParkingSpot(spot20);
             parkingLot.addParkingSpot(spot21);
             parkingLot.addParkingSpot(spot22);
             parkingLot.addParkingSpot(spot23);
             parkingLot.addParkingSpot(spot24);
            
             parkingLot.addParkingSpot(spot10);
             parkingLot.addParkingSpot(spot11);
             parkingLot.addParkingSpot(spot12);
             parkingLot.addParkingSpot(spot13);
             parkingLot.addParkingSpot(spot14);
            
             ParkingSpot nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
             
            ParkingSpot parkingSpot1 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot1);
            
             nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
             ParkingSpot parkingSpot2 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot2);
            
            nextParkingSpot= parkingLot.getNextAvailableSpot();
            System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
             ParkingSpot parkingSpot3 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot3);
            
            nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
             ParkingSpot parkingSpot4 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot4);
            
             nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
             ParkingSpot parkingSpot5 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot5);
             
             nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
             ParkingSpot parkingSpot6 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot6);
             
             nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
             ParkingSpot parkingSpot7 = parkingLot.park();
             System.out.println("Parked at "+parkingSpot7);
            
             //unpark
             System.out.println("Unpark "+parkingLot.unpark(parkingSpot7));
             System.out.println("Unpark "+parkingLot.unpark(parkingSpot4));
             
             nextParkingSpot= parkingLot.getNextAvailableSpot();
             System.out.println("Next Available at Floor "+nextParkingSpot.getFloor()+" - Spot "+nextParkingSpot.getSpot());
            
            ParkingSpot parkingSpotShouldBe4 = parkingLot.park();
            
            System.out.println("Parking at should be 4 "+parkingSpotShouldBe4);
             /*ParkingLot parkingLot = new ParkingLot(10,10);
             ParkingSpot spot1 = new ParkingSpot(1,1);
             ParkingSpot spot2 = new ParkingSpot(2,1);
             ParkingSpot spot3 = new ParkingSpot(3,1);
             ParkingSpot spot4 = new ParkingSpot(1,2);
             ParkingSpot spot5 = new ParkingSpot(2,2);
             ParkingSpot spot6 = new ParkingSpot(3,2);
                
            parkingLot.addParkingSpot(spot1);
            parkingLot.addParkingSpot(spot2);
            parkingLot.addParkingSpot(spot3);
            parkingLot.addParkingSpot(spot4);
            parkingLot.addParkingSpot(spot5);
            parkingLot.addParkingSpot(spot6);
            
            ParkingSpot ps1 = parkingLot.getNextAvailableSpot();//1,1
            System.out.println("Next Available at Floor "+ps1.getFloor()+" - Spot "+ps1.getSpot());
            
            parkingLot.park();//1,1
            parkingLot.park();
            parkingLot.park();
            
            ParkingSpot ps2 = parkingLot.getNextAvailableSpot();//1,2
            System.out.println("Next Available at Floor "+ps2.getFloor()+" - Spot "+ps2.getSpot());
            
            parkingLot.unpark(ps1);
            
            ParkingSpot ps3 = parkingLot.getNextAvailableSpot();//1,1
            System.out.println("Next Available at Floor "+ps3.getFloor()+" - Spot "+ps3.getSpot());*/
            
            
        }
        
    }   