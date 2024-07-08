import java.util.PriorityQueue;

//Time complexity:
//park() : O(N log N) where N = floors * spots in the worst case
//unpark(): O (N log N)
//addParkingSpot(): O(N log N)
//getNextAvailable(): O(1)
//Space complexity: O(N) where N = floors * spots in the worst case

public class ParkingLot {
    private int numberOfFloors;
    private  int numberOfSpotsPerFloor;
    private static int capacity;
    private PriorityQueue<ParkingSpot> availableSlots;


    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setNumberOfSpotsPerFloor(int numberOfSpotsPerFloor) {
        this.numberOfSpotsPerFloor = numberOfSpotsPerFloor;
    }

    public ParkingLot(int numberOfFloors, int numberOfSpotsPerFloor){
        this.numberOfFloors = numberOfFloors;
        this.numberOfSpotsPerFloor = numberOfSpotsPerFloor;
        this.capacity = numberOfFloors * numberOfSpotsPerFloor;

        this.availableSlots = new PriorityQueue<>( (p1, p2) -> {
            if(p1.getFloor() == p2.getFloor()){
                return p1.getSpot() - p2.getSpot();
            }else{
                return p1.getFloor() - p2.getFloor();
            }
        });
    }

    private class ParkingSpot{
        int floor;
        int spot;

        private int getSpot(){
            return this.spot;
        }

        private int getFloor(){
            return this.floor;
        }
        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

    }
    private void addParkingSpot(int floorNumber, int slotNumber){
        if(floorNumber > this.numberOfFloors || slotNumber > this.numberOfSpotsPerFloor){
            throw new IllegalArgumentException("Floor/Spot not allowed");
        }
        if(availableSlots.size() <= capacity){
            availableSlots.add(new ParkingSpot(floorNumber, slotNumber));
        }else{
            throw new IllegalStateException("Max capacity reached, cannot add more parking lots");
        }
    }

    private ParkingSpot getNextAvailable(){
        return availableSlots.peek();
    }

    private void park(){
        if(availableSlots.size() == 0){
            throw new IllegalStateException("Parking lot is full");
        }
        ParkingSpot p = availableSlots.poll();
        System.out.println("Parked at floor: " + p.getFloor() + " Spot: " + p.getSpot());
    }

    private void unpark(int floor, int spot){
        availableSlots.add(new ParkingSpot(floor, spot));
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

        System.out.println("Next available Floor: " + n.getFloor() + ", Slot: " + n.getSpot());

        pl.park();

        ParkingSpot n2 = pl.getNextAvailable();

        System.out.println("Next available Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.park();

        pl.unpark(1, 1);

        ParkingSpot n1 = pl.getNextAvailable();

        System.out.println("Next available Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());

    }

}
