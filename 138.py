"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

# TC : O(n)
# SC : O(1)


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return None
  # place copy next to origimal node                              
        curr = head
        # create a copy of all nodes and place next to original node
        while curr :

            newnode = Node(curr.val)              
            newnode.next = curr.next
            curr.next = newnode
            curr = curr.next.next

        # set copy
        curr = head
        while curr:
            if curr.random :
                curr.next.random = curr.random.next
            curr = curr.next.next

        # split the linkedlist into two parts
        curr = head
        copyHead = curr.next
        copycurr = copyHead
        while curr:
            curr.next = curr.next.next
            if copycurr.next == None:
                break
            copycurr.next = copycurr.next.next
            curr = curr.next
            copycurr = copycurr.next
        return copyHead
        