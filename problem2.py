#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No



# Definition for a Node.
from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        node_map = {}

        curr = head
        while curr:
            node_map[curr] = Node(curr.val)
            curr = curr.next

        curr = head
        while curr:
            node_map[curr].next = node_map.get(curr.next)
            node_map[curr].random = node_map.get(curr.random)
            curr = curr.next

        return node_map[head]

        