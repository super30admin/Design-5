// "static void main" must be defined in a public class.
public class Main {
    public static class ParkingLot{
        int maxFloors;
        int maxSpots;
        PriorityQueue<ParkingSpot> pq ;
        
        public  ParkingLot(int maxFloors, int maxSpots){
            this.maxFloors=maxFloors;
            this.maxSpots = maxSpots;
            this.pq = new PriorityQueue<>((a,b)-> {
                    if(a.floor==b.floor)
                        return a.spot-b.spot;
                    else
                        return a.floor-b.floor;});
            
        }
        
        public void addNewParkingSpot(int floor, int spot){
            if(floor> this.maxFloors || spot> this.maxSpots)
                throw new IllegalArgumentException("Invalid Parking Spot details");
            
            pq.add(new ParkingSpot(floor,spot));
        }
        
        public ParkingSpot park(){
            if(pq.isEmpty())
                throw new IllegalArgumentException("No Parking Space available");
            
            return pq.poll();
                
        }
        
        public void unpark(ParkingSpot spot){
            addNewParkingSpot(spot.floor,spot.spot);
        }
        
        public ParkingSpot getNextAvailableParkingSpot(){
            if(pq.isEmpty())
                throw new IllegalArgumentException("No Parking Space available");
            return pq.peek();
        }
    }
    public static class ParkingSpot{
        int floor;
        int spot;
        public ParkingSpot(int floor, int spot){
            this.floor=floor;
            this.spot=spot;
        }
    }
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(5,5);
        pl.addNewParkingSpot(0,1);//O(log n)
        pl.addNewParkingSpot(0,5);//O(log n)
        pl.addNewParkingSpot(1,1);//O(log n)
        pl.addNewParkingSpot(5,1);//O(log n)
        //pl.addNewParkingSpot(6,1);
        ParkingSpot spot = pl.park();//O(1)
        System.out.println(spot.floor+"  "+spot.spot);
        pl.park();//O(1)
        pl.park();//O(1)
        //pl.park();
        spot = pl.getNextAvailableParkingSpot();        //O(1)
        System.out.println("Next available Parking Space:"+spot.floor+"  "+spot.spot);
        //pl.park();
        pl.getNextAvailableParkingSpot(); //O(1)
        pl.unpark(new ParkingSpot(1,1));  //O(log n)
        spot = pl.getNextAvailableParkingSpot();  //O(1)      
        System.out.println("Next available Parking Space:"+spot.floor+"  "+spot.spot);
        
    }
}