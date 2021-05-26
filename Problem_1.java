// "static void main" must be defined in a public class.
public class Main {
    
    static class ParkingLot{
        int maxFloors, maxSpots;
        PriorityQueue<ParkingSpace> pq = new PriorityQueue<>((a,b)-> {
            if(a.floor==b.floor){
                return a.spot-b.spot;
            }
            return a.floor-b.floor;
        });
        public ParkingLot(int maxFloors, int maxSpots){
            this.maxFloors=maxFloors;
            this.maxSpots=maxSpots;
        }
        public ParkingSpace park(){
            nextAvailableSpot();
            return pq.poll();
        }
        public void unpark(int floor, int spot){
            ParkingSpace p = new ParkingSpace(floor,spot);
            pq.add(p);
        }
        public void addParkingSpot(int floor, int spot){
            if(floor>maxFloors){
                throw new IllegalStateException("Invalid Floor");
            }
            if(spot>maxSpots){
                throw new IllegalStateException("Invalid spot");
            }
            ParkingSpace p = new ParkingSpace(floor,spot);
            pq.add(p);
        }
        public ParkingSpace nextAvailableSpot(){
            if(pq.isEmpty()){
                throw new IllegalStateException("Parking is full");
            }
            return pq.peek();
        }
    }
    static class ParkingSpace{
        int floor, spot;
        public ParkingSpace(int floor, int spot){
            this.floor=floor;
            this.spot=spot;
        }
        public int getFloor(){
            return this.floor;
        }
        public int getSpot(){
            return this.spot;
        }
        
    }
    
    public static void main(String[] args) {
        ParkingLot plot= new ParkingLot(50,50);
        plot.addParkingSpot(0,0);
        plot.addParkingSpot(0,1);
        plot.addParkingSpot(0,2);
        plot.addParkingSpot(1,0);
        plot.addParkingSpot(1,2);
        ParkingSpace p=plot.nextAvailableSpot();
        System.out.println(p.getFloor()+" "+p.getSpot());
        p=plot.park();
        ParkingSpace s=plot.nextAvailableSpot();
        System.out.println(s.getFloor()+" "+s.getSpot());
    }
}