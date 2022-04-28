import java.util.*;

class ParkingLot {
  // Class defining the ParkingSpot.
  class ParkingSpot {
    int floor;
    int spotNumber;

    ParkingSpot(int floor, int spotNumber) {
      this.floor = floor;
      this.spotNumber = spotNumber;
    }

    public int getFloor(){
      return this.floor;
    }

    public int getSpotNumber(){
      return this.spotNumber;
    }
  }

  class NoAvailableSpotsException extends Exception {
    public NoAvailableSpotsException(String str){
      super(str);
    }
  }

  class SpotUnavailableException extends Exception {
    public SpotUnavailableException(String str) {
      super(str);
    }
  }

  int floors;
  int spotsPerFloor;
  Set<ParkingSpot> availableSpots;
  public ParkingLot(int floors, int spotsPerFloor) {
    this.floors = floors;
    this.spotsPerFloor = spotsPerFloor;
    this.availableSpots = new HashSet<>();
    fillAvailableSpots();
  }

  private void fillAvailableSpots(){
    for(int i = 1; i <= this.floors; i++){
      for(int j = 1; j <= this.spotsPerFloor; j++){
        ParkingSpot spot = new ParkingSpot(i, j);
        this.availableSpots.add(spot);
      }
    }
  }

  // Method to park at any available spot.
  public ParkingSpot park() throws NoAvailableSpotsException{
    if(availableSpots.isEmpty()){
      throw new NoAvailableSpotsException("No parking spots available");
    }

    Iterator<ParkingSpot> iterator = availableSpots.iterator();
    ParkingSpot spot = iterator.next();
    availableSpots.remove(spot);
    return spot;
  }

  // Method to park at a specific spot in the lot.
  public ParkingSpot park(ParkingSpot spot) throws SpotUnavailableException{
    if(!availableSpots.contains(spot)) {
      throw new SpotUnavailableException("Spot already in use");
    }

    availableSpots.remove(spot);
    return spot;
  }

  // Method to unpark a vehicle from lot.
  public void unpark(ParkingSpot spot) {
    availableSpots.add(spot);
  }

  // Method to find the total number of available spots.
  public int totalAvailableSpots() {
    return availableSpots.size();
  }

  public static void main(String[] args) {
    ParkingLot lot = new ParkingLot(3, 10);
    System.out.println("Initial spots available: " + lot.totalAvailableSpots());

    try {
      ParkingSpot spot1 = lot.park();
      ParkingSpot spot2 = lot.park();

      System.out.println("Spot 1: " + "floor: " + spot1.floor + " spot: " + spot1.spotNumber);
      System.out.println("Spot 2: " + "floor: " + spot2.floor + " spot: " + spot2.spotNumber);

      System.out.println("------- unparking ----------");
      lot.unpark(spot1);
      System.out.println(" spots available: " + lot.totalAvailableSpots());


    } catch(NoAvailableSpotsException e){

    }

    System.out.println("spots available: " + lot.totalAvailableSpots());
  }
}
