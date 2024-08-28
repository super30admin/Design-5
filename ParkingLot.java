import java.util.PriorityQueue;

public class ParkingLot { //overall S.C O(n) where n is max number of available spots

    static class ParkingSpot{
        int floor; //the floor which car is parked
        int spot; //the spot on the floor

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

    int maxFloors; //define the max number of floors in this lot
    int spotsPerFloor; //define max spots on each floor

    PriorityQueue<ParkingSpot> pq  = new PriorityQueue<>((a, b) -> { //assign slots based on
        if(a.floor == b.floor) return a.spot - b.spot; //if floors are equal, then nearest spot first
        return a.floor - b.floor; //floor index first
    });

    public ParkingLot(int maxFloors, int spotsPerFloor){
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public void park(){ //O(1) T.C
        if(pq.isEmpty()){ //all slots are assigned
            throw new IllegalStateException("Parking lot is full");
        }
        pq.remove(); //else, assign the nearest slot
    }

    public ParkingSpot getNextAvailable(){ //O(1) T.C
        return pq.peek(); //get the next nearest available slot
    }

    public void unpark(int floor, int spot){ //O(1) T.C
        ParkingSpot newSpot = new ParkingSpot(floor, spot); //create a parkingspot from the unparked floor and spot
        pq.add(newSpot); //and add it to the heap to make it available
    }

    public void addParkingSpot(int floor, int spot){ //to add more available spots, O(1) T.C
        if(floor > maxFloors){ //if the given floor is not defined in range
            throw new IllegalArgumentException("floor input greater than max allowed");
        }
        if(spot > spotsPerFloor){ //if the given spot is not defined in range
            throw new IllegalArgumentException("spots input greater than max allowed");
        }
        ParkingSpot newSpot = new ParkingSpot(floor, spot); //create a new spot with given inputs
        pq.add(newSpot); //add it to the heap to make this spot as available
    }

    public static void main (String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);

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