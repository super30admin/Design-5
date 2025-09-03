import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
        
    def getSpot(self):
        return self.spot
    
    def getFloor(self):
        return self.floor
    
    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor<other.floor

class ParkingLot:
    def __init__(self, maxFloors, spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.pq = []
    
    def park(self):
        # whenever we park we remove the spot from the heap
        if not self.pq:
            raise Exception("Error: Parking Lot is Full")
        re = heapq.heappop(self.pq)
        return re
    
    def unpark(self, floor, spot):
        # whenever you unpark push to the heapq
        newspot = ParkingSpot(floor,spot)
        heapq.heappush(self.pq, newspot)
    
    def getNextAvailable(self):
        return self.pq[0]
    
    def addParkingSpot(self,floor,spot):
        if floor>self.maxFloors:
            raise Exception("Floor input greater than mnax allowed")
        if spot>self.spotsPerFloor:
            raise Exception("Spots input greater than max allowed")
        newSpot = ParkingSpot(floor,spot)
        heapq.heappush(self.pq, newSpot)
if __name__ == "__main__":
    pl = ParkingLot(3,2)
    pl.addParkingSpot(1, 1)
    pl.addParkingSpot(2, 1)
    pl.addParkingSpot(3, 1)
    pl.addParkingSpot(1, 2)
    pl.addParkingSpot(2, 2)
    pl.addParkingSpot(3, 2)
    n = pl.getNextAvailable()
    print("Parked at Floor:", n.getFloor(), ", Slot:", n.getSpot())
    pl.park()
    n2 = pl.getNextAvailable()
    print("Parked at Floor:", n2.getFloor(), ", Slot:", n2.getSpot())
    pl.unpark(1, 1)
    n1 = pl.getNextAvailable()
    print("Parked at Floor:", n1.getFloor(), ", Slot:", n1.getSpot())        
    
    