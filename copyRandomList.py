"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    # TC: O(n)
    # SC : O(n)
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        
        cur = head
        # Step 1: Clone each node and insert it right after the original node
        while cur:
            newnode = Node(cur.val)
            newnode.next = cur.next
            cur.next = newnode
            cur = newnode.next  # Move to the next original node
        
        # Step 2: Assign random pointers for the cloned nodes
        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            cur = cur.next.next  # Move to the next original node
        
        # Step 3: Separate the original list and the cloned list
        cur = head
        dummy = Node(-1)  # Dummy head for the new list
        copy_cur = dummy
        while cur:
            copy_cur.next = cur.next
            copy_cur = copy_cur.next
            cur.next = cur.next.next  # Restore original list links
            cur = cur.next  # Move to the next original node
        
        return dummy.next  # Return the head of the copied list