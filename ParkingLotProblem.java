import java.util.PriorityQueue;

public class ParkingLotProblem {
    static class ParkingSpot{
        private int floor;
        private int spot;

        ParkingSpot(int floor, int spot){
            this.floor = floor;
            this.spot = spot;
        }

        private int getSpot(){
            return spot;
        }

        private int getFloor(){
            return floor;
        }
    }

    static class ParkingLot{
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) ->{
            if(a.floor == b.floor) return a.spot - b.spot;
            return a.floor - b.floor;
        });

        ParkingLot(int maxFloors, int spotsPerFloor){
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park(){
            if(pq.isEmpty()){
                throw new IllegalStateException("Parking lot is full");
            }
            ParkingSpot re = pq.remove();
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
            if(floor > maxFloors) throw new IllegalArgumentException("Floor input greater than max allowed");
            if(spot > spotsPerFloor) throw new IllegalArgumentException("Spot input greater than max allowed");
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }    
}