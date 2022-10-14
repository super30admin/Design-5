"""
Time Complexity : 
1. addParkingSlot - O(nlog n) where n is the total number of parking slots added nlogn is the time complexity for the heapify which will take place at the time when we will add any element to the heap.
2.getAvailability : O(1)
3. park : O(1), need to remove the parking slot at the top of the heap.
4. unPark: O(nlog n) where n is the total number of parking slots added nlogn is the time complexity for the heapify which will take place at the time when we will add any element to the heap.
                  
Space Complexity : O(n) which is the number of elements present in the heap. In worst case m * n where m is the maximum number of floors and n is the maximum number of spots per floor.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
As this is the design problem, start thinking from the bigger view
Person enters the parking Lot, looks for the nearest possible empty spot, once get the nearest possible empty spot parks the vehicle and get the token. After some time leaves the parking slot, so that spot will be available for the parking, compare it with the other avaialble parking slots and keep ready the nearest empty spot for the next person.
"""
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

def main():

    pl = ParkingLot(10, 20)
    pl.addParkingSlot(1, 1)
    pl.addParkingSlot(2, 1)
    pl.addParkingSlot(3, 1)
    pl.addParkingSlot(1, 2)
    pl.addParkingSlot(2, 2)
    pl.addParkingSlot(3, 2)
    
    nextAvailableParkingSpot = pl.getAvailability()
    print(f"Floor: {nextAvailableParkingSpot.floor}")
    print(f"Spot: {nextAvailableParkingSpot.spot}")
    
    pl.park()
    
    nextAvailableParkingSpot = pl.getAvailability()
    print(f"Floor: {nextAvailableParkingSpot.floor}")
    print(f"Spot: {nextAvailableParkingSpot.spot}")
    pl.unPark(1, 1)
    
    nextAvailableParkingSpot = pl.getAvailability()
    print(f"Floor: {nextAvailableParkingSpot.floor}")
    print(f"Spot: {nextAvailableParkingSpot.spot}")

main()
    
    
    
