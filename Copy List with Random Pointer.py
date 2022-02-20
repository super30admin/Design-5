"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    
    # Three Pass without maintaining hashmap
    # Create deep copy nodes and put them next to orignal nodes concept
    # TC: O(N) --> 3N --> Three Pass
    # SC: O(1)
    
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        # Null Case
        if (head == None):
            return None
        
        # Create deep copy nodes and put them next to orignal nodes --> 1st Pass
        curr_orignal = head
        while (curr_orignal != None):
            copy = Node(curr_orignal.val)
            copy.next = curr_orignal.next
            curr_orignal.next = copy
            
            curr_orignal = curr_orignal.next.next
            
        # Create random pointers on deep copy list --> 2nd Pass
        curr_orignal = head
        while (curr_orignal != None):
            if (curr_orignal.random is not None):
                curr_orignal.next.random = curr_orignal.random.next
                
            curr_orignal = curr_orignal.next.next
            
        # Splitting the two link lists --> 3rd Pass
        copy_head = head.next
        curr_orignal = head
        curr_copy = copy_head
        while (curr_orignal != None):
            curr_orignal.next = curr_orignal.next.next
            if (curr_copy.next != None):
                curr_copy.next = curr_copy.next.next
            
            curr_orignal = curr_orignal.next
            curr_copy = curr_copy.next
            
        return copy_head
            
            