// "static void main" must be defined in a public class.

public class Main {
     public static class Spot {
            public int spotId;
            public int floorNo;
            
            public Spot(int spotId, int floorNo){
                this.spotId = spotId;
                this.floorNo = floorNo;
            }
    }
    public static class ParkingLot {
        PriorityQueue<Spot> pq;
        
        public int spotsPerFloor;
        public int maxFloors;
            
        public ParkingLot (int spotId, int maxFloors){
            this.spotsPerFloor = spotsPerFloor;
            this.maxFloors = maxFloors;
            pq = new PriorityQueue<>((a,b) -> {
                if(b.floorNo == a.floorNo){
                    return a.spotId - b.spotId;
                }
                return a.floorNo - b.floorNo;
            });
        }
        
        Spot getNextAvailableSpot(){
            if(!pq.isEmpty()){
                return pq.peek();
            }
            return null;
        }
        
        Spot park(){
            if(!pq.isEmpty()){
                return pq.poll();
            }
            return null;
        }
        
        void unpark(int spotId, int floorNo){
            addParkingSpot(spotId, floorNo);    
        }
        
        void addParkingSpot(int spotId, int floorNo){
            if(floorNo <=0 && floorNo > maxFloors){
                throw new IllegalArgumentException("Floor No is invalid");
            }
            if(spotId <=0 && spotId > spotsPerFloor){
                throw new IllegalArgumentException("Spot No is invalid");
            }
            
            pq.add(new Spot(spotId, floorNo));
        }
    }           
    
    

    public static void main(String[] args) {
        
        ParkingLot lot = new ParkingLot(10, 20);
        lot.addParkingSpot(1,1);
        lot.addParkingSpot(2,1);
        lot.addParkingSpot(1,2);
        lot.addParkingSpot(2,2);
        lot.addParkingSpot(1,3);
        lot.addParkingSpot(1,4);
        
        printNextAvailableSpot(lot);        
        lot.park(); // 1,1
        lot.park(); // 2,1        
        lot.park(); // 1,2
        printNextAvailableSpot(lot);  // 2,2
        lot.unpark(1,1); 
        printNextAvailableSpot(lot);  // 1,1
            
    }
    
private static void printNextAvailableSpot(ParkingLot lot) {
    Spot nextSpot = lot.getNextAvailableSpot();
        if(nextSpot != null){
            System.out.printf("Next available spot %d | floor %d\n",nextSpot.spotId, nextSpot.floorNo);                
        }
}
  /*
    OUTPUT :
    Next available spot 1 | floor 1
    Next available spot 2 | floor 2
    Next available spot 1 | floor 1
  */
    

}
