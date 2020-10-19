# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :  Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

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
        
        if head == None:
            return head
        
        hmap = {}
        
        deepCopy = Node(head.val)
        hmap[head] = deepCopy
        newNode = deepCopy
        
        while head:
            deepCopy.next = self.getNode(head.next, hmap)
            deepCopy.random = self.getNode(head.random, hmap)
            
            head = head.next
            deepCopy = deepCopy.next
            
        return newNode
    
    def getNode(self, orgNode, hmap):
        if orgNode == None:
            return orgNode
        elif orgNode in hmap:
            return hmap[orgNode]
        else:
            newNode = Node(orgNode.val)
            hmap[orgNode] = newNode
        return newNode
        
        
        
        

        
