"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# Approach 1: Create a new list using HashMap
# hashMap will help track of created nodes and we will be able to avoid creating
# duplicate nodes
# TC: O(N) for one time LL traversal
# SC: O(N) for hashMap
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: 
            return None
        mapping = {}
        
        def clone(node):
            # if node not in map then create copy and add to map
            if not node in mapping:
                mapping[node] = Node(node.val)
            # return copy
            return mapping[node]
            
        # initialize curr at head
        curr = head
        dummyHead = Node(-1)
        copyCurr = dummyHead
        # while curr is not none
        while curr:
            # make deep copy of each node
            copyCurr.next = clone(curr)
            # if curr node has a random pointer
            if curr.random:
                copyCurr.next.random = clone(curr.random)
            # increment both pointers
            curr = curr.next
            copyCurr = copyCurr.next
        return dummyHead.next
            
            
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# Approach 2: without hashmap
# algo:
# Create copy of each node and insert it right after the node in first pass
# then update all the random pointers in the 2nd pass
# in final pass separate original and copied lists
# TC: O(N) even though we do 3 passes
# SC: O(1) No extra space used
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: 
            return None

        # pass 1: Create clones of each node
        curr = head
        while curr:
            # make deep copy of each node
            node = Node(curr.val)
            node.next = curr.next
            curr.next = node
            curr = curr.next.next # skip over cloned node
        
        # pass 2: populate random pointers
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        # pass 3: untangle both linked lists
        curr = head
        copyHead = head.next
        copyCurr = copyHead
        while curr:
            curr.next = curr.next.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        return copyHead
        
            
            
            