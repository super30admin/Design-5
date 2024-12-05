class Main {
	public static void main (String[] args) {      
    	ParkingLot pl = new ParkingLot(3, 2);
        System.out.println("Floors "+pl.maxFloors+" and Spots "+pl.spotsPerFloor);
        for(int i=0;i<7;i++){
            if(pl.hasSpace())
            System.out.println(pl.park(i));
            else System.out.println("Full");
        }
        System.out.println(pl.hasSpace());
        for(int i=0;i<7;i++){
            System.out.println(pl.checkSpot(i));
        }
        System.out.println(pl.unpark(2));
        System.out.println(pl.getNextAvailable());
	}
}
    class ParkingSpot{
        int floor,spot;

        public ParkingSpot(int floor, int spot){
            this.floor=floor;
            this.spot=spot;
        }
    }
    class ParkingLot {
	    int maxFloors,spotsPerFloor;
        int currFloor=0,currSpot=0;
        PriorityQueue<ParkingSpot> pq;
        HashMap<Integer,ParkingSpot> map;
        
	    public ParkingLot(int maxFloors, int spotsPerFloor){
	        this.maxFloors = maxFloors;
	        this.spotsPerFloor = spotsPerFloor;
            pq=new PriorityQueue<>((a,b)->{
                if(a.floor==b.floor) return a.spot-b.spot;
                return a.floor-b.floor;
            });
            map=new HashMap<>();
	    }
        
        public ParkingSpot getNextAvailable(){
            // System.out.println("Inside gna 1st");
            if(pq.peek()==null){
                return this.addParkingSpot();
            }
            return pq.peek();
        }
        public boolean hasSpace(){
            return (map.size()+pq.size()<this.maxFloors*this.spotsPerFloor);
        }
        public ParkingSpot unpark(int driver){
            if(!map.containsKey(driver)){
                return null;
            }
            ParkingSpot park=map.get(driver);
            pq.add(park);
            map.remove(driver);
            return park;
        }
        public ParkingSpot checkSpot(int driver){
            return map.get(driver);
        }
        private ParkingSpot addParkingSpot(){
            // System.out.println("Inside aps 1st");
            if(this.currSpot<this.spotsPerFloor)
                return new ParkingSpot(this.currFloor,this.currSpot++);
            this.currFloor++;this.currSpot=0;
            if(this.currFloor<this.maxFloors)
                return new ParkingSpot(this.currFloor,this.currSpot++);
            return null;
            
        }
        public boolean park(int driver){
            // System.out.println("Inside park 1st");
            ParkingSpot parks= this.getNextAvailable();
            if(parks!=null){
                map.put(driver,parks);
                return true;
            }
            return false;
        }
    }

