"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# Time : O(n)
# Space : O(n)
class Solution:
    hash_map = {}
    def copyRandomList(self, head: 'Node') -> 'Node':
        if(head == None): 
            return head
        
        copy_head = self.clone(head)
        curr = head
        curr_copy = copy_head
        
        while(curr != None):
            curr_copy.next = self.clone(curr.next)
            curr_copy.random = self.clone(curr.random)
            curr = curr.next
            curr_copy = curr_copy.next
            
        return copy_head
        
        
    def clone(self, node):
        if(node == None):
            return None
        
        # if node is previously created, fetch from map and return
        if(node in self.hash_map):
            return self.hash_map[node]
        
        # if node is not created, create a new node, put it in map and return that
        new_node = Node(x=node.val)
        self.hash_map[node] = new_node
        return new_node