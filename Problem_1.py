"""
Problem : 1

Time Complexity : O(1)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Parking lot system

class ParkingSpot(object):

    def __init__(self,floor,spot):
        self.floor=floor
        self.spot=spot

    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor

    def getSpot(self):
        return self.spot

    def getFloor(self):
        return self.floor
    
class ParkingLot(object):
    
    def __init__(self,maxFloors,spotsPerFloor):
        self.maxFloors=maxFloors
        self.spotsPerFloor=spotsPerFloor
        self.pq=[]
        heapq.heapify(self.pq)
    def park(self):
        if not self.pq:
            return "Parking Lot is Full"
        re=heapq.heappop(self.pq)
        return re
    
    def unpark(self,floor,spot):
        newSpot=ParkingSpot(floor,spot)
        heapq.heappush(self.pq,newSpot)
    
    def getNextAvailable(self):
        return self.pq[0]

    def addParkingSpot(self,floor,spot):
        if floor>self.maxFloors:
            return "Floor out of bounds"
        if spot>self.spotsPerFloor:
            return "Spots out of bounds"
        newSpot=ParkingSpot(floor,spot)
        heapq.heappush(self.pq,newSpot)
    
p1=ParkingLot(10,20)
p1.addParkingSpot(1,1)
p1.addParkingSpot(2,1)
p1.addParkingSpot(3,1)
p1.addParkingSpot(1,2)
p1.addParkingSpot(2,2)
p1.addParkingSpot(3,2)
n=p1.getNextAvailable()

print("Parked at Floor:",n.getFloor(),",Slot:",n.getSpot())
p1.park()
n2=p1.getNextAvailable()
print("Parked at Floor:",n2.getFloor(),",Slot:",n2.getSpot())
p1.unpark(1,1)
n3=p1.getNextAvailable()
print("Parked at Floor:",n3.getFloor(),",Slot:",n3.getSpot())

    