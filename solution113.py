#Time Complexity:O(logn)
#Space Complexity:O(1)
import heapq

class ParkingSpot:                                                              #initializing the structure of parking spot
    def __init__(self,floor:int,spot:int):
        self.floor=floor
        self.spot=spot
        
    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor
    
    def __str__(self):
        return 'Parked at Floor: {}, Spot: {}'.format(self.floor, self.spot)
    

class ParkingLot:                                                               #initializing structure of parking spot with other possible methods
    def __init__(self,maxfloors:int,noOfSpotsPerFloor:int):                     #the number of floors and spots in each floors are initialized
        self.maxfloors=maxfloors
        self.noOfSpotsPerFloor=noOfSpotsPerFloor
        self.availableSpots=[]                                                  
        
    def Park(self):                                                             #if there are no available spots return excption
        if len(self.availableSpots)==0:
            raise Exception('Parking Lot is Full')
        return heapq.heappop(self.availableSpots)                               #else remove next available spot to show parked
        
    def addParkingSpot(self,floor:int,spot:int):
        if(floor>self.maxfloors) or spot>self.noOfSpotsPerFloor:                #if floor or spot does not exists return exception else create a spot
            raise Exception('Input is out of allowed range')
        self._add_vacant_spot(floor, spot)  
        
    def getNextAvailable(self):                                                 #if there are no available spots return excption                                         
        if len(self.availableSpots)==0:
            raise Exception('Parking Lot is Full')
        return self.availableSpots[0]                                           ##else return next available spot
    
    def unPark(self,floor,spot):
        self._add_vacant_spot(floor, spot)                                      #if uparking at a spot add it back to the avialable spots list
        
    def _add_vacant_spot(self, floor, spot):
        parking_spot = ParkingSpot(floor, spot)                                 #create spot and add it to available spots
        heapq.heappush(self.availableSpots, parking_spot)

def main():
    pl=ParkingLot(10,20)
    pl.addParkingSpot(1,1)
    pl.addParkingSpot(2,1)
    pl.addParkingSpot(3,1)
    pl.addParkingSpot(1,2)
    pl.addParkingSpot(2,2)
    pl.addParkingSpot(3,2)
    print(pl.getNextAvailable())
    pl.Park()
    print(pl.getNextAvailable())
    pl.unPark(1,1)
    print(pl.getNextAvailable())
    
main()