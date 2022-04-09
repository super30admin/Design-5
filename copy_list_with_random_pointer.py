##Time complexity : - O(n)
# Space complexity: - O(1)

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
        ##cloned node
        node = head
        while (node != None):
            clonednode = Node(node.val)
            originalnode = node.next
            node.next = clonednode
            clonednode.next = originalnode
            node = node.next.next

        ## 1-1'-2-2'-3-3'-x

        node = head
        while (node != None):
            if (node.random != None):
                clonednode = node.next
                node.next.random = node.random.next

            node = node.next.next

        clonedhead = head.next
        node = head

        while (node != None):
            clonednode = node.next
            node.next = node.next.next
            if clonednode.next != None:
                clonednode.next = clonednode.next.next
            node = node.next
        return clonedhead







