import java.util.PriorityQueue;

public class ParkingLot {

    private final PriorityQueue<Integer> freeSpots; // min-heap of available spot numbers
    private final boolean[] occupied;
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.freeSpots = new PriorityQueue<>();
        this.occupied = new boolean[capacity + 1];

        for (int spot = 1; spot <= capacity; spot++) {
            freeSpots.offer(spot);
        }
    }

    //Time Complexity: O(log n)
    public int park() {
        if (freeSpots.isEmpty()) {
            return -1; // lot is full
        }
        int spot = freeSpots.poll();
        occupied[spot] = true;
        return spot;
    }

    //Time Complexity: O(log n)
    public boolean unpark(int spotNumber) {
        if (spotNumber < 1 || spotNumber > capacity || !occupied[spotNumber]) {
            return false;
        }
        occupied[spotNumber] = false;
        freeSpots.offer(spotNumber);
        return true;
    }

    //Time Complexity: O(1)
    public int availableSpots() {
        return freeSpots.size();
    }

    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3);

        System.out.println("Available: " + lot.availableSpots());

        int a = lot.park();
        int b = lot.park();
        System.out.println("Car A -> spot " + a);
        System.out.println("Car B -> spot " + b);
        System.out.println("Available: " + lot.availableSpots());

        lot.unpark(a);
        System.out.println("Available after A leaves: " + lot.availableSpots());

        int c = lot.park();
        System.out.println("Car C -> spot " + c);

        int d = lot.park();
        System.out.println("Car D -> spot " + d);

        int e = lot.park();
        System.out.println("Car E -> spot " + e);
    }
}
