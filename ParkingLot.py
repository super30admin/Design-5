# Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. When someone leave you need update this space as empty.

# Data Structures
# Priority Queue: To track the closest available parking space. This data structure allows us to efficiently retrieve and remove the closest parking space.
# Hash Set: To keep track of the occupied spaces.
# Array/List: To represent the parking spaces for quick access and updates.

# Time Complexity : O(n), where n is the number of parking spaces
# Space Complexity : O(n)

import heapq

class ParkingLot:
    def __init__(self, total_spaces):
        self.total_spaces = total_spaces
        self.available_spaces = list(range(1, total_spaces + 1))
        heapq.heapify(self.available_spaces)
        self.occupied_spaces = set()

    def park(self):
        if not self.available_spaces:
            return "Parking lot is full"
        space = heapq.heappop(self.available_spaces)
        self.occupied_spaces.add(space)
        return "Park at space {}".format(space)

    def leave(self, space):
        if space not in self.occupied_spaces:
            return "Space {} is already empty".format(space)
        self.occupied_spaces.remove(space)
        heapq.heappush(self.available_spaces, space)
        return "Space {} is now free".format(space)

    def get_occupied_spaces(self):
        return sorted(self.occupied_spaces)

# Example 1
parking_lot = ParkingLot(5)
print(parking_lot.park())  # Output: Park at space 1
print(parking_lot.park())  # Output: Park at space 2
print(parking_lot.leave(1))  # Output: Space 1 is now free
print("Occupied spaces: {}".format(parking_lot.get_occupied_spaces()))  # Output: Occupied spaces: [2]

# Example 2
print(parking_lot.park())  # Output: Park at space 1
print(parking_lot.park())  # Output: Park at space 3
print(parking_lot.park())  # Output: Park at space 4
print(parking_lot.leave(2))  # Output: Space 2 is now free
print(parking_lot.leave(2))  # Output: Space 2 is already empty
print("Occupied spaces: {}".format(parking_lot.get_occupied_spaces()))  # Output: Occupied spaces: [1, 3, 4]

# Example 3
print(parking_lot.park())  # Output: Park at space 2