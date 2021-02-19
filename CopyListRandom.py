# Deep copy of nodes with extra space(hashmap)
# TC: O(n)
# SC: O(n)
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

# O(1) space
# Steps:
# 1. create deep copy and put it next to original
# 2. create random pointer connections for the copies 
#       curr.next.random = curr.random.next
#       curr = curr.next.next
# 3. Split lists:
#       curr.next = curr.next.next
#       curr'.next = curr'.next.next
#       curr = curr.next
#       curr' = curr'.next
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head == None: return head
        
        # deep copy and place it adjacent
        curr = head
        while curr:
            currCopy = Node(curr.val)
            currCopy.next = curr.next
            curr.next = currCopy
            curr = curr.next.next
        
        # create random pointers of copied nodes
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        # split the lists
        curr = head
        copyHead = head.next
        currCopy = head.next
        while curr:
            curr.next = curr.next.next
            if currCopy.next:
                currCopy.next = currCopy.next.next
            curr = curr.next
            currCopy = currCopy.next
        return copyHead