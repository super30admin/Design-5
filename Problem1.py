#TIme complexity is: O(n) where n is the no of parking slots in the priority queue
#Space complexity is: O(m*n) m=flors, n=spots
#COde ran successfully on compiler
#No issues faced while coding

import heapq

#Creating parkingSpot object
class ParkingSpot:
    #initializing required variables
    def __init__(self, floor, spot):
        self.floor = floor
        self.spot = spot

    #Function to get spot value
    def getSpot(self):
        return self.spot

    #Function to get g=floor object
    def getFloor(self):
        return self.floor

    # Custom comparison to enable comparison between ParkingSpot objects
    def __lt__(self, other):
        #If the floor is same, the retruval will be based on the spot value
        if self.floor == other.floor:
            return self.spot < other.spot
        #If the floor is not same, we will return based on the floor
        return self.floor < other.floor


class ParkingLot:
    #Initializing all the required variables
    def __init__(self, maxFloors, spotsPerFloor):
        self.maxFloors = maxFloors
        self.spotsPerFloor = spotsPerFloor
        self.pq = []

    def park(self):
        #If the size of the priority queue is full, we will return message
        if not self.pq:
            raise ValueError("Parking lot is full")
        #ELse we will add values into the priority queue
        return heapq.heappop(self.pq)

    def unpark(self, floor, spot):
        #When we unpark a specific spot, we will push that into heap
        newSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, newSpot)

    def getNextAvailable(self):
        #We will be retriving the top value in the priority queue
        if self.pq:
            return self.pq[0]
        #If the priority queue is emptym we will return None
        return None

    def addParkingSpot(self, floor, spot):
        #When adding parking spots, we will be comparing floor and spot values with maximum values
        if floor > self.maxFloors:
            raise ValueError("Floor input greater than max allowed")
        if spot > self.spotsPerFloor:
            raise ValueError("Spot input greater than max allowed")
        newSpot = ParkingSpot(floor, spot)
        heapq.heappush(self.pq, newSpot)


if __name__ == "__main__":
    #No of floors is 10 and no slots per each floor is 20
    pl = ParkingLot(10, 20)
    #Adding the available parking slots into the heap
    pl.addParkingSpot(1, 1)
    pl.addParkingSpot(2, 1)
    pl.addParkingSpot(3, 1)
    pl.addParkingSpot(1, 2)
    pl.addParkingSpot(2, 2)
    pl.addParkingSpot(3, 2)

    #FInding the next available spot
    n = pl.getNextAvailable()
    print(f"Parked at Floor: {n.getFloor()}, Slot: {n.getSpot()}")

    #Parking a car
    pl.park()

    #Finding the next available spot
    n2 = pl.getNextAvailable()
    print(f"Parked at Floor: {n2.getFloor()}, Slot: {n2.getSpot()}")

    #Unparking the car
    pl.unpark(1, 1)
    #Finding the next available spot
    n1 = pl.getNextAvailable()
    print(f"Parked at Floor: {n1.getFloor()}, Slot: {n1.getSpot()}")
