"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#time complexity: O(n)
# space complexity: O(1)

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return None
        # add copy Node next to curr
        curr = head
        
        while curr != None:
            copyNode = Node(curr.val)
            temp = curr.next
            curr.next = copyNode
            copyNode.next = temp
            curr = curr.next.next

        # # add randoms
        curr = head
        copyHead = head.next
        copyCurr = copyHead

        while curr!=None:
            if curr.random != None:
                copyCurr.random = curr.random.next
            curr = curr.next.next
            if copyCurr.next != None:
                copyCurr = copyCurr.next.next
        
        # split the lists
        curr = head
        copyCurr = copyHead

        while curr!=None:
            curr.next = curr.next.next
            if copyCurr.next!=None:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        
        return copyHead

