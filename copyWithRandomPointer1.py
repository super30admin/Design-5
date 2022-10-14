"""
Time Complexity : O(n) where n is the total number of nodes. n because we need to iterate to all the nodes to create a deep copy 

Space Complexity : O(n) where n is the total number of nodes. All the nodes will be stored in hashMap

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
1. Iterate through the input list and add it to hashMap if not added previoulsy.
2. Create a deep copy of the node while adding it to the hashMap. HashMap will have key as inputNode and value as newNode.
3. After creating and adding inputNode, newNode pair to the hashMap check if inputNode.next and inputNode.random are present in hashMap.
4. If already present then get its value and assign it to the newNode.next and newNode.random
5. If not then create a newNode, add it to the hashMap and make the necessary conncections.
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    #Time Complexity: O(n) where n is the total number of nodes
    #Space Complexity : O(n) where n is the total number of nodes
    def __init__(self):
        self.hashMap = {}
        
    def createNode(self, head):
        if head == None:
            return None
        if head in self.hashMap:
            return self.hashMap[head]
        if head not in self.hashMap:
            newNode = Node(head.val)
            self.hashMap[head] = newNode
            return newNode
        
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        hashMap = {}
        curr = head
        newCurr = self.createNode(head)
        currCopy = newCurr
        while curr != None:
            currCopy.next = self.createNode(curr.next)
            currCopy.random = self.createNode(curr.random)
            curr = curr.next
            currCopy = currCopy.next
        
        return newCurr