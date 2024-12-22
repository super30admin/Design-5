import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    def get_spot(self):
        return self.spot

    def get_floor(self):
        return self.floor

    def __lt__(self, other):
        # Custom comparator to order ParkingSpot objects
        if self.floor == other.floor:
            return self.spot < other.spot
        return self.floor < other.floor


class ParkingLot:
    def __init__(self, max_floors, spots_per_floor):
        self.max_floors = max_floors
        self.spots_per_floor = spots_per_floor
        self.pq = []  # Min-heap to maintain the parking spots

    def park(self):
        if not self.pq:
            raise Exception("Parking lot is full")
        return heapq.heappop(self.pq)  # O(log(mn))

    def unpark(self, floor, spot):
        new_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, new_spot)  # O(log(mn))

    def get_next_available(self):
        if not self.pq:
            raise Exception("No available parking spots")
        return self.pq[0]  # Peek at the min element

    def add_parking_spot(self, floor, spot):
        if floor > self.max_floors:
            raise Exception("Floor input greater than max allowed")
        if spot > self.spots_per_floor:
            raise Exception("Spot input greater than max allowed")
        new_spot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, new_spot)  # O(log(mn))


# Main function to demonstrate functionality
if __name__ == "__main__":
    pl = ParkingLot(10, 20)
    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(3, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 2)
    pl.add_parking_spot(3, 2)

    n = pl.get_next_available()  # 1,1
    print(f"Parked at Floor: {n.get_floor()}, Slot: {n.get_spot()}")
    pl.park()

    n2 = pl.get_next_available()  # 1,2
    print(f"Parked at Floor: {n2.get_floor()}, Slot: {n2.get_spot()}")
    pl.park()

    n3 = pl.get_next_available()  # 2,1
    print(f"Parked at Floor: {n3.get_floor()}, Slot: {n3.get_spot()}")
    pl.park()

    pl.unpark(1, 2)
    n1 = pl.get_next_available()  # 1,2
    print(f"Parked at Floor: {n1.get_floor()}, Slot: {n1.get_spot()}")
