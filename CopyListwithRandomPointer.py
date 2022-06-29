"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        curr=head
        if not curr:
            return None
        while curr:
            node=Node(curr.val)
            node.next=curr.next
            curr.next=node
            curr=curr.next.next
        curr=head
        while curr:
            if curr.random==None:
                curr.next.random=None
            else:
                curr.next.random=curr.random.next
            curr=curr.next.next
        curr=head.next
        while curr.next:
            curr.next=curr.next.next
            curr=curr.next
        return head.next
        