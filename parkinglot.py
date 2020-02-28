class parking_lot:
    def __init__(self, m, n):
        # Initilizing a hashmap named spots_map to map car number with the spot where the car was parked
        self.spots_map = {}
        # Empty_spaces is list of all available parking spaces. It has all spaces initially
        self.empty_spaces = [(i,j) for j in range(1,n+1)for i in range(1,m+1)]
    
    def park(self, number):
        # Checking if car number is valid i.e the incoming car number should not be in the spots_map
        if number in self.spots_map:
            print("Invalid car - car already present in lot")
            return
        
        import heapq
        # If there are no available spaces, return by printing that lot is full
        if not self.empty_spaces:
            print("Sorry, Parking lot is full")
            return 
        
        # if empty spaces are present, heapify the spaces to get the nearest available spot from entrance (which is assumed to 
        # be at 0,1
        heapq.heapify(self.empty_spaces)
        # get floor an spot where car can be parked and assign the those value to the car number
        floor , spot = heapq.heappop(self.empty_spaces)
        print("Please place the car in floor", floor,"spot", spot)
        self.spots_map[number] = (floor, spot)
        
    def unpark(self, number):
        # checking if the car number is valid i.e if it is parked in the lot
        if number in self.spots_map:
            # getting the floor and spot of the car based on car number and deleting its entry from spots_map and making the 
            # space available
            floor, spot = self.spots_map[number]
            self.empty_spaces.append((floor, spot))
            del self.spots_map[number]
            print("Car removed from floor", floor, "spot", spot)
            # If car number is not valid
        else:
            print("Invalid car number")
            return
    
    
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