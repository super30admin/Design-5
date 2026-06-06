class Node:
    def __init__(self, x, next= None, random = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head):
        if not head:
            return head
        newmap = {}
        curr = head
        while curr:
            if curr not in newmap:
                newmap[curr] = Node(curr.val)
            if curr.next and curr.next not in newmap:
                newmap[curr.next] = Node(curr.next.val)
            if curr.random and curr.random not in newmap:
                newmap[curr.random] = Node(curr.random.val)
            newNode = newmap[curr]
            newNode.next = newmap[curr.next] if curr.next else None
            newNode.random = newmap[curr.random] if curr.random else None
            curr = curr.next
        return newmap[head]