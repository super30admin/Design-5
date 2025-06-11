# Time Complexity : O(LogN) for each operation.
# Space Complexity : O(1)

from heapq import heappush as insert
from heapq import heappop as remove

class ParkingSpot :
    def __init__(self,floor_num, spot):
        self.floor_num = floor_num
        self.spot = spot

    def get_floor(self):
        return self.floor_num

    def get_spot(self):
        return self.spot

class ParkingLot:
    def __init__(self,max_spots,spots_per_floor):
        self.max_spots = max_spots
        self.spots_per_floor = spots_per_floor
        self.max_floors = int(self.max_spots/self.spots_per_floor)
        self.heap = []

    def add_parking_spot (self, floor, spot):
        if len(self.heap) == self.max_spots:
            print ("Cannot add more spots")
        parking_spot = ParkingSpot(floor,spot)
        insert(self.heap,(floor,spot,parking_spot))

    def get_next_available(self):
        if len(self.heap) == 0 :
            print ("No spots left to park")
        else :
            return self.heap[0]

    def park(self):
        return remove(self.heap)

    def unpark(self,floor,spot):
        parking_spot = ParkingSpot(floor,spot)
        insert(self.heap,(floor,spot,parking_spot))