// "static void main" must be defined in a public class.

/*
 * getnext available tc: O(1)
 * park : O(n log n) for n cars - for 1 - O(1)
 * unpark - log n
 * add parking spots - mn log mn n= spots, m floors
 * sc: mn log mn - for queue.
 */
public class Main {

    // *************** Parking Lot ***************
    public static class ParkingLot {
        int maxfloors, maxspots;
        PriorityQueue<ParkingSpot> pq_spot;

        public ParkingLot(int floors, int spots) {
            this.maxfloors = floors;
            this.maxspots = spots;
            this.pq_spot = new PriorityQueue<>((a, b) -> {
                if (a.floor == b.floor) {
                    return a.spot - b.spot; // nearest lot first
                }
                return a.floor - b.floor; // lower floor first!
            });
        }

        // ***************Adding Parking Spots in Queue***************
        public void addParkingSpots(int floor, int spot) {
            if (floor > maxfloors) {
                throw new IllegalArgumentException("Invalid Floor");
            }
            if (spot > maxspots) {
                throw new IllegalArgumentException("Invalid Spot");
            }

            // otherwse make object and add it to Q
            ParkingSpot ps = new ParkingSpot(floor, spot);
            pq_spot.add(ps);
        }

        // ****************** Parking Method ******************
        public ParkingSpot park() {
            if (pq_spot.isEmpty()) {
                throw new IllegalArgumentException("No Parking spots available");
            }
            return pq_spot.poll(); // nearest spot
        }

        // ************ Un-Parking Method *******************
        public void unPark(int floor, int spot) {
            addParkingSpots(floor, spot);
        }

        // ********************** Get next parking ***********************
        public ParkingSpot getNextAvailableParking() {
            if (pq_spot.isEmpty())
                throw new IllegalArgumentException("No Parking spots available");

            return pq_spot.peek();
        }
    }

    // *************** class Parking Spot ***************
    public static class ParkingSpot {
        int floor, spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        public int getFloor() {
            return floor;
        }

        public int getSpot() {
            return spot;
        }
    }

    // calling main method for execution
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ParkingLot blueGarage = new ParkingLot(10, 5);
        blueGarage.addParkingSpots(0, 1);
        blueGarage.addParkingSpots(0, 4);
        blueGarage.addParkingSpots(0, 0);
        blueGarage.addParkingSpots(2, 1);
        blueGarage.addParkingSpots(1, 4);
        blueGarage.addParkingSpots(3, 2);

        ParkingSpot parked = blueGarage.park();
        System.out.println("Vehicle Parked at : " + parked.getFloor() + " " + parked.getSpot());

        parked = blueGarage.park();
        System.out.println("Vehicle Parked at : " + parked.getFloor() + " " + parked.getSpot());

        ParkingSpot available = blueGarage.getNextAvailableParking();
        System.out.println("NEXT AVAILABLE floor: " + available.getFloor() + " spot: " + available.getSpot());

        blueGarage.unPark(0, 1);
        System.out.println("Vehicle Unparked at: xyz floors");
        parked = blueGarage.park();
        System.out.println("Vehicle Parked at : " + parked.getFloor() + " " + parked.getSpot());

    }
}

// some helpful links: https://www.careercup.com/question?id=5084295966228480