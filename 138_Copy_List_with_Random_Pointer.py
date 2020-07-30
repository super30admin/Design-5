# Time Complexity : O(n) [n = number of nodes in the list]
# Space Complexity : O(1) [The new list is returned as output]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


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
        if not head:return None
        node_map = dict()
        curr = head
        
        def clone(node):
            if not node:return None
            if node in node_map:
                return node_map[node]
            new_node = Node(node.val)
            node_map[node] = new_node
            return new_node
            
        while curr is not None:
            copy_node = clone(curr)
            
            copy_node.next = clone(curr.next)
            copy_node.random = clone(curr.random)
            
            curr = curr.next
            
        return node_map[head]