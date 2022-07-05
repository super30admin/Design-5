// Time Complexity :O(nlogn) - all operations n= parking spots
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// "static void main" must be defined in a public class.
public class Main {
    
    public static class ParkingSpot{
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
    
    public static class ParkingLot{
        int numOfFloors;
        int numOfSpotsPerFloor;
        
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>(
        (a,b)->{
            if(a.floor == b.floor){
                return a.spot - b.spot;
            }
            return a.floor - b.floor;
        });
        
        public ParkingLot(int numOfFloors, int numOfSpotsPerFloor){
            this.numOfFloors = numOfFloors;
            this.numOfSpotsPerFloor = numOfSpotsPerFloor;
        }
        
        public ParkingSpot park(){
            if(pq.isEmpty()){
                throw new IllegalArgumentException("Parking Lot is FULL");
            }
            
            ParkingSpot ps = pq.remove();
            return ps;
        }
        
        public ParkingSpot getNextAvailable(){
            return pq.peek();
        }
        
        public void unpark(int floor, int spot){
            ParkingSpot ps = new ParkingSpot(floor, spot);
            pq.add(ps);
        }
        
        public void addParkingSpot(int floor, int spot){
            if(floor>numOfFloors){
                 throw new IllegalArgumentException("Floor is greater than maximum floors");
            }
            
            if(spot>numOfSpotsPerFloor){
                 throw new IllegalArgumentException("Spot is greater than maximum spots");
            }
            
            ParkingSpot ps = new ParkingSpot(floor, spot);
            pq.add(ps);
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
        ParkingSpot n = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        pl.park();
        ParkingSpot n2 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unpark(1, 1);
        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    }
    
    
}