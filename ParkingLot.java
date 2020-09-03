class ParkingLot {
    int numberOfFloors;
    int spotsPerFloor;
    //heap to store the spots in increaing order of floor number and increasing order of spot numbers (in case of equal floor number)
    PriorityQueue<ParkingSpot> support; 
    
    //multi-threading is used if number of entrances and exits are more than 1
    
    public ParkingLot(int numberOfFloors, int spotsPerFloor) {
        this.numberOfFloors = numberOfFloors;
        this.spotsPerFloor = spotsPerFloor;
        support = new PriorityQueue<>((a, b) -> { 
            if(a.getFloor() == b.getFloor())                           
            {
                return a.getSpot() - b.getSpot();
            }
            else
            {
                return a.getFloor() - b.getFloor();
            }
        });
    }
    
    //done initially(only once) - O(mn log(mn)) - m - # of floors and n - # of spots per floor
    public void addSpots() {
        for(int i = 0; i < numberOfFloors; i++)
        {
            for(int j = 0; j < spotsPerFloor; j++)
            {
                support.offer(new ParkingSpot(i, j));
            }
        }
    }
    
    //time - O(log mn)
    public void addSpot(int floor, int spot) {
        if(support.size() == numberOfFloors * spotsPerFloor)
        {
            throw new IllegalArgumentException("Parking lot is full");
        }
        support.offer(new ParkingSpot(floor, spot));
    }
    
    //time - O(1)
    //return root of the heap
    public ParkingSpot getNextAvailable() {
        if(support.size() == 0)
        {
            throw new IllegalStateException("Parking Lot is full");
        }
        return support.peek();
    }
    
    //time - O(log mn)
    //delete root to return that spot and percolation occurs
    public ParkingSpot park() {
        if(support.size() == 0)
        {
            throw new IllegalStateException("Parking Lot is full");
        }
        return support.poll();
    }
    
    //time - O(log mn)
    //add spot to heap and percolation occurs
    public void unPark(int floor, int spot) {
        support.offer(new ParkingSpot(floor, spot));
    }
}

class ParkingSpot {
    //floor number and spot number combines to form primary key of parking spot
    private int floorNumber; 
    private int spotNumber;
    //constructor
    public ParkingSpot(int floorNumber, int spotNumber) {
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
    }
    //getters
    public int getFloor() {
        return this.floorNumber;
    }
    public int getSpot() {
        return this.spotNumber;
    }
    //setters
    public void setFloor(int floor) {
        this.floorNumber = floor;
        return;
    }
    public void setSpot(int spot) {
        this.spotNumber = spot;
        return;
    }
}

public class Solution {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3, 2);
        lot.addSpots();
        
        //lot.addSpot(100, 200); //expected - exception
        
        ParkingSpot next = lot.getNextAvailable();
        System.out.println("The next available slot is at Floor - " + next.getFloor() + " Spot - " + next.getSpot()); //expected - 0,0
        
        ParkingSpot car1 = lot.park();
        ParkingSpot car2 = lot.park();
        
        next = lot.getNextAvailable();
        System.out.println("The next available slot is at Floor - " + next.getFloor() + " Spot - " + next.getSpot()); //expected - 1,0
        
        lot.unPark(car1.getFloor(), car1.getSpot());
        
        next = lot.getNextAvailable();
        System.out.println("The next available slot is at Floor - " + next.getFloor() + " Spot - " + next.getSpot()); //expected - 0,0
     }
}
