import heapq

class ParkingLot:
    def __init__(self, total_spaces: int):
        self.total_spaces = total_spaces
        self.available_spaces = [(i, i) for i in range(1, total_spaces + 1)]
        heapq.heapify(self.available_spaces)
        self.occupied_spaces = set()
        self.token_map = {}
    
    def park(self) -> int:
        if not self.available_spaces:
            print("Parking Lot Full!")
            return -1
        
        _, space = heapq.heappop(self.available_spaces)
        token = space
        self.occupied_spaces.add(space)
        self.token_map[token] = space
        print(f"Car parked at space {space}, Token: {token}")
        return token
    
    def leave(self, token: int):
        if token not in self.token_map:
            print("Invalid Token!")
            return
        
        space = self.token_map.pop(token)
        self.occupied_spaces.remove(space)
        heapq.heappush(self.available_spaces, (space, space))
        print(f"Space {space} is now available.")
    
    def get_occupied_spaces(self):
        return sorted(self.occupied_spaces)