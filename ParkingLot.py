# SC:O(n) (where n = number of spots)
# Use MinHeap to store empty spots and make available spot for incoming vehicle at O(1) TC.

import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor

    def __str__(self):
        return 'Parking Ticket Floor: {}, Spot {}'.format(self.floor, self.spot)

class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):
        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        self.available_spots = []

    def _is_full(self):
        return len(self.available_spots) == 0

    def park(self):                                     # O(1)
        if self._is_full():
            return 'FULL'
        return heapq.heappop(self.available_spots)

    def get_next_available(self):                       # O(1)
        if self._is_full():
            raise Exception('FULL')
        return self.available_spots[0]

    def unpark(self, floor, spot):                      # O(logn)
        self._add_vacant_spot(floor, spot)
        return "New spot available: floor {}, spot {}".format(floor, spot)

    def add_parking_spot(self, floor, spot):            # O(logn)
        if floor > self.max_floors or spot > self.spots_per_floor:
            raise Exception('Enter Valid input')

        self._add_vacant_spot(floor, spot)

    def _add_vacant_spot(self, floor, spot):
        parking_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.available_spots, parking_spot)


def main():
    pl = ParkingLot(2, 2)

    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(2, 2)
    
    print(pl.park())
    print(pl.park())
    print(pl.park())
    print(pl.park())
    print(pl.park())
    print(pl.unpark(1, 1))

main()