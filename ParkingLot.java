//TC constructor - O(m*n*log(mn))
//TC park - O(log(mn))
//TC unpark - O(log(mn))
//SC - O(mn)

import java.io.*;
import java.util.*;

public class ParkingLot {
    
    int maxFloors;
    int maxSpotsPerFloor;
    
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>( (a, b) -> {
        if(a.getFloor() == b.getFloor())
        {
            return a.getSpot() - b.getSpot();
        }
        else
        {
            return a.getFloor() - b.getFloor();
        }
    });
    
    class ParkingSpot{
        int floor;
        int spot;
        
        public ParkingSpot(int f, int s)
        {
            this.floor = f;
            this.spot = s;
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
    
    public ParkingLot(int floors, int spots)
    {
        this.maxFloors = floors;
        this.maxSpotsPerFloor = spots;
        
        for(int i = 0; i < this.maxFloors; ++i)
        {
            for(int j = 0; j < this.maxSpotsPerFloor; ++j)
            {
                pq.add(new ParkingSpot(i, j));
            }
        }
    }

    public int getMaxFloors(){
        return this.maxFloors;
    }

    public int getMaxSpotsPerFloor()
    {
        return this.maxSpotsPerFloor;
    }
    
    
    public ParkingSpot park()
    {
        ParkingSpot ps = getNextFreeSpot();
        if(ps == null)
            throw new IllegalStateException("Parking Lot is full");
        pq.poll();
        return ps;
    }
    
    public void unpark(int fl, int sp)
    {
        if(fl >= getMaxFloors())
            throw new IllegalArgumentException("Floor number out of bounds");
        else if(sp >= getMaxSpotsPerFloor())
            throw new IllegalArgumentException("Spot number out of bounds");
        else
        {
            pq.add(new ParkingSpot(fl, sp));
        }
    }

    private ParkingSpot getNextFreeSpot()
    {
        return pq.peek();
    }
    
    public int findFreeSpots()
    {
        return pq.size();
    }
    
	public static void main (String[] args) {
	ParkingLot p1 = new ParkingLot(5,10);
        System.out.println("The number of free slots are " + p1.findFreeSpots());
        ParkingSpot ps1 = p1.getNextFreeSpot();
        System.out.println("The next free slot is at floor " + ps1.getFloor() + " and spot number " + ps1.getSpot());
        p1.park();
        System.out.println("The number of free slots are " + p1.findFreeSpots());
        p1.unpark(ps1.getFloor(), ps1.getSpot());
        System.out.println("The number of free slots are " + p1.findFreeSpots());
	}
}
