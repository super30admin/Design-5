import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ParkingGarageSystem {

    // map of parking spots to distance from entrance
    private final Map<Integer, Integer> parkingSpots;

    // map of car numbers to parking spots
    private final Map<String, Integer> occupation;

    // heap to keep track of the least distance parking spot
    private final PriorityQueue<DistancePair> minHeap;

    public ParkingGarageSystem(Map<Integer, Integer> parkingSpots) {
        this.parkingSpots = parkingSpots;
        this.occupation = new HashMap<>();
        this.minHeap = new PriorityQueue<>();
        for (int spot : parkingSpots.keySet()) {
            minHeap.add(new DistancePair(spot, parkingSpots.get(spot)));
        }
    }

    public int parkCar(String carNumber) {
        if (minHeap.isEmpty()) {
            throw new IllegalStateException("No parking spots available");
        }
        DistancePair pair = minHeap.poll();
        occupation.put(carNumber, pair.spot);
        return pair.spot;
    }

    public int unparkCar(String carNumber) {
        if (!occupation.containsKey(carNumber)) {
            throw new IllegalArgumentException("Car not found");
        }
        int spot = occupation.get(carNumber);
        minHeap.add(new DistancePair(spot, parkingSpots.get(spot)));
        occupation.remove(carNumber);
        return spot;
    }

    static class DistancePair implements Comparable<DistancePair> {
        int spot;
        int distance;

        public DistancePair(int spot, int distance) {
            this.spot = spot;
            this.distance = distance;
        }

        @Override
        public int compareTo(DistancePair other) {
            return this.distance - other.distance;
        }
    }
}

class Driver {
    public static void main(String[] args) {
        Map<Integer, Integer> parkingSpots = new HashMap<>();
        parkingSpots.put(1, 1);
        parkingSpots.put(2, 1);
        parkingSpots.put(3, 2);
        parkingSpots.put(4, 2);
        parkingSpots.put(5, 3);
        parkingSpots.put(6, 3);
        ParkingGarageSystem garage = new ParkingGarageSystem(parkingSpots);

        System.out.println("Parking car no. ADZ in spot " + garage.parkCar("ADZ"));
        System.out.println("Parking car no. BMB in spot " + garage.parkCar("BMB"));
        System.out.println("Parking car no. CFK in spot " + garage.parkCar("CFK"));
        System.out.println("Parking car no. DOG in spot " + garage.parkCar("DOG"));
        System.out.println("Parking car no. EDG in spot " + garage.parkCar("EDG"));

        System.out.println("Car no. DOG leaving from spot " + garage.unparkCar("DOG"));
        System.out.println("Car no. BMB leaving from spot " + garage.unparkCar("BMB"));

        System.out.println("Parking car no. FOO in spot " + garage.parkCar("FOO"));
        System.out.println("Parking car no. GA2 in spot " + garage.parkCar("GA2"));
        System.out.println("Parking car no. HAT in spot " + garage.parkCar("HAT"));
        System.out.println("Parking car no. IDK in spot " + garage.parkCar("IDK"));
    }
}
/* Output:
Parking car no. ADZ in spot 1
Parking car no. BMB in spot 2
Parking car no. CFK in spot 4
Parking car no. DOG in spot 3
Parking car no. EDG in spot 6
Car no. DOG leaving from spot 3
Car no. BMB leaving from spot 2
Parking car no. FOO in spot 2
Parking car no. GA2 in spot 3
Parking car no. HAT in spot 5
Exception in thread "main" java.lang.IllegalStateException: No parking spots available
	at ParkingGarageSystem.parkCar(ParkingGarageSystem.java:27)
	at Driver.main(ParkingGarageSystem.java:82)
*/
