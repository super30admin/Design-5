import java.util.PriorityQueue;

// Design a parking lot system where you need to provide a token with the parking space number
// on it to each new entry for the space closest to the entrance. When someone leaves you need to update this space as empty.
// What data structures will you use to perform the closest empty space tracking,
// plus finding what all spaces are occupied at a give time.

public class DesignParkingLot {

    static class ParkingSpot{
        int floor;
        int spot;
        public ParkingSpot(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }
    }

    static class ParkingLot{
        int maxFloor;
        int SpotPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>(
            (a,b) -> {
                if (a.floor == b.floor) return a.spot - b.spot;
                return a.floor - b.floor;
            }
        );

        public ParkingLot(int maxFloor, int spoyPerFloor){
            this.maxFloor = maxFloor;
            this.SpotPerFloor = spoyPerFloor;
        }

        public ParkingSpot park(){

            if (pq.isEmpty()){
                throw new IllegalStateException("Parking lot is full");
            }
            ParkingSpot ps = pq.remove();
            return ps;
        }

        public ParkingSpot getNextAvailable(){
            return pq.peek();
        }

        public void unpark(int floor, int slot){
            ParkingSpot newSpot = new ParkingSpot(floor, slot);
            pq.add(newSpot);
        }

        public void addParkingSpot(int floor, int spot){
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }
    
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 3);
        ParkingSpot n = pl.getNextAvailable();
        System.out.println(n.floor + " " + n.spot);
        pl.park();

        n = pl.getNextAvailable();
        System.out.println(n.floor + " " + n.spot);

        pl.unpark(1,1);

        n = pl.getNextAvailable();
        System.out.println(n.floor + " " + n.spot);

    }
}
