'''
    Time Complexity:
        O(n) (where n = number of nodes)

    Space Complexity:
        O(n) (where n = number of nodes)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Keep a mapping of {old_node: new_node} in a HashMap.
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def __init__(self):
        self.hash_map = {}

    def copyRandomList(self, head: 'Node') -> 'Node':
        return self.deep_copy(head)

    def deep_copy(self, node):
        if node is None:
            return None

        if node in self.hash_map:
            return self.hash_map[node]

        n = Node(node.val)
        self.hash_map[node] = n
        n.next = self.deep_copy(node.next)
        n.random = self.deep_copy(node.random)
        return n
