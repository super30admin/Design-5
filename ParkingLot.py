import heapq

class ParkingSpot:
	def __init__(self, floor, spot):
		self.floor = floor
		self.spot = spot

	def __lt__(self, other):
		# For heapify
		if self.floor == other.floor:
			return self.spot < other.spot
		else:
			return self.floor < other.floor

class ParkingLot:
	def __init__(self):
		l = [] # dummy data
		for i in range(1,3):
			for j in range(1,5):
				l.append(ParkingSpot(i, j))
		self.parkingLot = l# all the spots contains an array of all the Spot objects
		self.pqueue = [] # to store the empty spots
		self.occupied = set() # to store the spots which are occupied
		for i in self.parkingLot:
			heapq.heappush(self.pqueue, i)

	def park(self):
		# Time Complexity : O(log n) where n is the number of empty spots available
		spot = heapq.heappop(self.pqueue)
		self.occupied.add(spot)
		return spot

	def unpark(self, spot): # if they give me the floor number and spot number then create a object of parkingspot and use that for the set and queue
		# Instead of creating the object again, we can store the floornumber_spotnumber as a key in the dictionary instead of a hashset just storing the objects
		# In the dictionary key is the floornumber_spotnumber and the value is the ParkingSpot object
		# Time Complexity : O(log n) where n is the number of empty spots available. Whenever we push or pop to a priority queue, heapify happens and that take O(log n) complexity
		self.occupied.remove(spot)
		heapq.heappush(self.pqueue, spot)

if __name__ == '__main__':
	pl = ParkingLot()
	sp1 = pl.park()
	print(sp1.floor, sp1.spot)
	sp2 = pl.park()
	print(sp2.floor, sp2.spot)
	sp3 = pl.park()
	print(sp3.floor, sp3.spot)
	pl.unpark(sp1)
	sp4 = pl.park()
	print(sp4.floor, sp4.spot)