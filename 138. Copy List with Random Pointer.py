'''
T = O(3n)
S = O(1)

1. Traverse through the list and add a copy of each node right after the node.
2. Traverse again and populate the random pointers of the copy nodes.
3. Traverse again and split the list into 2, one being the original and the other one being the copy 
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
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        
        curr = head
        while curr:
            node = Node(curr.val)
            node.next = curr.next
            curr.next = node
            curr = curr.next.next
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        slow = head
        fast = head.next
        deep = fast
        while slow:
            slow.next = fast.next
            slow = slow.next
            if fast.next:
                fast.next = slow.next
                fast = fast.next
        return deep

'''
T = O(n)
S = O(n)
Approach:
Traverse and maintain a clone linked list and maintain a hashmap  to check if the clone node is already created return the deep copy to the man node
'''

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    hashmap = {}
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head == None: return head
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
        if node== None: return None
        if node in self.hashmap:
            return self.hashmap[node]
        newNode = Node(node.val)
        self.hashmap[node] = newNode 
        return newNode
        