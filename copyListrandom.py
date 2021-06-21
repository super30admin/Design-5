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
        if head is None: return None
        current = head

        # connecting the list
        while current is not None:
            deepcopyNode = Node(current.val)
            deepcopyNode.next = current.next
            current.next = deepcopyNode
            current = current.next.next

        # connecting the Random Pointer of deep

        current = head
        while current is not None:
            if current.random is not None:
                current.next.random = current.random.next
            current = current.next.next

        # split the list
        current = head
        random = head.next
        randomptr = head.next

        while current is not None:
            current.next = current.next.next
            if current.next is not None:
                randomptr.next = randomptr.next.next

            current = current.next
            randomptr = randomptr.next

        return random






