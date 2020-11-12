// Time Complexity: AddCar : O(log(N)) RemoveCar : O(log(N)) getAllOccupiedSpace : O(N) closesEmptySpace : O(1)
// Space Complexity: O(N)

import java.util.*;
class Problem1 {
    int size;
    PriorityQueue<Integer> vacantLots;
    HashMap<Integer, Integer> occupiedLots;

    public List<Integer> getNumbersInRange(int size) {
	    List<Integer> result = new ArrayList<>();
	    for (int i = 0; i < size; i++) {
	        result.add(i);
	    }
	    return result;
	}
    public Problem1(int parkingLotSize) {
        size = parkingLotSize;
        
        vacantLots = new PriorityQueue<>(getNumbersInRange(size)); 
        occupiedLots = new HashMap<>();
    }

    public List<Integer> getAllOccupiedSpace() {

        List<Integer> occupiedList = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : occupiedLots.entrySet()) {
            occupiedList.add(entry.getValue());
        }  
        return occupiedList;
    }

    public int closesEmptySpace() {

        return vacantLots.peek();
    }

    public boolean removeCar(int carId) {

        if (!occupiedLots.containsKey(carId)) 
            return false;
        
        int occupiedSlot = occupiedLots.get(carId);
        occupiedLots.remove(carId);
        vacantLots.add(occupiedSlot);
        return true;
    }

    public boolean addCar(int carId) {
        
        if (!vacantLots.isEmpty())
            return false;
        

        int emptySpot = vacantLots.poll();
        occupiedLots.put(carId, emptySpot);
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Heelo");
    }
}