# Approach:
# System Level requirements
    * First come first serve basis for parking ?
    * How many entry and exit points - - - > assume single for now
    * How do we fill matrix/grid/spots -- which DS to use? Stacks or priority queues
    
# Spot level requirements
    * Assume no distinction between spot types(reserved, handicap, compact only etc)
    * Spot is empty or not
    * How do we map the spots to the vehicle parked

# DS Choice - Min heaps

# Why not simple traversal or stacks

# Brute force - Iterate over matrix and where the first spot is empty will be assigned, linear time complexity and is very expensive
# Stacks - Will not be ideal as we pop off the empty spots from top and if a farther spots gets vacant after a closer one say 2, the farther spot say 7 takes the top position in the stack

class ParkingSpace:

    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
        
    def __lt__(self, other):
        if self.floor == other.floor:
            return  self.spot < other.spot
        return self.floor < other.floor 
    
class ParkingLot:    
    def __init__(self, floors, spots_per_floor):
        self.heap = []
        self.floor = floors
        self.spots_per_floor = spots_per_floor

     # O(1)   
    def park(self):
        if len(self.heap) == 0:
            return "No space available for parking"
        
        # else return parking spot from heap
        return heapq.heappop(self.heap)
    
    # once a spot becomes free add it, we can simply call the addParkingSpot
    # O(log N)
    def unpark(self, floor, spot):
        self.addParkingSpot(floor, spot)
    
    # O(log N)
    def addParkingSpot(self, floor, spot):
        if floor > self.floor:
            return "Floor not valid"
        
        if spot > self.spots_per_floor:
            return "Spot not valid

        if len(self.heap) == 0:
            return "No empty slots available"
        
        parking_spot = ParkingSpace(floor, spot)
        heapq.heappush(self.heap, parking_spot)
    
    # O(1)
    # heap always has the empty spots, peek to see which is the next available
    def getNextAvailable(self):
        if len(self.heap) > 0:
            return self.heap[0]
    
    

 s = ParkingLot(10, 5)
 s.addParkingSpot(0,2)
 s.addParkingSpot(1,2)
 s.addParkingSpot(0,7)
 s.addParkingSpot(0,0)
 s.addParkingSpot(5,5)
 s.addParkingSpot(1,1)

 print(s.park())
 print(s.park())
 print(s.park())
 print(s.park())

 print(s.park())
 s.unpark(5,5)
 s.unpark(0,0)
 print(s.park())

