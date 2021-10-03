"""
Time Complexity : O(n) where n is the no. of nodes in the list 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
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
        if not head:
            return head
        
        # Step 1: Creating the copy and joining the same
        curr = head
        while curr:
            currCopy = Node(curr.val, None, None)
            currCopy.next = curr.next
            curr.next = currCopy
            curr = currCopy.next
            
        # Step 2: Setting the random pointers
        curr = head
        while curr:
            curr.next.random = curr.random.next if curr.random else None
            curr = curr.next.next
                
        # Step 3: Split the two lists into two individual lists
        curr = head
        currCopy1 = curr.next
        copyHead = curr.next
        while curr:
            curr.next = curr.next.next
            currCopy1.next = currCopy1.next.next if currCopy1.next else None
                
            curr = curr.next
            currCopy1 = currCopy1.next
        return copyHead