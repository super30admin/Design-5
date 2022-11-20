// Time Complexity: addParkingSpots -> O(logN), park -> O(logN), unpark -> O(logN), getNextAvailableSpot -> O(1),
// getFloor -> O(1), getSpot -> O(1)
// Space Complexity: O(N) where N is the toal number of parking spots across all floors, stored in priority
// Queue as a min Heap
public class Main {

    public static class ParkingSpot {
        int floor, spot;

        public ParkingSpot (int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        //getters
        int getFloor() {
            return this.floor;
        }

        int getSpot() {
            return this.spot;
        }
    }

    public static class ParkingLot {
        int maxfloors, maxspots;

        PriorityQueue<ParkingSpot> pq;

        public ParkingLot(int floors, int spots) {
            maxfloors = floors;
            maxspots = spots;
            // Using priority queue as a min heap
            pq = new PriorityQueue<>((a, b) -> {
                if (a.floor == b.floor) {
                    return a.spot - b.spot;
                }
                return a.floor - b.floor;
            });
        }

        public void addParkingSpots(int floor, int spot) {
            // Input validation
            if (floor > maxfloors) {
                throw new IllegalArgumentException("Invalid Floor");
            }
            if (spot > maxspots) {
                throw new IllegalArgumentException("Invalid Spot");
            }
            // Create and add avaible spots to the min heap
            ParkingSpot ps = new ParkingSpot(floor, spot);
            pq.add(ps);
        }

        public ParkingSpot park() {
            if(pq.isEmpty()) {
                throw new IllegalArgumentException("Parking Spaces are Full!");
            }

            return pq.poll();
        }

        public void unpark(int floor, int spot) {
            addParkingSpots(floor, spot);
        }

        public ParkingSpot getNextAvailableSpot() {
            if(pq.isEmpty()) {
                throw new IllegalArgumentException("No empty spot is available");
            }
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10, 5);

        lot.addParkingSpots(0,1);
        lot.addParkingSpots(0,4);
        lot.addParkingSpots(0,0);
        lot.addParkingSpots(1,1);
        lot.addParkingSpots(2,1);
        ParkingSpot parked = lot.park();
        System.out.println("Vehicle parked at : " + parked.getFloor() + " " + parked.getSpot());
        parked = lot.park();
        System.out.println("Vehicle parked at : " + parked.getFloor() + " " + parked.getSpot());
        ParkingSpot available = lot.getNextAvailableSpot();
        System.out.println("Parking available at : " + available.getFloor() + " " + available.getSpot());
        lot.unpark(0, 0);
        parked= lot.park();
        System.out.println("Vehicle parked at : " + parked.getFloor() + " " + parked.getSpot());
        lot.unpark(101, 202);

    }
}
