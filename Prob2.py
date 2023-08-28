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
        return 'Floor: {}, Spot: {}'.format(self.floor, self.spot)

class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):

        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        self.available_spots = []

    def _is_full(self):
        return len(self.available_spots) == 0

    def park(self):                                     
        if self._is_full():
            raise Exception('Lot full')
        return heapq.heappop(self.available_spots)

    def get_next_available(self):
        if self._is_full():
            raise Exception('Lot full')
        return self.available_spots[0]

    def unpark(self, floor, spot):                      
        self._add_vacant_spot(floor, spot)

    def add_parking_spot(self, floor, spot):
        if floor > self.max_floors or spot > self.spots_per_floor:
            raise Exception('Out of range')
        self._add_vacant_spot(floor, spot)

    def _add_vacant_spot(self, floor, spot):
        parking_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.available_spots, parking_spot)