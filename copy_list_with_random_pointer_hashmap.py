# Time Complexity : O(N) where N is number of nodes in the linkedlist
# Space Complexity : O(N) where N is number of nodes in the linkedlist
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
    def __init__(self):
        self.hashmap = {}
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return None
        copyHead = self.cloneNode(head)     
        curr = head
        currCopy = copyHead
        while curr is not None:
            currCopy.next = self.cloneNode(curr.next)
            currCopy.random = self.cloneNode(curr.random)
            curr = curr.next
            currCopy = currCopy.next
            
        return copyHead
        
    def cloneNode(self, node):
        if node == None:
            return None
        
        if node in self.hashmap:
            return self.hashmap[node]
        newNode = Node(node.val)
        self.hashmap[node] = newNode
        return newNode