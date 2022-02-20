class ParkingLot:
    
    # TC: O(log(N*M))
    # SC: O(N*M)
    # N --> Number of Floors
    # M --> Number of Spots at each floor
    
    def __init__(self, maxFloors, spotsPerFloor):
        import heapq
        self.heap = []
        heapq.heapify(self.heap)
        
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
            
    def park(self):
        
        self.getNextAvailable()
        
    def unpark(self, floor, spot):
        
        self.addParkingSpots(floor, spot)
        
    def getNextAvailable(self):
        
        if len(self.heap) == 0:
            raise ValueError("Full Parking Lot.")
            
        return heapq.heappop(self.heap)
        
    def addParkingSpots(self, floor, spot):
        
        if (floor > self.maxFloors):
            raise ValueError("Floor input is greater then max allowed.")
    
        if (spot > self.spotsPerFloor):
            raise ValueError("Spot input is greater then max spots allowed per floor.")
    
        currParkinSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.heap, currParkinSpot)
        
class ParkingSpot:
    
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
        
    def __lt__(self, other):
        if (self.floor == other.floor):
            return self.spot < other.spot
        else:
            return self.floor < other.floor
        
    def getFloor(self):
        return self.floor
    
    def getSpot(self):
        return self.spot
    
    def setFloor(self, floor):
        self.floor = floor
    
    def setSpot(self, spot):
        self.spot = spot