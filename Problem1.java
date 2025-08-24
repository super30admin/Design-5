
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// ## Problem 1: 
// This problem was asked at Intuit

// Design a parking lot system where you need to provide a token 
// with the parking space number on it 
// to each new entry for the space closest to the entrance. 

// When someone leave you need update this space as empty. 
// What data structures will you use to perform the closest empty space tracking, 
// plus finding what all spaces are occupied at a give time.

class Solution {

    private Set<Integer> used;
    private PriorityQueue<Integer> available;
    private int size;

    Solution(int size) {
        this.size = size;
        used = new HashSet<>();
        available = new PriorityQueue<>();
        for (int i = 1; i <= size; ++i) {
            available.add(i);
        }
    }

    public int provideToken() {
        if (available.isEmpty()) {
            return -1;
        }

        int slot = available.poll();
        used.add(slot);
        return slot;
    }

    public void leave(int slot) {
        // only if this was removed, then add it to available
        if (used.remove(slot)) {
            available.add(slot);
        }
    }

    public List<Integer> getOccupiedSpaces() {
        return new ArrayList<>(used);
    }
}