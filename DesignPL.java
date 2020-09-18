//Time Complexity : written with functions
//Space Complexity : O(n) number of max spots in pq
import java.util.PriorityQueue;

class ParkingLot{
    int totalFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) ->{
        if(a.floor == b.floor)return a.spot-b.spot;
        else return a.floor-b.floor;
    });
    public ParkingLot(int totalFloors,int spotsPerFloor){
        this.totalFloors = totalFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public void park(){// O(1)
        //check pq empty case = no parking spot avaible
        if(pq.isEmpty()){
            throw new IllegalStateException("No free parking spot available");
        }
        System.out.println("Parking in the next available spot");
        pq.poll();
    }
    public void unpark(int floor, int spot){ //O(log n) to put this spot in right position in pq
        System.out.println("Vacating the spot "+floor+" "+spot);
        addParkingSpot(floor, spot);
    }
    public ParkingSpot getNextAvailable(){//O(1)
        return pq.peek();
    }
    public void addParkingSpot(int floor, int spot){// O(nlogn) to add every spot to pq
        if(floor > totalFloors){
            throw new IllegalStateException("Floor out of range");
        }
        if(spot > spotsPerFloor){
            throw new IllegalStateException("Spot out of range");
        }
        ParkingSpot ps = new ParkingSpot(floor, spot);
        pq.add(ps);
    }
}
class ParkingSpot{
    int floor;
    int spot;
    public ParkingSpot(int floor,int spot){
        this.floor=floor;
        this.spot = spot;
    }
}
class DesignPL{ 
    public static void main(String args[]){
        ParkingLot p1 = new ParkingLot(10,20);
        p1.addParkingSpot(1, 3);
        p1.addParkingSpot(1, 1);
        p1.addParkingSpot(2, 1);
        p1.addParkingSpot(2, 2);
        p1.addParkingSpot(1, 9);
        p1.addParkingSpot(3, 3);

        System.out.println("Next available:" + p1.getNextAvailable().floor +" "+ p1.getNextAvailable().spot);
        p1.park();
        p1.park();
        p1.park();
        System.out.println("Next available:" + p1.getNextAvailable().floor +" "+ p1.getNextAvailable().spot);
        p1.unpark(1, 3);
        System.out.println("Next available:" + p1.getNextAvailable().floor +" "+ p1.getNextAvailable().spot);


        
    }
}