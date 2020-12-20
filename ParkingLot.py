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
    parkingSpot.__lt__ = lambda a, b : a.spot<b.spot if a.floor == b.floor else a.floor<b.floor
    def __init__(self, floors, spots):
        self.floors = floors
        self.spots = spots
        self.heap = []

    def park(self):
        #what does park mean? pop it off the heap saying its taken
        if self.heap:
            heappop(self.heap)
        else:
            return "Empty"


    def unPark(self, floor, spot):
        self.addParkingSpot(floor, spot)

    def addParkingSpot(self, floor, spot):
        if 0<=floor<self.floors and 0<=spot<=self.spots:
            #Add to the heap based on the comparator above
            newSpot = parkingSpot(floor,spot)
            heapq.heappush(self.heap, newSpot)
        else:
            return "Invalid Entry"


    def getNextAvailable(self):
        return self.heap[0]




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
