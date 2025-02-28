#park(): O(log N) (min-heap pop)
#leave(): O(log N) (min-heap push)
#getOccupiedSpaces(): O(N log N)(due to sorting in retrieval)
import heapq

class ParkingLot:
    def __init__(self, totalSpaces: int):
        self.totalSpaces = totalSpaces
        self.availableSpaces = list(range(1, totalSpaces + 1)) 
        heapq.heapify(self.availableSpaces)
        self.occupiedSpaces = set()  # occupied spots

    def park(self) -> int:
        if not self.availableSpaces:
            print("Parking Lot Full!")
            return -1  # no space available
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


parkingLot = ParkingLot(5)
print(parkingLot.park())  # 1
print(parkingLot.park())  # 2
print(parkingLot.park())  # 3
parkingLot.leave(2)
print(parkingLot.park())  # 2 (gets reassigned)
print(parkingLot.getOccupiedSpaces())  # [1, 2, 3]
