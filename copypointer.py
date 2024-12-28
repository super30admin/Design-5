"""
Iterate throughlinked list and create newnode map it to the original node
Iterate through the list again and now link next and random pointers in the newly created nodes
SP: O(n)
TC: O(n)
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
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        hmap = {None: None}
        curr= head
        while curr:
            newNode = Node(curr.val)
            hmap[curr] = newNode
            curr = curr.next
        curr = head
        while curr:
            c = hmap[curr]
            c.next = hmap[curr.next]
            c.random = hmap[curr.random]
            curr = curr.next
        return hmap[head]        