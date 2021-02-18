# Optimized approach with constant space 
# Time - O(N)
# Space - O(1)

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
        
        current = head
        
        # step 1 - assign deep copies and link to nodes in the linked list
        while current:
            # copy of current ie head
            current_copy = Node(current.val)
            # establish pointers to next of deep copy node
            current_copy.next = current.next
            current.next = current_copy
            # move current to next next since current.next is now the deep copy list
            # egs 1 --> 1' ---> 2 ----> 2'
            current = current.next.next
            
            
        # step 2 - assign random pointer references
        current = head
        while current:
            if current.random:
                current.next.random = current.random.next
            current = current.next.next
            
            
        # step 3 - split the lists
        current = head
        # current_copy --> head of copied list will be head.next egs 1 --> 1' here head.next is the head of the copied list
        # head_copy -- copy of head of original LL we need it as we will be moving this pointer, we need to return this at the end
        current_copy, head_copy = head.next, head.next
        while current:
            # 1--> 2 --> 3
            current.next = current.next.next
            
            # 1' --> 2' --> 3'
            # needs to be checked only for deep copy list since 1--> 1'---> 2 ---> 2'(current_copy) ---> None (current_copy.next)
            if current_copy.next:
                current_copy.next = current_copy.next.next
            
            # update refs as we iterate 
            current = current.next
            current_copy = current_copy.next
            
        return head_copy 
            
            
            
            
# Brute Force Approach
# Time - O(N)
# Space - O(N)

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':

        if head == None:
            return head
        
        # stores deep copies of nodes
        self.hashmap = {}
        
        # head of deep copy LL
        head_copy = self.clone(head)
        current = head
        current_copy = head_copy
        
        while current:
            current_copy.next = self.clone(current.next)
            current_copy.random = self.clone(current.random)
            current = current.next
            current_copy = current_copy.next
            
        return head_copy
        
        
    def clone(self, node):
        
        # if a node does not have a random pointer or points to NONE
        if node == None:
            return node
        
        if node in self.hashmap:
            return self.hashmap[node]
        
        newNode = Node(node.val)
        self.hashmap[node] = newNode
        
        return newNode 
        
        