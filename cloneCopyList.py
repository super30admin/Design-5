'''
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Created a store (hashMap) which contains the new node to old node reference. Use the store to create
the list. If a node does not exist then create it and save it in store else return the saved reference
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    def __init__(self):
        self.store = {}

    def clone(self, originalNode: 'Node') -> 'Node':
        if originalNode == None:
            return None
        cloneNode = self.store.get(originalNode)

        if cloneNode == None:
            cloneNode = Node(originalNode.val)
            self.store[originalNode] = cloneNode

        return cloneNode

    def copyRandomList(self, head: 'Node') -> 'Node':
        cursor = head
        resultCursor = self.clone(head)

        while cursor != None:
            resultCursor.random = self.clone(cursor.random)
            resultCursor.next = self.clone(cursor.next)
            resultCursor = resultCursor.next
            cursor = cursor.next

        return self.clone(head)