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
    ParkingLot(int maxFloors, int spotsPerFloor){
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
        this.q = new PriorityQueue<ParkingSpot>((a,b)->{
            if(a.floor == b.floor)
                return a.spot - b.spot;
            else return a.floor - b.floor;
        });
    }
    void addParkingSpot(int floor, int spot){
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        q.add(newSpot);
    }
    ParkingSpot getNextAvailable(){
        return q.peek();
    }
    void park(){
        if(getNextAvailable()!=null) q.poll();
        else System.out.println("Error");
    }
     void unpark(ParkingSpot p){
        q.add(p);
    }
}
public class Main {
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