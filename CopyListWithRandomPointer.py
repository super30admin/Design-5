# Time Complexity - O(N)
# Space Complexity - O(1)

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
        
        #base case
        if head == None:
            return None
        
        
        # Creating a new linked list after every element of old linked list
        ptr = head
        
        while (ptr != None):
            
            newNode = Node(ptr.val)
            temp = ptr.next
            ptr.next = newNode
            newNode.next = temp
            
            ptr = newNode.next
        
        # Setting the random pointer
        
        ptr = head
        while(ptr != None):
            if ptr.random != None:
                ptr.next.random = ptr.random.next
            
            ptr = ptr.next.next
            
        # Unweave the linked list
        
        ptrOld = head
        ptrNew = head.next
        head_new = head.next
        while(ptrOld != None):
            
            ptrOld.next = ptrOld.next.next
            if ptrNew.next != None:
                ptrNew.next = ptrNew.next.next
            
            ptrOld = ptrOld.next
            ptrNew = ptrNew.next
            
        return head_new
        
#         self.visited = {}
#         oldNode = head
#         newNode = Node(oldNode.val)
#         self.visited[oldNode]=newNode
        
#         while(oldNode):
            
#             newNode.random = self.clone(oldNode.random)
#             newNode.next = self.clone(oldNode.next)
            
            
#             oldNode = oldNode.next
#             newNode = newNode.next
            
            
#         return self.visited[head]
    
#     def clone(self, node):
        
#         if node != None:
#             if node not in self.visited:
#                 self.visited[node]=Node(node.val,None,None)
                            
#             return self.visited[node]
            
#         return None
                
            
        