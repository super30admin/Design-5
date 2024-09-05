# Design-5

## Problem 1: 
This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
When someone leave you need update this space as empty. 
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.

import heapq

class ParkingLot:
    def __init__(self, total_spaces):
        # Initialize the total number of parking spaces
        self.total_spaces = total_spaces
        # Min-heap to track the closest available space
        self.available_spaces = [(i, i) for i in range(1, total_spaces + 1)]
        heapq.heapify(self.available_spaces)
        # Set to keep track of occupied spaces
        self.occupied_spaces = set()

    def park(self):
        """Assign the closest available space."""
        if self.available_spaces:
            # Pop the closest space from the heap
            closest_space = heapq.heappop(self.available_spaces)[1]
            # Mark it as occupied
            self.occupied_spaces.add(closest_space)
            # Provide the token with the space number
            print(f"Vehicle parked at space {closest_space}")
            return closest_space
        else:
            print("Parking Lot is full")
            return None

    def leave(self, space_number):
        """Free up a parking space when a vehicle leaves."""
        if space_number in self.occupied_spaces:
            # Remove the space from occupied set
            self.occupied_spaces.remove(space_number)
            # Add it back to the heap of available spaces
            heapq.heappush(self.available_spaces, (space_number, space_number))
            print(f"Space {space_number} is now free")
        else:
            print(f"Space {space_number} is not currently occupied")

    def occupied(self):
        """Get a list of all occupied spaces."""
        return sorted(list(self.occupied_spaces))

# Example usage
if __name__ == "__main__":
    # Create a parking lot with 10 spaces
    parking_lot = ParkingLot(10)
    
    # Park vehicles
    parking_lot.park()  # Vehicle parked at space 1
    parking_lot.park()  # Vehicle parked at space 2
    
    # Leave space 1
    parking_lot.leave(1)  # Space 1 is now free
    
    # Park another vehicle
    parking_lot.park()  # Vehicle parked at space 1 again, since it is the closest
    
    # Check occupied spaces
    print("Occupied spaces:", parking_lot.occupied())

# TC = O(log n), SC = O(1)


## Problem 2: Copy List with Random Pointer https://leetcode.com/problems/copy-list-with-random-pointer/

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        current = head
        while current:
            cloned_node = Node(current.val, current.next)
            current.next = cloned_node
            current = cloned_node.next
        current = head
        while current:
            if current.random:
                current.next.random = current.random.next
            current = current.next.next
        original_current = head
        cloned_head = head.next
        while original_current:
            cloned_current = original_current.next
            original_current.next = cloned_current.next
            if cloned_current.next:
                cloned_current.next = cloned_current.next.next
            original_current = original_current.next
        return cloned_head
# TC = O(n), SC = O(1)