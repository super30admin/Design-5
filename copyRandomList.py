"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        x = {}
        temp = head
        new_head = None
        temp2 = None
        while(temp!=None):
            if(new_head==None):
                new_head = Node(temp.val)
                temp2 = new_head
            else:
                temp2.next = Node(temp.val)
                temp2 = temp2.next
            x[temp] = temp2
            temp = temp.next
            
        temp = head
        temp2 = new_head
        while(temp!=None):
            if(temp.random!=None):
                temp2.random = x[temp.random]
            temp2 = temp2.next
            temp = temp.next
        
        return new_head
