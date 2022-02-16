from queue import PriorityQueue

class ParkingLot:

    def __init__(self,maxFloor,numberOfParkingLot):
        self.maxFloor = maxFloor
        self.numberOfParkingLot = numberOfParkingLot
        self.pq = PriorityQueue()



    def addParkingSpot(self,floor,spot):
        if floor > self.maxFloor:
             raise Exception("Floor is invalid")

        if spot > self.numberOfParkingLot:
            raise Exception("Spot is invalid")

        self.pq.put((floor,spot,ParkingSpace(floor,spot)))

    def getNextAvailableSpot(self):
        return self.pq.queue[0]

    def park(self):
        if len(self.pq.queue) == 0:
            raise Exception("No parking space available")

        _,_,parkingSpot = self.pq.get()

        return parkingSpot

    def unpark(self,floor,spot):
        if floor > self.maxFloor:
             raise Exception("Floor is invalid")

        if spot > self.numberOfParkingLot:
            raise Exception("Spot is invalid")

        self.pq.put((floor,spot,ParkingSpace(floor,spot)))



class ParkingSpace:
    def __init__(self,floor,spot):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor

    def getSpot(self):
        return self.spot

lot = ParkingLot(10,10)
lot.addParkingSpot(1,1)
lot.addParkingSpot(1,5)
lot.addParkingSpot(2,3)
lot.addParkingSpot(3,2)
print(lot.getNextAvailableSpot())
lot.park()
print(lot.getNextAvailableSpot())
lot.park()
lot.park()
lot.unpark(1,1)
print(lot.getNextAvailableSpot())
lot.park()
print(lot.getNextAvailableSpot())
