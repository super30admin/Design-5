class ParkingSpot:
    def __init__(self, level, spot):
        self.level = level
        self.spot = spot
    def __lt__(self, other):
        if self.level!=other.level:
            self.level < other.level
        else:
            self.spot < other.spot
    def getSpot(self):
        return self.spot
    def getLevel(self):
        return self.level


class ParkingLot:
    
    def __init__(self, number_of_level, number_of_spot):
        import heapq
        self.number_of_level = number_of_level
        self.number_of_spot = number_of_spot
        self.free_space = []
        self.__populateSpace()
        
        
    def __populateSpace(self):
        for i in range(self.number_of_level):
            for j in range(self.number_of_spot):
                heapq.heappush(self.free_space, ParkingSpot(i, j))
                
    def park(self):  
        try:
            p_spot = heapq.heappop(self.free_space)
            level = p_spot.getLevel()
            spot = p_spot.getSpot()
            return [level, spot]
        except:
            print("Parking spot is full")
            
    def unpark(self, level, spot):
        if level < self.number_of_level and spot < self.number_of_spot:
            heapq.heappush(self.free_space, ParkingSpot(level, spot))
        else:
            print("Invalid Parking Spot Number")
            

# Driver
parking = ParkingLot(2, 2)
lot_num = parking.park()
print(lot_num)
lot_num = parking.park()
print(lot_num)
lot_num = parking.park()
print(lot_num)
lot_num = parking.park()
print(lot_num)
lot_num = parking.park()
print(lot_num)
parking.unpark(1, 0)
parking.unpark(0, 1)
lot_num = parking.park()
print(lot_num)
lot_num = parking.park()
print(lot_num)

            
        
        
