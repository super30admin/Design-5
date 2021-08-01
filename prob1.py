"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if head is None:
            return None
        #Time complexity: O(n)
        # Space complexity: O(1)
        cur = head
        # adding new nodes in between
        while cur is not None:
            newNode = Node(cur.val)
            newNode.next = cur.next
            cur.next = newNode
            cur = cur.next.next
        
        # adding random pointers in the new nodes
        cur = head
        while cur is not None:
            if cur.random is not None:
                cur.next.random = cur.random.next
            cur = cur.next.next
        newHead = head.next
        cur = head
        while cur is not None:
            temp = cur.next
            cur.next = cur.next.next
            if temp.next is not None:
                temp.next = temp.next.next
            cur = cur.next
        return newHead
        #Time and Space complexities: O(n)
        # self.cloneMap = {}
        # def clone(node):
        #     if node is None:
        #         return None
        #     if node in self.cloneMap:
        #         return self.cloneMap[node]
        #     else:
        #         newNode = Node(node.val)
        #         self.cloneMap[node] = newNode
        #         return newNode
        # cur = head
        # cloneHead = Node(head.val)
        # self.cloneMap[head] = cloneHead
        # cloneCur = cloneHead
        # while cur is not None:
        #     cloneCur.next = clone(cur.next)
        #     cloneCur.random = clone(cur.random)
        #     cloneCur = cloneCur.next
        #     cur = cur.next
        # return cloneHead
           
