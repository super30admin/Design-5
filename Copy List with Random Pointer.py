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
            return
        # Approach 1 Uses a hashmap to map old nodes to new copy nodes to help with the random pointers
        # Time Complexity: O(2n)
        # Space Complexity: O(n)
        # hmap = {}
        # copyhead = Node(head.val)
        # hmap[head] = copyhead
        # curr = head
        # currcopy = copyhead
        # # Loop to deepcopy the nodes
        # while curr.next:
        #     curr = curr.next
        #     currcopy.next = Node(curr.val)
        #     currcopy = currcopy.next
        #     hmap[curr] = currcopy
        # # print(hmap)
        # # Another loop to copy the random pointers
        # curr = head
        # currcopy = copyhead
        # while curr:
        #     if curr.random:
        #         currcopy.random = hmap[curr.random]
        #     curr = curr.next
        #     currcopy = currcopy.next

        # return copyhead

        # Approach 2 Use hashmap to maintain old to copy node maps like approach 1, but do it all in a single pass
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        # hmap = {}
        # curr = head
        # copyhead = Node(head.val)
        # currcopy = copyhead
        # hmap[curr] = currcopy
        # def clone(root):
        #     if not root: return None
        #     if root not in hmap:
        #         hmap[root] = Node(root.val)
        #     return hmap[root]

        # while curr:
        #     # curr = curr.next
        #     currcopy.next = clone(curr.next)
        #     currcopy.random = clone(curr.random)
        #     curr = curr.next
        #     currcopy = currcopy.next
        # return copyhead

        # Approach 3 Try to solve this in O(1) Space and linear time, mapping new copy nodes by placing them in front of old nodes
        # Time Complexity: O(3n)
        # Space Complexity: O(1)

        curr = head

        # While loop to create new copy nodes
        while curr:
            temp = curr.next
            curr.next = Node(curr.val)
            curr = curr.next
            curr.next = temp
            curr = curr.next

        # While loop to copy random pointers for new copy nodes
        copyhead = head.next
        currcopy = copyhead
        curr = head
        currcopy = copyhead

        while curr:
            if curr.random:
                currcopy.random = curr.random.next
            curr = curr.next.next
            if currcopy.next:
                currcopy = currcopy.next.next

        # While loop to separate two linkedlists
        curr = head
        currcopy = copyhead
        while currcopy:
            if currcopy.next:
                currcopy.next = currcopy.next.next
            currcopy = currcopy.next

        return copyhead

