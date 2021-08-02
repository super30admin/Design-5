"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    # Approach 1: using hash map
    """
    Pass 1: create the linked list copy with just the next pointers
            simultaneously, also map each node with its respective copy
    
    Pass 2: traverse through each node and assign the random pointers of the copied node to the corresponding node looking at the map
    
    TC: O(n) n -> nodes in given linked lis
    SC: O(n)
    """
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        hash_map = {}
        copied_node = self.copy_node(head)
        copied_head = copied_node
        hash_map[head] = copied_node
        curr_node = head.next
        while curr_node:
            copied_node.next = self.copy_node(curr_node)
            copied_node = copied_node.next
            hash_map[curr_node] = copied_node
            curr_node = curr_node.next
        curr_node = head
        curr_copy_node = copied_head
        while curr_node:
            if curr_node.random:
                curr_copy_node.random = hash_map[curr_node.random]
            curr_node = curr_node.next
            curr_copy_node = curr_copy_node.next
        
        return copied_head
    
    def copy_node(self, node):
        copied_node = Node(node.val)
        return copied_node
    
    #Approach 2: modify input, without extra space
    """
    1) Traverse through orignal list and merge the original and copied list such that each orignal node's next ptr points to its copied node:
    og(1) --> copied(1) --> og(2) --> copied(2) --> Null
    
    2) now for each copied node, you can point its random ptr to the node next to its og node's random ptr
    
    3) segregate the two lists and return copied head 
    
    TC: O(n)
    SC: O(1)
    """
    
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        curr_node = head
        # copy and merge
        while curr_node:
            temp = curr_node.next
            curr_node.next = Node(curr_node.val, temp)
            curr_node = temp
            
        curr_node = head
        # assign random ptr
        while curr_node:
            temp = curr_node.next.next
            if curr_node.random:
                curr_node.next.random = curr_node.random.next
            curr_node = temp
        

        curr_node = head
        out = head.next
        # segregate
        while curr_node.next:
            temp = curr_node.next
            curr_node.next = curr_node.next.next
            curr_node = temp
            
        return out
                
        
            