"""
Description: Design a parking lot with floors and spots with one entry/exit point

Time Complexity: O(log (m*n)): to park and unpark
Space Complexity: O(m*n), where m -> number of floors and n are number of spots per floor

Working Code: Not yet, unable to resolve heappush error:
'list' object has no attribute 'heappush'
"""

from heapq import heapify, heappop, heappush

class ParkingSpot:
    
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot
        
    """ currently unused
    def getSpotID(self):
        return [self.floor, self.spot]
    """

class ParkingLot:
    
    def __init__(self, nFloor, nSpot):
        self.nFloor = nFloor
        self.nSpot = nSpot
        self.queue = []
        heapify(self.queue)
        
    # Considerig heap has only empty spots
    def Park(self):
        if self.queue: heappop(self.queue)
    
    def unPark(self, floor, spot):
        self.queue.heappush([floor, spot])
        
    def addSpot(self, floor, spot):
        pSpot = ParkingSpot(floor, spot)
        heappush(self.queue, [floor, spot])
        return pSpot
    
    def nextEmptySpot(self):
        if self.queue:
            return self.queue[0]
        else:
            return None, None
          
def main():
    
    pl = ParkingLot(5, 24) # parking lot with 5 floors and 24 spots each
    
    pl.addSpot(1,12)
    pl.addSpot(2,15)
    pl.addSpot(3,1)
    pl.addSpot(1,20)
    pl.addSpot(2,3)
    pl.addSpot(3,5)
    
    print(pl.nextEmptySpot())
    pl.Park()
    print(pl.nextEmptySpot())
    pl.unPark(1,12)
    print(pl.nextEmptySpot())
    
if __name__ == "__main__":
    main()
