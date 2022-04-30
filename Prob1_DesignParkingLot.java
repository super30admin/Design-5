class ParkingLot{
    int totalFloors;
    int spotsPerFloor;
    PriorityQueue<Spot> queue;
    
    public ParkingLot(int totalFloors, int spotsPerFloor){
        this.totalFloors = totalFloors;
        this.spotsPerFloor = spotsPerFloor;
        
        queue = new PriorityQueue<>(
            (a,b) -> {
                if(a.fl == b.fl)    return a.num - b.num;
                
                return a.fl - b.fl;
            }
        );
        
    }
    
    public void addSpot(int f, int s){
        if(f > totalFloors){
            System.out.println("Floor number > TotalFloors is not allowed");
        }
        Spot sp = new Spot(f,s);
        queue.add(sp);
    }
    
    public Spot parkCar(){
        if(queue.isEmpty()){
           System.out.println("NO spots available"); 
        }
        
        Spot temp = queue.peek();
        queue.remove();
        return temp;
    }
    public void unparkCar(int floor, int spot){
        Spot sp = new Spot(floor, spot);
        queue.add(sp);
    }
    public Spot firstAvailable(){
        return queue.peek();
    }
}
class Spot{
    int fl;
    int num;
    public Spot(int floor, int spot){
        fl = floor;
        num = spot;
    }
    public int getFloor(){
        return this.fl;
    }   
        
    public int getSpot(){
        return this.num;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Parking Lot");
        
        ParkingLot ps = new ParkingLot(10, 5);
        
        ps.addSpot(1,1);
        ps.addSpot(1,5);
        
        ps.addSpot(3,1);
        
        ps.addSpot(4,1);
        ps.addSpot(4,2);
        
        
        System.out.println("First Available spot : Floor " + ps.firstAvailable().getFloor() + "  -- at spot" + ps.firstAvailable().getSpot());
        
        ps.parkCar();
        ps.parkCar();
        
        System.out.println("First Available spot : Floor " + ps.firstAvailable().getFloor() + "  -- at spot" + ps.firstAvailable().getSpot());
        ps.unparkCar(1,5);
        
        System.out.println("First Available spot : Floor " + ps.firstAvailable().getFloor() + "  -- at spot" + ps.firstAvailable().getSpot());
        
        
        
        
        
        
        
    }
}