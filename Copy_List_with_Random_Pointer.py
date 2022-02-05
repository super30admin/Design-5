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
        """
        Copy List with Random Pointer
        Time complexity : O(n)
        Space complexity : O(1)
        """
        curr = head
        while curr is not None:
            temp = Node(curr.val)
            temp.next = curr.next
            curr.next = temp
            curr = curr.next.next
            
        curr = head
        while curr is not None:
            if curr.random is None:
                curr.next.random = None
                curr = curr.next.next
                continue
            curr.next.random = curr.random.next
            curr = curr.next.next
            # break
        curr = head
        if head is None:
            return head
        temp = head.next
        copy_curr = temp
        while curr is not None:
            if curr.next.next is None:
                break
            curr.next = curr.next.next
            copy_curr.next = copy_curr.next.next
            curr = curr.next
            copy_curr = copy_curr.next
            
            
                
            
    
        
        return temp