public class Main {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(9, 9);
        pl.park();
        pl.park();
        pl.park();
        pl.unpark(1, 1);
        pl.unpark(9, 9);
        ParkingSpot ps = pl.getNextAvailable();
        System.out.println(ps.getFloor() + " " + ps.getSpot());
    }
}
