//  Design Parking Lot
//  https://www.careercup.com/question?id=5084295966228480

import java.util.*;

public class DesignParkingLot {
    class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a, b) -> {
            if (a.floor == b.floor) {
                return a.spot - b.spot;
            }

            return a.floor - b.floor;
        });

        public ParkingLot(int maxFloors, int spotsPerFloor) {
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park() throws Exception {
            if (pq.isEmpty()) {
                throw new Exception();
            }

            return pq.poll();
        }

        public ParkingSpot getNextAvailable() throws Exception {
            if (pq.isEmpty()) {
                throw new Exception();
            }

            return pq.peek();
        }

//        public void unPark() {
//            addParkingSpot(floor, spot);
//        }

        public void addParkingSpot(int floor, int spot) throws Exception {
            if (floor > maxFloors) {
                throw new Exception();
            }

            if (spot > spotsPerFloor) {
                throw new Exception();
            }

            ParkingSpot sp = new ParkingSpot(floor, spot);
            pq.add(sp);
        }
    }

    class ParkingSpot {
        int floor;
        int spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        public int getFloor() {
            return this.floor;
        }

        public int getSpot() {
            return this.spot;
        }
    }
}