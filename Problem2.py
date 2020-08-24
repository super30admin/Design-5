
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

"""

    Name :  Shahreen Shahjahan Psyche
    Time : O(N)
    Space: O(N) [the hashmap]
    
    Passed all the test cases in LC : Yes

"""

class Solution:
    
    # mapping the original node to new nodes
    def deepCopyAndMap(self, head):
        records = {}
        while head:
            new_node = Node(head.val)
            records[head] = new_node
            head = head.next 
        return records
        
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        # edge case
        if not head:
            return
        
        root = head
        records = self.deepCopyAndMap(root)
        root = head
        
        # copying the next node and the random node wrt the original list node
        while root:
            curr_node = records[root]
            if root.next:
                curr_node.next = records[root.next]
            if root.random:
                curr_node.random = records[root.random]
            root = root.next 
            
        return records[head]
        
        
        
        
