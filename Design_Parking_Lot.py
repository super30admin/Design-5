# park: O(log n)
# leave: O(log n)
# getOccupiedSpaces: O(n log n)
import heapq

class ParkingLot:
    def __init__(self, totalSpaces: int):
        self.totalSpaces = totalSpaces
        self.availableSpaces = list(range(1, totalSpaces + 1)) 
        heapq.heapify(self.availableSpaces)
        self.occupiedSpaces = set()

    def park(self) -> int:
        if not self.availableSpaces:
            print("Parking Lot Full!")
            return -1
        space = heapq.heappop(self.availableSpaces)
        self.occupiedSpaces.add(space)
        return space

    def leave(self, space: int):
        if space in self.occupiedSpaces:
            self.occupiedSpaces.remove(space)
            heapq.heappush(self.availableSpaces, space)
        else:
            print(f"Space {space} is already empty or invalid.")

    def getOccupiedSpaces(self):
        return sorted(self.occupiedSpaces)