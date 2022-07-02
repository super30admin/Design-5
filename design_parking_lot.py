# Time Complexity : O(log N) where N is number of parking spots
# Space Complexity : O(N) where N is number of parking spots
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import heapq as hq

class ParkingSpot:
    def __init__(self, floor, spot) -> None:
        self.floor = floor
        self.spot = spot
    
    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor
    
    def getFloor(self):
        return self.floor

    def getSpot(self):
        return self.spot

class ParkingLot:
    def __init__(self, maxFloors, maxSpots) -> None:
        self.maxFloors = maxFloors
        self.maxSpots = maxSpots
        self.queue = []
        hq.heapify(self.queue)

    def parkVehicle(self):
        if len(self.queue) == 0:
            raise Exception("Parking lot is full")
        
        return hq.heappop(self.queue)


    def unparkVehicle(self, floor, spot):
        spot = ParkingSpot(floor, spot)
        hq.heappush(self.queue, spot)

    def nextAvailableSpot(self):
        return self.queue[0]

    def addNewSpot(self, floor, spot):
        if floor > self.maxFloors:
            raise Exception("Invalid floor number")
        if spot > self.maxSpots:
            raise Exception("Invalid spot number")

        self.unparkVehicle(floor, spot)


p = ParkingLot(5,10);

p.addNewSpot(1, 1)
p.addNewSpot(2, 1)
p.addNewSpot(3, 1)
p.addNewSpot(1, 2)
p.addNewSpot(2, 2)
p.addNewSpot(3, 2)
available = p.nextAvailableSpot();
print(f"Parked at Floor {available.getFloor()} Spot {available.getSpot()}");
p.parkVehicle()
available = p.nextAvailableSpot();
print(f"Parked at Floor {available.getFloor()} Spot {available.getSpot()}");