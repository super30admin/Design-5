import java.util.Comparator;
import java.util.PriorityQueue;

public class ParkingLot {
    static int noOfFloors = 500;
    static int spotsPerFloor = 500;
    // pq arguments in((size),(comparator))
    // pq has list of all available parking spots, if we park then we remove that from queue.
    PriorityQueue<parkingSpot> queue = new PriorityQueue<>((noOfFloors*spotsPerFloor),(new Comparator<parkingSpot>() {
        @Override
        public int compare(parkingSpot o1, parkingSpot o2) {
            if(o1.floor == o2.floor) return o1.spot-o2.spot;
            else return o1.floor-o2.floor;
        }
    }));
    // parking spot object : each spot has a floor number and a spot number.
    public class parkingSpot{
        private int floor;
        private int spot;
        public parkingSpot(int floor,int spot){
            this.floor = floor;
            this.spot = spot;
        }
        public int getFloor(){
            return floor;
        }
        public int getSpot(){
            return spot;
        }
    }
    //park : get next available spot and remove that from queue as it will be filled.
    // Time: O(log n)
    public parkingSpot Park(parkingSpot pspot){
        parkingSpot newSpot = getNextSpot();
        if(newSpot == null) throw new IllegalStateException("no spots left");
        queue.remove();
        return newSpot;
    }
    //unparking : add this spot object to priority queue as it is getting freed up.
    //Time : O(log n)
    public void unPark(parkingSpot pspot){
        queue.add(pspot);
    }
    
    // getting next available spot : check top of priority queue and return it .
    // Time : O(1).
    public parkingSpot getNextSpot(){
        if(queue.isEmpty())
            throw new IllegalStateException("all spots filled");
        return queue.peek();
    }
    
    // adding a spot object to parkingLot: if a new parking spot created , add this to priority queue.
    // time: O(log n)
    public void addParkingSpot(int floor,int spot){
        parkingSpot newspot = new parkingSpot(floor,spot);
        queue.add(newspot);
    }
}
