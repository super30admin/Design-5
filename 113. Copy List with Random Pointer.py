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
        if head is None:
            return

        # Step 1: create deep copy and put next to original
        curr = head
        while curr:
            copyNode = Node(curr.val)
            copyNode.next = curr.next
            curr.next = copyNode
            curr = curr.next.next

        # step 2: connect random nodes
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        # Step 3: Separate list i.e copy and original list
        curr = head
        currHead = curr.next
        currCopy = curr.next
        while curr:
            curr.next = curr.next.next
            if currCopy.next:
                currCopy.next = currCopy.next.next
            curr = curr.next
            currCopy = currCopy.next
        return currHead

# Without using the hashMap
# Time Complexity: O(3n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
