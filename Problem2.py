# Time Complexity: O(n)
# Space Complexity: O(1)

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
        
        current = head
        while current:
            new_node = Node(current.val)
            new_node.next = current.next
            current.next = new_node
            current = new_node.next
        
        current = head
        while current:
            if current.random:
                current.next.random = current.random.next
            current = current.next.next
        
        new_head = head.next
        current = head
        while current:
            copied = current.next
            current.next = copied.next
            if copied.next:
                copied.next = copied.next.next
            current = current.next
        
        return new_head
