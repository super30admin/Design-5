# Time: O(logn) for park, unpark and addParking
# Space: O(n) for all available parking spots in pq
# Leetcode: None
# Issues: priority queue logic __lt__

import heapq

class ParkingSpot:                                      # case by case basis
    def __init__(self,floor,spot):
        self.floor = floor                              # every car is assigned a floor and a spot
        self.spot = spot

    def __lt__(self,other):                             # priority logic for heap
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor

class ParkingLot:                                       # all of parking
    def __init__(self,max_floors, spotsPerFloor):
        self.max_floors = max_floors
        self.spotsPerFloor= spotsPerFloor
        self.pq = []

    def park(self):
        if not self.pq:                                 # can we park the car?
            raise Exception("Parking Lot Full")
        return heapq.heappop(self.pq)
    

    def unpark(self,floor,spot):                        # I dont need parking anymore
        new_spot = ParkingSpot(floor, spot)             # spot is free now
        heapq.heappush(self.pq, new_spot)

    def getNextAvailable(self):                         # Does the parking lot have a parking spot available?
        if not self.pq:
            raise Exception("No avaialble Spots")
        return self.pq[0]

    def addParkingSpot(self, floor, spot):
        if floor > self.max_floors:
            raise Exception("greater than max floors")
        if spot > self.spotsPerFloor:
            raise Exception("greater than max spots")
        new_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, new_spot)

if __name__ == "__main__":
    pl = ParkingLot(10, 20)
    pl.addParkingSpot(1, 1)
    pl.addParkingSpot(2, 1)
    pl.addParkingSpot(3, 1)
    pl.addParkingSpot(1, 2)
    pl.addParkingSpot(2, 2)
    pl.addParkingSpot(3, 2)

    n1 = pl.getNextAvailable()
    print(f"Parked at Floor: {n1.floor}, Slot: {n1.spot}")
    pl.park()

    n2 = pl.getNextAvailable()
    print(f"Parked at Floor: {n2.floor}, Slot: {n2.spot}")
    pl.park()

    n3 = pl.getNextAvailable()
    print(f"Parked at Floor: {n3.floor}, Slot: {n3.spot}")
    pl.unpark(1, 2)

    n4 = pl.getNextAvailable()
    print(f"Parked at Floor: {n4.floor}, Slot: {n4.spot}")

    # pl.addParkingSpot(10, 21) # exception
    n5 = pl.unpark(11,21)
