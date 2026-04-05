# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, insert deep copies of each node right next to originals.
# Then, link the random pointers using the interleaved structure.
# Finally, split the combined list into original and cloned lists.


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
            return None

        curr = head
        while curr is not None:
            copy_node = Node(curr.val)
            copy_node.next = curr.next
            curr.next = copy_node
            curr = curr.next.next

        curr = head

        while curr is not None:  # random pointers
            if curr.random is not None:
                curr.next.random = curr.random.next

            curr = curr.next.next

        curr = head
        copyCurr = curr.next
        copyHead = copyCurr

        while curr is not None:
            curr.next = curr.next.next
            if copyCurr.next is not None:
                copyCurr.next = copyCurr.next.next

            curr = curr.next
            copyCurr = copyCurr.next

        return copyHead