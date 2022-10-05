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
        if head is None:
            return None
        self.hashMap = {}
        copyHead = self.clone(head)
        curr = head
        currCopy = copyHead
        while curr:
            currCopy.next = self.clone(curr.next)
            currCopy.random = self.clone(curr.random)
            curr = curr.next
            currCopy = currCopy.next

        return copyHead

    def clone(self, node):
        if node is None:
            return None
        if node in self.hashMap:
            return self.hashMap.get(node)
        copyNode = Node(node.val)
        self.hashMap[node] = copyNode
        return copyNode
# Using HashMap
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No