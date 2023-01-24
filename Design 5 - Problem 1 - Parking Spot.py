"""
FAANMG Problem #114 {Hard} 

Parking Spot


# Space complexity : O(m*n) --> m = floors, n = spots on each floor

Did this code successfully run on Leetcode : Yes

@name: Rahul Govindkumar
"""



import heapq
from random import randint

# defining class for Parking Spot which contains floors and spots on each floor
class ParkingSpot:
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    # writing getter functions to fetch the floor and spot number
    def getSpot(self):
        return self.spot

    def getFloor(self):
        return self.floor

    # writing custom comparators as we have two atteibutes to compare to get a Parking spot
    def __lt__(self, other):
        # if the floor is same then get the lower value of spot
        if self.getFloor() == other.getFloor():
            return self.getSpot() < other.getSpot()
        else:
          # otherwise return the lower floor value
            return self.getFloor() < other.getFloor()
    # custom function for greater comparison
    def __gt__(self, other):
      # if the floor is same then get the lower value of spot
        if self.getFloor() == other.getFloor():
            return self.getSpot() > other.getSpot()
        else:
           # otherwise return the greater floor value
            return self.getFloor() > other.getFloor() 

    # function that returns value if we have the same spot and floor
    def __eq__(self, other):
        return (self.getFloor() == other.getFloor() and self.getSpot() == other.getSpot())

    # string output of the floor and spot availability
    def __str__(self):
        return 'Floor: {} || Slot: {}'.format(self.getFloor(), self.getSpot())

# adding class for Parking Lot having attributes as the maimum floor and mx spots on a floor
class ParkingLot:
    def __init__(self, maxF , spotsF):
        self.maxF = maxF
        self.spotsF = spotsF

        # maintain a priority que - Heap for the available spots and floor
        self.que = []
        for floor in range(maxF):
            for spot in range(spotsF):
                # add parking spots for all the possible available in the queue
                self.addParking(floor, spot)

    # Time : O(log mn)
    def park(self):
        # if the queue is not empty then remove one spot from the que and return else the parking Lot is full
        if len(self.que) > 0:
            parkingSpot = heapq.heappop(self.que)
            return parkingSpot
        else:
            print('No parking space available')
            return None

    # Time : O(log mn)
    def unpark(self, parkingSpot):
        # fetch the current parking floor and spot and add it to the queue
        floor = parkingSpot.getFloor()
        spot = parkingSpot.getSpot()

        # check if the spot is within the parking space
        if floor < self.maxF and spot < self.spotsF:
            self.addParking(floor, spot)
        else:
            print('Invalid parking spot')

    # add the spot to the queue if it is within the Parking Space
    def addParking(self, floor, spot):
        parkingSpot = ParkingSpot(floor, spot)

        if floor < self.maxF and spot < self.spotsF:
            heapq.heappush(self.que, parkingSpot)
        else:
            print('Invalid spot')

    # print the available slots at each opertaion
    def status(self):
        print('Available Slots: {}'.format(len(self.que)))


# custom values to test the above code for Parking Lot
def main():

    parkingLot = ParkingLot(2, 2)

    for i in range(5):
        print(parkingLot.status())
        print("Parking: {}".format(parkingLot.park()))
        print('-------------------------------------')

    for i in range(3):
        parkingSpace = ParkingSpot(randint(0, 2), randint(0, 3))
        parkingLot.unpark(parkingSpace)
        print(parkingLot.status())
        print("Parking: {}".format(parkingLot.park()))
        print('-------------------------------------')

if __name__ == '__main__':
    main()