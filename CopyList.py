# The copyRandomList method creates a deep copy of a linked list with `next` and `random` pointers.

# Step 1: Create cloned nodes:
# - Insert a cloned node immediately after each original node in the list.

# Step 2: Update random pointers:
# - For each original node, set the `random` pointer of its clone to the clone of the original's `random` node.

# Step 3: Separate the cloned list:
# - Restore the original list and extract the cloned list by adjusting the `next` pointers.

# TC: O(n) - Each node is visited a constant number of times.
# SC: O(1) - No additional data structures used; cloning is done in-place.


# Definition for a Node.
from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        
        l1 = head
        while l1 is not None:
            l2 = Node(l1.val)
            l2.next = l1.next
            l1.next = l2
            l1 = l2.next
            
        newHead = head.next
        
        l1 = head
        while l1 is not None:
            if l1.random is not None:
                l1.next.random = l1.random.next
            l1 = l1.next.next
            
        l1 = head
        while l1 is not None:
            l2 = l1.next
            l1.next = l2.next
            if l2.next is not None:
                l2.next = l2.next.next
            l1 = l1.next
            
        return newHead