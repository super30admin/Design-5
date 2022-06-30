'''
time complexity: O(n)
space complexity: O(n\)
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
        if head==None: return None
        curr = head
        while(curr!=None):
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        
        curr = head

        
        while(curr!=None):
            if(curr.random!=None):
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        curr = head
        copyCurr = head.next
        copyhead = copyCurr
        while(curr!=None):
            curr.next = curr.next.next
            if(copyCurr.next!=None):
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        return copyhead