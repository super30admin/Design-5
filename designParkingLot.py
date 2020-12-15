#Time Complexity : O(1) - getNextAvailable, O(NlogK) - unPark, addParkingSpot
#Space Complexity : O(floors*spots)
#Did this code successfully run on Leetcode : Yes

class parkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor

    def getSpot(self):
        return self.spot

class parkingLot:
    def __init__(self, floors, spots):
        self.floors = floors
        self.spots = spots
        self.priorityQueue = []

    parkingSpot.__lt__ = lambda self, next: self.spot < next.spot if self. floor == next.floor else self.floor < next.floor

    def park(self):
        if len(self.priorityQueue) == 0:
            return "Parking lot is full"
        return heapq.heappop(self.priorityQueue)

    def unPark(self, floor, spot):
        self.addParkingSpot(floor, spot)

    def addParkingSpot(self, floor, spot):
        if floor > self.floors:
            return "INVALID FLOOR"
        if spot > self.spots:
            return "INVALID SPOT"
        newParkingSpot = parkingSpot(floor, spot)
        heapq.heappush(self.priorityQueue, newParkingSpot)

    def getNextAvailable(self):
        return self.priorityQueue[0]



pl = parkingLot(10,20)
pl.addParkingSpot(1, 1)
pl.addParkingSpot(2, 1)
pl.addParkingSpot(3, 1)
pl.addParkingSpot(1, 2)
pl.addParkingSpot(2, 2)
pl.addParkingSpot(3, 2)

n = pl.getNextAvailable()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))

l = pl.park()
n = pl.getNextAvailable()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))

pl.unPark(1,1)
n = pl.getNextAvailable()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))
