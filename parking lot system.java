// This problem was asked at Intuit

// Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. When someone leave you need update this space as empty. What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
import java.io.*;
class Main{
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
        
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {//using heap to get nearest //spot,
            if(a.floor == b.floor) return a.spot - b.spot;//if floor is equal return nearest spot
            return a.floor - b.floor;//otherwise return nearest floor first.
        });
       public ParkingLot(int maxFloors, int spotsPerFloors){
           this.maxFloors = maxFloors;
           this.spotsPerFloor = spotsPerFloors;
       } 
       
        public ParkingSpot park(){
            if(pq.isEmpty()){
                throw new IllegalStateException("Parking Lot is Full");
            }
            ParkingSpot result = pq.remove();//log(mn)
            return result;
        }
         public void unpark(int floor, int spot){
           
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);//log(mn)
        }
        
         public ParkingSpot getNextAvailable(){
            return pq.peek();
        }
        
        public void addParkingSpot(int floor, int spot){
            if(floor > maxFloors){
                throw new IllegalStateException("floor input greater than max allowed");
            }
            if(spot > spotsPerFloor){
                throw new IllegalStateException("spot input greater than spot per floor allowed");
            }
           ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
        
        
    }
    public static void main(String[] args){
    ParkingLot pl = new ParkingLot(3,2);//creating parkinglot object 3 floors and 2 spot per floor
    pl.addParkingSpot(1,1);
    pl.addParkingSpot(1,2);
    pl.addParkingSpot(2,1);
    pl.addParkingSpot(2,2);
    pl.addParkingSpot(3,1);
    pl.addParkingSpot(3,2);
    
    ParkingSpot n = pl.getNextAvailable();
    System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
    pl.park();
    ParkingSpot n1 = pl.getNextAvailable();
    System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    pl.park();
    ParkingSpot n2 = pl.getNextAvailable();
    System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
    pl.park();
    pl.unpark(1,2);
    ParkingSpot n3 = pl.getNextAvailable();
    System.out.println("Parked at Floor: " + n3.getFloor() + ", Slot: " + n3.getSpot());
    
}
}
