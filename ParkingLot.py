
import heapq
class ParkingLot:
    def __init__ (self, maxFloors, maxSpots):
        self.maxFloors = maxFloors
        self.maxSpots = maxSpots        
        self.pq = []
        
    def park(self):
        if not self.pq:
            raise Exception("Sorry, no Space available")
        #return self.pq.heappop()
        return heappop(self.pq)
        
    def unpark(self, floor, spot):
        #p = ParkingSpace(floor,spot)
        #self.pq.heappush(p)
        heappush(self.pq,(floor,spot))
    
    def addParkingSpot(self ,floor, spot):
        if floor > self.maxFloors:
            raise Exception("Sorry, Invalid floor")
        if spot > self.maxSpots:
            raise Exception("Sorry, Invalid spot")
        #p = ParkingSpace(floor,spot)
        heappush(self.pq,(floor,spot))
    
    def getNextAvailable(self):
        if not self.pq:
            raise Exception("Sorry, no Space available")
        #return self.pq[0]
        return self.pq[0]
        
    
    
class ParkingSpace:
    def __init__ (self,floor,spot):
        self.floor = floor
        self.spot = spot
    
    def getFloor(self):
        return self.floor
    
    def getSpot(self):
        return self.Spot
    
def main():
    #print("Hello World")
    plot = ParkingLot(50,50)
    plot.addParkingSpot(0,0)
    plot.addParkingSpot(1,0)
    plot.addParkingSpot(2,0)
    plot.addParkingSpot(3,0)
    plot.addParkingSpot(4,0)
    
    print(f"Parked at {plot.park()}"  )
    print(f"Next available Spot { plot.getNextAvailable()}" )
    print(f"Parked at {plot.park()}"  )
    print(f"Next available Spot { plot.getNextAvailable()}" )
    print(f"Parked at {plot.park()}"  )
    print(f"Next available Spot { plot.getNextAvailable()}" )
    
    plot.unpark(0,0)
    print(f"Unparked (0, 0 )" )
    print(f"Next available Spot { plot.getNextAvailable()}" )
    print(f"Parked at {plot.park()}"  )
   

    
    
    
if __name__ == "__main__":
    main()
