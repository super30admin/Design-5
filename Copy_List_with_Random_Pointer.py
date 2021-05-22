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
            return
        
        head1 = head        
        while head1:
            new_node = Node(head1.val)
            new_node.next =  head1.next
            head1.next = new_node
            head1 = head1.next.next
            
        head1= head        
        while head1:
            if head1.random:
                head1.next.random = head1.random.next
            head1 = head1.next.next
            
        head1 = head
        head2 = head1.next
        head3 = head1.next
        while head1:            
            head1.next = head2.next
            if head2.next:
                head2.next = head2.next.next
            head1 = head1.next
            head2 = head2.next
            
        return head3
        
        
