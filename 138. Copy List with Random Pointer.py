'''
T = O(3n)
S = O(1)

1. Traverse through the list and add a copy of each node right after the node.
2. Traverse again and populate the random pointers of the copy nodes.
3. Traverse again and split the list into 2, one being the original and the other one being the copy 
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
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        curr = head
        while curr:
            node = Node(curr.val)
            node.next = curr.next
            curr.next = node
            curr = curr.next.next
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        slow = head
        fast = head.next
        deep = fast
        while slow:
            slow.next = fast.next
            slow = slow.next
            if fast.next:
                fast.next = slow.next
                fast = fast.next
        return deep
            
        