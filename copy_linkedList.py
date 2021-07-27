"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    """
    TC:O(n)
    SC:O(1)
    """
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return None
        
        # create the deep copies
        cur=head
        while(cur):
            newNode= Node(cur.val)
            newNode.next=cur.next
            cur.next=newNode
            cur=cur.next.next
            
        # start with random pointers
        cur=head
        while(cur):
            if cur.random:
                cur.next.random=cur.random.next
            cur=cur.next.next
        
        # split
        cur=head
        copyHead=head.next
        curCopy=copyHead
        
        while(cur):
            cur.next=cur.next.next
            if curCopy.next:
                curCopy.next=  curCopy.next.next
            cur=cur.next
            curCopy=curCopy.next
        
        return copyHead
        
#     """
#     Not optimized
#     TC:O(n)
#     SC:O(n)
    
#     """
#     def __init__(self):
#         self.mapp={}

    
#     def copyRandomList(self, head: 'Node') -> 'Node':
#         if not head: return
#         cur=head
#         curCopy=self.clone(head)
#         while cur:
#             curCopy.next=self.clone(cur.next)
#             curCopy.random=self.clone(cur.random)
#             cur=cur.next
#             curCopy=curCopy.next
#         return self.mapp[head]
    
#     def clone(self,node):
#         if not node:return None
#         if node in self.mapp:
#             return self.mapp[node]
#         newNode=Node(node.val)
#         self.mapp[node]=newNode
#         return newNode
    
    
    
    
    
            
        