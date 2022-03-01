class ParkingSystem(object):
    def __init__(self, big, med, small):
        self.lotSize = [big, med, small]

    def addCar(self,carSize):
        if carSize == 1:
            if self.lotSize[0] > 0:
                self.lotSize[0] -= 1
                return True
        if carSize == 2:
            if self.lotSize[1] > 0:
                
                self.lotSize[1] -= 1
                return True
        if carSize == 3:
            if self.lotSize[2] > 0:
                
                self.lotSize[2] -= 1
                return True
        else: return False

if __name__ == "__main__":
    obj = ParkingSystem(2,1,1)

    print(obj.addCar(1))
    print(obj.addCar(1))
    print(obj.addCar(1))
    print(obj.addCar(2))
    print(obj.addCar(2))
    print(obj.addCar(2))