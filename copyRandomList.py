"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#TC:O(n)
#SC:O(n)...We will store a clone mapping for each node entailing linear space complexity with respect to the original list passed to us.
#Ran successfully on Leetcode:Yes
#Algo:Use a hashtable to facilitate the cloning.
#In the hashmap we map original to copy of the nodes
#In create node function we check if the copy we are making already exists in the map else, we create a copy.

class Solution:
    def copyRandomList(self, head):
        self.nlist={None:None} #old_node:new_node
        
        def create_node(node):
            if node in self.nlist:
                return self.nlist[node]
            else:
                c_node=Node(node.val)
                self.nlist[node]=c_node
                return c_node
        
        node=head
        while node:
            new_node=create_node(node)
            new_node.next=create_node(node.next)
            new_node.random=create_node(node.random)
            node=node.next
                
        return self.nlist[head]  
        
