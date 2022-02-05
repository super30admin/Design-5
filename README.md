# Design-5

## Problem 1: 
This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
When someone leave you need update this space as empty. 
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.

## Problem 2: Copy List with Random Pointer

https://leetcode.com/problems/copy-list-with-random-pointer/

"""


# Time Complexity = O(n)
# Space Complexity = O(1)

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
        curr=head
        while curr is not None:
            newNode=Node(curr.val)
            newNode.next=curr.next
            curr.next=newNode
            curr=curr.next.next
        p,q=head,head.next
        newhead=q
        while p is not None:
            if p.random is not None:
                q.random=p.random.next
            p=p.next.next
            if q.next is not None:
                q=q.next.next
        p=head
        q=head.next
        while p is not None:
            p.next=q.next
            if p.next is not None:
                q.next=p.next.next
            p=p.next
            q=q.next
        return newhead
            
            
        
            
        