class ParkingLot{
    int maxFloors;
    int spotsPerFloor;
    
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
        if(a.floor == b.floor) return a.spot - b.spot;
        return a.floor - b.floor;
    });
    
    public ParkingLot(int maxFloors, int spotsPerFloor){
        this.maxFloors = maxFloors;
        this.spotsPerFloor = spotsPerFloor;
    }
    
    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Parking lot is full");
        }
        
        ParkingSpot re = pq.remove;
        return re;
    }
    
    public ParkingSpot getNextAvailable(){
        return pq.peek();
    }
    
    public void unpark(int floor, int spot){
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
        
    }
    
    public void addParkingSpot(int floor, int spot){
        if(floor > maxFloors){
            throw new IllegalArgumentException("floor input is greater than max allowed");
        }
        
        if(spot > spotsPerFloor){
            throw new IllegalArgumentException("spots input is greater than max allowed");
        }
        
        
        ParkingSpot newSpot = new ParkingSpot(floor, spot);
        pq.add(newSpot);
        
        
    }
    
    
}

class ParkingSpot{
    int floor;
    int spot;
    public ParkingSpot(int floor, int spot){
        this.floor = floor;
        this.spot = spot;
    }
    
    public int getSpot(){
        return this.spot;
    }
    
    public int getFloor(){
        return this.floor;
    }
}
