/*Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
  When someone leave you need update this space as empty. 
  What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
  */
//The idea here is to solve this problem thinking as a 2D grid having an entry and exit
//Use a Priority Queue(min heap) of the type ParkingSpaces(which is a pair of floor and spot number) data structure to keep tracking of available spaces.
//Implement functions for parking, unparking, get the next available free spot and adding a new parking space
public class Main {
    public static class ParkingLot{
        int maxFloors, maxSpots;
        //min heap to implement the available spaces
        PriorityQueue<ParkingSpace> pq = new PriorityQueue<>((a,b) -> {
            //if same floor, then return the spot in ascending order
            if(a.floor == b.floor){
                return a.spot - b.spot;
            }
            //otherwise go by the floor number
            return a.floor-b.floor;
        });
        public ParkingLot(int maxFloors,int maxSpots){
            this.maxFloors = maxFloors;
            this.maxSpots = maxSpots;
        }
        public ParkingSpace park(){
            //check for empty spaces
            if(pq.isEmpty()) throw new IllegalStateException("Paking is full");
            //once parked, the space is occupied so this space is removed from the heap
            return pq.poll();
        }
        public void unPark(int floor,int spot){
            ParkingSpace p = new ParkingSpace(floor,spot);
            //add the new available space to the heap once unparked
            pq.add(p);
        }
        public void addParkingSpot(int floor,int spot){
            //before adding the new spot and floor check if its not out of bounds
            if(floor > maxFloors) throw new IllegalStateException("Invalid floor");
            if(spot > maxSpots) throw new IllegalStateException("Invalid spot");
            //add the new availble space into the heap
             ParkingSpace p = new ParkingSpace(floor,spot);
            pq.add(p);
        }
        public ParkingSpace getNextAvailableSpot(){
            if(pq.isEmpty()) throw new IllegalStateException("Paking is full");
                //return the next available space which is the first element in the heap
                return pq.peek();
        }
    }
    public static class ParkingSpace{
        int spot,floor;
        public ParkingSpace(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }
        public int getFloor(){
            return this.floor;
        }
        public int getSpot(){
            return this.spot;
        }
    }
    public static void main(String[] args) {
        ParkingLot plot = new ParkingLot(50,50);
        plot.addParkingSpot(0,0);
        plot.addParkingSpot(1,0);
        plot.addParkingSpot(2,0);
        plot.addParkingSpot(1,1);
        plot.addParkingSpot(3,0);
        ParkingSpace p = plot.park();
        System.out.println("Parked at floor "+p.getFloor()+" and spot "+p.getSpot());
        p = plot.getNextAvailableSpot();
        System.out.println("Parking available at floor "+p.getFloor()+" and spot "+p.getSpot());
        p = plot.park();
        System.out.println("Parked at floor "+p.getFloor()+" and spot "+p.getSpot());
        p = plot.park();
        System.out.println("Parked at floor "+p.getFloor()+" and spot "+p.getSpot());
       plot.unPark(0,0);
         p = plot.park();
        System.out.println("Parked at floor "+p.getFloor()+" and spot "+p.getSpot());
         p = plot.getNextAvailableSpot();
        System.out.println("Parking available at floor "+p.getFloor()+" and spot "+p.getSpot());
    }
}