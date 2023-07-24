'''
Problem: Design Parking lot System
Time Complexity: O(nlogn), where n is the empty spots
Space Complexity: O(n), where n is empty spots
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        used a miheap in which inserting the parkings spot(floor, spot)
        whenever unpark, add empty spot to minheap to get the closest spot for next car
        park() pop the closest spot from the heap
'''

import heapq

class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

class ParkingLot:
    def __init__(self, maxFloor, spotsPerFloor):
        self.maxFloor = maxFloor
        self.spotsPerFloor = spotsPerFloor
        self.pq = []
        heapq.heapify(self.pq)
        
    def park(self):
        if len(self.pq) == 0:
            return None
        else:
            spot = heapq.heappop(self.pq)
            return spot
    
    def unpark(self, floor, spot):
        space = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, (space.floor, space.spot))
    
    def getNextAvailable(self):
        return self.pq[0]
    
    def addParkingSpot(self, floor, spot):
        if floor > self.maxFloor:
            print('Maximum floors reached')
            return None
        
        if spot > self.spotsPerFloor:
            print('Maximum spots reached')
            return None
        
        space = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, (space.floor, space.spot))
            

#DRIVER CODE
p1 = ParkingLot(10, 20)
p1.addParkingSpot(1, 1)
p1.addParkingSpot(2, 1)
p1.addParkingSpot(3, 1)
p1.addParkingSpot(1, 2)
p1.addParkingSpot(2, 2)
p1.addParkingSpot(3, 2)
n = p1.getNextAvailable();
print('Next available slot is:', n)
space = p1.park()
if space is None:
    print('Parking lot is full')
else:
    print('Parked at :', space)
    
space = p1.park()
if space is None:
    print('Parking lot is full')
else:
    print('Parked at :', space)
    
space = p1.park()
if space is None:
    print('Parking lot is full')
else:
    print('Parked at :', space)
    
p1.unpark(1,2)
print('Unparking from (1,2)')

space = p1.park()
if space is None:
    print('Parking lot is full')
else:
    print('Parked at :', space)
    
n = p1.getNextAvailable();
print('Next available slot is:', n)