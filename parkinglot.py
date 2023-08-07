# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes 
# // Any problem you faced while coding this :NO

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


if __name__ == '__main__':
    lot = ParkingLot(20,10)
    lot.add_parking_spot(1,1)
    lot.add_parking_spot(1,2)
    lot.add_parking_spot(2,1)
    lot.add_parking_spot(2,3)

    next_avail = lot.get_next_available()
    print (next_avail[2].get_floor(),next_avail[2].get_spot()) # (1,1)
    #print (lot.heap)
    parked = lot.park()
    print (parked[2].get_floor(),parked[2].get_spot()) #(1,1) 
    #print (lot.heap)
    parked = lot.park()
    print (parked[2].get_floor(),parked[2].get_spot()) #(1,2)
    #print (lot.heap)
    parked = lot.park()
    print (parked[2].get_floor(),parked[2].get_spot()) #(2,1)
    #print (lot.heap)
    parked = lot.park()
    print (parked[2].get_floor(),parked[2].get_spot()) #(2,3)
    #print (lot.heap)
    next_avail = lot.get_next_available() #No spots available


    lot.unpark(2,1)
    next_avail = lot.get_next_available()
    print (next_avail[2].get_floor(),next_avail[2].get_spot()) # (2,1)
    lot.unpark(1,1)
    next_avail = lot.get_next_available()
    print (next_avail[2].get_floor(),next_avail[2].get_spot()) #(1,1)