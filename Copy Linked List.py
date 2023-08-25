# Time Complexity : O(n)
# Space Complexity : O(1)

# Code ran on LeetCode
# Add a copy of current node in between current node and the next node, also update the random pointers. Maintain a hashmap to keep track of these copy nodes. original node -> new node.
# In the second pass, remove connections of the original linked list 

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

        copy_map = {}
        dummy = Node(-1)
        dummy.next = head
        start = head
        while start:
            if start in copy_map:
                copyNode = copy_map[start]
            else:
                copyNode = Node(start.val)
                copy_map[start] = copyNode
            copyNode.next = start.next
            start.next = copyNode
            if start.random is not None:
                if start.random in copy_map:
                    copyNode.random = copy_map[start.random]
                else:
                    newNode = Node(start.random.val)
                    copy_map[start.random] = newNode
                    copyNode.random = copy_map[start.random]

            start = start.next.next

        start = dummy
        while start.next:
            temp = start.next
            start.next = start.next.next
            temp.next = None

            start = start.next

        return dummy.next
            