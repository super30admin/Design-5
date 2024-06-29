import java.util.PriorityQueue;

public class MyClass
{

    static class ParkingLot
    {
        // These variables will hold how many floors are there and in each floor how many number of spots we have
        int maxSpots, maxFloors;

        // Min heap will give us the minimum spot available at any time to make parking easy. So heap will be storing only the available slots for parking
        PriorityQueue<ParkingSpot> heap = new PriorityQueue<>((a, b) -> {

            // If both the floors are same then consider the nearest spot among them
            if(a.floor == b.floor) return a.spot - b.spot;

            // If both the floors are not same then return the minimum floor
            return a.floor - b.floor;
        });

        public ParkingLot(int floors, int spots)
        {
            maxFloors = floors;
            maxSpots = spots;
        }

        public ParkingSpot park()
        {
            if(heap.isEmpty()) throw new IllegalArgumentException("No available slots for parking");

            return heap.poll();
        }

        // This function will add all the available slots to priority queue
        public void addParkingSpots(int floor, int spot)
        {
            // If the request is for an invalid floor return Exception
            if(floor > maxFloors || floor < 0) throw new IllegalArgumentException("Invalid Floor");

            // If the request is for an invalid floor return Exception
            if(spot > maxSpots || spot < 0) throw new IllegalArgumentException("Invalid Spot");

            // Add the spot in to heap
            heap.add(new ParkingSpot(floor, spot));
        }

        public void unpark(int floor, int spot)
        {
            // Because by unparking the slot becomes available and we need to add it back to heap
            addParkingSpots(floor, spot);
        }

        // This will give us the next available slot for parking
        public ParkingSpot getNextAvailable()
        {
            if(heap.isEmpty()) throw new IllegalArgumentException("No available slots for parking");

            return heap.peek();
        }
    }

    // This class will just hold the info. regarding the floor and spot
    static class ParkingSpot
    {
        int floor, spot;

        public ParkingSpot(int floor, int spot)
        {
            this.floor = floor;
            this.spot = spot;
        }

        public int getFloor()
        {
            return floor;
        }

        public int getSpot()
        {
            return spot;
        }
    }

    public static void main(String[] args) 
    {
        // 10 floors and 5 spots in each floor
        ParkingLot lot = new ParkingLot(10, 5);

        // These are available slots and we add them to heap
        lot.addParkingSpots(0, 1);
        lot.addParkingSpots(0, 4);
        lot.addParkingSpots(0, 0);
        lot.addParkingSpots(1, 1);
        lot.addParkingSpots(2, 1);

        // Will give me a slot for parking
        ParkingSpot parked = lot.park();

        System.out.println("Vehicle parked at : " + parked.getFloor() + " " + parked.getSpot());

        parked = lot.park();

        System.out.println("Vehicle parked at : " + parked.getFloor() + " " + parked.getSpot());

        // This gives me the next available spot for parking
        ParkingSpot available = lot.getNextAvailable();

        System.out.println("Parking available at : " + available.getFloor() + " " + available.getSpot());

        // Unparking the spot
        lot.unpark(0, 0);

        parked = lot.park();

        // This should give me (0, 0)
        System.out.println("Vehicle parked at : " + parked.getFloor() + " " + parked.getSpot());
    }
}
