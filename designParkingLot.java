// Time Complexity : O(log n) n-number of spots in priority queue (sorting) 
// Space Complexity : O(n) n spots are stored in priority queue
// https://www.geeksforgeeks.org/design-parking-lot-using-object-oriented-principles/
/* Design a parking lot system where you need to provide a token with the parking space number on it 
to each new entry for the space closest to the entrance. When someone leave you need update this space as empty. 
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
*/
import java.util.PriorityQueue;
class ParkingLot {
    int maxFloors, spotsPerFloor;
    PriorityQueue<ParkingSpot> pq=new PriorityQueue<>((a,b)->{
    if(a.floor==b.floor)
    {
        return a.spot-b.spot;
    }
    else
        return a.floor-b.floor;
    });

    
    public ParkingLot(int maxFloors,int spotsPerFloor)
    {
        this.maxFloors=maxFloors;
        this.spotsPerFloor=spotsPerFloor;
    }
    
    public ParkingSpot park()
    {
        if(pq.isEmpty())
           throw new IllegalStateException("Parking lot is full");
        return pq.poll();
    }
    
    public ParkingSpot getNextAvailable()
    {
        if(pq.isEmpty())
           throw new IllegalStateException("Parking lot is full");
        return pq.peek();
    }
    
    public void unpark(int floor,int spot)
    {
        addParkingSpot(floor,spot);

    }
    
    public void addParkingSpot(int floor,int spot)
    {
        if(floor> maxFloors || spot> spotsPerFloor)
        throw new IllegalStateException("Out of Range input");
        ParkingSpot ps=new ParkingSpot(floor,spot);
        pq.add(ps);
    }
}

class ParkingSpot {
    int floor;
    int spot;
    public ParkingSpot(int floor,int spot)
    {
        this.floor=floor;
        this.spot=spot;
    }
    
    public int getFloor()
    {
        return this.floor;
    }
    
    public int getSpot()
    {
        return this.spot;
    }

}

class ParkingLotDesign {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10,20);
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