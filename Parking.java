// "static void main" must be defined in a public class.
// SC O(M*N) - Total number of elements in priority queue. TC O(log(m*n)) where m*n is the total elements in Priority queue
public class Main {
    
    private static class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq;
        public ParkingLot(int maxFloors, int spotsPerFloor){
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
            pq = new PriorityQueue<>((a,b) -> {
                if (a.floor == b.floor){
                    return a.spot - b.spot;
                }
                return a.floor - b.floor;
            });
        }
        
        public ParkingSpot park(){
            if (pq.isEmpty()){
                throw new IllegalArgumentException("lot full");
            }
            return pq.remove();
        }
                      
        public ParkingSpot getNextAvailable(){
            return pq.peek();
        }
                      
        public void unpark(int spot, int floor){
           ParkingSpot ps = new ParkingSpot(spot, floor);
            pq.add(ps);
        }
                      
        public void addParking(int spot, int floor) {
            if (spot > spotsPerFloor) {
                throw new IllegalArgumentException(" spot exceeded limit");
            }
            if (floor > maxFloors) {
                throw new IllegalArgumentException(" floor exceeded limit");
            }
            ParkingSpot ps = new ParkingSpot(spot, floor);
            pq.add(ps);
        }
                    
    }
    
    private static class ParkingSpot {
        int spot;
        int floor;
        public ParkingSpot(int spot, int floor)
        {
            this.spot = spot;
            this.floor = floor;
        }
        public int getSpot()
        {
            return spot;
        }
        public int getFloor() {
            return floor;
        }
    }
  
    public static void main(String[] args) {
        
	    ParkingLot pl = new ParkingLot(10, 20);
		pl.addParking(1, 1);
 		pl.addParking(2, 1);
 		pl.addParking(3, 1);
 		pl.addParking(1, 2);
 		pl.addParking(2, 2);
 		pl.addParking(3, 2);
		ParkingSpot n = pl.getNextAvailable();
 		System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
 		pl.park();
 		ParkingSpot n2 = pl.getNextAvailable();
 		System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
 		pl.unpark(1, 1);
 		ParkingSpot n1 = pl.getNextAvailable();
 		System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    }
}
