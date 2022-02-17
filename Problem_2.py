# Space complexity O(n) 
# time complexity O(1) constant
# running on leetcode : Yes 
# any problems : NO

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
        # null case
        if head == None:
            return None
        #create deep copies nodes and put them next to original node
        curr = head
        while curr != None:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        #create random ptr on deep copy list
        curr = head
        while curr!= None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
        # split
        curr = head
        copyHead = head.next
        copyCurr = copyHead
        while(curr != None):
            curr.next = curr.next.next
            if copyCurr.next != None:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        return copyHead
            
            
            