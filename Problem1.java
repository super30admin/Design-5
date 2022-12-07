// Problem: https://www.careercup.com/question?id=5084295966228480

import java.util.*;

class parkingLot {
    // entrance of the parking lot is considered to be 0
    int size;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

    parkingLot(int size) {
        this.size = size;
        for (int i = 1; i < size; i++) {
            minHeap.offer(i);
        }
    }

    public int entry() {
        if (minHeap.size() == 0) {
            return -1;
        }
        return minHeap.poll();
    }

    public void exit(int spot) {
        minHeap.add(spot);
    }
}

public class Problem1 {
    public static void main(String[] args) {
        parkingLot lot = new parkingLot(10);
        int spot = lot.entry();
        String print = spot == -1 ? "Parking Full" : "Entry " + Integer.toString(spot);
        System.out.println(print);
        lot.exit(10);
        System.out.println("Exit 10");
        spot = lot.entry();
        print = spot == -1 ? "Parking Full" : "Entry " + Integer.toString(spot);
        System.out.println(print);
        lot.exit(1);
        System.out.println("Exit 1");

    }
}