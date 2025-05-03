# Time Complexity : O(N)

# Space Complexity : O(N)

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
        dummy = Node(-99)
        # make copies of the individual nodes and their nexts, add mapping to dictionary
        node_to_copy = {}
        cur = head
        copy = dummy
        while cur:
            node = Node(cur.val)
            node_to_copy[cur] = node
            copy.next = node
            copy = copy.next
            cur = cur.next
        
        cur = head
        while cur:
            cur_copy = node_to_copy[cur]
            random = cur.random
            if random:
                random_copy = node_to_copy[random]
                cur_copy.random = random_copy
            else:
                cur_copy.random = None
            cur = cur.next
        
        return dummy.next
