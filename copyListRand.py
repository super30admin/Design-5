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
        
        curr = head
        while curr:
            cc = Node(curr.val)
            cc.next = curr.next
            curr.next = cc
            curr = curr.next.next
        
        curr = head
        while curr:
            cc = curr.next
            if curr.random:
                cc.random = curr.random.next
            curr = curr.next.next
        
        curr = head
        cHead = curr.next
        while curr:
            cc = curr.next
            temp = cc.next
            if cc.next:
                cc.next = cc.next.next
            curr.next = temp
            curr = temp
        
        return cHead
            