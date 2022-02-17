"""
Design a parking lot system where you need to provide 
a token with the parking space number on it to each 
new entry for the space closest to the entrance. 

When someone leave you need update this space as empty. 
What data structures will you use to perform the closest 
empty space tracking, plus finding what all spaces are 
occupied at a give time.
"""

# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

from queue import PriorityQueue

class ParkingLot:

    def __init__(self,maxFloor,numberOfParkingLot):
        self.maxFloor = maxFloor
        self.spotsPerFloor = spotsPerFloor
        self.pq = PriorityQueue()

    def addParkingSpot(self,floor,spot):
        if floor > self.maxFloor:
             raise Exception("Invalid Floor")

        if spot > self.numberOfParkingLot:
            raise Exception("Invalid Spot")

        self.pq.put(floor, spot, ParkingSpace(floor,spot))

    def getNextAvailableSpot(self):
        return self.pq.queue[0]

    def park(self):
        if len(self.pq.queue) == 0:
            raise Exception("Parking Lot Full")

        _, _, parkingSpot = self.pq.get()

        return parkingSpot

    def unpark(self, floor, spot):
        if floor > self.maxFloor:
             raise Exception("Invalid Floor")

        if spot > self.numberOfParkingLot:
            raise Exception("Invalid Spot")

        self.pq.put(floor,spot,ParkingSpace(floor,spot))

class ParkingSpace:
    def __init__(self,floor,spot):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor

    def getSpot(self):
        return self.spot
    

    