import heapq


class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def get_floor(self):
        return self.floor

    def get_spot(self):
        return self.spot


class ParkingLot:
    def __init__(self, floors, spots_per_floor):
        self.floors = floors
        self.spots_per_floor = spots_per_floor

        self.grid = [[None for x in range(self.spots_per_floor)] for y in range(self.floors)]

        self.heap = list()

        for i in range(self.floors):
            for j in range(self.spots_per_floor):
                heapq.heappush(self.heap, (i, j))

    def park(self):
        if len(self.heap) > 0:
            spot = heapq.heappop(self.heap)
            fl = spot[0]
            sp = spot[1]
            obj = ParkingSpot(fl, sp)
            self.grid[fl][sp] = obj
            print("Vehicle Parked")
        else:
            print('All Slots are Full')

    def unpark(self, fl, sp):
        if self.grid[fl - 1][sp - 1] is None:
            print("Spot is already empty")
        else:
            self.grid[fl - 1][sp - 1] = None
            heapq.heappush(self.heap, (fl - 1, sp - 1))
            print("Vehicle Unparked")


pl = ParkingLot(1, 1)
pl.park()
pl.unpark(1, 1)
pl.park()
pl.park()
