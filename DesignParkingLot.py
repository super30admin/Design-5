import heapq

class ParkingSpot:

    def __init__(self, floor, spot):
        self.spot = spot
        self.floor = floor

    def getSpot(self):
        return self.spot

    def getFloor(self):
        return self.floor

class ParkingLot:

    def __init__(self, spots, floors):
        self.minHeap = []
        self.maxSpotsPerFloor = spots
        self.maxFloors = floors
        ParkingSpot.__lt__  = lambda x,y: x.spot<y.spot if x.floor==y.floor else x.floor<y.floor

    #Time complexity - O(logn)  - heapify
    #Space complexity - O(n) - heap size
    def addParkingSpot(self, floor, spot):
        if spot>self.maxSpotsPerFloor:
            return "Spot choosen is out of bounds"
        if floor>self.maxFloors:
            return "Floor choosen is out of bounds"
        parkSpace = ParkingSpot(floor, spot)
        heapq.heappush(self.minHeap, parkSpace)


    # Time complexity - O(logn) - heapify
    # Space complexity - O(n) - heap size
    def park(self):
        if len(self.minHeap)<=0:
            return "No spots available"
        parkSpace = heapq.heappop(self.minHeap)
        return parkSpace.getSpot(), parkSpace.getFloor()


    # Time complexity - O(logn) - heapify
    # Space complexity - O(n) - heap size
    def unPark(self, floor, spot):
        parkSpace = ParkingSpot(floor, spot)
        heapq.heappush(self.minHeap, parkSpace)

    # Time complexity - O(1)
    # Space complexity - O(1)
    def getNextParkingSpot(self):
        return self.minHeap[0]


parkingLot = ParkingLot(5,4)

#adding parking spots
parkingLot.addParkingSpot(1,1)
parkingLot.addParkingSpot(1,2)
parkingLot.addParkingSpot(1,4)
parkingLot.addParkingSpot(3,3)
print(parkingLot.addParkingSpot(7,7))


#parking
print(parkingLot.park())
print(parkingLot.park())


#unparking
parkingLot.unPark(1,1)
parkingLot.unPark(3,2)


#show whats next available spot
res = parkingLot.getNextParkingSpot()
print(res.getFloor(),  res.getSpot())

