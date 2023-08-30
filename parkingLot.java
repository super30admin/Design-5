import java.util.PriorityQueue;

class ParkingSpot{
    int floor;
    int spot;
    ParkingSpot(int floor, int spot){
        this.floor = floor;
        this.spot = spot;
    }

    public int getFloor(){
        return this.floor;
    }

    public int getSpot(){
        return this.spot;
    }
}

class ParkingLot{
    int maxFloors;
    int maxParkingSpotsPerFloor;
    PriorityQueue<ParkingSpot> pq;

    public ParkingLot(int maxFloors, int maxParkingSpotsPerFloor){
        this.maxFloors = maxFloors;
        this.maxParkingSpotsPerFloor = maxParkingSpotsPerFloor;
        pq = new PriorityQueue<>((a,b) -> {
            if(a.floor == b.floor){
                return a.spot - b.spot;
            }
            return a.floor - b.floor;
        });
    }

    public ParkingSpot park(){ // O(1)
        if(pq.isEmpty()){
            throw new IllegalArgumentException("Parking lot is full");
        }
        ParkingSpot nextAvailable = pq.poll();
        return nextAvailable;
    }

    public ParkingSpot unpark(int floor, int spot){ // O(log n)
        if(floor > maxFloors || spot > maxParkingSpotsPerFloor)
            throw new IllegalArgumentException("Invalid floor or spot");
        
        ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
        pq.add(parkingSpot);
        return parkingSpot;
    }

    public ParkingSpot getNextAvailable(){ // O(1)
        if(pq.isEmpty()){
            throw new IllegalArgumentException("No parking spots are available");
        }

        return pq.peek();
    }

    public void addParkingSpot(int floor, int spot){ // O(log n)
        if(floor > maxFloors || spot > maxParkingSpotsPerFloor)
            throw new IllegalArgumentException("Invalid floor or spot");
        ParkingSpot parkingSpot = new ParkingSpot(floor, spot);
        pq.add(parkingSpot);
    }
}