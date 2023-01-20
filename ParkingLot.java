//TC:nlogn
//SC: o(n)
//n -> number of floors*slots

public class main {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(3,2);
        pl.addParkingSlot(1,1);
        pl.addParkingSlot(2,1);
        pl.addParkingSlot(3,1);
        pl.addParkingSlot(1,2);
        pl.addParkingSlot(2,2);
        pl.addParkingSlot(3,2);

        ParkingSlot n = pl.nextAvailable();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSlot());
        pl.park();
        pl.park();
        pl.park();
        pl.park();
        pl.park();
        ParkingSlot n2 = pl.nextAvailable();
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSlot());
        pl.unpark(1,1);
        ParkingSlot n1 = pl.nextAvailable();
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSlot());
    }
    static class ParkingLot{
        int maxFloors; int slotsPerFloor;
        public ParkingLot(int floors, int slots){
            maxFloors = floors;
            slotsPerFloor = slots;
        }
        Queue<ParkingSlot> queue = new PriorityQueue<>((a,b) ->{
            if(a.floor == b.floor) return a.slot-b.slot;
            return a.floor-b.floor;
        });
        private ParkingSlot nextAvailable(){//0(1)
            if(queue.isEmpty())
                throw new IllegalArgumentException("Parking Lot Full");
            return queue.peek();
        }
        private ParkingSlot park(){//log(n)
            if(queue.isEmpty())
                throw new IllegalArgumentException("Parking Lot Full");
            return queue.poll();
        }
        private void unpark(int floor, int slot){//log(n)
            queue.add(new ParkingSlot(floor,slot));
        }
        private void addParkingSlot(int floor, int slot){//log(n)
            if(floor> maxFloors) 
                throw new IllegalArgumentException("not a valid floor");
            if(slot> slotsPerFloor) 
                throw new IllegalArgumentException("not a valid slot");
            queue.add(new ParkingSlot(floor,slot));
        }
    }
    static class ParkingSlot{
        int floor; int slot;
        public ParkingSlot(int floor,int slot){
            this.floor = floor;
            this.slot = slot;
        }
        private int getFloor(){
            return this.floor;
        }
        private int getSlot(){
            return this.slot;
        }
    }
}
