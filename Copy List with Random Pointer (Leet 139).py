'''
Using Hashmap Approach
Time: O(n)
Space: O(n) for hashmap
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        if head is None:
            return
        
        self.hm = dict()
        
        deepcopy = self.clone(head)
        copycurr = deepcopy
        curr = head
        
        while curr != None:
            copycurr.next = self.clone(curr.next)
            copycurr.random = self.clone(curr.random)
            curr = curr.next
            copycurr = copycurr.next
        
        return deepcopy
    
    def clone(self, node):
        if node:
            if node not in self.hm:
                new_node = Node(node.val)
                self.hm[node] = new_node
            return self.hm[node]



'''
Time: O(n)
Space: O(1)
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        if head is None:
            return None
        
        curr = head
        while curr != None:
            new_node = Node(curr.val)
            new_node.next = curr.next
            curr.next = new_node
            curr = curr.next.next
        
        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
    
        curr = head
        new_curr = head.next
        while curr.next != None:
            temp = curr.next
            curr.next = curr.next.next
            curr = temp
        
        return new_curr
        