// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


class ParkingLot {
    private int capacity;
    private boolean[] parkingSpaces;
    private Queue<Integer> emptySpaces;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaces = new boolean[capacity];
        this.emptySpaces = new LinkedList<>();

        for (int i = 0; i < capacity; i++) {
            emptySpaces.offer(i);
        }
    }

    public int park() {
        if (emptySpaces.isEmpty()) {
            System.out.println("Parking lot is full");
            return -1;
        }

        int parkingSpace = emptySpaces.poll();
        parkingSpaces[parkingSpace] = true;
        return parkingSpace;
    }

    public void leave(int spaceNumber) {
        if (spaceNumber < 0 || spaceNumber >= capacity) {
            System.out.println("Invalid space number");
            return;
        }

        if (parkingSpaces[spaceNumber]) {
            parkingSpaces[spaceNumber] = false;
            emptySpaces.offer(spaceNumber);
            System.out.println("Space " + spaceNumber + " is now empty");
        } else {
            System.out.println("Space " + spaceNumber + " is already empty");
        }
    }

    public void printOccupiedSpaces() {
        System.out.print("Occupied spaces: ");
        for (int i = 0; i < capacity; i++) {
            if (parkingSpaces[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);

        int token1 = parkingLot.park();
        int token2 = parkingLot.park();
        int token3 = parkingLot.park();

        parkingLot.printOccupiedSpaces();

        parkingLot.leave(token2);
        parkingLot.printOccupiedSpaces();

        parkingLot.leave(token2); // Trying to leave the same space again
        parkingLot.leave(11);     // Trying to leave an invalid space

        int token4 = parkingLot.park();
        parkingLot.printOccupiedSpaces();
    }
}
