"""
I solved this by first inserting a copy of each node right after the original node,  
so that the copied nodes are interleaved with the original ones. Then, I set the random pointers for the copied nodes by referring to the original nodes random pointers next nodes. After that, I separated the two lists to restore the original and get the copied list. This way, I avoided using extra space for a hashmap.
Time Complexity: O(n)
Space Complexity: O(1)
"""

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

        if not head:
            return None
        
        #create deep copy and put next to original
        curr = head
        while curr:
            copyCurr = Node(curr.val) 
            copyCurr.next = curr.next
            curr.next = copyCurr
            curr = curr.next.next
        
        #create random pointers
        curr = head
        copyCurr = head.next
        while curr:
            if curr.random:
                copyCurr.random = curr.random.next
            curr = curr.next.next
            if copyCurr.next:
                copyCurr = copyCurr.next.next

        #separate both list
        curr = head
        copyCurr = head.next
        newHead = head.next
        while curr:
            curr.next = curr.next.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
            
        return newHead  