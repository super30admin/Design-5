import heapq

# Class to handle each slot status in the parking lot
class Slot:
	def __init__(self, floor, slotno):
		self.floor = floor
		self.slotno = slotno
		self.reserve = "N"

	def __lt__(self, other):
		if self.floor < other.floor or (self.floor==other.floor and self.slotno < other.slotno):
			return True
		return False

	def reserve_slot(self):
		self.reserve = "Y"

	def unreserve_slot(self):
		self.reserve = "N"


class ParkingLot:
	def __init__(self, nfloors, ncapacity):
		self.nfloors = nfloors
		self.ncapacity = ncapacity
		self.slots = []
		# min heap to maintain the available slots
		self.available_slots = []
		self.create_slots()
		self.vechile_slots = {}	# dictionary to hold vechile and parking slot mapping.

	# create parking lot slots.
	def create_slots(self):
		for f in range(self.nfloors):
			for s in range(self.ncapacity):
				slot = Slot(f, s)
				self.slots.append(slot)
				heapq.heappush(self.available_slots, slot)

	# return the next available slot.
	def next_available(self):
		if len(self.available_slots)==0:
			raise Exception("Cannot find any available slots.")
		slot = heapq.nsmallest(1, self.available_slots)[0]
		print("Next available parking slot is {} on floor {}.".format(slot.slotno, slot.floor))

	# pop the next available slot.
	def get_slot(self):
		if len(self.available_slots)==0:
			raise Exception("Cannot find any available slots.")
		return heapq.heappop(self.available_slots)

	# reserve a slot in parking lot.
	def reserve_slot(self, vechile):
		# check if the vehicle is already present in the vechile slot dictionary. If yes, raise an error.
		if vechile in self.vechile_slots:
			slot = vechile_slots[vechile]
			raise Exception("Parking slot {} on floor {} is already reserved by the vechile {}.".format(slot.slotno, slot.floor, vechile))

		# reserve the slot for the new vechile.
		slot = self.get_slot()
		self.vechile_slots[vechile] = slot
		slot.reserve = 'Y'
		print("Slot no: {} on floor {} has been reserved by vechile {} for parking.".format(slot.slotno, slot.floor, vechile))


	# unreserve a slot.
	def unreserve_slot(self, vechile):
		# raise an error if vechile is not present in the reserved slots hash table.
		if vechile not in self.vechile_slots:
			raise Exception("Vechile not found in the reserved list.")

		slot = self.vechile_slots[vechile]
		del self.vechile_slots[vechile]		# delete the vechile slot mapping from the mapping hash table.
		slot.reserve = 'N'
		# push the slot back to the available slots heap
		heapq.heappush(self.available_slots, slot)
		print("Slot no: {} on floor {} has been unreserved by vechile {}.".format(slot.slotno, slot.floor, vechile))

	# Show the status of the available slots
	def show_slot_status(self, slot):
		if slot.reserve == "Y":
			print("Floor: {}, Slot No: {} is reserved!".format(slot.floor, slot.slotno))
		else:
			print("Floor: {}, Slot No: {} is available!".format(slot.floor, slot.slotno))

	# show the slots status
	def slow_slots(self):
		for slot in self.slots:
			self.show_slot_status(slot)


if __name__ == '__main__':
	park = ParkingLot(2, 2)
	
	park.next_available()
	park.reserve_slot("ABC")
	
	park.next_available()
	park.reserve_slot("DAM")
	
	park.next_available()
	park.reserve_slot("SJK")

	park.unreserve_slot("ABC")
	
	park.slow_slots()

	park.next_available()
	park.reserve_slot("AKP")
	
	# park.next_available()





