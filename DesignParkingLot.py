# Time Complexity : addParkingSpot, unpark, park – O(log (F * S)) (heap operations) / getNextAvailable – O(1)
# Space Complexity : O(F * S) where F = floors, S = spots per floor
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We’re using heap to always pick the spot with the lowest floor and lowest spot number.
# When someone parks, we remove the best spot from the heap.
# If someone unparks, we just add that spot back to the heap again.


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
        return self.floor < other.floor

class ParkingLot:
    def __init__(self, maxFloors, spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.pq = []

    def park(self):
        if not self.pq:
            raise Exception("Error: Parking lot is full")
        re = heapq.heappop(self.pq)
        return re

    def unpark(self, floor, spot):
        newSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, newSpot)

    def getNextAvailable(self):
        return self.pq[0]

    def addParkingSpot(self, floor, spot):
        if floor > self.maxFloors:
            raise Exception("Error floor input greater than max allowed")
        if spot > self.spotsPerFloor:
            raise Exception("Error: spots input greater than max allowed")
        newSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, newSpot)

if __name__ == "__main__":
    pl = ParkingLot(3, 2)
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
