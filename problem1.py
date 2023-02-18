#time O(N)
#space O(1)
"""
# Definition for a Node.
class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        d={}
        curr=head
        while curr:
            d[curr]=Node(curr.val,None,None)
            curr=curr.next
        curr1=head
        while curr1:
            if curr1.next:
                d[curr1].next=d[curr1.next]
            if curr1.random:
                d[curr1].random=d[curr1.random]
            curr1=curr1.next
        return d[head]