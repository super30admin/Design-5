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
        if head is None:
            return None
        curr=head
        while curr is not None:
            copycurr=Node(curr.val)
            copycurr.next=curr.next
            curr.next=copycurr

            curr=curr.next.next
        
        curr=head
        while curr is not None:
            if curr.random is not None:
                curr.next.random=curr.random.next

            curr=curr.next.next

        curr=head
        currHead=curr.next
        currcopy=currHead

        while curr is not None:
            curr.next=curr.next.next
            if currcopy.next is not None:
                currcopy.next=currcopy.next.next
            
            curr=curr.next
            currcopy=currcopy.next
        return currHead
