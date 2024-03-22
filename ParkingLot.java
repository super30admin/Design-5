// TC : park - O(log n*m)  // unPark - O(log n*m) // getNextSpot - O(1)
// SC : O(n*m)

package S30_Codes.Design_5;
import java.util.PriorityQueue;

class Main {
    static class ParkingSpot{
        int floor;
        int spot;
        public ParkingSpot(int floor, int spot){
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
        int spotsPerFloor;

        public ParkingLot(int maxFloors, int spotsPerFloor){
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }

        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b)->{
            if(a.floor == b.floor)
                return a.spot - b.spot;
            return a.floor - b.floor;
        });

        public ParkingSpot park(){
            if(pq.isEmpty())
                throw new IllegalStateException("Parking lot is full");
            return pq.remove();
        }

        public void unPark(int floor, int spot){
            pq.add(new ParkingSpot(floor, spot));
        }

        public ParkingSpot getNextAvailableSpot(){
            return pq.peek();
        }

        public void addParkingSpot(int floor, int spot){
            if(floor > maxFloors)
                throw new IllegalStateException("Floor input greater then max allowed");
            if(spot > spotsPerFloor)
                throw new IllegalStateException("Spot input greater then max allowed");

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
        ParkingSpot n1 = pl.getNextAvailableSpot(); //1,1
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
        pl.park();
        ParkingSpot n2 = pl.getNextAvailableSpot(); //1,2
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.park();
        ParkingSpot n3 = pl.getNextAvailableSpot(); //2,1
        System.out.println("Parked at Floor: " + n3.getFloor() + ", Slot: " + n3.getSpot());
        pl.unPark(1,1);
        ParkingSpot n4 = pl.getNextAvailableSpot(); //1,1
        System.out.println("Parked at Floor: " + n4.getFloor() + ", Slot: " + n4.getSpot());
    }
}
