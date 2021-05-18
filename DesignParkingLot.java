// "static void main" must be defined in a public class.
public class Main {

  static class ParkingLot{
    int maxFloors, maxSpots;

    PriorityQueue<ParkingSpace> queue = new PriorityQueue<>((a,b) -> a.floor == b.floor ? a.spot - b.spot :a.floor - b.floor );

    public ParkingLot(int maxFloors, int maxSpots){
      this.maxFloors = maxFloors;
      this.maxSpots = maxSpots;
    }

    public ParkingSpace park(){
      if(queue.isEmpty()){
        throw new IllegalStateException("Parking is full!");
      }
      return queue.poll();
    }

    public void unpark(int floor, int spot){
      ParkingSpace p = new ParkingSpace(floor, spot);
      queue.add(p);
    }

    public void addParkingSpot(int floor, int spot){
      if(floor > maxFloors){
        throw new IllegalStateException("Invalid floor!");
      }
      if(spot > maxSpots){
        throw new IllegalStateException("Invalid spot!");
      }
      ParkingSpace ps = new ParkingSpace(floor, spot);
      queue.add(ps);
    }

    public ParkingSpace getNextAvailableSpot(){
      if(queue.isEmpty()){
        throw new IllegalStateException("Parking is full!");
      }
      return queue.peek();
    }
  }

  static class ParkingSpace{
    int floor, spot;

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
    ParkingLot parkingLot = new ParkingLot(50,50);
    parkingLot.addParkingSpot(0,0);
    parkingLot.addParkingSpot(0,1);
    parkingLot.addParkingSpot(2,0);
    parkingLot.addParkingSpot(1,1);
    parkingLot.addParkingSpot(3,0);

    ParkingSpace ps = parkingLot.park();

    System.out.println("Parked at floor:"+ps.getFloor()+" spot: "+ps.getSpot());
    ps = parkingLot.getNextAvailableSpot();
    System.out.println("Parked at floor:"+ps.getFloor()+" spot: "+ps.getSpot());
    System.out.println("--------------------------------");
    ParkingSpace ps1 = parkingLot.park();

    System.out.println("Parked at floor:"+ps1.getFloor()+" spot: "+ps1.getSpot());
    ps1 = parkingLot.getNextAvailableSpot();
    System.out.println("Parked at floor:"+ps1.getFloor()+" spot: "+ps1.getSpot());
  }
}
