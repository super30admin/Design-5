public class ParkingLot {

    private boolean[] arr;
    private int closestVacant;
    private Set<Integer> set;

    public ParkingLot(int n) {
        this.arr = new boolean[n];
        this.set = new HashSet<>();
    }

    public void addVehicle() {
        arr[closestVacant] = true;
        set.add(closestVacant);

        for(int i=0; i<arr.length; i++) {
            if(!arr[i]) {
                closestVacant = i;
                break;
            }
        }
    }

    public int findClosestVacantSpace() {
        return closestVacant;
    }

    public void removeVehicle(int i) {
        arr[i] = false;
        set.remove(i);
        if(closestVacant > i) {
            closestVacant = i;
        }
    }

    public void printFilledSpaces() {
        System.out.println(set);
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);
        parkingLot.addVehicle();
        parkingLot.addVehicle();
        parkingLot.addVehicle();
        parkingLot.removeVehicle(2);
        parkingLot.addVehicle();
        parkingLot.addVehicle();
        parkingLot.removeVehicle(1);
        parkingLot.printFilledSpaces();
    }

}
