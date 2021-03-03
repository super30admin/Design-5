'''
T = O(n) for parking
	O(n) for releasing
	O(n) for checking the next available spot
	
S = O(1)

Approach:
Brute Force: Maintain a array at every park or release check if its a valid operation
''' 

class ParkingLot:
    def __init__(self,floors,spots):
        self.floors = floors
        self.spots = spots
        self.Lot = [[0 for i in range(spots)] for j in range(floors)]
        
    def Park(self,no):
        spot = self.getAvailable()
        if spot != None:
            self.Lot[spot[0]][spot[1]] = [spot[1] + spot[0] * self.spots ,no]
            print("Vehicle Parked")
        
    def Release(self,no):
        for i in range(self.floors):
            for j in range(self.spots):
                if self.Lot[i][j] != 0:
                    if self.Lot[i][j][1] == no:
                        self.Lot[i][j] = 0
                        print('Spot Released')
                        return
        print("Vehicle Number Invalid cannot Unpark:" ,no)
                    
    def getAvailable(self):
        for i in range(self.floors):
            for j in range(self.spots):
                if self.Lot[i][j] == 0:
                    return [i,j]
        print('Parking Lot is Full Go Home')
        
    def showLot(self):
        for i in range(self.floors):
            print(self.Lot[i][:])
        
        
P = ParkingLot(3,3)
P.showLot()
P.Park(1)
P.Park(2)
P.Park(3)
P.Park(4)
P.Park(5)
P.Park(6)
P.Park(7)
P.Park(8)
P.Park(9)
P.showLot()
P.Release(5)
P.showLot()
P.Park(5)
P.showLot()



'''
T = O(1) Parking
	O(logn) Release because the empty spot has to be added to the heap

S = O(logn) As heap is getting used
Approach:
Not Sure if I covered all the test cases would be helpful if you can rview this solution
'''

from heapq import heapify, heappush, heappop

class ParkingLot:
    def __init__(self,floors,spots):
        self.floors = floors
        self.spots = spots
        self.Lot = [[0 for i in range(spots)] for j in range(floors)]
        self.ParkQ = []
        self.TotalCount = 0
        
    def Park(self,no):
        spot = self.getAvailable()
        if spot != None:
            RSpot = spot // self.spots
            CSpot = spot % self.spots
            self.Lot[RSpot][CSpot] = [spot,no]
            print("Vehicle", no ,"Parked at", spot)
            self.TotalCount += 1
            
    def Release(self,spotno):
        RSpot = spotno // self.spots
        CSpot = spotno % self.spots
        ## Check if the Spot is valid
        if spotno >= (self.floors * self.spots):
            print('Invalid Spot:',spotno)
            return
        ## Check if the Spot is already empty
        if self.Lot[RSpot][CSpot][1] == 0:
                print('Already Spot is Empty',spotno)
                return
            
        ## If not empty clear it out and append it to min heap
        else:
            heappush(self.ParkQ, spotno)
            ## Clear the Spot to zero
            self.Lot[RSpot][CSpot][1] = 0
            self.TotalCount -= 1
            print("Spot is Released",spotno)
                    
    def getAvailable(self):
        ## Check if there are previous places that are empty or there is only availability at the
        ## End of the loop.
        if len(self.ParkQ) != 0:
            spot = heappop(self.ParkQ)
        else:
            if not self.isLotFull():
                spot = self.TotalCount
            else:
                print("Parking Lot is Full go Home")
                return
        return spot
        
    def isLotFull(self):
        return self.TotalCount  == (self.floors * self.spots)
        
    def showLot(self):
        for i in range(self.floors):
            print(self.Lot[i][:])
        
        
P = ParkingLot(5,3)
P.showLot()
P.Park(1);P.Park(2);P.Park(3)
P.Park(4);P.Park(5);P.Park(6)
P.Park(7);P.Park(8);P.Park(9);
P.Park(10);P.Park(11);P.Park(12);
P.Park(13);P.Park(14);
P.showLot()
P.Park(15)
P.showLot()
P.Release(5)
P.Release(7)
P.showLot()
P.Park(9)