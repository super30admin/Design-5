// Time Complexity - O(log n)
// Space Complexity - O(n), n - no of parking spots

public class Main {

  public static class ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq;
    public ParkingLot(int floors, int spots) {
      this.maxFloors = floors;
      this.spotsPerFloor = spots;
      pq = new PriorityQueue<>((a,b) -> {
        if (a.getFloor() == b.getFloor()) {
          return a.getSpot() - b.getSpot();
        }
        return a.getFloor() - b.getFloor();
      });
    }
    public void addParkingSpot(int floor, int spot) {
      if(floor > maxFloors) throw new IllegalArgumentException("Floor exceeds max floors");
      if(spot > spotsPerFloor) throw new IllegalArgumentException("Spot exceeds max spots per floor");
      ParkingSpot pSpot = new ParkingSpot(floor, spot);
      pq.add(pSpot);
    }
    public ParkingSpot getAvailableSpot() {
      if(pq.isEmpty()) throw new IllegalArgumentException("No available spots");
      return pq.peek();
    }
    public ParkingSpot park() {
      if(pq.isEmpty()) throw new IllegalArgumentException("No available spots");
      return pq.poll();
    }
    public void unpark(int floor, int spot) {
      addParkingSpot(floor, spot);
    }
  }

  public static class ParkingSpot {
    int floor;
    int spot;
    public ParkingSpot(int floor, int spot) {
      this.floor = floor;
      this.spot = spot;
    }
    public int getFloor() {
      return floor;
    }
    public int getSpot() {
      return spot;
    }
  }

  public static void main(String[] args) {
    ParkingLot plot = new ParkingLot(5,4);
    plot.addParkingSpot(0,0);
    plot.addParkingSpot(2,1);
    plot.addParkingSpot(4,2);
    plot.addParkingSpot(1,3);
    plot.addParkingSpot(2,2);
    ParkingSpot pSpot = plot.park();
    System.out.println("Floor: ", +pSpot.getFloor(), " Spot: ", +pSpot.getSpot());
    pSpot = plot.park();
    System.out.println("Floor: ", +pSpot.getFloor(), " Spot: ", +pSpot.getSpot());
    pSpot = plot.park();
    System.out.println("Floor: ", +pSpot.getFloor(), " Spot: ", +pSpot.getSpot());
    plot.unpark(2,1);
    pSpot = plot.getAvailableSpot();
    System.out.println("Floor: ", +pSpot.getFloor(), " Spot: ", +pSpot.getSpot());
  }
}