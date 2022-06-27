"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
#TC:O(N)
#SC:O(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        hm = dict()
        
        curr = Node(-1)
        dummy = curr
        curr1 = head
        while(curr1!=None):
            if(curr1 in hm):
                curr.next = hm[curr1]
            else:
                curr.next = Node(curr1.val)
            hm[curr1] = curr.next
            if(curr1.random!=None):
                if(curr1.random in hm):
                    curr.next.random = hm[curr1.random]
                else:
                    curr.next.random = Node(curr1.random.val)
                    hm[curr1.random] = curr.next.random
            curr=curr.next
            curr1= curr1.next
        # curr = dummy.next
        # curr1=head
        # while(curr!=None):
        #     if(curr1.random!=None):
        #         curr.random = hm[curr1.random]
        #     curr = curr.next
        #     curr1=curr1.next
        return dummy.next