# Time Complexity:
# park: O(log n) 
# leave: O(log n) 
# get_occupied_spaces: O(n) 
# Space Complexity: O(n) 

import heapq

class ParkingLot:
    def __init__(self, total_spaces: int):
        """
        Initialize a parking lot with a specified number of spaces.
        
        :param total_spaces: The total number of parking spaces.
        """
        self.available = list(range(1, total_spaces + 1))  # 1-indexed spaces
        heapq.heapify(self.available)
        self.occupied = set()

    def park(self) -> int:
        """
        Park a vehicle in the parking lot.
        
        :return: The parking space number if available, otherwise None.
        """
        if not self.available:
            return None  # No space available
        space = heapq.heappop(self.available)
        self.occupied.add(space)
        return space  # Token with space number

    def leave(self, space: int) -> None:
        """
        Remove a vehicle from the parking lot.
        
        :param space: The parking space number.
        :raises ValueError: If the space is not occupied.
        """
        if space not in self.occupied:
            raise ValueError("Space is not occupied")
        self.occupied.remove(space)
        heapq.heappush(self.available, space)

    def get_occupied_spaces(self) -> list:
        """
        Get a list of occupied parking spaces.
        
        :return: A list of occupied parking space numbers.
        """
        return list(self.occupied)
