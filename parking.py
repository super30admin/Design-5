"""
Time complexity Park, getNextavailablespot -->O(1)
unpark, add parkingspot O(Nlogk)  O((maxFloor*spotperfloor)log(floors*lots))

SC-O(Floors*spots)
"""

import heapq
class parkingSpot:
    def __init__(self,floor,spot):
        self.floor=floor
        self.spot=spot
        
    def getFloor(self):
        return self.floor
    
    def getSpot(self):
        return self.spot

    
class parkingLot:
    def __init__(self,maxFloor,spotperfloor):
        self.maxFloor=maxFloor
        self.spotperfloor=spotperfloor
        self.pq=[]
    
    parkingSpot.__lt__ = lambda self, next: self.spot<next.spot if self. floor==next.floor else self.floor<next.floor
    
    
    """  
def __lt__(self, nxt): 
        if self. floor==nxt.floor:
            return self.spot-nxt.spot
        return self.floor-nxt.floor
setattr(parkingSpot, "__lt__", lambda self, next: self.spot-next.spot if self. floor==next.floor else self.floor-next.floor )

"""   
    
    def park(self):
        if(len(self.pq)==0):
            print("parking lot is Full")
        return heapq.heappop(self.pq)
    
    def unpark(self,floor,spot):
        self.addParkingspot(floor,spot)
    
    def addParkingspot(self,floor,spot):
        if(floor>self.maxFloor):
            print("Invalid Parking Lot")
        if(spot>self.spotperfloor):
            print("No spots")
        newSpot=parkingSpot(floor,spot)
        heapq.heappush(self.pq,newSpot)
    
    def getNextavailablespot(self):
        
        return heapq.heappop(self.pq)
    
pl =parkingLot(5,5)
pl.addParkingspot(1, 1)
pl.addParkingspot(1, 3)
pl.addParkingspot(1, 2)
pl.addParkingspot(2, 1)
pl.addParkingspot(2, 2)
pl.addParkingspot(2, 3)
l=pl.park()
print(l.getFloor(),l.getSpot())

n = pl.getNextavailablespot()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))
n = pl.getNextavailablespot()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))
n = pl.getNextavailablespot()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))
pl.unpark(1,2) 
n = pl.getNextavailablespot()
print("Park at Floor: " + str(n.getFloor()) + ", Slot: " + str(n.getSpot()))
    