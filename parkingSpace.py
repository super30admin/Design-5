class parkingSpace:
    def __init__(self, floor, slot):
        self.floor = floor
        self.slot = slot

    def getFloor(self):
        return self.floor

    def getSlot(self):
        return self.slot

    def getSpot(self):
        return "Parking Space(" + str(self.floor) + " " + str(self.slot) + ")"

    def __lt__(self, parkingSpace2):
        print(self.floor)
        if parkingSpace2.getFloor() == None:
            return None
        if self.floor == parkingSpace2.getFloor():
            return self.slot < parkingSpace2.getSlot()
        else:
            return self.floor < parkingSpace2.getFloor()
