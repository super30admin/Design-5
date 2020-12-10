#Time Complexity : O(n) where n is the number of nodes in the linkedlist
#Space Complexity : O(1) 
#Did this code successfully run on Leetcode : Yes


"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head

        #Make copy nodes adjacent to the original node, i.e. originalNode.next = copyNode
        curr = head
        while curr:
            newNode = Node(curr.val)

            newNode.next = curr.next
            curr.next = newNode
            curr = newNode.next

        #Point all random pointers of new nodes to their random pointers
        curr = head
        while curr:
            curr.next.random = curr.random.next if curr.random else None
            curr = curr.next.next

        #Split the lists into two
        old, new = head, head.next
        newHead = head.next

        while old:
            old.next = old.next.next
            new.next = new.next.next if new.next else None

            old = old.next
            new = new.next

        return newHead

#     def clone(self, node):
#         if node:
#             if node in self.mapping:
#                 return self.mapping[node]
#             else:
#                 newNode = Node(node.val)
#                 self.mapping[node] = newNode
#                 return newNode
#         return None

#     def copyRandomList(self, head: 'Node') -> 'Node':
#         if not head:
#             return head
#         self.mapping = {}
#         newNode = self.clone(head)
#         self.mapping[head] = newNode
#         curr = head
#         newHead = newNode
#         while curr:
#             newNext = self.clone(curr.next)
#             newRandom = self.clone(curr.random)
#             newNode.next = newNext
#             newNode.random = newRandom
#             newNode = newNode.next
#             curr = curr.next
#         return newHead
