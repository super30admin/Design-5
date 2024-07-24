# Time Complexity  :
# O(n), Linked List traversal

# Space Complexity  :  
# O(n), Creating new node for each existing node in the Linked List


# Approach:
# LinkedList traversal and manipulation.


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
        # =============> Approach: TC = O(n), SC = O(1) <==============#
        if not head:
            return
        
        # 1. Create a copy of node and place the copyNode next to original curr node
        curr = head
        while(curr):
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next

        # 2. Set the random pointers of copied nodes
        curr = head
        while(curr):
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        # 3. Break the combined linked lists into two 
        curr = head
        copyCurr = curr.next
        copyHead = copyCurr
        while(curr):
            curr.next = copyCurr.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
            
        return copyHead