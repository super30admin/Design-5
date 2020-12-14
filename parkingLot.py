#As taught in class, using heapq to design a parking lot
import heapq
class ParkingLot:
    def __init__(self,maxFloors,spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.pd = heapq()

    def comp(self,a,b):
        if a.floor == b.floor:
            return a.spot - b.spot
        return a.floor - b.floor

    def park(self):
        if len(self.pd)==0:
            return
        toPark = self.pd.get()
        return toPark

    def unpark(self,floor,spot):
        self.addParkingSpot(floor,spot)


    def addParkingSpot(self,floor,spot):
        if  floor > self.maxFloors or floor > self.spotsPerFloor:
            print("Floor input greater than max")
            return
        newSpot = self.ParkingSpot()
        self.pd.push(newSpot,key=self.comp(newSpot,spot))

    def getNextAvailable(self):
        return self.pq.peek()
        
class ParkingSpot:
    def __init__(self,floor,spot):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor

    def geetSpot(self):
        return self.spot
    
