"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    def copyRandomList(self, head: "Optional[Node]") -> "Optional[Node]":
        # T: O(n), S: O(n)
        if not head:
            return None

        # Dictionary to store old node → new node mapping
        old_to_new = {}

        # First pass: Create copies of all nodes (without links)
        current = head
        while current:
            # Create a new node and store in our mapping
            old_to_new[current] = Node(current.val)
            current = current.next

        # Second pass: Set next and random pointers
        current = head
        while current:
            # Get the corresponding new node
            new_node = old_to_new[current]

            # Set its next pointer (if current.next exists)
            if current.next:
                new_node.next = old_to_new[current.next]

            # Set its random pointer (if current.random exists)
            if current.random:
                new_node.random = old_to_new[current.random]

            current = current.next

        # Return the head of the copied list
        return old_to_new[head]
