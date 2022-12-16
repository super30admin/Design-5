# TC:O(N)
# SC:O(N)

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
        cur=head

        oldCopy={None:None}
        while cur:
            node=Node(cur.val)
            oldCopy[cur]=node
            cur=cur.next

        cur=head
        while cur:
            node=oldCopy[cur]
            node.next=oldCopy[cur.next]
            node.random=oldCopy[cur.random]

            cur=cur.next

        return oldCopy[head]