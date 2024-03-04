#Time Complexity : O(n)
#Space Complexity :O(n)

import heapq

class ParkingLot:
    maxFloors = 5
    maxSlotsPerFloor = 10
    
    def __init__(self):
        self.pq = []
    
    def park(self):
        ps = self.get_next_available()
        if ps is None:
            raise Exception("Parking Lot is Full.")
        self.pq.remove(ps)
        return ps
    
    def unpark(self, floor, slot):
        ps = self.ParkingSpace(floor, slot)
        if ps not in self.pq:
            self.pq.append(ps)
        else:
            raise Exception("Invalid Parking Lot.")
    
    def add_parking_space(self, floor, slot):
        ps = self.ParkingSpace(floor, slot)
        self.pq.append(ps)
    
    def get_next_available(self):
        if len(self.pq) > 0:
            return self.pq[0]
        return None
    
    def main(self):
        pl = ParkingLot()
        pl.add_parking_space(1, 1)
        pl.add_parking_space(2, 1)
        pl.add_parking_space(3, 1)
        pl.add_parking_space(1, 2)
        pl.add_parking_space(2, 2)
        pl.add_parking_space(3, 2)
        n = pl.get_next_available()
        print("Parked at Floor: " + str(n.get_floor()) + ", Slot: " + str(n.get_slot()))
        pl.unpark(2, n.get_slot())
    
    class ParkingSpace:
        def __init__(self, floor, slot):
            if floor > ParkingLot.maxFloors or slot > ParkingLot.maxSlotsPerFloor:
                raise ValueError("Capacity is 5 floors and 10 slots per floor.")
            self.floor = floor
            self.slot = slot
        
        def get_floor(self):
            return self.floor
        
        def get_slot(self):
            return self.slot
        
        def __eq__(self, other):
            if isinstance(other, ParkingLot.ParkingSpace):
                return (self.get_floor() == other.get_floor() and
                        self.get_slot() == other.get_slot())
            return False

pl = ParkingLot()
pl.main()

