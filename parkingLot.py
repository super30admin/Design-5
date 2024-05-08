class Car:
    def __init__(self, license_number):
        self.license_number = license_number

class ParkingSpot:
    def __init__(self, number):
        self.number = number
        self.is_occupied = False
        self.current_car = None

    def park_car(self, car):
        if not self.is_occupied:
            self.current_car = car
            self.is_occupied = True
            return True
        return False

    def remove_car(self):
        if self.is_occupied:
            self.current_car = None
            self.is_occupied = False
            return True
        return False

class ParkingLot:
    def __init__(self, num_spots):
        self.spots = [ParkingSpot(i) for i in range(num_spots)]
    
    def find_free_spot(self):
        for spot in self.spots:
            if not spot.is_occupied:
                return spot
        return None
    
    def park_car(self, car):
        free_spot = self.find_free_spot()
        if free_spot:
            return free_spot.park_car(car)
        return False

    def remove_car(self, spot_number):
        if 0 <= spot_number < len(self.spots):
            return self.spots[spot_number].remove_car()
        return False

# Usage
parking_lot = ParkingLot(10)  # Create a parking lot with 10 spots
car1 = Car("ABC123")
car2 = Car("XYZ456")

# Park cars
print(parking_lot.park_car(car1))  # True
print(parking_lot.park_car(car2))  # True

# Try to remove car from spot 0
print(parking_lot.remove_car(0))  # True

# Try to park another car in the same spot
car3 = Car("LMN789")
print(parking_lot.park_car(car3))  # True
