import heapq

class ParkingLot:
    def __init__(self, maxFloors, maxSpots):
        self.maxFloors = maxFloors
        self.maxSpots = maxSpots
        self.pq = []
    
    def getNextSpot(self):
        if not self.pq:
            raise Exception("Parking lot is full!")
        return self.pq[0]
    
    def park(self):
        if not self.pq:
            raise Exception("Parking lot is full!")
        res = heapq.heappop(self.pq)
        return res
        
    
    def unPark(self, floor, spot):
        newSpot = (floor, spot)
        heapq.heappush(self.pq, newSpot)
    
    def addSpot(self, floor, spot):
        if floor>self.maxFloors:
            raise ValueError("Floor number is exceeding maximum floors")
        if spot>self.maxSpots:
            raise ValueError("Spot number is exceeding maximum spots per floor")
        
        heapq.heappush(self.pq,(floor, spot))

PLot = ParkingLot(10, 10)
PLot.addSpot(2, 3)
PLot.addSpot(1, 2)
PLot.addSpot(1, 1)
PLot.addSpot(3, 1)

print("Next available:", PLot.getNextSpot())
print("Car parked at:", PLot.park())
print("Car parked at:", PLot.park())
print("Next available:", PLot.getNextSpot())
PLot.unPark(1,1)
print("Next available after unpark:", PLot.getNextSpot())
print("Car parked at:", PLot.park())
print("Car parked at:", PLot.park())
print("Car parked at:", PLot.park())
#print("Car parked at:", PLot.park())