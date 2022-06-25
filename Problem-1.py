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
        if not head:
            return None
        
        # create new list elements and join
        curr=head
        while curr:
            currCopy=Node(curr.val)
            currCopy.next=curr.next
            curr.next=currCopy
            curr=curr.next.next
            
        #RP connections
        curr=head
        while curr:
            if curr.random:
                curr.next.random=curr.random.next
            curr=curr.next.next
        
        #Split
        curr=head
        copyCurr=head.next
        newHead=head.next
        while curr:
            curr.next=curr.next.next
            if copyCurr.next:
                copyCurr.next=copyCurr.next.next
                
            curr=curr.next
            copyCurr=copyCurr.next
            
        return newHead
            
        
        