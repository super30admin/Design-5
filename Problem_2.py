"""
Problem : 2

Time Complexity : O(n)

Space Complexity : 
Approach 1&2 - O(n)
Approach 3 - O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Two Pass - 
Creating the new linked list, and storing the newnode to the node its copied from in a hashmap
now while connecting all random pointers, starting from original list, if the random pointer at that node exists
then checking whats the copied node in the new list for that node and pointing to that from the current node
in the copid list

One Pass -
Creating the new list and its connection through the random pointer in one go



"""

# Copy List with Random Pointer

"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

# Approach - 1
# Two Pass

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return None
        
        hmap={}
        copyHead=Node(head.val)
        curr=head
        copyCurr=copyHead
        hmap[head]=copyHead
        while curr.next:
            
            copyCurr.next=Node(curr.next.val)
            hmap[curr.next]=copyCurr.next
            copyCurr=copyCurr.next
            curr=curr.next

        curr=head
        copyCurr=copyHead
        while curr:
            if curr.random:
                copyCurr.random=hmap[curr.random]
            curr=curr.next
            copyCurr=copyCurr.next
        return copyHead
    
# Approach - 2
# One Pass

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
        if not head:
            return None

        def clone(node):
            if not node:
                return None
            
            if node not in hmap:
                newnode=Node(node.val)
                hmap[node]=newnode
                
            return hmap[node]

        hmap={}
        copyHead=Node(head.val)
        curr=head
        copyCurr=copyHead
        hmap[head]=copyHead
        while curr:
            copyCurr.next=clone(curr.next)
            copyCurr.random=clone(curr.random)
            curr=curr.next
            copyCurr=copyCurr.next
        return copyHead
    
# Approach - 3
# With O(1) Space

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
        if not head:
            return None

        curr=head

        while curr:
            newnode=Node(curr.val)
            newnode.next=curr.next
            curr.next=newnode
            curr=curr.next.next
        curr=head
        copyHead=head.next
        copyCurr=head.next

        while curr:
            if curr.random:
                copyCurr.random=curr.random.next
            curr=curr.next.next
            if copyCurr.next:
                copyCurr=copyCurr.next.next
        
        curr=head
        copyCurr=head.next
        while curr:
            curr.next=curr.next.next
            if copyCurr.next:
                copyCurr.next=copyCurr.next.next
            curr=curr.next
            copyCurr=copyCurr.next
        return copyHead