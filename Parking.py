# Time Complexity : O(1) for allocate,freespace anf available
# Space Complexity : O(n)

from heapq import heappush as push
from heapq import heappop as pop
from heapq import heapify
class Parking:

    def __init__(self,spaces,dist_map):
        self.spaces = spaces
        self.heap = []
        self.dist_map = dist_map
        heapify(self.heap)
        for key in self.dist_map:
            push(self.heap,(self.dist[key],key))

    def allocate(self):
        _,key = pop(self.heap)
        return key


    def freeSpace(self,key):
        push(self.heap,(self.dist[key],key))


    def available(self):
        print(self.heap)