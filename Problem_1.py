import heapq
#DESIGN A PARKING LOT
class ParkingSpot:
    #initialize the floor and spot
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor
    
    def getSpot(self):
        return self.spot
    
class ParkingLot:
    #initialize the parking lot by providing the number of floors and spots per floor
    def __init__(self, floors, spots):
        self.floors = floors
        self.spots = spots
        self.lot = [[None for j in range(self.spots)] for i in range(self.floors)]
        
        self.space = []

        for floor in range(self.floors):
            for spot in range(self.spots):
                heapq.heappush(self.space,(floor, spot))
    
    def park(self):

        #allocate a parking spot, pop from the heap the nearest parking spot and initialize it

        availableSpot = heapq.heappop(self.space)

        parkSpot = ParkingSpot(availableSpot[0], availableSpot[1])
        self.lot[availableSpot[0]][availableSpot[1]] = parkSpot

        return vars(self.lot[availableSpot[0]][availableSpot[1]])
    

    def unpark(self, parkingSpot):

        #deallocate a parking spot, make the spot None and push it to heap
        floor = parkingSpot.getFloor()
        spot = parkingSpot.getSpot()
        heapq.heappush(self.space,(floor,spot))

        self.lot[floor][spot] = None
        return self.lot[floor][spot]
    
parkingLot = ParkingLot(4, 10)
for cnt in range(10):
    print(parkingLot.park())
print(parkingLot.unpark(parkingLot.lot[0][8]))
