import java.util.PriorityQueue;

//Time complexity: O(LogN)N= floors* spots
//Space complexity: O(N) available spots(max floors* spots

public class ParkingStructure {

    static class ParkingSpot{
        int floor;
        int spot;
        ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }
        public int getSpot(){
            return this.spot;
        }
        public int getFloor(){
            return this.floor;
        }
    }
    static class ParkingLot{
        int maxFloors;
        int maxSpots;
        PriorityQueue<ParkingSpot> queue = new PriorityQueue<>((a,b) ->{
           if(a.floor == b.floor) return a.spot -b.spot;
           return a.floor - b.floor;
        });

        ParkingLot(int maxFloors, int maxSpots){
            this.maxFloors = maxFloors;
            this.maxSpots = maxSpots;
        }

        public ParkingSpot park(){
            return queue.poll();
        }
        public void unPark(int floor, int spot){
            ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
            queue.offer(parkingSpot);
        }
        public ParkingSpot getNextAvailable(){
            return queue.peek();
        }

        public void addParkingSpot(int floor, int spot){
            if(floor > maxFloors ){
                throw new IllegalStateException("Floor is greater than maxFloors");
            }
            if(spot > maxSpots){
                throw new IllegalStateException("Spot is greater than maxSpots");
            }
            ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
            queue.offer(parkingSpot);
        }
    }

    public static void main(String args[]){
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(1, 3);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);

        ParkingSpot n = pl.getNextAvailable(); //1,2
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        pl.park();
        ParkingSpot n2 = pl.getNextAvailable(); //1,2
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.park();
        pl.unPark(1, 1);
        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("After unparking availability Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());


    }
}
