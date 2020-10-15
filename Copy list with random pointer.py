"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if head == None:
            return head
        
        hashMap = {}
        deepCopy = Node(head.val)
        hashMap[head] = deepCopy
        newNode = deepCopy
        while(head is not None):
            deepCopy.next = self.getNode(head.next, hashMap)
            deepCopy.random = self.getNode(head.random, hashMap)
            
            head = head.next
            deepCopy = deepCopy.next
        
        return newNode
    
    def getNode(self, originalNode, hashMap):
        if originalNode == None:
            return originalNode
        
        elif originalNode in hashMap:
            return hashMap[originalNode]
        
        else:
            newNode = Node(originalNode.val)
            hashMap[originalNode] = newNode
        
        return newNode
         
        
        
        
        #timeComplexity: O(n)
        #spaceComplexity: O(n)
