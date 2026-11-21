# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using a hash map + single traversal to create a deep copy of the linked list
# The hash map stores the mapping from original nodes to cloned nodes.
# Create nodes on demand and connect their next and random pointers.

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
        nodedict = {}
        if not head:
            return None
        newHead = dummy = Node(0)
        while head:
            if head not in nodedict:
                # Create a clone if it doesn't already exist
                nodedict[head] = Node(head.val)
            # Connect the next pointer
            newHead.next = nodedict[head]
            # Connect the random pointer
            if head.random:
                if head.random not in nodedict:
                    nodedict[head.random] = Node(head.random.val)
                newHead.next.random = nodedict[head.random]
            newHead = newHead.next
            head = head.next
        return dummy.next



            

