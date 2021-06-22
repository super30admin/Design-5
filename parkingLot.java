/*package whatever //do not write package name here */
//Time complexity O(n)
//Space complexity O(n)
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class ParkingLots {
    
        int maxFloors;
        int maxSpots;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b)-> 
        {if(a.floor == b.floor) 
            return a.spot - b.spot;
            else
                return (a.floor - b.floor);
            });
        
        public ParkingLots(int maxFloors,int maxSpots){
            
            this.maxFloors = maxFloors;
            this.maxSpots = maxSpots;
            
            
        }
        
   
        
    
    public ParkingSpot park(){
        if(pq.size() == 0){
            
            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot top = pq.poll();
        return top;
    }
    
     public ParkingSpot getNextAvailable(){
        
       return pq.peek();
    }
    
    public void unPark(int floor, int spot){
        
        addParkingSpot(floor,spot);
    }
   
    public void addParkingSpot(int floor, int spot){
        
        if(floor > maxFloors){
            
            throw new IllegalStateException("give input is greater than number of max floors");
        }
        
        if(spot > maxSpots){
            
            throw new IllegalStateException("give input is greater than number of max spots");
        }
        
        ParkingSpot newSpot = new ParkingSpot(floor,spot);
        pq.add(newSpot);
        
        
        
    }
}
    
    class ParkingSpot{
        
        int floor;
        int spot;
        
        public ParkingSpot(int floor, int spot){
            
            this.floor= floor;
            this.spot = spot;
        }
    }
    
    class GFG{
    public static void main(String[] args) {
        System.out.println("Hello World!");
     
     ParkingLots pl = new ParkingLots(10,20);
     
     pl.addParkingSpot(1,1);
     pl.addParkingSpot(2,1);
     pl.addParkingSpot(3,1);
     pl.addParkingSpot(1,2);
     pl.addParkingSpot(2,2);
     pl.addParkingSpot(3,2);
     
     ParkingSpot n = pl.getNextAvailable();
     
     System.out.println("Parked at floor" + n.floor + "slot:" + n.spot);
     
     pl.park();
      ParkingSpot n1 = pl.getNextAvailable();
      System.out.println("Parked at floor" + n1.floor + "slot:" + n1.spot);
      
      pl.unPark(1,1);
      ParkingSpot n2 = pl.getNextAvailable();
      System.out.println("Parked at floor" + n2.floor + "slot:" + n2.spot);
     
    }

}