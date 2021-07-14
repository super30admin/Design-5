"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# time : 0(N)
#space : 0(N)
class Solution(object):
    def copyRandomList(self, head):
        if head is None:
            return None
        clone_head = Node(head.val)
        curr = head
        temp = clone_head
        mymap = {}
        mymap[curr] = clone_head
        
        while curr.next is not None:
            temp.next = Node(curr.next.val)
            mymap[curr.next] = temp.next 
            curr = curr.next
            temp= temp.next
            
        curr = head
        temp1 = clone_head
        while curr is not None:
            if curr.random is None:
                temp1.random = None
            else:
                
                temp1.random = mymap[curr.random]
            curr = curr.next
            temp1 = temp1.next
            
        return clone_head
            
            
        """
        :type head: Node
        :rtype: Node
        """
        