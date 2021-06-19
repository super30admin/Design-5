import java.util.*;

//Each floor will have different spots
//New car should be placed in lowest available and lowest available slot.
//For example: if the floor 1 and floor9 slots are available.
//Then it should park in the first floor not the 9th one.
//https://leetcode.com/playground/cxvCgX8r

public class ParkingSystem {

    int floors;
    int spots;
    
  PriorityQueue<ParkingSlot> pq = new PriorityQueue<ParkingSlot>((a,b)-> {
        return a.floor - b.floor;
  });
    
    public ParkingSystem(int floors, int spots) {
        this.floors = floors;
        this.spots = spots;
        for(int i=0;i<floors;i++) {
            for(int j=0;j<spots;j++) {
                pq.add(new ParkingSlot(i,j));
            }
        }
    }
    
    public boolean park() {
        if(getAvailableSport() == null) return false;
        pq.poll();
        return true;
    }
    
    public void unpark(int floor, int spot) {
        pq.add(new ParkingSlot(floor, spot));
    }
    
    public ParkingSlot getAvailableSport() {
        if(pq.size() == 0) return null;
        return pq.peek();
    }
    
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(10,10);
        printSlot(parkingSystem.getAvailableSport());
        parkingSystem.park();
        printSlot(parkingSystem.getAvailableSport());
        parkingSystem.park();
        printSlot(parkingSystem.getAvailableSport());
        parkingSystem.unpark(9,9);
        printSlot(parkingSystem.getAvailableSport());
    }
    
    private static void printSlot(ParkingSlot slot) {
        System.out.println("The floor: "+slot.getFloor() + " The spot: "+slot.getSpot());
    }
    
    
     public class ParkingSlot {
        int spot;
        int floor;
        public ParkingSlot(int spot, int floor) {
            this.spot = spot;
            this.floor = floor;
        }
         
         public int getSpot(){ return this.spot;}
         public int getFloor(){ return this.floor;}
    }
}