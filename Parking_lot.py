class parking_lot:
    def __init__(self, m, n):
        self.spots_map = {}
        self.empty_spaces = [(i,j) for j in range(1,n+1)for i in range(1,m+1)]
    
    def park(self, number):
        if number in self.spots_map:
            print("Invalid car - car already present in lot")
            return
        
        import heapq
        if not self.empty_spaces:
            print("Sorry, Parking lot is full")
            return 
        
        # if empty spaces are present
        heapq.heapify(self.empty_spaces)
        floor , spot = heapq.heappop(self.empty_spaces)
        print("Please place the car in floor", floor,"spot", spot)
        self.spots_map[number] = (floor, spot)
        
    def unpark(self, number):
        if number in self.spots_map:
            floor, spot = self.spots_map[number]
            self.empty_spaces.append((floor, spot))
            del self.spots_map[number]
            print("Car removed from floor", floor, "spot", spot)
        else:
            print("Invalid car number")
    
    
p = parking_lot(2,3)
p.park(1234)
p.park(234)
p.park(9876)
p.park(986)
p.park(876)
p.unpark(1234)
p.unpark(234)
p.unpark(9876)
p.park(2345)
p.park(2345)
p.unpark(10)
p.unpark(1234)
p.park(98761)
p.park(9861)
p.park(8761)
p.park(987634)

'''
             # output

Please place the car in floor 1 spot 1
Please place the car in floor 1 spot 2
Please place the car in floor 1 spot 3
Please place the car in floor 2 spot 1
Please place the car in floor 2 spot 2
Car removed from floor 1 spot 1
Car removed from floor 1 spot 2
Car removed from floor 1 spot 3
Please place the car in floor 1 spot 1
Invalid car - car already present in lot
Invalid car number
Invalid car number
Please place the car in floor 1 spot 2
Please place the car in floor 1 spot 3
Please place the car in floor 2 spot 3
Sorry, Parking lot is full
'''
