"""
Approach -
Priority Queue using a custom comparator giving higher precedence to floor number.

Time Complexity for Parking & Un-parking O(log(MN)) where M - floors and N - slots per floor
Space Complexity overall:   O(MN)
"""


from heapq import heappush as insert
from heapq import heappop as remove
from random import randint

class ParkingSpace:

    #   Parking Space containing floor and slot information
    def __init__(self, floor: int, slot: int):
        self.__floor = floor
        self.__slot = slot

    #   Getters
    def getFloor(self):
        return self.__floor

    def getSlot(self):
        return self.__slot

    #   Custom Comparators for less than, greater than and equal to
    def __lt__(self, other):
        if (self.getFloor() == other.getFloor()):
            return (self.getSlot() < other.getSlot())
        else:
            return (self.getFloor() < other.getFloor())

    def __gt__(self, other):
        if (self.getFloor() == other.getFloor()):
            return (self.getSlot() > other.getSlot())
        else:
            return (self.getFloor() > other.getFloor())

    def __eq__(self, other):
        return ( self.getFloor() == other.getFloor() and self.getSlot() == other.getSlot() )

    #   String representation
    def __str__(self):
        return 'Floor: {} || Slot: {}'.format(self.getFloor(), self.getSlot())

class ParkingLot:

    #   Initialize empty Parking Lot with some floors containing some slots
    def __init__(self, maxFloors, maxSlots):
        self.__maxFloors = maxFloors
        self.__maxSlots = maxSlots

        self.__priorityQueue = []

        #   Fill the Priority Queue
        for floor in range(self.__maxFloors):
            for slot in range(self.__maxSlots):
                self.addParkingSpace(floor, slot)


    def park(self) -> 'ParkingSpace':

        #   if slots available => return the closest slot available
        if (len(self.__priorityQueue) > 0):
            parkingSpace = remove(self.__priorityQueue)
            return parkingSpace

        #   else do nothing
        else:
            print('Oops!!! The Parking Lot is Full')
            return None

    def unpark(self, parkingSpace: 'ParkingSpace') -> None:

        floor = parkingSpace.getFloor()
        slot = parkingSpace.getSlot()

        #   if parking space is in limitations => add it to the available slots in priority queue
        if (floor < self.__maxFloors and slot < self.__maxSlots):
            self.addParkingSpace(floor, slot)
        #   else do nothing
        else:
            print("Can't unpark  slot that is unavailable !!! ")

    def addParkingSpace(self, floor: int, slot: int) -> None:

        parkingSpace = ParkingSpace(floor, slot)

        #   if parking space is in limitations => add it to the available slots in priority queue
        if (floor < self.__maxFloors and slot < self.__maxSlots):
            insert(self.__priorityQueue, parkingSpace)
        #   else do nothing
        else:
            print('Try another Floor and another Slot !!!')

    def status(self):
        return 'Available Slots: {}'.format(len(self.__priorityQueue))

def main():

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

if __name__ == '__main__':
    main()