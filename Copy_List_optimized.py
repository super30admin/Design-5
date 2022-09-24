# Time - O(n)
# Space - O(1)
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
        
        # make copy of the list nodes to the adjacent right
        curr = head
        while curr != None:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        
        # creating random pointers for the new list
        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        # splitting the lists
        curr = head
        # head of the copy list is the next of head
        copyHead = head.next
        copyCurr = copyHead
        while curr != None:
            curr.next = curr.next.next
            # have to check for the last element, if there is next of the copyCurr, only then make the next pointer
            if copyCurr.next != None:
                copyCurr.next = copyCurr.next.next
            
            # move both the pointer by next
            curr = curr.next
            copyCurr = copyCurr.next
            
        return copyHead
