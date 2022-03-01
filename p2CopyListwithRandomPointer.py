"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random




    Time: O(N)
    Space:O(N)    
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        copyMap = {None:None}
        curr = head
        
        while curr:
            copyMap[curr] = Node(curr.val)
            curr = curr.next
        
        curr = head
        while curr:
            copyMap[curr].next= copyMap[curr.next]
            copyMap[curr].random = copyMap[curr.random]
            curr = curr.next
        return copyMap[head]
        

