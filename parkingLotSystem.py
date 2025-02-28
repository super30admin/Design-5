import heapq


# Assign closest space: O(1) (Extract min)
# Free a space: O(log n) (Insert back)
# Check if occupied: O(1)
# Get all occupied spaces: O(n)
class ParkingLot:
    def __init__(self, total_spaces):
        self.total_spaces = total_spaces
        self.available_spaces = list(range(1, total_spaces + 1))  # Closest spaces first
        heapq.heapify(self.available_spaces)  # Min-heap for closest parking space
        self.occupied_spaces = set()  # Tracks occupied spaces

    def park(self):
        if not self.available_spaces:
            print("Parking lot is full")
            return None
        space = heapq.heappop(self.available_spaces)  # Get closest space
        self.occupied_spaces.add(space)
        return f"Token issued: Space {space}"

    def leave(self, space):
        if space not in self.occupied_spaces:
            print(f"Error: Space {space} is already empty or invalid")
            return
        self.occupied_spaces.remove(space)  # Mark as empty
        heapq.heappush(self.available_spaces, space)  # Add back to heap

    def get_occupied_spaces(self):
        return sorted(self.occupied_spaces)  # Return sorted occupied spaces


# Example Usage
lot = ParkingLot(5)
print(lot.park())  # Token issued: Space 1
print(lot.park())  # Token issued: Space 2
lot.leave(1)
print(lot.park())  # Token issued: Space 1 (reclaimed)
print(lot.get_occupied_spaces())  # [1, 2]
