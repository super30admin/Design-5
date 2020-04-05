import parkingSpace as PS
import heapq

class parkingLot:
    def __init__(self, maxfloor, maxslot):
        self.maxFloor = maxfloor
        self.maxSlot = maxslot
        self.minHeap = []

        for floor in range(1,maxfloor+1):
            for slot in range(1,maxslot+1):
                self.addParkingSpace(floor,slot)

    def park(self):
        try:
            ps = heapq.heappop(self.minHeap)
        except:
            print("Parking is Full")
            return

        return ps

    def unpark(self, ps):
        heapq.heappush(self.minHeap, (ps))

    def addParkingSpace(self, floor, slot):
        ps = PS.parkingSpace(floor,slot)
        heapq.heappush(self.minHeap,(ps))

    def status(self):
        return len(self.minHeap)

pl = parkingLot(1,5)
ps1 = pl.park()
print("state", pl.status())
ps2 = pl.park()
ps3 = pl.park()
ps4 = pl.park()
print("state", pl.status())