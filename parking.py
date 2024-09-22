# Time: O(1)
# space : worst O(n)

# This problem was asked at Intuit

# Design a parking lot system where you need to provide a token with the parking 
# space number on it to each new entry for the space closest to the entrance. 
# When someone leave you need update this space as empty. 
# What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.
class parkingLot(object):
    next = 0
    nearest = []
    capacity = 1000 # can change as per the requirement
    def enter_parking_lot(self):
        token = -1
        if self.nearest[len(self.nearest) - 1] < self.next:
            token = self.nearest.pop(0)
        else:
            token = self.next
            self.next += 1
            if self.next > self.capacity:
                token = -1
        return token
    
    def exit_parking_lot(self, token):
        if token == self.next -1:
            self.next -= 1
        else:
            self.nearest.append(token)



        

    