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
        self.nodes = defaultdict(Node)
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        start = newNode = self.cloneNode(head)
        while head:
            
            newNode.next = self.cloneNode(head.next) if head.next else None
            newNode.random = self.cloneNode(head.random) if head.random else None
            
            newNode = newNode.next
            head = head.next
        
        return start 
    
    def cloneNode(self, node):
        if node in self.nodes:
            return self.nodes[node]
        else:
            newNode = Node(node.val)
            self.nodes[node] = newNode
            return newNode
Time Complexity: O(N)
Space: O(N)
            
        
        
