from heapq import heappush as insert
from heapq import heappop as remove
#O(logmn)>no. of spots
#O(mn)
class ParkingSpot:
    def __init__(self, floor: int, spot: int):
        self.floor = floor
        self.spot = spot

    def getFloor(self):
        return self.floor

    def getSpot(self):
        return self.spot

    def __lt__(self, other):
        if self.getFloor() == other.getFloor():
            return (self.getSpot() < other.getSpot())
        return (self.getFloor() < other.getFloor())

    def printDetails(self):
        return 'Floor: {} || Slot: {}'.format(self.getFloor(), self.getSpot())


class ParkingLot:
    #parking lot has parking spots
    def __init__(self, maxFloors, spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.heap = []

    def park(self):
        #heap has parking spots
        if len(self.heap) > 0:
            return remove(self.heap)
        else:
            print("Parking lot full.")
            return None

    def unpark(self, floor,spot):
        #create spot for unparked vehicle
        if (floor < self.maxFloors and spot < self.spotsPerFloor):
            self.addSpot(floor, spot)

    def addSpot(self, floor, spot):
        #create spot by inserting in heap
        if floor > self.maxFloors or spot > self.spotsPerFloor:
            print("Value out of bounds")
        else:
            newSpot = ParkingSpot(floor, spot)
            insert(self.heap, newSpot)

    def getNextAvailableSpot(self):
        #nextavailable spot on top as it is min heap
        return self.heap[0]

    def status(self):
        return 'Available Slots: {}'.format(len(self.heap))


def main():
    parkingLot = ParkingLot(10, 5)
    parkingLot.addSpot(3,4)
    parkingLot.addSpot(1,4)
    parkingLot.addSpot(0,1)
    parkingLot.addSpot(2,4)
    parkingLot.addSpot(0,0)
    
    for i in range(5):
        print(parkingLot.status())
        spot=parkingLot.park()
        print("f",spot.getFloor()," s",spot.getSpot())
    parkingLot.unpark(0,1)
    parkingLot.unpark(0,0)
    spot=parkingLot.park()
    print("f",spot.getFloor()," s",spot.getSpot())
    spot=parkingLot.getNextAvailableSpot()
    print("f",spot.getFloor()," s",spot.getSpot())
    
if __name__ == '__main__':
    main()