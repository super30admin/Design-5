class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def get_spot(self):
        return self.spot

    def get_floor(self):
        return self.floor


class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):
        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        # 1-based indexing, extra row/col at index 0 unused
        self.occupied = [[False] * (spots_per_floor + 1) for _ in range(max_floors + 1)]

    def park(self):
        for floor in range(1, self.max_floors + 1):
            for spot in range(1, self.spots_per_floor + 1):
                if self.occupied[floor][spot]:
                    self.occupied[floor][spot] = False  # mark as occupied
                    return ParkingSpot(floor, spot)
        raise Exception("Error: Parking lot is full")

    def unpark(self, floor, spot):
        self.occupied[floor][spot] = True  # mark as available

    def get_next_available(self):
        for floor in range(1, self.max_floors + 1):
            for spot in range(1, self.spots_per_floor + 1):
                if self.occupied[floor][spot]:
                    return ParkingSpot(floor, spot)
        return None

    def add_parking_spot(self, floor, spot):
        if floor > self.max_floors:
            raise ValueError("Error: floor input greater than max allowed")
        if spot > self.spots_per_floor:
            raise ValueError("Error: spots input greater than max allowed")
        self.occupied[floor][spot] = True  # mark as available


if __name__ == "__main__":
    pl = ParkingLot(3, 2)
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

    pl.unpark(1, 1)

    n1 = pl.get_next_available()
    print(f"Parked at Floor: {n1.get_floor()}, Slot: {n1.get_spot()}")