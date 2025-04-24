# This approach connects the node with corresponding node in the next and maps random of the current with corresponding copy
# TC: O(N)
# SC: O(1)


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
        curr = head
        while curr:
            newnode = Node(curr.val)
            newnode.next = curr.next
            curr.next = newnode
            curr = curr.next.next
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        curr = head
        copy = curr.next
        copycurr = copy
        while curr and copycurr.next:
            curr.next = curr.next.next
            copycurr.next = copycurr.next.next
            curr = curr.next
            copycurr = copycurr.next
        return copy



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
        self.dic = {}
        copy = self.clone(head)
        curr = head
        copycurr = copy
        while curr:
            node = self.clone(curr.next)
            copycurr.next = node
            node = self.clone(curr.random)
            copycurr.random = node
            curr = curr.next
            copycurr = copycurr.next
        return copy

    def clone(self, node):
        if not node:
            return None
        if node in self.dic:
            return self.dic[node]
        newNode = Node(node.val)
        self.dic[node] = newNode
        return newNode