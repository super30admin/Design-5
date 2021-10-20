# // Time Complexity :O(1) park add,O(logn),unpark,get slot
# // Space Complexity :O(n) size of heap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no





#design a parting lot
#capacity
#categories-types of vehicle
#charges-duration(how long to park)

#parking spot-smaller entity, parking lot-bigger entity
#no of floors, spots per floor, number of entry exit points(1), order of filling vehicles
#spot level id-foor, spot number

import heapq
class ParkingLot:
    def __init__(self,level,spot):
        self.level=level
        self.spots_per=spot
        self.available_spots=[]
    def add_parking_spot(self,floor,spot):
        if floor<self.level and spot<self.spots_per:
            self.add_vacant_spots(floor,spot)
    def add_vacant_spots(self,floor,spot):
        ps=Parkingspot(floor,spot)
        heapq.heappush(self.available_spots,ps)
    def get_next_available(self):
        return self.available_spots[0]
    def park(self):
        return heapq.heappop(self.available_spots)
    def unpark(self, floor, spot):                     
        self.add_vacant_spots(floor, spot)




    


class Parkingspot:
    def __init__(self,floor,spot):
        self.floor=floor
        self.spot=spot
    def __lt__(self,other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor
    
    

def main():
    pl=ParkingLot(10,20)
    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(3, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 2)
    pl.add_parking_spot(3, 2)
    print(pl.get_next_available())
    pl.park()
    print(pl.get_next_available())
    pl.unpark(1,1)
main()




