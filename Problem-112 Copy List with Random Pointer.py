# 138. Copy List with Random Pointer
# https://leetcode.com/problems/copy-list-with-random-pointer/


"""# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

# Inefficient Space Solution

# Logic: Iterate the original LL and make a linear output LL. 
# When making new nodes, save in hashmap the input node as key 
# and new node as value. After the linear LL is complete, 
# iterate the input again and set random for all using the hashmap.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        hashmap = dict()
        
        ptr = head
        newHead = Node(head.val)
        ptr1 = newHead
        hashmap[ptr] = ptr1
        
        ptr = ptr.next
        
        # Make copy of input without random
        while ptr:
            node = Node(ptr.val)
            hashmap[ptr] = node
            
            ptr1.next = node
            
            ptr = ptr.next
            ptr1 = ptr1.next
        
        
        # 
        ptr = head
        ptr1 = newHead
        
        while ptr:
            if ptr.random:
                ptr1.random = hashmap[ptr.random]
            ptr = ptr.next
            ptr1 = ptr1.next
        
        return newHead

# Efficient Space Solution

# Logic: Add dummy nodes in the input LL with the same values as input. 
# This means that, for every node in input LL add a similar node just 
# next to it. Iterate the new LL and populate random. Seperate the two 
# LL and return the newHead.

# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        # Add dummy nodes
        ptr = head
        
        while ptr:
            node = Node(ptr.val)
            
            node.next = ptr.next
            ptr.next = node
            ptr = node.next
        
        # Populate random
        ptr = head
        
        while ptr:
            if ptr.random:
                ptr.next.random = ptr.random.next
            ptr = ptr.next.next
        
        # Remove new LL from input LL
        ptr = head
        newHead = ptr.next
        ptr1 = newHead
        
        while ptr:
            ptr.next = ptr1.next
            
            if ptr.next:
                ptr1.next = ptr.next.next
            
            ptr = ptr.next
            ptr1 = ptr1.next
        
        return newHead