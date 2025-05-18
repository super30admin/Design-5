# For the parking system, we will use two data structures:
# 1. A dictionary to store the parking lot with the car's license plate as the key and the parking spot as the value.
# 2. A min heap to keep track of the available parking spots in sorted order.
# The heap will allow us to efficiently find the next available parking spot that is closest empty space.
# The dictionary will allow us to quickly check if a car is already parked in the lot.


# Time complexity:
# - Park: O(log n) for inserting into the heap and O(1) for inserting into the dictionary.
# - Leave: O(log n) for removing from the heap and O(1) for removing from the dictionary.
# Space complexity:
# - O(n) for storing the parking spots in the heap and the parked cars in the dictionary.


import heapq

class ParkingLot:
    def __init__(self, total_spots):
        self.available = list(range(1, total_spots + 1))
        heapq.heapify(self.available)
        self.occupied = {}  

    def park(self, vehicle_number):
        if not self.available:
            return "Parking Full"
        spot = heapq.heappop(self.available)
        self.occupied[spot] = vehicle_number
        return f"Token issued for spot {spot}"

    def leave(self, spot):
        if spot in self.occupied:
            del self.occupied[spot]
            heapq.heappush(self.available, spot)
            return f"Spot {spot} is now free"
        return "Spot was not occupied"

    def getOccupiedSpots(self):
        return self.occupied.copy()
