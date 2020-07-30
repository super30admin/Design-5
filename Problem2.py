# Time Complexity : O(n)
# Space Complexity :O(n), for map to store all nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    map_ = None
    def copyRandomList(self, head: 'Node') -> 'Node':
        self.map_ = {}
        if not head or head is None:
            return None 
        copynode = self.copy(head)
        curr = head 
        while curr is not None:
            copynode.random = self.copy(curr.random)
            copynode.next = self.copy(curr.next) 
            curr = curr.next 
            copynode = copynode.next 
        
        return self.map_[head]
    
    def copy(self, node):
        if node is None:
            return None 
        if node in self.map_:
            return self.map_[node]
        
        newnode = Node(node.val, node.next, node.random)
        self.map_[node] = newnode
        return newnode