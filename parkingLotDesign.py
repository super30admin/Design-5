from collections import deque
import heapq
class ParkingSpot:
    
    # initialize the floor and spot
    def __init__(self,floor,spot):
        self.floor = floor
        self.spot = spot
    
    # get the floor
    def getFloor(self):
        return self.floor
    
    # get the spot
    def getSpot(self):
        return self.spot

class ParkingLot:
    
    # initialize totalFloor and totalSlots avaialble in a singleFloor
    def __init__(self,floors,slots):
        self.floors = floors
        self.slots = slots
        
        # initlize a parking grid space
        self.parkingGrid = [[None for col in range(0,self.slots)]for row in range(0,self.floors)]
        
        # initlize parking space
        self.parkingSpace = []
        
        # add the floors and slots to the minHeap
        for floor in range(0,self.floors):
            for slot in range(0,self.slots):
                heapq.heappush(self.parkingSpace,(floor,slot))
    
    # park the vehicle
    def parkVehicle(self):
        '''extract the min from the queue and park'''
        
        # get the spot i.e extract the minfrom the queue
        availableSpot = heapq.heappop(self.parkingSpace)
        
        # create an object of parkingSpot and park the car in the parkingGrid
        parkingSpot = ParkingSpot(availableSpot[0],availableSpot[1])
        self.parkingGrid[availableSpot[0]][availableSpot[1]] = parkingSpot
        
        return vars(self.parkingGrid[availableSpot[0]][availableSpot[1]])
    
    # unpark the vehicle
    def unparkVehicle(self,parkingSpot: ParkingSpot):
        '''provide the spot and pueh to the queue'''
        # parkingSpot will be the obj of ParkingSpot class
        
        # get the floor
        floor = parkingSpot.getFloor()
        
        # get the spot
        spot = parkingSpot.getSpot()
        
        # add to the priorityQueue
        heapq.heappush(self.parkingSpace,(floor,spot))
        
        # set the parkingGrid to None
        self.parkingGrid[floor][spot] = None        
        
        return self.parkingGrid[floor][spot]

parkingLot = ParkingLot(floors=4,slots=10)

# park 10 vehicles
for count in range(0,10):
    parkingLot.parkVehicle()
    
# unpark the vehicles
parkingLot.unparkVehicle(parkingLot.parkingGrid[0][0])
parkingLot.unparkVehicle(parkingLot.parkingGrid[0][8])
print(f"Floor 0 is:\t{parkingLot.parkingGrid[0]}")