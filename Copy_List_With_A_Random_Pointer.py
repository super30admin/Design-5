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
        curr=head
        
        while curr is not None:
            n=curr.next
            dup=Node(curr.val)
            curr.next=dup
            dup.next=n
            curr=n
            
        curr=head
        
        while curr is not None:
            if curr.random is not None:
                curr.next.random=curr.random.next
                
            curr=curr.next.next
            
        dummy=Node(-1,None)
        tail=dummy
        
        curr=head
        while curr is not None:
            n=curr.next.next
            
            dup=curr.next
            tail.next=dup
            tail=dup
            
            curr.next=n
            curr=n
            
        return dummy.next
            
        