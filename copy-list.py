"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
from collections import defaultdict
class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        # Hashmap to store cloned nodes
        cloneMap = {}
        
        curr = head
        
        # 1st pass -> construct cloneMap
        # Key - Node
        # Value - Clone
        while curr != None:
            cloneMap[curr] = Node(curr.val)
            curr = curr.next
            
        # 2nd pass -> build new list from cloneMap 
        curr = head
        while curr != None:
            cloneMap[curr].next = cloneMap.get(curr.next)
            cloneMap[curr].random = cloneMap.get(curr.random)
            curr = curr.next
            
        return cloneMap.get(head)