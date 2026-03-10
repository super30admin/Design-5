# Time Complexity : O(log n) per entry/exit, n = number of parking spaces
# Space Complexity : O(n), for tracking empty spaces and occupied spaces
# Did this code successfully run on Leetcode : N/A (design problem)
# Any problem you faced while coding this : No

# Explanation:
# 1. Use a min-heap to track empty parking spaces (closest to entrance is always on top).
# 2. Use a set to track occupied spaces if needed for reporting all occupied spaces.
# 3. On car entry, pop the smallest space number from heap and mark it as occupied.
# 4. On car exit, push the freed space back to the min-heap and remove from occupied set.
# 5. This ensures always allocating the closest available space in O(log n).

import heapq

class ParkingLot:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.empty_spaces = list(range(1, capacity + 1))  # min-heap of empty spaces
        heapq.heapify(self.empty_spaces)
        self.occupied = set()  # set of occupied space numbers

    def park(self) -> int:
        if not self.empty_spaces:
            raise Exception("Parking lot full")
        space = heapq.heappop(self.empty_spaces)
        self.occupied.add(space)
        return space

    def leave(self, space: int) -> None:
        if space in self.occupied:
            self.occupied.remove(space)
            heapq.heappush(self.empty_spaces, space)
        else:
            raise Exception("Space already empty")

    def getOccupiedSpaces(self) -> set:
        return self.occupied.copy()