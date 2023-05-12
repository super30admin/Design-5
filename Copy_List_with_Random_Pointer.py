# Time Complexity : O(N), where N is the number of nodes in the linked list
# Space Complexity : O(1)

class Node:
    def __init__(self, val=0, next=None, random=None):
        self.val = val
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None

        # Step 1: Create a copy of each node and insert it after the original node
        curr = head
        while curr:
            new_node = Node(curr.val, None, None)
            new_node.next = curr.next
            curr.next = new_node
            curr = new_node.next

        # Step 2: Assign random pointers for the copied nodes
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        # Step 3: Separate the original and copied lists
        curr = head
        new_head = head.next
        new_curr = new_head

        while curr:
            curr.next = curr.next.next
            if new_curr.next:
                new_curr.next = new_curr.next.next
            curr = curr.next
            new_curr = new_curr.next

        return new_head