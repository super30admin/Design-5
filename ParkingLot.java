import java.util.PriorityQueue;

public  class ParkingLot {
    int maxfloors, spotsperfloor;
   
    public ParkingLot(int maxfloors,int spotsperfloor){
        this.maxfloors=maxfloors;
        this.spotsperfloor=spotsperfloor;
    }
    PriorityQueue<ParkingSpot>pq=new PriorityQueue<>((a,b)->{
        if(a.floor==b.floor){return a.spot-b.spot;}
        return a.floor-b.floor;

    });
    public void addParkingSpot(int floor ,int spot){
        if(floor>maxfloors){
            throw new IllegalArgumentException("Invalid floor");
        }
        if(spot>spotsperfloor){
            throw new IllegalArgumentException("Invalid spot");
        }
        pq.add(new ParkingSpot(floor,spot));
    }
    public ParkingSpot getNextAvailable(){
        return pq.peek();
    }
    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalArgumentException("No parking available");
        }
        return pq.poll();
    }
    public void unpark(int floor, int spot){
        pq.add(new ParkingSpot(floor,spot));
    }
    class ParkingSpot{
        int floor, spot;
        public ParkingSpot(int floor, int spot){
            this.floor=floor;
            this.spot=spot;
        }
         int getFloor(){
            return this.floor;

        }
        int getSpot(){
            return this.spot;
        }
    }
    public static void main(String args[]){
        ParkingLot obj=new ParkingLot(10, 10);
        obj.addParkingSpot(0,1);
        obj.addParkingSpot(0,5);
        obj.addParkingSpot(5,7);
        obj.addParkingSpot(2,5);
        obj.addParkingSpot(4,1);
        obj.addParkingSpot(9,1);
        obj.addParkingSpot(1,1);
        ParkingSpot spot=obj.park();
        System.out.println("parked at floor: "+spot.getFloor()+"spot: "+spot.getSpot());
         spot=obj.park();
        System.out.println("parked at floor: "+spot.getFloor()+"spot: "+spot.getSpot());
         spot=obj.park();
        System.out.println("parked at floor: "+spot.getFloor()+"spot: "+spot.getSpot());
         spot=obj.park();
        System.out.println("parked at floor: "+spot.getFloor()+"spot: "+spot.getSpot());
         spot=obj.park();
        System.out.println("parked at floor: "+spot.getFloor()+"spot: "+spot.getSpot());
        obj.unpark(0, 5);
        spot=obj.park();
        System.out.println("parked at floor: "+spot.getFloor()+"spot: "+spot.getSpot());
    }
}
