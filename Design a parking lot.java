class Main {
    
    static class ParkingSpot
    {
        int spot;
        int floor;
        
        public ParkingSpot(int floor,int spot)
        {
            this.floor=floor;
            this.spot=spot;
        }   
        public int getFloor()
        {
            return this.floor;
        }
        public int getSpot()
        {
            return this.spot;
        }
        
    }
    
    static class ParkingLot
    {
        int maxFloor;
        int maxSpot;
        PriorityQueue <ParkingSpot> pq=new PriorityQueue<>((a,b)->
                                             {if(a.floor==b.floor) return a.spot-b.spot;
                                            return a.floor-b.floor;
                                             });
          
        public ParkingLot(int maxFloor,int maxSpot)
        {
            this.maxFloor=maxFloor;
            this.maxSpot=maxSpot;
        }
        // park
        public ParkingSpot park()
        {
            //if there are no vacant spots in the priority queue
            if(pq.isEmpty())
            {
                throw new IllegalStateException("Parking lot is full") ;
            }
            ParkingSpot re=pq.remove();
            return re;
        }
        
        //unpark
        public void unpark(int floor,int spot)
        {
            ParkingSpot newspot=new ParkingSpot(floor,spot);
             pq.add(newspot);
        }
        
        //get the next available spot
        public ParkingSpot getNextAvailableSpot()
        {
            return pq.peek();
        }
        //add new spot
        public void addParkingSpot(int floor, int spot)
        {
            if(floor>maxFloor)
            {
                throw new IllegalStateException("floor input greater than max allowed"); 
            }
            if(spot>maxSpot)
            {
                throw new IllegalStateException("spot input greater than max allowed"); 
            }
            
            ParkingSpot newSpot=new ParkingSpot(floor, spot);
            pq.add(newSpot);
        }
    }
    
    
    
    public static void main(String[] args) {
        ParkingLot p1=new ParkingLot(10,20); //maxFloor=10 & max spots in each floor=20
            p1.addParkingSpot(1, 1);
            p1.addParkingSpot(2, 1);
            p1.addParkingSpot(3, 1);
            p1.addParkingSpot(1, 2);
            p1.addParkingSpot(2, 2);
            p1.addParkingSpot(3, 2);
            
            ParkingSpot n=p1.getNextAvailableSpot();
        System.out.println("Parked at floor" + n.getFloor() + " ,Spot=" + n.getSpot());
            p1.park();
            ParkingSpot n1=p1.getNextAvailableSpot();
        System.out.println("Parked at floor" + n1.getFloor() + " ,Spot=" + n1.getSpot());
            
            p1.unpark(1,1);
            ParkingSpot n2=p1.getNextAvailableSpot();
        System.out.println("Parked at floor" + n2.getFloor() + " ,Spot=" + n2.getSpot());
    }
}


      
  
    