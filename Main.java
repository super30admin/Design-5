// "static void main" must be defined in a public class.
// Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. When someone leave you need update this space as empty. What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
import java.util.*;

class ParkingLot{
    int total;
    ArrayList<List<Integer>> spotDistance;
    HashMap<Integer, Integer> occupied;
    PriorityQueue<List<Integer>> pq;
    public ParkingLot(ArrayList<List<Integer>> dist){
        
        spotDistance = new ArrayList<>(dist);
        System.out.println(spotDistance);
        occupied = new HashMap<>();
        total = spotDistance.size();
        pq = new PriorityQueue<>((a,b)->a.get(1)-b.get(1));
        
        for(List<Integer> ls: spotDistance){
            pq.add(ls);
        }
        
    }
    
    //Add car nearest to the gate
    public void addCar(){
        int parkNumber=0;
        if(!pq.isEmpty()){
            parkNumber = pq.peek().get(0);
            occupied.put(parkNumber,pq.poll().get(1));
            
        }
        
        System.out.println("parkingNumber is: "+parkNumber);
        System.out.println(occupied);
        
    }
    
    //remove car from parking lot
    public void removeCar(int parkingNumber){
        if(!mp.isEmpty()){
            
        }//if
    }//method
}//class

public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot Design");
        ArrayList<List<Integer>> dist = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        ls.add(100);
        ls.add(10);
        dist.add(new ArrayList<>(ls));
        ls.clear();
        ls.add(120);
        ls.add(16);
        dist.add(new ArrayList<>(ls));
        ls.clear();
        ls.add(180);
        ls.add(5);
        dist.add(new ArrayList<>(ls));
        ParkingLot pobj = new ParkingLot(dist);
        pobj.addCar();
        pobj.addCar();
        pobj.addCar();
    }
}