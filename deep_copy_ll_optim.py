"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# Time: O(n)
# Space: O(1)
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if(head == None):
            return None
        # Create copy of each node next to original node
        curr = head
        # copy_head = curr
        while(curr != None):
            copy = Node(curr.val)
            copy.next = curr.next
            curr.next = copy
            
            curr = curr.next.next
            
        # establish random pointers for copy nodes
        curr = head
        while(curr != None):
            if(curr.random != None):
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        # detatch true list and copy list
        curr = head
        true_head = curr
        copy_head = curr.next
        copy_head_copy = copy_head
        while(true_head != None):
            true_head.next = true_head.next.next
            copy_head.next = copy_head.next.next if copy_head.next else None
            
            true_head = true_head.next
            copy_head = copy_head.next
            
        return copy_head_copy
            
        
        