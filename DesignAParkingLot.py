-------------------------------Design a parking lot ---------------------------------------------
# Time Complexity : park: O(1), unpark o(log(floor*spots))
# Space Complexity : O(floors*spots)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here we will first design a parking lot with number of floors and and spots for each floor.
#and we will have 2 functions which are park and unpark. We will first have vacant spots 
# and all the spots will be added to the heap which sorts by the ascending order or floors and then spots.
# Once the spot is filled up we will pop the spot from the heap. When it is vacant we will add to the heap again .
# so that we will find it in the order of floor and spot number.

import heapq
class HeapClass:
  def __init__(self, floor, spot):
    self.floor = floor
    self.spot = spot
  
  def __lt__(self, other):
    if self.floor == other.floor:
      return self.spot<other.spot
    else:
      return self.floor<other.floor

class Parkinglot:
  def __init__(self,maxFloors, maxSpots):
    self.maxFloors = maxFloors
    self.maxSpots = maxSpots
    self.heap = []
  
  def park(self):
    lot = heapq.heappop(self.heap)
    print(lot.floor, lot.spot)
    return lot
  
  def unpark(self, floor, spot):

    heapq.heappush(self.heap, HeapClass(floor, spot))
  
pl = Parkinglot(2,4)

for i in range(pl.maxFloors):
  for j in range(pl.maxSpots):
    heapq.heappush(pl.heap, HeapClass(i,j))

print((pl.heap[0].floor, pl.heap[0].spot))
pl.park()
pl.park()
pl.park()
pl.park()
print((pl.heap[0].floor, pl.heap[0].spot))
pl.unpark(0,2)
print((pl.heap[0].floor, pl.heap[0].spot))