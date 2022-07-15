//time complexity : O(1)
//space complexity : O(1)

import java.util.*;

class ParkingSpot {

  int floor;
  int spot;

  ParkingSpot(int floor, int spot) {
    this.floor = floor;
    this.spot = spot;
  }

  public int getFloor() {
    return this.floor;
  }

  public int getSpot() {
    return this.spot;
  }

}

class ParkingLot {

  int maxFloors;
  int spotsPerFloor;
  PriorityQueue<ParkingSpot> pq;

  public ParkingLot(int maxFloors, int spotsPerFloor) {

    this.maxFloors = maxFloors;
    this.spotsPerFloor = spotsPerFloor;

    pq = new PriorityQueue<>((a, b) -> {
      if (a.getFloor() == b.getFloor()) {
          return a.getSpot() - b.getSpot();
      }
      return a.getFloor() - b.getFloor();
    }
    );
  }

  public void addParkingSlot(int floor, int spot) {
      if(floor > maxFloors)
        System.out.println("input floor is greater than maximum allowed");
      else
        pq.add(new ParkingSpot(floor, spot));
  }

  public ParkingSpot park() {
    if(!pq.isEmpty()) {
      ParkingSpot ps = pq.poll();
      return ps;
    }
    else
    {
      System.out.println("parking lot is full");
      return null;
    }
  }

  public void unpark(int floor, int spot) {
    pq.add(new ParkingSpot(floor, spot));
  }

  public ParkingSpot getNextAvailable() {
    return pq.peek();
  }

}

public class DesignParkingLot {

  public static void main(String ar[]) {

    ParkingLot pl = new ParkingLot(5,3);

      pl.addParkingSlot(1,1);
      pl.addParkingSlot(1,3);
      pl.addParkingSlot(2,1);
      pl.addParkingSlot(3,2);
      pl.addParkingSlot(3,3);
      pl.addParkingSlot(4,1);

      ParkingSpot ps = pl.getNextAvailable();
      System.out.println("Next available slot is : "+ps.getFloor()+", "+ps.getSpot());

      pl.park();

      ParkingSpot ps1 = pl.getNextAvailable();
      System.out.println("Next available slot is : "+ps1.getFloor()+", "+ps1.getSpot());

  }
}
