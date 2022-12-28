"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
'''
Time complexity --> O(3n)
Space Complexity --> O(1)
'''
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        #Step 1 create copy nodes next to its original node
        #example 1-->1'-->2-->2' and so on
        if head == None:
            return None
        curr = head
        newhead = None
        while curr:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        #Step 2 link random pointer to the copied list
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        #Step 3 is =breaking the linked list
        curr = head
        newhead = curr.next
        newcurr = newhead
        while curr:
            
                curr.next = newcurr.next
                if curr.next:
                    newcurr.next = curr.next.next
                curr = curr.next
                newcurr = newcurr.next
        return newhead
