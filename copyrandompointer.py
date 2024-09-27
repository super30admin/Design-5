#Time complexity: O(N)
#Space compleexity: O(N) for hashmap
#Running on leetcode: Yes
#Problems faced: None
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
    def __init__(self):
        self.clonemap = defaultdict(Node)
        
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        
        cursor = head
        resultCursor = self.clone(cursor)
        
        copynode = resultCursor
        
        while(cursor!=None):
            resultCursor.next = self.clone(cursor.next)
            resultCursor.random = self.clone(cursor.random)
            cursor = cursor.next
            resultCursor = resultCursor.next
        return copynode
        
    def clone(self, node):
        
        if node == None:
            return None
        
        if node not in self.clonemap:
            clonenode = Node(node.val)
            self.clonemap[node] = clonenode
       
        return self.clonemap[node]
    
        
        
        
        
        