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
        ogLL = head
        cloneLL = None
        while head:
            #always make the pointers of lone node first
            newNode = Node(head.val, head.next)
            head.next = newNode
            head = newNode.next
            if not cloneLL:
                cloneLL = newNode
        
        #connect all random pointers
        head = ogLL
        while head:
            head.next.random = head.random.next if head.random else None
            head = head.next.next
        
        ogHead = ogLL
        cloneHead = cloneLL
        while ogHead:
            ogHead.next = ogHead.next.next
            if cloneHead.next:
                cloneHead.next = cloneHead.next.next
            ogHead = ogHead.next
            cloneHead = cloneHead.next
        return cloneLL
