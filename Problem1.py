# Time Complexity : O(n^k)
# Space Complexity :O(n), for dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Design a parking lot.
import heapq

class ParkingSpace:
    def __init__(self, floor, slot):
        self.floor = floor
        self.slot = slot

    def getFloor(self):
        return self.floor

    def getSlot(self):
        return self.slot

    def __lt__(self, other):
        if(self.getFloor() == other.getFloor()):
            return (self.getSlot() < other.getSlot())
        else:
            return (self.getFloor() < other.getFloor())

    def __gt__(self, other):
        if(self.getFloor() == other.getFloor()):
            return (self.getSlot() > other.getSlot())
        else:
            return (self.getFloor() > other.getFloor())

    def __eq__(self, other):
        return (self.getFloor() == other.getFloor() and self.getSlot() == other.getSlot())

    def __str__(self):
        return 'Floor: {} || Slot: {}'.format(self.getFloor(), self.getSlot())


class ParkingLot:

    def __init__(self, maxFloors, maxSlots):
        self.maxFloors = maxFloors
        self.maxSlots = maxSlots

        self.priorityQueue = []

        for floor in range(self.maxFloors):
            for slots in range(self.maxSlots):
                self.addParkingSpace(floor, slots)
    
    
    def park(self): 
        if len(self.priorityQueue) > 0:
            parkingSpace = heapq.heappop(self.priorityQueue)
            return parkingSpace
        
        else:
            raise Exception('Opps! The Parking Lot is Full. ☹️')
    
    def unpark(self, parkingSpace):
        floor = parkingSpace.getFloor()
        slot = parkingSpace.getSlot()
        
        if floor < self.maxFloors and slot < self.maxSlots:
            self.addParkingSpace(floor, slot)
        else:
            raise Exception("Cant Unpark slot that is unavailable.")
    
    def addParkingSpace(self, floor, slot):
        parkingSpace = ParkingSpace(floor, slot)
        
        if floor < self.maxFloors and slot < self.maxSlots:
            heapq.heappush(self.priorityQueue, parkingSpace)
        else:
            raise Exception("Try another Slot")
    
    def status(self):
        return 'Available Slots: {}'.format(len(self.priorityQueue))


if __name__ == "__main__":
    parkingLot = ParkingLot(2, 2)
    for i in range(5):
        print(parkingLot.status())
        print("Parking: {}".format(parkingLot.park()))
        print('-------------------------------------')

    for i in range(3):
        parkingSpace = ParkingSpace(randint(0, 2), randint(0, 3))
        parkingLot.unpark(parkingSpace)
        print(parkingLot.status())
        print("Parking: {}".format(parkingLot.park()))
        print('-------------------------------------')
