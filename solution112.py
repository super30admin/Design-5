#Time COmplexity:O(n)
#Space Complexity:O(n)
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
            return None
        self.dict={}                                    #create hashmap that store new node as key and its copy as value
        copyHead=self.clone(head)                       #call the clone function that creates a copy of the node or returns copy if already exists
        curr=head
        currCopy=copyHead
        while curr:
            currCopy.next=self.clone(curr.next)         #for every node in list, create copy.next and copy.random by iterating through the nodes
            currCopy.random=self.clone(curr.random)
            curr=curr.next
            currCopy=currCopy.next
        return copyHead
        
    def clone(self,node:'Node')->'Node':                
        if not node:                                    #if node is null return none
            return None
        if node in self.dict:                           #if node already exists in dict return the copy of node
            return self.dict[node]
        newNode=Node(node.val)                          #else create copy of node as value in dict and then return the copy.
        self.dict[node]=newNode
        return newNode

#Time Complexity:O(n)
#Space Complexity:O(1)
#Approach:Insert copy of each node next to respective nodes, connect the copies to its respective next and random nodes and return the copied list

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
            return None
        curr=head
        while curr:
            currCopy=Node(curr.val)
            currCopy.next=curr.next
            curr.next=currCopy
            curr=curr.next.next
        curr=head
        while curr:
            if curr.random:
                curr.next.random=curr.random.next
            curr=curr.next.next
        curr=head
        copyHead=currCopy=head.next
        while curr:
            curr.next=curr.next.next
            if currCopy.next:
                currCopy.next=currCopy.next.next
            curr=curr.next
            currCopy=currCopy.next
        return copyHead