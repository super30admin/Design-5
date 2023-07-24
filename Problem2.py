'''
Problem: Copy List with Random Pointer
Time Complexity: O(n), where n is the number of nodes
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        deep copy every node next to original node 
        then assign the random pointers
        at the end split the orignal list and copied list
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
        #create deep copies
        curr = head
        while curr:
            new = Node(curr.val)
            new.next = curr.next
            curr.next = new
            curr= curr.next.next
        
        #random pointers
        curr = head
        copycurr = head.next
        copyhead = head.next

        while curr:
            if curr.random is not None:
                copycurr.random = curr.random.next
            curr = curr.next.next
            if copycurr.next:
                copycurr = copycurr.next.next
        
        #split the list
        curr = head
        copycurr = head.next

        while curr:
            curr.next = curr.next.next
            if copycurr.next:
                copycurr.next = copycurr.next.next
            curr= curr.next
            copycurr = copycurr.next
        
        return copyhead

        