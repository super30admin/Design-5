#  Time Complexity : O(F * S) for park() and getNextAvailable(), O(1) for unpark() and addParkingSpot() 
#  Space Complexity : O(F * S) 
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: This code defines a simple parking lot system with two classes: ParkingSpot to represent a specific spot identified by its floor and number, and ParkingLot to manage available and occupied spots. The ParkingLot maintains a 2D list (occupied) to track whether each spot is free (False) or available (True). It provides methods to park a car (park), remove a car (unpark), find the next available spot (getNextAvailable), and add new parking spots (addParkingSpot).
class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
    
    def getSpot(self):
        return self.spot
    
    def getFloor(self):
        return self.floor

class ParkingLot:
    def __init__(self, maxFloor, spotsPerFloor):
        self.maxFloor = maxFloor
        self.spotsPerFloor = spotsPerFloor
        self.occupied = [[False] * (spotsPerFloor + 1) for _ in range(maxFloor + 1)]
    
    def park(self):
        for i in range(1, self.maxFloor + 1):
            for j in range(1, self.spotsPerFloor + 1):
                if self.occupied[i][j]:
                    self.occupied[i][j] = False
                    return ParkingSpot(i, j)
        
        raise Exception("Error: Parking Spot is Full!")
    
    def unpark(self, floor, spot):
        self.occupied[floor][spot] = True
    
    def getNextAvailable(self):
        for floor in range(1, self.maxFloor + 1):
            for spot in range(1, self.spotsPerFloor + 1):
                if self.occupied[floor][spot]:
                    return ParkingSpot(floor, spot)
        return None
    
    def addParkingSpot(self, floor, spot):
        if floor > self.maxFloor:
            raise Exception("Error! Floor entered greater than allowed")
        if spot > self.spotsPerFloor:
            raise Exception("Error! Spot greater than allowed")
        self.occupied[floor][spot] = True

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