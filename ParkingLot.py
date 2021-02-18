'''
    Time Complexity:
        Mentioned with every method

    Space Complexity:
        O(n) (where n = number of spots)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Use MinHeap to keep track of closest empty space.
'''

import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor

class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):
        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        self.available_spots = []

    def _is_full(self):
        return len(self.available_spots) == 0

    def park(self):                                     # O(1)
        if self._is_full():
            raise Exception('Parking Lot is full')

        return heapq.heappop(self.available_spots)

    def get_next_available(self):                       # O(1)
        if self._is_full():
            raise Exception('Parking Lot is full')

        return self.available_spots[0]

    def unpark(self, floor, spot):                      # O(logn)
        self._add_vacant_spot(floor, spot)

    def add_parking_spot(self, floor, spot):            # O(logn)
        if floor > self.max_floors or spot > self.spots_per_floor:
            raise Exception('Input is out of allowed range')

        self._add_vacant_spot(floor, spot)

    def _add_vacant_spot(self, floor, spot):
        parking_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.available_spots, parking_spot)


def main():
    pl = ParkingLot(10, 20)

    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(3, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 2)
    pl.add_parking_spot(3, 2)

    n1 = pl.get_next_available()
    print('Parked at Floor: {}, Spot: {}'.format(n1.floor, n1.spot))

    pl.park()
    n2 = pl.get_next_available()
    print('Parked at Floor: {}, Spot: {}'.format(n2.floor, n2.spot))

    pl.unpark(1, 1)
    n3 = pl.get_next_available()
    print('Parked at Floor: {}, Spot: {}'.format(n3.floor, n3.spot))

main()
