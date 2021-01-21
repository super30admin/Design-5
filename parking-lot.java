public class Main {
    public static class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        // Space - O(floors*spotsPerFloor)
        PriorityQueue<ParkingSpot> pq;
        
        public ParkingLot(int floors, int spots) {
            this.maxFloors = floors;
            this.spotsPerFloor = spots;
            pq = new PriorityQueue<>((a,b) -> {
                if(a.floor == b.floor) {
                    return a.spot - b.spot;
                }
                return a.floor - b.floor;
            });
        }
        // Time - O(1)
        public ParkingSpot park() {
            if(pq.isEmpty()) {
                throw new IllegalArgumentException("Parking lot full");
            }
            return pq.poll();
        }
         
        
        // Time - O(MN lg MN), M - floors, N - spots
        public void unPark(int floor, int spot) {
            addParkingSpace(floor, spot);
        }
        // Time - O(MN lg MN), M - floors, N - spots
        public void addParkingSpace(int floor, int spot) {
            if(floor > maxFloors) {                
                throw new IllegalArgumentException("Parking lot full");
            }
            if(spot > spotsPerFloor) {
                
                throw new IllegalArgumentException("Parking lot full");
            }
            ParkingSpot spots = new ParkingSpot(floor, spot);
            pq.add(spots);
        }
        // Time - O(1)
        public ParkingSpot getNextAvailableParkingSPot() {
            return pq.peek();
        }
    }
    public static class ParkingSpot {
        int floor, spot;
        
        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }
        
        public int getFloor() {
            return this.floor;
        }
        
        public int getSpot() {
            return this.spot;
        }
    }
    
    public static void main(String[] args) {
        ParkingLot p1 = new ParkingLot(10,5);
        p1.addParkingSpace(3,4);
        p1.addParkingSpace(1,4);
        p1.addParkingSpace(0,1);
        p1.addParkingSpace(2,4);
        p1.addParkingSpace(0,0);
        ParkingSpot spot = p1.park();
        System.out.println("Floor "+ spot.getFloor());
        
        
    }
}
