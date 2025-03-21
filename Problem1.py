"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#time complexity o(n)
#space complexity o(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        curr = head
        while curr != None:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next

        curr = head
        #create random pointers
        while curr != None:
            if curr.random !=None:
                curr.next.random = curr.random.next
            curr = curr.next.next

        #split the list
        curr = head
        copyHead = head.next
        copyCurr = curr.next
        while curr != None:
            curr.next = curr.next.next
            if copyCurr.next != None:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        
        return copyHead
        