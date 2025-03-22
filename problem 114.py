#  https://leetcode.com/problems/copy-list-with-random-pointer/

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
        if head == None:
            return None
        
        hm = {}
        copyHead = Node(head.val)
        hm[head] = copyHead
        curr = head
        copyCurr = copyHead

        while(curr.next != None):
            newNode = Node(curr.next.val)
            copyCurr.next = newNode
            hm[curr.next] = newNode
            curr = curr.next
            copyCurr = copyCurr.next

        curr = head
        copyCurr = copyHead
        while(curr != None):
            if curr.random != None:
                copyCurr.random = hm[curr.random]
        
            curr = curr.next
            copyCurr = copyCurr.next
        
        return copyHead


# TC: O(n)
# SC: O(n)

########################3 HM WITH A CLONE FUNCTION #########################

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
        if head == None:
            return None
        
        self.hm = {}
        copyHead = Node(head.val)
        self.hm[head] = copyHead
        curr = head
        copyCurr = copyHead

        while(curr != None):
            copyCurr.next = self.clone (curr.next,self.hm)
            if curr.random != None:
                copyCurr.random = self.clone(curr.random,self.hm)
        
            curr = curr.next
            copyCurr = copyCurr.next
        
        return copyHead
    
    def clone(self,node,hm):
        if node == None:
            return None

        if node in hm:
            return hm[node]
        
        newNode = Node(node.val)
        hm[node] = newNode
        return newNode


# TC: O(n)
# SC: O(n)


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
        if head == None:
            return None
        
        curr = head
        while curr != None:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next

        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            
            curr = curr.next.next
        
        curr = head
        newhead = head.next
        copyCurr = head.next
        while curr != None:
            curr.next = curr.next.next
            if copyCurr.next != None:
                copyCurr.next = copyCurr.next.next
            
            curr = curr.next
            copyCurr = copyCurr.next
        
        return newhead

        
        


# TC: O(n)
# SC: O(1)