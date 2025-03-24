// This problem was asked at Intuit
// Design a parking lot system where you need to provide a token with the
// parking space number on it to each new entry for the space closest to the
// entrance. When someone leave you need update this space as empty. What data
// structures will you use to perform the closest empty space tracking, plus
// finding what all spaces are occupied at a give time.

// Time Complexity:
// getOccupiedSpaces(): O(N)
// getAvailableParkingSpaceNumberClosertoEntrance(): O(logN)
// emptyParkingSpaceByID(): O(logN)

// Space Complexity: O(N)


import java.util.*;

class ParkingLot {
    int capacity;
    PriorityQueue<Integer> freeSpots;
    HashSet<Integer> occupied;
    int nextId;

    ParkingLot(int capacity) {
        this.capacity = capacity;
        this.freeSpots = new PriorityQueue<>();
        this.occupied = new HashSet<>();
        this.nextId = 1;
    }

    public List<Integer> getOccupiedSpaces() {
        List<Integer> oc = new ArrayList<>();
        oc.addAll(occupied);
        System.out.println(oc);
        return oc;
    }

    public int getAvailableParkingSpaceNumberClosertoEntrance() {
        if (freeSpots.isEmpty()) {
            if (nextId > capacity) {
                System.out.println("Parking Capacity Reached");
                return -1;
            }
            System.out.println(nextId);
            occupied.add(nextId);
            return nextId++;
        }
        int space = freeSpots.poll();
        occupied.add(space);
        System.out.println(space);
        return space;
    }

    public void emptyParkingSpaceByID(int id) {
        if (id > capacity || id < 1) {
            System.out.println("Wrong Parking ID");
            return;
        }
        if (!occupied.contains(id)) {
            System.out.println(id + " : Already Available");
            return;
        }
        occupied.remove(id);
        freeSpots.add(id);
        System.out.println(id + " : Unparked");
    }
}

public class ParkingLotMain {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(5);

        pl.getOccupiedSpaces();

        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();

        pl.getOccupiedSpaces();

        pl.emptyParkingSpaceByID(2);
        pl.emptyParkingSpaceByID(1);
        pl.getOccupiedSpaces();

        pl.emptyParkingSpaceByID(5);

        pl.getOccupiedSpaces();

        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();
        pl.getAvailableParkingSpaceNumberClosertoEntrance();

        pl.getOccupiedSpaces();

    }
}
