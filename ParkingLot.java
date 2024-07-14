// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ParkingSpot {
    public ParkingSpot(int floor, int spot) {
        this.floor = floor;
        this.spot = spot;
    }

    public int getSpot() {
        return this.spot;
    }

    public int getFloor() {
        return this.floor;
    }
}

class ParkingLot {
    int maxFloors;
    int spotsPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) ->{
        if(a.floor == b.floor)
            return a.spot - b.spot;
        return a.floor - b.floor;
    });

    public ParkingLot(int maxFloors, int spotsPerFloor) {
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }

    public ParkingSpot park() {
        if(pq.isEmpty()){
            throw new IllegalStateException("Error: Parking lot is full");
        }

        ParkingSpot re = pq.remove();
        return re;
    }

    public void unpark(int floor, int spot){
        ParkingSpot newspot = new ParkingSpot(floor, spot);
        pq.add(newspot);
    }

    public ParkingSpot getNextAvailable() {
        return pq.peek();
    }

    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors){
            throw new IllegalArgumentException("Error: floor input greater than max allowed");
        }

        if(spot > spotsPerFloor){
            throw new IllegalArgumentException("Error: spots input greater than max allowed");
        }

        ParkingSpot newspot = new ParkingSpot(floor, spot);
        pq.add(newspot);
    }

    public static void main(String[] args){
        ParkingLot pl = new ParkingLot(3,2);
        pl.addParkingSpot(1,1);
        pl.addParkingSpot(2,1);
        pl.addParkingSpot(3,1);
        pl.addParkingSpot(1,2);
        pl.addParkingSpot(2,2);
        pl.addParkingSpot(3,2);
        ParkingSpot n = pl.getNextAvailable();
        System.out.println("Parked at Floor: "+ n.getFloor() + ", Slot: "+n.getSpot());
        pl.park();
        ParkingSpot n2 = pl.getNextAvailable();
        System.out.println("Parked at Floor: "+ n2.getFloor() + ", Slot: "+n2.getSpot());
        pl.unpark(1,1);
        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at Floor: "+ n1.getFloor() + ", Slot: "+n1.getSpot());

    }
}