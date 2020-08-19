# Time Complixity : O(N)
#Space Complxity : O(N)
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
        d = {}
        if head == None:
            return None
        def clone(original):
            if original == None:
                return None
            copy = d.get(original)
            if copy == None:
                copy = Node(original.val)
                d[original] = copy
            return copy
        
        curr = head
        copycurr = clone(curr)
        while(curr != None):
            copycurr.random = clone(curr.random)
            copycurr.next = clone(curr.next)
            curr = curr.next
            copycurr = copycurr.next
        return d.get(head)
        