"""
Name: Srinidhi Bhat
Did it run on LC: Yes

Time Complexity: O(N) - N is number of nodes
Space Complexity: O(N) - Extra space for hashmap

Logic: Maintain a hashmap with Node-> Node connected to
There are two cases: 
random pointer: If the node we get after random pointer doesnt exist, create a hashmap and add this link, if it does
just add the link and the Node

next pointer:If the node we get after random pointer doesnt exist, create a hashmap and add this link, if it does
just add the link and the Node
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
    
    def __init__(self):
        self.visited = {}
    
    
    def getCloneNode(self,node):
        if node:
            if node in self.visited:
                print(self.visited[node].val)
                return self.visited[node]
            
            else:
                self.visited[node] = Node(node.val,None,None)
                print(self.visited[node].val)
                return self.visited[node]
        return None

    
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head is None:
            return None
        
        old_node = head
        new_node = Node(old_node.val,None,None)
        
        self.visited[old_node] = new_node
        
        while old_node!=None:
            new_node.next = self.getCloneNode(old_node.next)
            new_node.random = self.getCloneNode(old_node.random)
            
            old_node = old_node.next
            new_node = new_node.next
        return self.visited[head]
            