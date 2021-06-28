package Design5;

class GFG {
    public static void main(String[] args) {
        ParkingLots pl = new ParkingLots(10, 20);

        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);

        ParkingSpot n = pl.getNextAvailable();

        System.out.println("Parked at floor" + n.floor + "slot:" + n.spot);

        pl.park();
        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at floor" + n1.floor + "slot:" + n1.spot);

        pl.unPark(1, 1);
        ParkingSpot n2 = pl.getNextAvailable();
        System.out.println("Parked at floor" + n2.floor + "slot:" + n2.spot);

    }

}
