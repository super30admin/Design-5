// Space Complexity: Priority Queue Size -> O(nm) where n is floor, m spot
		public class ParkingLot {
		    int maxFloors, spotsPerFloor;
		    PriorityQueue<ParkingSpot> pq;
		

		    public ParkingLot(int maxFloors, int spotsPerFloor)
		    {
		        this.maxFloors = maxFloors;
		        this.spotsPerFloor = spotsPerFloor;
		        pq = new PriorityQueue<>((a,b) -> {
		            if(a.floor == b.floor)
		                return a.spot - b.spot;
		            else
		                return a.floor - b.floor;
		        }); 
		    }
		

		    // O(logn) where n is all parking spots
		    public void addParkingSpot(int floor, int spot)
		    {
		        if(floor > maxFloors)
		            throw new IllegalArgumentException("Invalid floor");
		        if(spot > spotsPerFloor)
		        throw new IllegalArgumentException("Invalid spot");
		

		        pq.offer(new ParkingSpot(floor, spot));
		    }
		

		    // check if available O(1)
		    public ParkingSpot getNextAvailableSpot()
		    {
		        return pq.peek();
		    }
		

		    // O(logn)
		    public ParkingSpot park()
		    {
		        if(pq.isEmpty())
		            throw new IllegalArgumentException("Parking lot is full");
		        else
		            return pq.poll();
		    }
		

		    // O(logn)
		    public void unPark(int floor, int spot)
		    {
		        pq.offer(new ParkingSpot(floor, spot));
		    }
		

		    public class ParkingSpot {
		        int floor;
		        int spot;
		

		        public ParkingSpot(int floor, int spot)
		        {
		            this.floor = floor;
		            this.spot = spot;
		        }
		

		        private int getFloor()
		        {
		            return floor;
		        }
		

		        private int getSpot()
		        {
		            return spot;
		        }
		    }
		}


