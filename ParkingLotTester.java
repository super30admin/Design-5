public class ParkingLotTester {
    public static void main(String[] args) {
        ParkingLot obj = new ParkingLot(10, 20);
        // ParkingLotRandomOrderFilling obj = new ParkingLotRandomOrderFilling(10, 20);

        obj.addParkingSpot(1, 2);
        obj.addParkingSpot(3, 2);
        obj.addParkingSpot(4, 2);
        obj.addParkingSpot(2, 2);
        obj.addParkingSpot(1, 1);

        ParkingSlot parkingSlot = obj.getAvailableSlot();

        System.out.println("Available at Floor:" + parkingSlot.getFloor() +
                " slot:" + parkingSlot.getSlot());

        parkingSlot = obj.park();

        System.out.println("Parked at Floor:" + parkingSlot.getFloor() +
                " slot:" + parkingSlot.getSlot());

        parkingSlot = obj.park();

        System.out.println("Parked at Floor:" + parkingSlot.getFloor() +
                " slot:" + parkingSlot.getSlot());

        parkingSlot = obj.park();

        System.out.println("Parked at Floor:" + parkingSlot.getFloor() +
                " slot:" + parkingSlot.getSlot());

        obj.unpark(1, 2);

        parkingSlot = obj.park();

        System.out.println("Parked at Floor:" + parkingSlot.getFloor() +
                " slot:" + parkingSlot.getSlot());
    }
}
