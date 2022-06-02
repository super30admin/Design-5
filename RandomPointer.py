"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# TC - O(n)
# SC - O(n)


class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return None

        curr = head

        while(curr):
            newnode = Node(curr.val)
            newnode.next = curr.next
            curr.next = newnode
            curr = curr.next.next

        curr = head

        while(curr):
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        curr = head
        copyhead = curr.next
        copy = copyhead

        while(curr):
            curr.next = curr.next.next
            if not copy.next:
                break
            copy.next = copy.next.next
            curr = curr.next
            copy = copy.next

        return copyhead
