class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(n) for the hashmap
    def copyRandomList(self, head: 'Node') -> 'Node':
        oldToCopy = {None: None}

        curr = head
        while curr:
            copy = Node(curr.val)
            oldToCopy[curr] = copy
            curr = curr.next

        curr = head
        while curr:
            copy = oldToCopy[curr]
            copy.next = oldToCopy[curr.next]
            copy.random = oldToCopy[curr.random]
            curr = curr.next
        return oldToCopy[head]


# Without the hashmap
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(1)
    def copyRandomList(self, head: 'Node') -> 'Node':
        dummy = Node(-1)
        dummy.next = head
        curr = head

        while curr:
            tmp = Node(curr.val)
            tmp.next = curr.next
            curr.next = tmp
            curr = tmp.next

        curr = head
        while curr:
            curr.next.random = curr.random.next if curr.random else None
            curr = curr.next.next

        curr, nxt = dummy, head
        while nxt:
            curr.next = nxt.next
            curr = nxt
            nxt = curr.next

        return dummy.next