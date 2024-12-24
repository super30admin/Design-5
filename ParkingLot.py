# The ParkingLot class simulates a parking lot system with efficient spot management using a min-heap.

# ParkingSpot:
# - Represents a parking spot with floor and spot information.
# - Supports comparison (`__lt__`) to prioritize by floor and spot number.

# ParkingLot:
# - Maintains a priority queue (min-heap) to efficiently track available spots.
# - Methods:
#   - park: Removes and returns the next available spot.
#   - unpark: Adds a spot back to the available queue.
#   - get_next_available: Retrieves the next available spot without removing it.
#   - add_parking_spot: Adds a new parking spot to the queue, ensuring it is within limits.

# TC:
# - park/unpark/add_parking_spot: O(log n) - Heap operations.
# - get_next_available: O(1) - Accessing the top of the heap.
# SC: O(n) - Space for the heap, where n is the total number of spots.


import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
    
    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor

    def get_spot(self):
        return self.spot

    def get_floor(self):
        return self.floor

class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):
        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        self.priority_queue = []
        
    def park(self):
        if not self.priority_queue:
            raise Exception("Parking lot is full")
        return heapq.heappop(self.priority_queue)
    
    def unpark(self, floor, spot):
        heapq.heappush(self.priority_queue, ParkingSpot(floor, spot))
    
    def get_next_available(self):
        if not self.priority_queue:
            raise Exception("No spots available")
        return self.priority_queue[0]
    
    def add_parking_spot(self, floor, spot):
        if floor > self.max_floors:
            raise Exception("Floor input greater than max allowed")
        if spot > self.spots_per_floor:
            raise Exception("Spot input greater than max allowed")
        heapq.heappush(self.priority_queue, ParkingSpot(floor, spot))

def main():
    pl = ParkingLot(10, 20)
    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(3, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 2)
    pl.add_parking_spot(3, 2)
    
    n = pl.get_next_available()
    print(f"Parked at Floor: {n.get_floor()}, Slot: {n.get_spot()}")
    pl.park()
    
    n2 = pl.get_next_available()
    print(f"Parked at Floor: {n2.get_floor()}, Slot: {n2.get_spot()}")
    pl.park()
    
    n3 = pl.get_next_available()
    print(f"Parked at Floor: {n3.get_floor()}, Slot: {n3.get_spot()}")
    
    pl.unpark(1, 2)
    
    n1 = pl.get_next_available()
    print(f"Parked at Floor: {n1.get_floor()}, Slot: {n1.get_spot()}")

if __name__ == "__main__":
    main()
