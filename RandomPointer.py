"""
A linked list of length n is given such that each node contains 
an additional random pointer, which could point to any node in the list, 
or null.

Construct a deep copy of the list. The deep copy should consist of 
exactly n brand new nodes, where each new node has its value set to the value 
of its corresponding original node. Both the next and random pointer of the new nodes 
should point to new nodes in the copied list such that the pointers in the original list 
and copied list represent the same list state. 

None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, 
where X.random --> Y, then for the corresponding 
two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.
"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

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
        
        #null case
        if head == None:
            return None
        
        # logic
        curr = head
        while curr != None:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
            
        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        
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
            
            
            
            