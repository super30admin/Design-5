#TC:O(log N)
#SC:O(N)
class ParkingLot:
    def __init__(self, capacity):
        self.parking_spaces = [None] * capacity
        self.empty_spaces_queue = []
        self.occupied_spaces = set()
        self.closest_empty_heap = []

    def park_vehicle(self, vehicle):
        if not self.empty_spaces_queue:
            return "Parking is full"
        
        space = self.empty_spaces_queue.pop(0)
        self.parking_spaces[space] = vehicle
        self.occupied_spaces.add(space)
        
        return space

    def exit_vehicle(self, space):
        if space in self.occupied_spaces:
            self.parking_spaces[space] = None
            self.occupied_spaces.remove(space)
            self.empty_spaces_queue.append(space)
            heapq.heappush(self.closest_empty_heap, space)

    def get_closest_empty_space(self):
        return heapq.heappop(self.closest_empty_heap)

    def get_occupied_spaces(self):
        return self.occupied_spaces


