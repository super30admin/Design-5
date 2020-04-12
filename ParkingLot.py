// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we need to design a parking lot.when one floor is filled next floor should be filled and in the same floor first nearest slot should be filled followed by next slot.So we can use min heap with custom comparator for this operation by which parking ,unparking can be done in logarithmic time complexity.

# Time complexity --> o(1) for park and o(log(mn)) for unpark
# space complexity -->o(log(mn)) 
import heapq
class parkingspace:
    def __init__(self,floor,slot):
        self.floor=floor
        self.slot=slot
    def __lt__(self,p2):
        if self.floor==p2.floor:
            return self.slot<p2.slot
        else:
            return self.floor<p2.floor

class ParkingLot:
    def __init__(self,maxFloors,maxSlotsPerFloor):
        self.maxSlotsPerFloor=maxSlotsPerFloor
        self.maxFloors=maxFloors
        self.h=[]

        for i in range(1,maxFloors+1):
            for j in range(1,maxSlotsPerFloor+1):
                self.addParkingSpace(i,j)

    def park(self):
        if len(self.h)==0:
            return "parking lot is full"
        ele=heapq.heappop(self.h)
        return ele

    def unpark(self,ps):
        # floor=ps.floor
        # slot=ps.slot
        # ps1=parkingspace(floor,slot)
        heapq.heappush(self.h,ps)


    def addParkingSpace(self,floor,slot):
        ps=parkingspace(floor,slot)
        heapq.heappush(self.h,ps)


    def status(self):
        return "Available"+' '+str(len(self.h))



parkinglot=ParkingLot(3,4)
user1=parkinglot.park()
print(user1)
print("user1 parked at "+ str(user1.floor)+' '+str(user1.slot)+' ' + parkinglot.status())
user2=parkinglot.park()
print("user2 parked at "+ str(user2.floor)+' '+str(user2.slot)+' ' +parkinglot.status())
user3=parkinglot.park()
print("user3 parked at "+ str(user3.floor)+' '+str(user3.slot)+' ' +parkinglot.status())
user4=parkinglot.park()
print("user4 parked at "+ str(user4.floor)+' '+str(user4.slot)+' ' +parkinglot.status())
user5=parkinglot.park()
print("user5 parked at "+ str(user5.floor)+' '+str(user5.slot)+' ' +parkinglot.status())
user6=parkinglot.park()
print("user6 parked at "+ str(user6.floor)+' '+str(user6.slot)+' ' +parkinglot.status())
parkinglot.unpark(user4)
parkinglot.unpark(user2)
user7=parkinglot.park()
print("user7 parked at "+ str(user7.floor)+' '+str(user7.slot)+' ' +parkinglot.status())
user8=parkinglot.park()
print("user8 parked at "+ str(user8.floor)+' '+str(user8.slot)+' ' +parkinglot.status())
