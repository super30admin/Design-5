#Time - O(n)
#Space - O(n)

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        old={None:None}
        
        curr=head
        
        while curr:
            copy=Node(curr.val)
            old[curr]=copy
            curr=curr.next
            
        curr=head
        while curr:
            copy=old[curr]
            copy.next=old[curr.next]
            copy.random=old[curr.random]
            curr=curr.next
        
        return old[head]