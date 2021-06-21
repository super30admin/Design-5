/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class ParkingLot
{
    int floor , spotsPerFloor;
    PriorityQueue<ParkingSpot> PQ = new PriorityQueue<>((a,b) -> 
    {
        if(a.floor == b.floor) return a.spot-b.spot;
        return a.floor - b.floor;
    });
    public ParkingLot(int floor , int spotsPerFloor)
    {
        this.floor = floor;
        this.spotsPerFloor = spotsPerFloor;
    }
    public ParkingSpot park()
    {
        ParkingSpot p = getNextAvailableSpot();
        return PQ.poll();
    }
    public ParkingSpot getNextAvailableSpot()
    {
        if(PQ.isEmpty())
        {
            throw new NullPointerException("No Spots are available");
        }
        else
        {
            return PQ.peek();
        }
    }
    public void UnPark(int floor , int spot)
    {
        AddSpot(floor , spot);
    }
    public void AddSpot(int floor , int spot)
    {
        PQ.add(new ParkingSpot(floor , spot));
    }
}
class ParkingSpot
{
   int floor , spot;
   public ParkingSpot(int floor , int spot)
   {
       this.floor = floor;
       this.spot = spot;
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
class GFG {
	public static void main (String[] args) {
		ParkingLot pl = new ParkingLot(10 ,20);
		pl.AddSpot(1,1);
		pl.AddSpot(2,1);
		pl.AddSpot(3,1);
		pl.AddSpot(1,2);
		pl.AddSpot(2,2);
		pl.park();
		ParkingSpot s = pl.getNextAvailableSpot();
		System.out.println("Next available spot "+s.floor + "  " +s.spot);
		pl.park();
		ParkingSpot s1 = pl.getNextAvailableSpot();
		System.out.println("Next available spot "+s1.floor + "  " +s1.spot);
		pl.UnPark(1,1);
		ParkingSpot s2 = pl.getNextAvailableSpot();
		System.out.println("Next available spot "+s2.floor + "  " +s2.spot);
	}
}