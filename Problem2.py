"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def __init__(self):
        self.hashmap = {}

    def copyRandomList(self, head: "Optional[Node]") -> "Optional[Node]":
        if not head:
            return None

        curr = head
        while curr:
            newNode = Node(curr.val, curr.next)
            curr.next = newNode
            curr = newNode.next
        curr = head

        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        curr = head
        copyHead = head.next
        while curr:
            copyCurr = curr.next
            curr.next = copyCurr.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next
            curr = curr.next

        return copyHead
