class ParkingLot:
    def __init__(self, floor, spots):
        self.floors = floor
        self.spots = spots
        self.pq = []
        for i in range(self.floors):
            for j in range(self.spots):
                heapq.heappush(self.pq, (i, j))
    def is_available(self):
        return self.pq[0]
    def park(self):
        if not self.pq:
            print("Parking lot full!")
            return
        spot = heapq.heappop(self.pq)
        return spot
    
    def unpark(self, floor, spot):
        if floor>=self.floors or spot >= self.spots:
            print("Incorrect floor or spot.")
            return
        heapq.heappush(self.pq, (floor, spot))
        
pl =  ParkingLot(1, 5)
print("next available: ", pl.is_available())
sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
print("next available: ", pl.is_available())

sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
pl.unpark(0, 0)
sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
sp = pl.park()
if sp:
    print("Parked at Floor: " , sp[0] , ", Slot: " ,sp[1])
