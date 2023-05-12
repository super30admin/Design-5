# Time Complexity : O(1) For both methods
# Space Complexity : O(N), where N is the total number of parking spaces.
class ParkingLot:
    def __init__(self, num_spaces):
        self.num_spaces = num_spaces
        self.available_spaces = set(range(1, num_spaces + 1))
        self.occupied_spaces = {}

    def park(self):
        if not self.available_spaces:
            return -1  # No available spaces
        space = self.available_spaces.pop()
        self.occupied_spaces[space] = True
        return space

    def leave(self, space):
        if space in self.occupied_spaces:
            del self.occupied_spaces[space]
            self.available_spaces.add(space)

    def get_available_spaces(self):
        return self.available_spaces

    def get_occupied_spaces(self):
        return self.occupied_spaces.keys()


# Example usage:
parking_lot = ParkingLot(10)
print("Available Spaces:", parking_lot.get_available_spaces())
print("Occupied Spaces:", parking_lot.get_occupied_spaces())

# Park 3 cars
print("Parked in space", parking_lot.park())
print("Parked in space", parking_lot.park())
print("Parked in space", parking_lot.park())

print("Available Spaces:", parking_lot.get_available_spaces())
print("Occupied Spaces:", parking_lot.get_occupied_spaces())

# Car in space 2 leaves
parking_lot.leave(2)

print("Available Spaces:", parking_lot.get_available_spaces())
print("Occupied Spaces:", parking_lot.get_occupied_spaces())
