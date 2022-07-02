# Time Complexity : O(N) where N is number of nodes in the linkedlist
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        if head == None: return None
        curr = head
        while curr is not None:
            newNode =  Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        
        curr = head
        while curr is not None:
            if curr.random is not None:
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        curr = head
        currCopy = head.next
        copyHead = currCopy
        
        while curr is not None:
            curr.next = curr.next.next
            if currCopy.next is not None:
                currCopy.next = currCopy.next.next
            curr = curr.next
            currCopy = currCopy.next
            
        return copyHead