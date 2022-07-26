#TC: O(n)
#SC: O(1)
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if head==None: return None
        curr=head
        while(curr!=None):
            copyCurr=Node(curr.val)
            copyCurr.next=curr.next
            curr.next=copyCurr
            curr=curr.next.next
        curr=head
        while(curr!=None):
            if curr.random!=None:
                curr.next.random=curr.random.next
            curr=curr.next.next
        curr=head
        copyCurr=head.next
        re=head.next
        while(curr!=None):
            curr.next=copyCurr.next
            if copyCurr.next!=None:
                copyCurr.next=curr.next.next
            curr=curr.next
            copyCurr=copyCurr.next
        return re