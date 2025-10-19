'''
This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. When someone leave you need update this space as empty. What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.

Solution:
1. Brute Force
We use a 2D array where row i and column j represent the floor and spot respectively. To park, we scan floor by floor and spot by spot until we find a true, then mark it false. To unpark, we simply flip the spot back to true so it becomes available again.

Let M = no. of floors, N = no. of spots
                Time               Space
__init__()      O(MN)              O(MN)
addSpot()       O(1)               O(1)
getAvailable()  O(MN)              O(1)
park()          O(MN)              O(1)
unpark()        O(1)               O(1)

2. Min-heap
We use a 2D array where row i and column j represent the floor and spot respectively. We assume that the entrance to the parking lot is nearest to the parking space with floor 0 and spot 0.

We use a min-heap data structure to store the pair (i,j). During initialization, we push the empty parking spaces (all elements of the 2D array) into a min-heap. The elements of the min-heap at any time represent the empty parking spaces available at that time. We always pick the parking space with the lowest floor and lowest spot number since it is nearest to the entrance. When someone parks, we remove the nearest (to the entrance) parking space from the heap. If someone unparks, we just add that spot back to the heap again.

https://youtu.be/wYxbqbiUDbo?t=211 (solution discussion)
https://youtu.be/wYxbqbiUDbo?t=1143 (coding)

Let M = no. of floors, N = no. of spots
                Time               Space
__init__()      O(MN log MN)       O(MN)
addSpot()       O(log(MN))         O(1)
getAvailable()  O(1)               O(1)
park()          O(log(MN))         O(1)
unpark()        O(log(MN))         O(1)

'''
import heapq

class ParkingLot:
    def __init__(self, floors, spots):
        ''' Time: O(MN log MN), Space: O(MN) '''
        # self.matrix=[[0]*spots for _ in range(floors)]
        # 2D matrix not really used, using only for clarity
        # matrix[i][j]: 0 = empty spot, 1 = car parked

        self.rows = floors
        self.cols = spots
        self.pq = [] # spots available for parking
        for floor in range(self.rows):
            for spot in range(self.cols):
                self.addSpot(floor, spot)

    def addSpot(self, floor, spot): # add empty spot to pq
        ''' Time: O(log(MN)), Space: O(1) '''
        if floor > self.rows:
            raise Exception(f"Floor number invalid: {floor}")
        elif spot > self.cols:
            raise Exception(f"Spot number invalid: {spot}")
        heapq.heappush(self.pq, (floor, spot)) # T = O(log (MN))
        # by default, min heap sorts on tuple[0] first and then on tuple[1]
        # self.matrix[floor][spot] = 0

    def getAvailable(self):
        ''' Time: O(1), Space: O(1) '''
        if len(self.pq) == 0:
            raise Exception(f"Spot number is invalid:")
        return self.pq[0] # peek

    def park(self):
        ''' Time: O(log(MN)), Space: O(1) '''
        if not self.pq:
            raise Exception(f"Cannot park. Parking lot is full.")
        floor, spot = heapq.heappop(self.pq) # T = O(log (MN))
        print(f"Parked: floor = {floor}, spot = {spot}")

    def unpark(self, floor, spot):
        ''' Time: O(log(MN)), Space: O(1) '''
        if floor > self.rows:
            raise Exception(f"Floor number invalid: {floor}")
        elif spot > self.cols:
            raise Exception(f"Spot number invalid: {spot}")
        elif len(self.pq) == self.rows*self.cols:
            raise Exception(f"Nothing to unpark. Parking lot is empty.")
        self.addSpot(floor,spot)
        print(f"Unparked: floor = {floor}, spot = {spot}")


def run_ParkingLot():
    tests = [( ["ParkingLot", "getAvailable", "park", "getAvailable", "park", "getAvailable", "park", "getAvailable", "park", "unpark", "unpark", "getAvailable", "park", "getAvailable", "park"],
               [[3,4], None, None, None, None, None, None, None, None, [0,2], [0,1], None, None, None, None],
               [None,[0,0],None,[0,1],None,[0,2],None,[0,3],None,None,None,[0,1],None,[0,2],None],
             ),
    ]
    for test in tests:
        operations, inputs, ans = test[0], test[1], test[2]
        outputs = []
        print(f"\n------------")
        for operation, input in zip(operations, inputs):
            if operation == "ParkingLot":
                sol = ParkingLot(input[0], input[1])
                output = None
            elif operation == "getAvailable":
                floor, spot = sol.getAvailable()
                output = [floor, spot]
            elif operation == "park":
                sol.park()
                output = None
            elif operation == "unpark":
                sol.unpark(input[0], input[1])
                output = None
            print(f"{operation}({input}): {output}")
            outputs.append(output)
        print(f"\nOperations = {operations}")
        print(f"inputs = {inputs}")
        print(f"outputs = {outputs}")
        success = (ans==outputs)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_ParkingLot()
