# Time : O(n)
# Space :O(n)

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return
        # maintain a hashmap which maps the old lsit to new list for a node
        self.map = {}
        
        # start with the head
        curr = head
        # clone the head
        copyHead = self.clone(head)
        copyCurr = copyHead
        
        # traverse from the head
        while curr != None:
            # clone the next and random elements of a node and point it for the new list
            copyCurr.next = self.clone(curr.next)
            copyCurr.random = self.clone(curr.random)
            
            # move pointers on both lists
            curr = curr.next
            copyCurr = copyCurr.next
        
        # return the head of the new list
        return copyHead
    
    def clone(self, node):
        # if Node is None then return None
        if node == None:
            return None
        # if node is present in the Hashmap, then just return it's corresponding value
        if node in self.map:
            return self.map[node]
        
        # if not, then create a deep copy and add the node to the hashmap
        newNode = Node(node.val)
        self.map[node] = newNode
        
        return newNode
