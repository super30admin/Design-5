#Time Complexity :- O(n)
#Space Complexity :- O(n)

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    hashMap = {}
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        self.hashMap = {}
        copyNode = self.cloneNodes(head)
        copyCurrNode = copyNode
        curr = head
        while curr:
            copyCurrNode.next = self.cloneNodes(curr.next)
            copyCurrNode.random = self.cloneNodes(curr.random)
            curr = curr.next
            copyCurrNode = copyCurrNode.next
        return copyNode



    def cloneNodes(self, node):
        if node is None:
            return None
        
        if node in self.hashMap:
            return self.hashMap[node]
        else:
            newNode = Node(node.val, None, None)
            self.hashMap[node] = newNode
            return newNode

#Time Complexity :- O(n)
#Space Complexity :- O(1)

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

        while curr :
            newNode = Node(curr.val, None, None)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        
        newCurr = head 
        while newCurr:
            if newCurr.random is not None:
                newCurr.next.random = newCurr.random.next
            newCurr = newCurr.next.next
        
        curr = head
        copyHead = curr.next
        copyCurr = curr.next
        while curr is not None:
            curr.next = copyCurr.next
            print(curr.val, copyCurr.val)
            if copyCurr.next is None:
                break
            copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next

        return copyHead
        