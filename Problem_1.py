"""
Time Complexity : O(mn)
Space Complexity : O(mn) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We use min heap here for storing all the available parking spots and use a comparator to pop out
the minimum one.
"""
from heapq import heappush as insert
from heapq import heappop as remove
from random import randint


class ParkingSpot:
    def __init__(self, floor: int, spot: int):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor

    def getSpot(self):
        return self.spot

    def __lt__(self, other):
        if self.getFloor() == other.getFloor():
            return (self.getSpot() < other.getSpot())
        return (self.getFloor() < other.getFloor())

    def printDetails(self):
        return 'Floor: {} || Slot: {}'.format(self.getFloor(), self.getSpot())


class ParkingLot:
    def __init__(self, maxFloors, spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.heap = []
        for i in range(self.maxFloors):
            for j in range(self.spotsPerFloor):
                self.addSpot(i, j)

    def park(self):
        if len(self.heap) > 0:
            return remove(self.heap)
        else:
            print("Parking lot full.")
            return None

    def unpark(self, ParkingSpot):

        floor = ParkingSpot.getFloor()
        spot = ParkingSpot.getSpot()

        if (floor < self.maxFloors and spot < self.spotsPerFloor):
            self.addSpot(floor, spot)

    def addSpot(self, floor, spot):
        if floor > self.maxFloors or spot > self.spotsPerFloor:
            print("Value out of bounds")
        else:
            newSpot = ParkingSpot(floor, spot)
            insert(self.heap, newSpot)

    def getNextAvailableSpot(self):
        return self.heap[0]

    def status(self):
        return 'Available Slots: {}'.format(len(self.heap))


def main():

    parkingLot = ParkingLot(2, 2)

    for i in range(5):
        print(parkingLot.status())
        print("Parking: {}".format(parkingLot.park()))

    for i in range(3):
        parkingSpot = ParkingSpot(randint(0, 2), randint(0, 3))
        parkingLot.unpark(parkingSpot)
        print(parkingLot.status())
        print("Parking: {}".format(parkingLot.park()))


if __name__ == '__main__':
    main()
