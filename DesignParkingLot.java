import java.util.PriorityQueue;

public class DesignParkingLot {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(3, 2);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);

        ParkingSpot n = pl.getNextAvailable(); //1,1
        System.out.println("Parking at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        pl.park();

        ParkingSpot n2 = pl.getNextAvailable(); //1,2
        System.out.println("Parking at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.park();

    }

    static class ParkingSpot {
        int floor, spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        public int getSpot() {
            return this.spot; //col index of spot in parking
        }

        public int getFloor() {
            return this.floor;
        }
    }

    static class ParkingLot {
        int maxFloors; //size
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
            if (a.floor == b.floor) return a.spot - b.spot;
            return a.floor - b.floor;
        });

        public ParkingLot(int maxFloors, int spotsPerFloor) {
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park() {
            if (pq.isEmpty()) {
                throw new IllegalStateException("Parking lot is full");
            }
            ParkingSpot res = pq.remove(); //log(mn)
            return res;
        }

        public void unPark(int floor, int spot) {
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }

        public ParkingSpot getNextAvailable() {
            return pq.peek();
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor > maxFloors) {
                throw new IllegalStateException("floor input greater than max allowed");
            }
            if (spot > spotsPerFloor) {
                throw new IllegalStateException("spot input greater than max allowed");
            }

            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }


    }
}

