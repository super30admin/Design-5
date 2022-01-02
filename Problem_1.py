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
        return 'Parked at Floor: {}, Spot: {}'.format(self.floor, self.spot)
    
class ParkingLot:
    def __init__(self, max_floors, spot_per_floors):
        self.max_floors = max_floors
        self.spot_per_floors = spot_per_floors
        self.available_spots = []
        
    def isFull(self):
        return len(self.available_spots) == 0
    
    def park(self):
        if self.isFull():
            raise Exception('Parking Space is Full')
        heapq.heappop(self.available_spots)
        
    def unpark(self, floor, spot):
        self.add_vacant_spot(floor, spot)
        
    def get_next_available(self):
        if self.isFull():
            raise Exception('Parking Space is Full')
        return self.available_spots[0]
        
    def add_parking_spot(self, floor, spot):
        if floor > self.max_floors or spot > self.spot_per_floors:
            raise Exception('Invalid Input')
        self.add_vacant_spot(floor, spot)
        
    def add_vacant_spot(self, floor, spot):
        heapq.heappush(self.available_spots, ParkingSpot(floor, spot))
        
def main():
    pl = ParkingLot(10, 20)
    pl.add_parking_spot(1, 1)
    pl.add_parking_spot(2, 1)
    pl.add_parking_spot(3, 1)
    pl.add_parking_spot(1, 2)
    pl.add_parking_spot(2, 2)
    pl.add_parking_spot(3, 2)
    print(pl.get_next_available())
    pl.park()
    print(pl.get_next_available())
    pl.unpark(1, 1)
    print(pl.get_next_available())

if __name__ == "__main__":
    main()