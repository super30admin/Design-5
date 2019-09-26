import Queue
class parking_lot:
    floors = 2
    slots_on_floor = 10
    self.available_slots = Queue.PriorityQueue()
    self.available_slots.put(range(1, (floors * slots_on_floor)+1))
    self.token = 1
    self.tracker = {}
    def park(self):
        if self.available_slots.empty():
            print("Sorry! No space Available")
            return None
        else:
            park_num = self.available_slots.get()
            self.tracker[self.token] = park_num
            self.token += 1
            return (self.token)

    def unpark(self, token_num):
        if token_num not in self.tracker:
            print("Wrong Token Number !")
            return
        else:
            parked_slot = self.tracker[token_num]
            self.available_slots.put(parked_slot)
            del self.tracker[token_num]