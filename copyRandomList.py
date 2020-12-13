"""
TC =O(3N) asympotitically O(N)
SC=O(1)

"""

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
        if head is None:
            return None
        
        """
        Step1 : create a deep copy node and put them next to adjacent node 1->1'->2->2'
        """
        curr=head
        while curr:
            currCopy= Node(curr.val)
            currCopy.next=curr.next
            curr.next=currCopy
            curr=curr.next.next
        
        """
        step2: traverse and populate the random ptr for deep copy list
        
        """
        curr=head
        while curr:
            if curr.random is not None:
                curr.next.random=curr.random.next
            curr=curr.next.next
        
        """
        step 3: split the list to normal and deep copy list
        
        """
        curr=head
        copyHead=curr.next
        currCopy=copyHead
        while curr:
            curr.next=curr.next.next
            if(currCopy.next):#not last node
                currCopy.next=currCopy.next.next
            curr=curr.next
            currCopy=currCopy.next
        
        return copyHead
            
                