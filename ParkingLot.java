/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
	
	public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(3, 2);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);

        ParkingSpot n = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        pl.park();

        ParkingSpot n2 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unpark(1, 1);

        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    }
    
    public static class ParkingSpot{
    int floor;
    int spot;
    
    public ParkingSpot(int floor, int spot){
       this.floor=floor;
        this.spot=spot;
    }
    
    private int getFloor(){
        return this.floor;
    }
    
    private int getSpot(){
        return this.spot;
    }
}

public static class ParkingLot{
    int floor;
    int spot;
    
    public ParkingLot(int floor, int spot){
        this.floor=floor;
        this.spot=spot;
    }

  //Holds parking spots and gives in the manner we request or we need
   PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]); // Compare spots if floors are equal
    }
    return Integer.compare(a[0], b[0]); // Compare floors
});
    
    private void addParkingSpot(int floor, int spot){
       
        queue.add(new int[]{floor,spot});
    }
    
    private ParkingSpot getNextAvailable(){
        if(queue.isEmpty()){
            return null;
        }else{
            int[] ans=queue.peek();
            return new ParkingSpot(ans[0],ans[1]);
            
        }
    }
    
    //park 
    private void park(){
        queue.poll();
    }
    
    private void unpark(int floor, int spot){
        queue.add(new int[]{floor,spot});
        
    }
    
}
	
}

