# TC: O(N)
# SC: O(N)
# Yes, It ran on Leetcode
# No problems

# Definition for a Node.
class Node(object):
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return
        
        node = head
        prev = None
        while node:                         # Insert new node in between
            new = Node(node.val,None,None)
            forw = node.next
            node.next = new
            new.next = forw
            node = forw
       
        prev = head
        curr = head.next
        new_head = head.next
        while prev and curr:
            if curr.next:
                nprev = curr.next
                ncurr = curr.next.next
            else:
                nprev = None
                ncurr = None
                
            if prev.random:
                curr.random = prev.random.next
            prev = nprev
            curr = ncurr
            
        prev = head
        curr = head.next
        while prev and curr:
            if curr.next:
                nprev, ncurr = curr.next, curr.next.next
            else:
                nprev, ncurr = None, None
            prev.next = nprev
            curr.next = ncurr
            prev = nprev
            curr = ncurr
        return new_head