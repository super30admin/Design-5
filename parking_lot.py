import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
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
    def __init__(self, maxFloor, spotsPerFloor):
        self.maxFloors = maxFloor
        self.spotsPerFloor = spotsPerFloor
        self.heap = []

    def addParkingSlot(self, floor, spot):
        if floor > self.maxFloors:
            raise Exception("Floor number is greater than the maximum available floors")
        if spot > self.spotsPerFloor:
            raise Exception("Spot number is greater than the maximum available spots per floor")
        newParkingSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.heap, newParkingSpot)

    def getAvailability(self):
        if len(self.heap) == 0:
            raise Exception("No Parking Spots are avaialble")
        availableParkingSlot = self.heap[0]
        return availableParkingSlot

    def park(self):
        return heapq.heappop(self.heap)

    def unPark(self, floor, spot):
        newParkingSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.heap, newParkingSpot)