"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

#time: O(n)
#space:O(n)
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        if not head:
            return head
        
        old_node = head
        
        while(old_node):
            
            temp= old_node.next
            new_node = Node(old_node.val,None,None)
            old_node.next = new_node
            new_node.next = temp
            old_node = new_node.next
        pointer = head
        old_node = head
        while(old_node and old_node.next):
            if old_node.random and old_node.next:
                old_node.next.random = old_node.random.next
            old_node = old_node.next.next
        old_node = head
        new_head = old_node.next
        new_node = old_node.next
        while(old_node and old_node.next and new_node and new_node.next ):
            old_node.next = old_node.next.next
            new_node.next = new_node.next.next
            old_node = old_node.next
            new_node = new_node.next
        return new_head
        
        
            
            
    