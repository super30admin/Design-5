# // Time Complexity :O(3n) 
# // Space Complexity :O(1) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

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
        #create deep copy
        if head is None:
            return head
        curr=head
        while curr:
            copy=Node(curr.val)
            copy.next=curr.next
            curr.next=copy
            curr=curr.next.next
        #create random nodes
        curr=head
        while curr:
            if curr.random:
                curr.next.random=curr.random.next
            curr=curr.next.next
        #split
        curr=head
        copyhead=head.next
        copy=head.next
        while curr:
            
            curr.next=curr.next.next
            if copy.next:
                copy.next=copy.next.next
            curr=curr.next
            copy=copy.next
        return copyhead
            
        
    
        