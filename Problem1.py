import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def get_spot(self):
        return self.spot

    def get_floor(self):
        return self.floor

    def __lt__(self, other):        # This is an in-built feature in python to compare objects, (helpful when objects are in a heap)
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor

class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):
        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        self.pq = []

    def park(self):
        if not self.pq:
            raise ValueError("Parking lot is full")
        return heapq.heappop(self.pq)

    def unpark(self, floor, spot):
        new_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, new_spot)

    def get_next_available(self):
        if not self.pq:
            raise ValueError("No available parking spots")
        return self.pq[0]

    def add_parking_spot(self, floor, spot):
        if floor > self.max_floors:
            raise ValueError("Floor input greater than max allowed")
        if spot > self.spots_per_floor:
            raise ValueError("Spot input greater than max allowed")
        new_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, new_spot)

def main():
    pl = ParkingLot(10, 20)
    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(3, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 2)
    pl.add_parking_spot(3, 2)

    print(pl.pq)

    n = pl.get_next_available()
    print("Parked at Floor: {}, Slot: {}".format(n.get_floor(), n.get_spot()))

    pl.park()
    pl.park()
    n2 = pl.get_next_available()
    print("Parked at Floor: {}, Slot: {}".format(n2.get_floor(), n2.get_spot()))

    pl.unpark(1, 1)
    n1 = pl.get_next_available()
    print("Parked at Floor: {}, Slot: {}".format(n1.get_floor(), n1.get_spot()))


if __name__ == "__main__":
    main()