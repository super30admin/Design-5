// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) throws Exception{
        ParkingLot pl = new ParkingLot(10,10);
        pl.addParkingSpot(1,1);
        pl.addParkingSpot(1,2);
        pl.addParkingSpot(1,5);
        pl.addParkingSpot(2,1);
        ParkingSpot ps = pl.getNextAvailable();
        System.out.println("Floor:"+ps.floor + " Spot: "+ps.spot);
        
        pl.park();
        ps = pl.getNextAvailable();
        System.out.println("Floor:"+ps.floor + " Spot: "+ps.spot);
        pl.park();
        ps = pl.getNextAvailable();
        System.out.println("Floor:"+ps.floor + " Spot: "+ps.spot);
        pl.unpark(1,1);
        ps = pl.getNextAvailable();
        System.out.println("Floor:"+ps.floor + " Spot: "+ps.spot);
    }
}

class ParkingLot{
    int maxFloors; int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue((a,b)->{
        if(((ParkingSpot)a).floor == ((ParkingSpot)b).floor) return ((ParkingSpot)a).spot-((ParkingSpot)b).spot;
        return ((ParkingSpot)a).floor-((ParkingSpot)b).floor;
    });
    public ParkingLot(int floors, int spots){
        this.maxFloors = floors;
        this.spotsPerFloor = spots;
    }
    
    public void addParkingSpot(int floor, int spot) throws IllegalStateException{
        if(floor > maxFloors || spot > spotsPerFloor){
            throw new IllegalStateException("floor or spot capacity is out of range!");
        }
        ParkingSpot ps = new ParkingSpot(floor, spot);
        pq.add(ps);
    }
    
    public ParkingSpot getNextAvailable() throws Exception{
        if(pq.isEmpty()) throw new Exception("Parking lot full");
        return pq.peek();
        
    }
    
    public void park(){
        pq.poll();
    }
    
    public void unpark(int floor, int spot){
        addParkingSpot(floor, spot);
    }
}

class ParkingSpot{
    int floor; int spot;
    public ParkingSpot(int floor, int spot){
        this.floor = floor;
        this.spot = spot;
    }
}
