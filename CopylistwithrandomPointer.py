#// Time Complexity : O(n) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

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
        # copyNode = Node(head)
        #create a copy list
        while curr != None:
            copyNode= Node(curr.val)
            copyNode.next = curr.next
            curr.next = copyNode
            curr = curr.next.next
        #random pointer
        curr = head
        while curr != None:
            if curr.random:
                curr.next.random = curr.random.next
            curr= curr.next.next
        curr = head
        
        copypoi = curr.next
        copyHead=copypoi
        #seperate list
        while curr != None:
            curr.next = copypoi.next
            if copypoi.next:
                copypoi.next = curr.next.next
            curr = curr.next
            copypoi = copypoi.next

        return copyHead

# Approach:
# 1. Create a copy of the original linked list.
# 2. Update the random pointers of the copied nodes.
# 3. Separate the copied list from the original list.
