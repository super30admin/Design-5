# Time Complexity : O(log N) where N is the total number of spots for park and addParkingLot and O(1) for unpark and nextAvailable
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I store free slots in a min heap whenever a new slot is added or while unparking. While parking, I just pop from the min-heap the get the next available slot.

from heapq import heappush, heappop

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def __eq__(self, other):
        return self.floor == other.floor and self.spot == other.spot

    def __lt__(self, other):
        if self.floor < other.floor:
            return True
        elif self.floor > other.floor:
            return False
        else:
            return self.spot < other.spot

    def __gt__(self, other):
        return not self.__lt__(other)

    def __le__(self, other):
        return self.__lt__(other) or self.__eq__(other)

    def __ge__(self, other):
        return self.__gt__(other) or self.__eq__(other) 

    def __str__(self):
        return str(self.floor) + " " + str(self.spot)

    def __repr__(self):
        return self.__str__()   

class PlarkingLot:
    def __init__(self, no_of_floors, spots_per_floor):
        self.no_of_floors = no_of_floors
        self.spots_per_floor = spots_per_floor
        self.spots = []

    def get_next_available_spot(self):
        return self.spots[0]

    def park(self):
        if len(self.spots):
            return heappop(self.spots)
        return None

    def unpark(self, floor, spot):
        p_spot = ParkingSpot(floor, spot)
        heappush(self.spots, p_spot)

    def add_parking_spot(self, floor, spot):
        if floor <= self.no_of_floors and spot < self.spots_per_floor:
            p_spot = ParkingSpot(floor, spot)
            heappush(self.spots,p_spot)

if __name__ == "__main__":
    p_lot = PlarkingLot(4, 10)
    for i in range(1,3):
        for j in range(1,11):
            p_lot.add_parking_spot(i,j)

    print(p_lot.spots)
    print("-------------")
    print(p_lot.park())
    print(p_lot.park())
    print(p_lot.park())
    print(p_lot.park())
    print(p_lot.park())
    print(p_lot.park())
    p_lot.unpark(2, 1)
    p_lot.unpark(1, 1)
    print(p_lot.park())
    print(p_lot.park())
    print(p_lot.park())
