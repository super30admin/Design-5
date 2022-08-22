# Time complexity: O(n)
# Space complexity: O(1)- returning the linkedlist created
# Approach: create the copy of each nodex next to the original node by traversing the entire linkedlist once
# Now, create corresponding random and pointers for copied nodes
# Now, to remove the link between original node and copy nodes, create the curr's next pointer to copycur's #next
# and create the copycurrents next pointer to copy curr's next's next.




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
        if head == None:
            return None
        curr = head
        while(curr != None):
            copyhead = Node(curr.val)
            copyhead.next = curr.next
            curr.next = copyhead
            curr = curr.next.next
        curr = head
        while(curr != None):
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
        curr = head
        copyhead = curr.next
        copycurr = curr.next
        while curr != None:
            curr.next = copycurr.next
            if copycurr.next == None:
                break
            copycurr.next = copycurr.next.next
            curr = curr.next
            copycurr = copycurr.next
        return copyhead
        
        