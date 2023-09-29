static class ParkingSpot{
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

static class ParkingLot{
    int maxFloor;
    int spotPerFloor;
    PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a-b)->{
        if(a.floor == b.floor) return a.spot - b.spot; // Here we are returning on basis of spot on sam floor.
        return a.floor-b.floor; // Here we are returning on basis of floor.
    });
    public ParkingLot(int maxFloors, int spotPerFloor){
        this.maxFloor = maxFloor;
        this.spotPerFloor = spotPerFloor;
    }
}
    public ParkingSpot park(){
        if(pq.isEmpty()){
            throw new IllegalStateException("Excpetion.")
        }
        ParkingSpot result = pq.remove();
        return result;
    }

    public ParkingSpot getNextAvailble{
        return pq.peek();
    }

    public void unpark{
        ParkingSpot sp = new ParkingSpot(floor,spot);
        pq.add(sp);
    }
public void addParkingSpot(int floor, int spot){
    if(floor> maxFloors){
        throw new IllegalStateException("Floor input is greater than max allowed");
    }
    if(spot>spotPerFloor){
        throw new IllegalStateException("Spot input is greater than max allowed.");
    }

    ParkingSpot sp = new ParkingSpot(floor,spot);
    pq.add(sp);

}