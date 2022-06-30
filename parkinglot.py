'''
time complexity: O(nlogn)
n - number of spots
space complexity: O(foor * spot)
'''
import heapq
import re
class parkingSpot:
    def __init__(self,floor,spot):
        self.floor = floor
        self.spot = spot
    def __lt__(self,other):
        if(self.floor==other.floor):
            return self.spot<other.spot
        return self.floor<other.floor


class parkingLot:
    def __init__(self,maxfloor,maxspot):
        self.maxfloor = maxfloor
        self.maxspot = maxspot
        self.vacantSpot = []

    def _is_full_(self):
        return len(self.vacantSpot)==0
    def getNextAvailable(self):
        if self._is_full_():
            return "No Spot Available"
        else:
            return self.vacantSpot[0]
    
    def park(self):
        if self._is_full_():
            raise Exception("Parking is already empty")
        else:
            return heapq.heappop(self.vacantSpot)
    

    def unpark(self,floor,spot):
        self._addVacantSpot(floor,spot)

    def add_parking_spot(self, floor, spot):        
        if floor > self.maxfloor or spot > self.maxspot:
            raise Exception('Input is out of allowed range')
        self._addVacantSpot(floor, spot)

    def _addVacantSpot(self,floor,spot):
        heapq.heappush(self.vacantSpot,parkingSpot(floor,spot))
    

def main():

    pl = parkingLot(10, 20)

    pl.add_parking_spot(1, 1)

    pl.add_parking_spot(2, 1)

    pl.add_parking_spot(3, 1)

    pl.add_parking_spot(1, 2)

    pl.add_parking_spot(2, 2)

    pl.add_parking_spot(3, 2)

    print("{} {} ".format(pl.getNextAvailable().floor,pl.getNextAvailable().spot))

    pl.park()

    print("{} {} ".format(pl.getNextAvailable().floor,pl.getNextAvailable().spot))

    pl.unpark(1, 1)

    print("{} {} ".format(pl.getNextAvailable().floor,pl.getNextAvailable().spot))

main()


