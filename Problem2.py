# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

#create a new node for every node and place it after original node then copy all the random pointers then remove the original nodes
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head == None:
            return head
        node = head
        while node != None:
            dummy = Node(node.val)
            nNode = node.next
            node.next = dummy
            dummy.next = nNode
            node = nNode
        node = head
        while node != None:
            if node.random == None:
                node.next.random = None
            else:
                node.next.random = node.random.next
            node = node.next.next
        node = head.next
        while node.next != None:
            node.next = node.next.next
            node = node.next
        node = head.next
        
        
        return head.next