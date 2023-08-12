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
        # Time Complexity: O(N), where N --> nodes in the linked list. We iterate through the list twice to create the mapping and then set the pointers.
        # Space Complexity: O(N), for the hash map used to store the mapping of nodes.
        if not head:
            return None

        # Step 1: Create a mapping of original nodes to their copies
        mapping = {}
        current = head
        while current:
            mapping[current] = Node(current.val)
            current = current.next

        # Step 2: Set the next and random pointers of copy nodes
        current = head
        while current:
            copy_node = mapping[current]
            if current.next:
                copy_node.next = mapping[current.next]
            if current.random:
                copy_node.random = mapping[current.random]
            current = current.next

        return mapping[head]
