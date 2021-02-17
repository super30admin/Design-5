/*
import heapq
class ParkingSpace:
    
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
    

class Wrapper:                                
    def __init__(self, space):
        self.space = space
        
    def __lt__(self, other):
        if self.space.floor == other.space.floor:
            return  self.space.spot < other.space.spot
        return self.space.floor < other.space.floor 
    
class ParkingLot:    
    def __init__(self, floors, spotperfloor):
        self.heap = []
        self.floor = floors
        self.spotperfloor = spotperfloor
        
    def park(self):
        if len(self.heap) == 0:
            return "No space available"
        w = heapq.heappop(self.heap)
        return (w.space.floor, w.space.spot)
    
    def unpark(self, floor, spot):
        self.addParkingSpot(floor, spot)
    
    def addParkingSpot(self, floor, spot):
        if floor > self.floor:
            return "Invalid floor"
        
        if spot > self.spotperfloor:
            return "Invalid spot"
        
        p = ParkingSpace(floor, spot)
        heapq.heappush(self.heap, Wrapper(p))
    
    def getNextSpot(self):
        if len(self.heap) > 0:
            return self.heap[0]
    
    

s = ParkingLot(10, 5)
s.addParkingSpot(0,2)
s.addParkingSpot(1,2)
s.addParkingSpot(0,7)
s.addParkingSpot(0,0)
s.addParkingSpot(5,5)
s.addParkingSpot(1,1)

print(s.park())
print(s.park())
print(s.park())
print(s.park())

print(s.park())
s.unpark(5,5)
s.unpark(0,0)
print(s.park())

*/

// Time - O(log(m*n)) where m and n are floor and spot number 
// Space - O(log(m*n))
// Logic - Added the parking spots to heap so that lowest spot will be fetched first
public class Main {
    public static class ParkingSpot{
    int floor;
    int spot;
    public ParkingSpot(int f, int s){
        this.floor = f;
        this.spot = s;
    }
    public int getFloor(){
        return this.floor;
    }
    public int getSpot(){
        return this.spot;
    }
}
    
    public static class ParkingLot{
        PriorityQueue<ParkingSpot> p;
        int floors;
        int spotsperfloor;
        
        public ParkingLot(int floors, int spots){
            this.floors = floors;
            this.spotsperfloor = spots;
            p = new PriorityQueue<>((a,b) -> {
                if (a.floor == b.floor)
                    return a.spot - b.spot;
                return a.floor - b.floor;
            });
        }
        
        public ParkingSpot park(){
            if (p.isEmpty())
                throw new IllegalArgumentException("Parking lot full");
            
            return p.poll();
        }
        public void unpark(int floor, int spot){
            addParking(floor, spot);
        }
        public void addParking(int floor, int spot){
            if (floor > floors)
                throw new IllegalArgumentException("Invalid floor");
            
            if (spot > spotsperfloor)
                throw new IllegalArgumentException("Invalid spot");
            
            ParkingSpot ps = new ParkingSpot(floor, spot);
            p.add(ps);
        }
        
        public ParkingSpot getnext(){
            return p.peek();
        }
    }
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10, 5);
        pl.addParking(0,1);
        pl.addParking(0,4);
        pl.addParking(0,0);
        pl.addParking(2,1);
        pl.addParking(10,1);
        ParkingSpot s = pl.park();
        System.out.println(s.getFloor() + " "+ s.getSpot());
         s = pl.park();
        System.out.println(s.getFloor() + " "+ s.getSpot());
        pl.unpark(0,0);
        s = pl.park();
        System.out.println(s.getFloor() + " "+ s.getSpot());
        
    }
}