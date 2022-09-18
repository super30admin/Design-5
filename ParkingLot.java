//TC : O(long(n))
//SC : O(m*n)

import java.io.*;

import java.util.PriorityQueue;

class Parking {

	public static void main (String[] args) {
        ParkingLot parking = new ParkingLot(20, 100);
        parking.addParkingSpot(1, 20);
        parking.addParkingSpot(8, 12);
        parking.addParkingSpot(3, 20);
        parking.addParkingSpot(1, 11);
        parking.addParkingSpot(9, 7);
        parking.addParkingSpot(3, 1);
        
        ParkingSpot n = parking.getNextAvailable();

        System.out.println("Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        parking.park();
        n = parking.getNextAvailable();
        System.out.println("Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        parking.unpark(1, 1);
        n = parking.getNextAvailable();
        System.out.println("Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
	}

	 static class ParkingSpot{
        int floor; int spot;
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

	 static class ParkingLot {
        int maxFloors; int spotsPerFloor;
        PriorityQueue <ParkingSpot> pq  = new PriorityQueue<>((a,b) -> {
            if(a.floor == b.floor) return a.spot - b.spot;
            return a.floor - b.floor;
        });
        public ParkingLot(int maxFloors, int spotsPerFloor){
            this.maxFloors = maxFloors; this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park(){
            if(pq.isEmpty()){
                throw new IllegalStateException("Parking lot is full");
            }
            return pq.remove();
        }
        public ParkingSpot getNextAvailable(){
            return pq.peek();
        }

        public void unpark(int floor, int spot){
            pq.add(new ParkingSpot(floor, spot));
        }
         
        public void addParkingSpot(int floor, int spot){
            if(floor > maxFloors){
                throw new IllegalArgumentException("floor does not exist");
            }
             if(spot > spotsPerFloor){
                throw new IllegalArgumentException("spot does not exists");
            }
            ParkingSpot newSpot = new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }
}

