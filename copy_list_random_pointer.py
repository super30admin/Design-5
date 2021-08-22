"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#Time Complexity: O(N)

#Space Complexity: O(1) 
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        cur = head
        while cur:
            newnode = Node(cur.val)
            newnode.next = cur.next
            cur.next = newnode
            cur = cur.next.next
        cur = head

        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            else:
                cur.next.random = None
            cur = cur.next.next
    
        cur = head
        copy_head = head.next
        copy = head.next
        while(cur):
            cur.next = cur.next.next
            if copy.next:
                copy.next = copy.next.next
            else:
                copy.next = None
                
            cur = cur.next
            copy = copy.next
        return copy_head
            