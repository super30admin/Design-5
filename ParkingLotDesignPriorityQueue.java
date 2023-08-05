import java.util.PriorityQueue;

// for multiple entry - concurrency issue
// for different kinds of vehicles - maintain separate priority queues

public class ParkingLotDesignPriorityQueue {

    // parking spot class for  parking spot object used in parking lot class
    public static class ParkingSpot {

        int floor;
        int spot;

        // parking spot constructor
        public ParkingSpot(int f, int s) {

            floor = f;
            spot = s;
        }

        public int getSpot() {

            return this.spot;
        }

        public int getFloor() {

            return this.floor;
        }
    }

    // parking lot class
    public static class ParkingLot {

        int maxFloors;        int spotsPerFloor;

        // priority queue to maintain available empty parking spots
        PriorityQueue<ParkingSpot> pqEmptySpace = new PriorityQueue<>((a,b) -> {

            // if same floor
            if(a.floor == b.floor) return a.spot - b.spot;

            // if different floors
            return a.floor - b.floor;
        });

        // parking lot constructor
        public ParkingLot(int mf, int spf) {

            maxFloors = mf;
            spotsPerFloor = spf;

        }

        // park method deletes an empty space from priority queue
        public void park() {

            if(pqEmptySpace.size() == 0) {

                throw new IllegalStateException("Parking lot is full");
            }

            pqEmptySpace.poll();
        }

        // get details of next available spot
        public ParkingSpot getNextAvailable() {

            return pqEmptySpace.peek();
        }

        // un park method adds that spot again to priority queue of available spots
        public void unPark(int f, int s) {

            ParkingSpot emptyAgain = new ParkingSpot(f, s);

            pqEmptySpace.add(emptyAgain);
        }

        // inserts empty parking spaces in parking lot
        public void addParkSpot(int f, int s) {

            if(f > maxFloors) {

                throw new IllegalStateException("Floor exceeds limit");
            }

            if(s > spotsPerFloor) {

                throw new IllegalStateException("Spot exceeds limit");
            }

            ParkingSpot newSpot = new ParkingSpot(f, s);

            pqEmptySpace.add(newSpot);
        }

    }

    public static void main(String[] args) {

        ParkingLot obj = new ParkingLot(10, 20);

        obj.addParkSpot(1,1);
        obj.addParkSpot(2,1);
        obj.addParkSpot(3,1);
        obj.addParkSpot(1,2);
        obj.addParkSpot(2,2);
        obj.addParkSpot(3,2);

        ParkingSpot n = obj.getNextAvailable();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Spot: " + n.getSpot());

        obj.park();

        ParkingSpot m = obj.getNextAvailable();
        System.out.println("Parked at Floor: " + m.getFloor() + ", Spot: " + m.getSpot());

        obj.unPark(1, 1);

        ParkingSpot l = obj.getNextAvailable();
        System.out.println("Parked at Floor: " + l.getFloor() + ", Spot: " + l.getSpot());

    }

}

