import heapq
class Parkinglot:
    def __init__(self,total_spaces, id_dist_map):
        self.total = total_spaces
        self.min_heap=[]
        self.id_dist_map = id_dist_map
        heapq.heapify(self.min_heap)
        for key in self.id_dist_map:
            val = self.id_dist_map[key]
            heapq.heappush(self.min_heap,(val,key))




    def insert(self):
        val,key = heapq.heappop(self.min_heap)
        return key #parking id


    def free(self,key):
        heapq.heappush(self.min_heap,(self.id_dist_map[key],key))

    
    def print_free_spaces(self):
        print(self.min_heap)


id_dist_map = {0:1,1:2,2:3,3:4,4:5,5:6}
Parking_lot1 = Parkinglot(5,id_dist_map)
Parking_lot1.print_free_spaces()
print(Parking_lot1.insert())
print(Parking_lot1.insert())
Parking_lot1.free(1)
print(Parking_lot1.insert())


