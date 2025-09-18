# Defining a class to represent a parking spot with floor and spot number
class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def getSpot(self):
        return self.spot

    def getFloor(self):
        return self.floor

# Defining a class to represent the parking lot
class ParkingLot:
    def __init__(self, maxFloors, spotsPerFloor):
        # Initializing the parking lot with given floors and spots per floor
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        # Creating a 2D list to track occupied status; True means available
        self.occupied = [[False] * (spotsPerFloor + 1) for _ in range(maxFloors + 1)]

    def park(self):
        # Iterating through all floors and spots to find the next available spot
        for floor in range(1, self.maxFloors + 1):
            for spot in range(1, self.spotsPerFloor + 1):
                # Checking if the spot is available
                if self.occupied[floor][spot]:
                    # Marking the spot as occupied
                    self.occupied[floor][spot] = False
                    # Returning the parking spot object
                    return ParkingSpot(floor, spot)
        # Raising an exception if no spots are available
        raise Exception("Error: Parking lot is full")

    def unpark(self, floor, spot):
        # Marking the given spot as available
        self.occupied[floor][spot] = True

    def getNextAvailable(self):
        # Iterating to find the next available spot
        for floor in range(1, self.maxFloors + 1):
            for spot in range(1, self.spotsPerFloor + 1):
                if self.occupied[floor][spot]:
                    return ParkingSpot(floor, spot)
        # Returning None if no spots are available
        return None

    def addParkingSpot(self, floor, spot):
        # Checking if the floor and spot are within allowed limits
        if floor > self.maxFloors:
            raise Exception("Error floor input greater than max allowed")
        if spot > self.spotsPerFloor:
            raise Exception("Error: spots input greater than max allowed")
        # Marking the spot as available
        self.occupied[floor][spot] = True

if __name__ == "__main__":
    # Creating a parking lot with 3 floors and 2 spots per floor
    pl = ParkingLot(3, 2)
    # Adding all spots as available
    pl.addParkingSpot(1, 1)
    pl.addParkingSpot(2, 1)
    pl.addParkingSpot(3, 1)
    pl.addParkingSpot(1, 2)
    pl.addParkingSpot(2, 2)
    pl.addParkingSpot(3, 2)

    # Getting and printing the next available spot
    n = pl.getNextAvailable()
    print("Parked at Floor:", n.getFloor(), ", Slot:", n.getSpot())
    pl.park()

    # Getting and printing the next available spot after parking
    n2 = pl.getNextAvailable()
    print("Parked at Floor:", n2.getFloor(), ", Slot:", n2.getSpot())
    pl.unpark(1, 1)

    # Getting and printing the next available spot after unparking
    n1 = pl.getNextAvailable()
    print("Parked at Floor:", n1.getFloor(), ", Slot:", n1.getSpot())

# Time Complexity (TC):
# - addParkingSpot: O(1)
# - park: O(F * S) in worst case, where F = maxFloors, S = spotsPerFloor
# - unpark: O(1)
# - getNextAvailable: O(F * S) in worst case

# Space Complexity (SC):
# - O(F * S) for the occupied 2D list
