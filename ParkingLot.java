// top level design first
// using minHeap

import java.util.PriorityQueue;

class ParkingSpot {
    int floor;
    int spot;
    ParkingSpot(int floor, int spot){
        this.floor = floor;
        this.spot = spot;
    }
}
class ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> q;
    ParkingLot(int maxFloors, int spotsPerFloor){ //O(log(mn)) heapify
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
        this.q = new PriorityQueue<ParkingSpot>((a,b)->{
            if(a.floor == b.floor)
                return a.spot - b.spot;
            else return a.floor - b.floor;
        });
    }
    void addParkingSpot(int floor, int spot){ //O(1)
        if(floor > maxFloors){
            throw new IllegalStateException("grater value is entered");
        }
        if(spot > spotsPerFloor){
            throw new IllegalStateException("full spots");
        }
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        q.add(newSpot);
    }
    ParkingSpot getNextAvailable(){ //O(1)
        return q.peek();
    }
    void park(){ //O(1)
        if(getNextAvailable()!=null) q.poll();
        else System.out.println("Error");
    }
     void unpark(ParkingSpot p){ //O(1)
        q.add(p);
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10,10);
        lot.addParkingSpot(1,1);
        lot.addParkingSpot(2,1);
        lot.addParkingSpot(2,2);
        System.out.println(lot.getNextAvailable().floor+","+lot.getNextAvailable().spot);
        lot.park();
        System.out.println(lot.getNextAvailable().floor+","+lot.getNextAvailable().spot);
        lot.park();
    }
}