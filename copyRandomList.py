# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


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
        """
        3 steps:
            - Create deep copy and put it next to the original
            - create random ptrs on copylist
            - split up to respective lists (copy and original)
        """
        if not head:
            return head
        
        curr = head
        while curr:
            currClone = Node(curr.val)
            currClone.next = curr.next 
            curr.next = currClone
            curr = curr.next.next 
            
        curr = head 
        while curr:
            if curr.random:
                curr.next.random = curr.random.next 
                
            curr = curr.next.next 
        
        curr = head
        currClone = head.next 
        dummy = head.next 
        
        while curr:
            curr.next = curr.next.next 
            if currClone.next:
                currClone.next = currClone.next.next 
            curr = curr.next 
            currClone = currClone.next 
        
        return dummy
        
        
        
        
        
        
        
        
            
            
            
            
            