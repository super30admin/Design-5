import heapq as hqueue


class ParkingLot:
    maxFloors = 5
    maxSlotsPerFloor = 10

    class ParkingSpace:
        floor = 0
        slot = 0

        def getFloor(self):
            return self.floor

        def getSlot(self):
            return self.slot

        def __init__(self, floor, slot):
            if floor > ParkingLot.maxFloors or slot > ParkingLot.maxSlotsPerFloor:
                raise Exception("Capacity is 5 floors and 10 slots per floor.")

            self.floor = floor
            self.slot = slot

        def __eq__(self, other):
            return (self.getFloor() == other.getFloor() and
                    self.getSlot() == other.getSlot())

        def __lt__(self, other):
            if self.getFloor() == other.getFloor():
                return self.getSlot() < other.getSlot()
            return self.getFloor() < other.getFloor()

        def __str__(self):
            return ",".join([str(self.floor), str(self.slot)])

    def __init__(self):
        self.pq = []

    def park(self):  # TC O(logN)
        spot = self.getNextAvailable()
        if spot is None:
            raise Exception("Parking Lot is Full.")
        print("Parking at", spot)
        hqueue.heappop(self.pq)
        return spot

    def unpark(self, floor, slot):  # TC O(logN)
        spot = self.ParkingSpace(floor, slot)
        if spot not in self.pq:
            hqueue.heappush(self.pq, spot)
        else:
            raise Exception("Invalid Parking Lot.")

    def addParkingSpace(self, floor, slot):
        spot = self.ParkingSpace(floor, slot)
        hqueue.heappush(self.pq, spot)  # TC O(logN)

    def getNextAvailable(self):  # TC O(1)
        if len(self.pq) > 0:
            return self.pq[0]


pklot = ParkingLot()

pklot.addParkingSpace(1, 1)
pklot.addParkingSpace(2, 1)
pklot.addParkingSpace(3, 1)
pklot.addParkingSpace(1, 2)
pklot.addParkingSpace(2, 2)
pklot.addParkingSpace(3, 2)
print(pklot.getNextAvailable())
p1 = pklot.park()
p2 = pklot.park()
print(pklot.getNextAvailable())
pklot.unpark(p1.floor, p1.slot)
pklot.unpark(p2.floor, p2.slot)
print(pklot.getNextAvailable())