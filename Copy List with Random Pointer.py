# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head: 
            return None

        
        curr = head
        while curr:
           
            node = Node(curr.val)
            node.next = curr.next
            curr.next = node
            curr = curr.next.next 
        
        
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        
        curr = head
        copyHead = head.next
        copyCurr = copyHead
        while curr:
            curr.next = curr.next.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        return copyHead