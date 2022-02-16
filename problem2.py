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
        self.hashMap = {}
        if head is None:
            return None

        currHead = head
        headNode = self.clone(head)
        copyNode = headNode

        while currHead is not None:
            copyNode.next = self.clone(currHead.next)
            copyNode.random = self.clone(currHead.random)

            currHead = currHead.next
            copyNode = copyNode.next

        return headNode


    def clone(self,head):
        if head == None:
            return None

        if head in self.hashMap:
            return self.hashMap[head]

        newNode = Node(head.val)
        self.hashMap[head] = newNode
        return newNode


# Approach 2:

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

        # adding new nodes into linked list
        while curr is not None:
            copy = Node(curr.val)
            copy.next = curr.next
            curr.next = copy
            curr = curr.next.next


        # adding random pointers
        curr = head
        copy = head.next
        while curr is not None:
            if curr.random is not None:
                curr.next.random = curr.random.next
            curr = copy.next
            if curr is not None:
                copy = curr.next

        # seprating nodes
        curr = head
        copyHead = head.next
        copy = copyHead
        while copy.next is not None:
            curr.next = copy.next
            copy.next = curr.next.next

            curr = curr.next
            copy = copy.next


        return copyHead
