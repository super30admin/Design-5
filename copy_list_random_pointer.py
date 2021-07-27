
# Definition for a Node.
class Node:
    def __init__(self, x, next, random):
        self.val = int(x)
        self.next = next
        self.random = random
# Time Complexity: O(n)
# Space Complexity: O(1)
# We are iterating over the given head and we are creating the copy of that with exact random
# and next pointer as of head and while doing that we are calling clone function which check if the
# node we received is already in hashmap and if not then make the entry and if already return the same
from collections import defaultdict


class Solution:
    hmap = defaultdict()

    def clone(self, node):
        if not node:
            return None
        if node in self.hmap:
            return self.hmap[node]
        updated_node = Node(node.val)
        self.hmap[node] = updated_node
        return updated_node

    def copyRandomList(self, head):

        if not head:
            return None
        curr = head
        currCopy = self.clone(head)

        while curr:
            currCopy.next = self.clone(curr.next)
            currCopy.random = self.clone(curr.random)

            curr = curr.next
            currCopy = currCopy.next

        return self.hmap[head]
