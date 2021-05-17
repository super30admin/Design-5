// Time Complexity :O(log(m*n))
// Space Complexity :O(log(m*n))

public class Main {
  public static class ParkingSpot {
    int floor;
    int spot;

    public ParkingSpot(int f, int s) {
      this.floor = f;
      this.spot = s;
    }

    public int getFloor() {
      return this.floor;
    }

    public int getSpot() {
      return this.spot;
    }
  }

  public static class ParkingLot {
    PriorityQueue<ParkingSpot> p;
    int floors;
    int spotsperfloor;

    public ParkingLot(int floors, int spots) {
      this.floors = floors;
      this.spotsperfloor = spots;
      p = new PriorityQueue<>((a, b) -> {
        if (a.floor == b.floor)
          return a.spot - b.spot;
        return a.floor - b.floor;
      });
    }

    public ParkingSpot park() {
      if (p.isEmpty())
        throw new IllegalArgumentException("Parking lot full");

      return p.poll();
    }

    public void unpark(int floor, int spot) {
      addParking(floor, spot);
    }

    public void addParking(int floor, int spot) {
      if (floor > floors)
        throw new IllegalArgumentException("Invalid floor");

      if (spot > spotsperfloor)
        throw new IllegalArgumentException("Invalid spot");

      ParkingSpot ps = new ParkingSpot(floor, spot);
      p.add(ps);
    }

    public ParkingSpot getnext() {
      return p.peek();
    }
  }

  public static void main(String[] args) {
    ParkingLot pl = new ParkingLot(10, 5);
    pl.addParking(0, 1);
    pl.addParking(0, 4);
    pl.addParking(0, 0);
    pl.addParking(2, 1);
    pl.addParking(10, 1);
    ParkingSpot s = pl.park();
    System.out.println(s.getFloor() + " " + s.getSpot());
    s = pl.park();
    System.out.println(s.getFloor() + " " + s.getSpot());
    pl.unpark(0, 0);
    s = pl.park();
    System.out.println(s.getFloor() + " " + s.getSpot());

  }
}