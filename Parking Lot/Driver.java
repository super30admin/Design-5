import java.util.*;

class ParkingSpot {
    int floor;
    int spot;

    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }
}
class ParkingLot {

    int floors;
    int spotsPerFloor;
    //Priority Queue
    PriorityQueue<ParkingSpot> pq;

    public ParkingLot(int floors, int spotsPerFloor) {        
        //initialization
        this.floors = floors;
        this.spotsPerFloor = spotsPerFloor;
        // Priorty queue (capacity, overriden comparator object)
        pq = new PriorityQueue<ParkingSpot>((this.floors * this.spotsPerFloor), 
        new Comparator<ParkingSpot>(){

            public int compare(ParkingSpot a, ParkingSpot b) {
                if(a.floor == b.floor) {
                   return a.spot - b.spot;
                }
                else {
                    return a.floor - b.floor;
                }
            }
        });

        // initialize parking lot queue
        for(int i=0;i<floors;i++){
            for(int j=0;j<spotsPerFloor;j++){
                ParkingSpot spot = new ParkingSpot(i, j);
                pq.add(spot);
            }
        }
    }

    // park

    public ParkingSpot park(){
        
        ParkingSpot parkingSpot = getNextAvailableSpot();
        // returns the spot if parked successfully else returns null if slot if full
        if(parkingSpot != null)
            return pq.poll();
        else
            return null;
    }

    // unpark
    public ParkingSpot unpark(int floor, int spot) {
        // adding the new parking spot based on parameters and returning the newly created spot object
        ParkingSpot newParkingSpot = new ParkingSpot(floor, spot);
        pq.add(newParkingSpot);
        return newParkingSpot;        
    }

    // getnextavailable
    public ParkingSpot getNextAvailableSpot() {
        if(pq.isEmpty())
            return null;
        else
            return pq.peek();
    }
    

}


class Driver {
    public static void main(String[] args){
        System.out.println("Parking Lot");

        // init parking lot
        int floors = 5;
        int spotsPerFloor = 500;
        ParkingLot parkingLot = new ParkingLot(floors, spotsPerFloor);
        ParkingSpot spot;
         // F-0; S-0
         spot = parkingLot.park();
        if(spot != null)
            System.out.println(spot.floor + " " + spot.spot);
        else
            System.out.println("Parking lot is full");
        // F-0; S-1
        spot = parkingLot.park();
        if(spot != null)
            System.out.println(spot.floor + " " + spot.spot);
        else
            System.out.println("Parking lot is full");
        // F-0; S-2
        spot = parkingLot.park();
        if(spot != null)
            System.out.println(spot.floor + " " + spot.spot);
        else
            System.out.println("Parking lot is full");            
        // F-0, S-2 unparked
        spot = parkingLot.unpark(0,2); 
        System.out.println(spot.floor + " " + spot.spot);
        parkingLot.unpark(0, 1);
        parkingLot.unpark(0, 0);
        // fill all parking slots
        for(int i=0;i<floors;i++){
            for(int j=0;j<spotsPerFloor;j++){
                parkingLot.park();
            }
        }

        // after exhausting
        spot = parkingLot.park();
        if(spot != null)
            System.out.println(spot.floor + " " + spot.spot);
        else
            System.out.println("Parking lot is full"); 

    }
}