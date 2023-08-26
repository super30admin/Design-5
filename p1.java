
import java.util.PriorityQueue;

/**
 * The ParkingLot object stores the no of floors available and spots in each
 * floor. It also maintains a priority queue indicating the vacant parking spots
 * for use.
 * 
 * Time Complexity : park : O(1) unpark : O(1) getNextAvailable : O(1)
 * 
 * Space complexity : O(1) as no extra space is used in the user oriented
 * functions In the constructor, space complexity will be O(floors*spots)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class ParkingLot {

	public int getNoOfFloors() {
		return NoOfFloors;
	}

	public int getNoOfSpots() {
		return NoOfSpots;
	}

	private int NoOfFloors;
	private int NoOfSpots;
	private PriorityQueue<ParkingSpot> q;

	ParkingLot(int floors, int spots){
		this.NoOfFloors=floors;
		this.NoOfSpots=spots;
		this.q=new PriorityQueue<> ((a,b)->{
			if(a.floor==b.floor) return a.spot-b.spot;
			return a.floor-b.floor;
		});
		for(int i=1;i<=floors;i++) {
			for(int j=1;j<=spots;j++) {
				q.add(new ParkingSpot(i,j));
			}
		}
	}

	class ParkingSpot
	{
		private int floor;
		public int getFloor() {
			return floor;
		}


		public int getSpot() {
			return spot;
		}

		private int spot;

		ParkingSpot(int floor, int spot){
			this.floor=floor;
			this.spot=spot;
		}
	}

	void park() {
		if(q.isEmpty()) {
			System.out.println("no space available");
		}
		ParkingSpot parkingSpot=q.poll();
		System.out.println("Vehicle parked at "+"floor : "+parkingSpot.floor+" and spot : "+parkingSpot.spot);

	}

	void unPark(int floor, int spot) {
		ParkingSpot parkingSpot=new ParkingSpot(floor,spot);
		q.add(parkingSpot);
		System.out.println("Vehicle removed from "+"floor : "+parkingSpot.floor+" and spot : "+parkingSpot.spot);
	}

	ParkingSpot getNextAvailable() {
		return q.peek();
	}

    public static void main (String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);

        ParkingSpot n = pl.getNextAvailable();
        pl.park();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());

        ParkingSpot n2 = pl.getNextAvailable(); //1,2
        System.out.println("Next available parking at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unPark(1, 1);
        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Next available parking at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
  	}


}