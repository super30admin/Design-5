# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
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
        if not head:
            return head

        node_cache = {}

        new_head = Node(head.val)
        node_cache[head] = new_head

        node = head
        while node:
            _next = node.next
            if _next:
                new_node = Node(_next.val)

                node_cache[node].next = new_node

                node_cache[_next] = new_node

            node = _next

        node = head
        while node:
            new_node = node_cache[node]
            if node.random:
                new_node.random = node_cache[node.random]
            node = node.next

        return node_cache[head]
