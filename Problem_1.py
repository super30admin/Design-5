"""
Problem 1: 
This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
When someone leave you need update this space as empty. 
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
"""

"""
Problem 1: 
This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
When someone leave you need update this space as empty. 
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
"""
import logging
class ParkingSpot:
    def __init__(self, floorID=None, spotID=None):
        self.floorID = floorID
        self.spotID = spotID
        
class Comparator:
    def __init__(self, floorID, spotID):
        self.floorID = floorID
        self.spotID  = spotID
        
    def __lt__(self, obj):
        if self.floorID == obj.floorID:
            return self.spotID < obj.spotID
        
        return self.floorID < obj.floorID
    
    def __eq__(self, other):
        return self.floorID == other.floorID and self.spotID == other.spotID

import heapq
class Parking:
    def __init__(self, max_floor, spots_per_floor):
        self.max_floor = max_floor
        self.spots_per_floor = spots_per_floor
        self.pq = []
        
        
    def add_parking_spots(self, floorID, spotID):
        """
        Add all the available parking spots in a heap as per the max parking area
        TC: O(NlogK), N is total no of spots
        SC: O(N)
        """
        
        if floorID > self.max_floor:
            logging.error("Max Capacity reached : The floor is outside the capacity of the parking lot")
            return
            
        if spotID > self.spots_per_floor:
            logging.error("Max Capacity reached: The spot is outside the capacity of the spots per floor")
            return
            
        spot = Comparator(floorID, spotID)
        self.pq.append(spot)
        heapq.heapify(self.pq)

        
    def park_the_car(self):
        """
        Park the car in the available position
        TC: O(1)
        SC: O(1)
        """
        if len(self.pq) == 0 or self.pq == None:
            logging.error("Max size reached: The parking is full, there is no available space")
            return
            
        spot = heapq.heappop(self.pq)
        
        return spot
    
    def unpark_the_car(self, floorID, spotID):
        """
        unpark the car from the given location
        TC: O(N)
        SC: O(N)
        """
        spot = Comparator(floorID, spotID)
        
        if spot in self.pq:
            logging.error("the spot is free: there is no car to unpark")
            return
            
        self.pq.append(spot)
        heapq.heapify(self.pq)
        
    def get_next_spot(self):
        """
        TC: O(1)
        SC: O(1)
        """
        if len(self.pq) == 0 or self.pq == None:
            logging.error("Max size reached: The parking is full, there is no available space")
            
        return self.pq[0]
        
        
# driver Code
PARK = Parking(10, 10)
PARK.add_parking_spots(0,1)
PARK.add_parking_spots(1,3)
PARK.add_parking_spots(2,1)
PARK.add_parking_spots(2,5)
PARK.add_parking_spots(3,1)
PARK.add_parking_spots(3,2)

spot = PARK.get_next_spot()
print("the next available spot is at floor ",spot.floorID, " and lot ", spot.spotID)

p1 = PARK.park_the_car()
print("Your car is parked at floor ", p1.floorID, " and lot ",p1.spotID)
p2 = PARK.park_the_car()
print("Your car is parked at floor ", p2.floorID, " and lot ",p2.spotID)
p3 = PARK.park_the_car()
print("Your car is parked at floor ", p3.floorID, " and lot ",p3.spotID)

spot1 = PARK.get_next_spot()
print("the next available spot is at floor ",spot1.floorID, " and lot ", spot1.spotID)
PARK.unpark_the_car(2,5)

PARK.unpark_the_car(2,3)


spot2 = PARK.get_next_spot()
# for s in PARK.pq:
#     print(s.floorID, s.spotID)
print("the next available spot is at floor ",spot2.floorID, " and lot ", spot2.spotID)

# check edge cases
PARK.add_parking_spots(11,2)
p4 = PARK.park_the_car()
print("Your car is parked at floor ", p4.floorID, " and lot ",p4.spotID)
p5 = PARK.park_the_car()
print("Your car is parked at floor ", p5.floorID, " and lot ",p5.spotID)
p6 = PARK.park_the_car()
print("Your car is parked at floor ", p6.floorID, " and lot ",p6.spotID)
p7 = PARK.park_the_car()
print("Your car is parked at floor ", p7.floorID, " and lot ",p7.spotID)
p8 = PARK.park_the_car()
p9 = PARK.park_the_car()


