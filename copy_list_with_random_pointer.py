"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#O(n)
#O(1)
class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return head
        #1)create new list and attach
        cur=head
        while cur:
            temp=cur.next
            cur.next=Node(cur.val)
            cur.next.next=temp
            cur=cur.next.next
        #2)set random pointers
        cur=head
        while cur:
            if cur.random:
                cur.next.random=cur.random.next
            cur=cur.next.next
        #3)break/split the 2lists
        cur=head
        newList=cur.next
        newHead=newList
        while cur:
            cur.next=cur.next.next
            if newList.next:
                newList.next=newList.next.next
            cur=cur.next
            newList=newList.next
        return newHead
                
            
            
        
        