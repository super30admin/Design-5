
/*
Approach: 

To design such system we need to know what basic information we want to store and retrieve.

1) No of floors and no of spots on each floor
2) Is parking lot full or not
3) Nearest parking space. Floorwise and spot wise
4) Update the space when a vehicle is parked/unparked

To acheive all of the above we can use a priority queue. It will always return the most nearest parking space available both floorwise and spotwise.


TC: O(log(mn))
SC: O(mn)

where m = no. of floors
n = no of spots in each floor
*/
public class Main {
    
    // A class to hold the main functions and information of the parking lot 
    public static class ParkingLot{
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq;
        
        public ParkingLot(int floors, int spots){
            this.maxFloors = floors;
            this.spotsPerFloor = spots;
            
            // Make a custom comparator which compares two spots if floors are same else compares               two floors
            pq = new PriorityQueue<>((a,b) -> {
               if(a.floor == b.floor){
                   return a.spot - b.spot;
               } 
                return a.floor - b.floor;
                
            });
        }
        
        // TC: O(log(mn))
        // It removes the parking spot from available parking lots maintained in the priority queue
        public ParkingSpot park(){
             if (pq.isEmpty()){
                 throw new IllegalArgumentException("Parking Lot Full!");
             }
            return pq.poll();
        }
        
        // It adds the parking spot to available parking spots maintained in the priority queue
        public void unPark(int floor, int spot){
            addParkingSpace(floor,spot);
        }
        
        // TC: O(log(mn))
        // It adds parking spot into the available parking spots maintained in the priority queue 
        public void addParkingSpace(int floor, int spot){
            if (floor > maxFloors){
                throw new IllegalArgumentException("Invalid Floor number!");
            }
            
            if (spot > spotsPerFloor){
                throw new IllegalArgumentException("Invalid Spot number!");
            }
            
            ParkingSpot spots = new ParkingSpot(floor,spot);
            pq.add(spots);
        }
        
        public ParkingSpot getNextAvailableParkingSpot(){
            return pq.peek();
        }
    }
    
    // A class to hold the main functions and information of a parking spot 
    public static class ParkingSpot{
        int floor, spot;
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
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10,5);
        pl.addParkingSpace(3,4);
        pl.addParkingSpace(1,4);
        pl.addParkingSpace(0,1);
        pl.addParkingSpace(2,4);
        pl.addParkingSpace(0,0);
        
        ParkingSpot spot = pl.park();
        System.out.println("Floor: " + spot.getFloor() + " Spot: " + spot.getSpot()); 
        
        spot = pl.park();
        System.out.println("Floor: " + spot.getFloor() + " Spot: " + spot.getSpot()); 
        
        spot = pl.park();
        System.out.println("Floor: " + spot.getFloor() + " Spot: " + spot.getSpot()); 
        
        pl.unPark(0,1);
        pl.unPark(0,0);
        
        spot = pl.park();
        System.out.println("Floor: " + spot.getFloor() + " Spot: " + spot.getSpot()); 
        
        spot = pl.getNextAvailableParkingSpot();
        System.out.println("Floor: " + spot.getFloor() + " Spot: " + spot.getSpot()); 
    }
}