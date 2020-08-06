import java.util.PriorityQueue;

//Time Complexity : O(1)
//Space Complexity : O(n)
public class ParkingLot {
  private int maxFloor;
  private int maxSpots;

  PriorityQueue<ParkingSpot> pq;
  public ParkingLot(int maxFloor, int maxSpots) {
    this.maxFloor = maxFloor;
    this.maxSpots = maxSpots;
    pq = new PriorityQueue<ParkingSpot>((a, b) -> {
      if (a.getFloor() == b.getFloor())
        return a.getSpotId() - b.getSpotId();
      return a.getFloor() - b.getFloor();
    });
  }
    public ParkingSpot getNextAvailableSpot () {
      return pq.peek();
    }

    public ParkingSpot park () {

      if (pq.isEmpty())
        throw new IllegalStateException("parking lot is full");
      ParkingSpot p = pq.remove();
      return p;
    }

    public void unpark ( int floor, int spotId){
      if (pq.isEmpty()) {
        throw new IllegalStateException("Parking lot is full");
      }
      ParkingSpot p = new ParkingSpot(floor, spotId);
      pq.add(p);
    }

    public ParkingSpot addParkingSpot ( int floor, int spotId){

      if (floor > maxFloor) {
        throw new IllegalStateException("floor greater than maxFloor");
      }
      if (spotId > maxSpots) {
        throw new IllegalStateException("spot greater than Spot");
      }
      ParkingSpot parkingSpot = new ParkingSpot(floor, spotId);
      pq.add(parkingSpot);
      return parkingSpot;
    }


  public static void main(String[] args){

    ParkingLot parkingLot = new ParkingLot(3,5);

    parkingLot.addParkingSpot(1,1);
    parkingLot.addParkingSpot(2,1);
    parkingLot.addParkingSpot(2,1);
    ParkingSpot n = parkingLot.getNextAvailableSpot();
    System.out.println(n.getFloor()+" "+ " "+n.getSpotId());
    parkingLot.park();
    ParkingSpot n1 = parkingLot.getNextAvailableSpot();
    System.out.println(n1.getFloor()+" "+ " "+n1.getSpotId());
   parkingLot.unpark(1,1);
    ParkingSpot n2 = parkingLot.getNextAvailableSpot();
    System.out.println(n2.getFloor()+" "+ " "+n2.getSpotId());
    parkingLot.park();

  }


}
