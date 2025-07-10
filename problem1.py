# Time Complexity : O(log n) for park and leave, O(1) for get_occupied_spaces
# Space Complexity : O(n) for occupied set and O(n) for available list
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

class ParkingLot:
    def __init__(self, total_spaces):
        self.available = list(range(1, total_spaces + 1))  # 1-indexed spaces
        heapq.heapify(self.available)
        self.occupied = set()

    def park(self):
        if not self.available:
            return None  # No space available
        space = heapq.heappop(self.available)
        self.occupied.add(space)
        return space  # Token with space number

    def leave(self, space):
        if space in self.occupied:
            self.occupied.remove(space)
            heapq.heappush(self.available, space)

    def get_occupied_spaces(self):
        return list(self.occupied)
