import heapq

class ParkingLot:
    def __init__(self, size):
        # Initialize the heap with all space indices (0 to size-1)
        self.available_spaces = list(range(size))
        heapq.heapify(self.available_spaces)  # Convert the list into a heap
        self.occupied = set()  # Set to keep track of occupied spaces
        self.tokens = {}  # Dictionary to store tokens for spaces
    
    def issue_token(self):
        if not self.available_spaces:
            return "No space available"
        
        # Get the closest available space (smallest index) from the heap
        space = heapq.heappop(self.available_spaces)
        self.occupied.add(space)
        # Generate a token for this space (here just using the space index)
        token = f"Token-{space}"
        self.tokens[space] = token
        return token
    
    def leave_space(self, space):
        if space not in self.occupied:
            return "Space not occupied"
        
        # Remove the space from the occupied set and the tokens dictionary
        self.occupied.remove(space)
        del self.tokens[space]
        # Add the space back to the heap (making it available for future allocation)
        heapq.heappush(self.available_spaces, space)
    
    def get_occupied_spaces(self):
        return list(self.occupied)

# Example usage:
lot = ParkingLot(10)
token1 = lot.issue_token()  # Issue token for the closest space
token2 = lot.issue_token()  # Issue token for the next closest space
print(token1)
print(lot.get_occupied_spaces())  # Output: List of currently occupied spaces
lot.leave_space(0)  # Mark space 0 as empty
print(lot.get_occupied_spaces())  # Output: List of currently occupied spaces
print(lot.available_spaces)
