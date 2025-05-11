# Design a parking lot using a heap
# The parking lot has multiple floors and each floor has multiple parking spots
# The parking spots are represented as a min heap, where the parking spot with the lowest floor and spot number is at the top of the heap
# The parking lot has the following operations:
# 1. park() - parks a car in the next available parking spot
# 2. unpark(floor, spot) - unparks a car from the specified parking spot
# 3. getNextAvailable() - returns the next available parking spot
# 4. addParkingSpot(floor, spot) - adds a new parking spot to the parking lot

# Time Complexity:
# 1. park() - O(log m*n)
# 2. unpark(floor, spot) - O(log m*n)
# 3. getNextAvailable() - O(1)
# 4. addParkingSpot(floor, spot) - O(log m*n)
# Space Complexity: O(m*n)
# where m is the number of floors and n is the number of parking spots per floor
import heapq
class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
    
    def getFloor(self):
        return self.floor
    
    def getSpot(self):
        return self.spot
    
    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor
        
class ParkingLot:
    def __init__(self, maxFloors, spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.heap = []
        
    def park(self):
        if not self.heap:
            raise Exception("parking lot is full")
        res = heapq.heappop(self.heap)
        return res

    def unpark(self, floor, spot):
        newSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.heap, newSpot)
    
    def getNextAvailable(self):
        if not self.heap:
            return None
        return self.heap[0]

    def addParkingSpot(self, floor, spot):
        if floor > self.maxFloors:
            raise Exception("Exceeded maximum number of floors allowed")
        if spot > self.spotsPerFloor:
            raise Exception("Exceeded maximum number of spots allowed per floor. Try another floor.")
        newSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.heap, newSpot)
        
def main():
    pl = ParkingLot(3, 2)
    pl.addParkingSpot(1, 1)
    pl.addParkingSpot(2, 1)
    pl.addParkingSpot(3, 1)
    pl.addParkingSpot(1, 2)
    pl.addParkingSpot(2, 2)
    pl.addParkingSpot(3, 2)

    n = pl.getNextAvailable()
    print(f"Parked at Floor: {n.getFloor()}, Slot: {n.getSpot()}")

    pl.park()
    n2 = pl.getNextAvailable()
    print(f"Parked at Floor: {n2.getFloor()}, Slot: {n2.getSpot()}")

    pl.park()
    n3 = pl.getNextAvailable()
    print(f"Parked at Floor: {n3.getFloor()}, Slot: {n3.getSpot()}")

    pl.unpark(1, 2)
    n1 = pl.getNextAvailable()
    print(f"Parked at Floor: {n1.getFloor()}, Slot: {n1.getSpot()}")

if __name__ == "__main__":
    main()