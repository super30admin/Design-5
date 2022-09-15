
# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

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
        if head == None: return head
        curr=head
        currCopy=None

        while(curr!=None):                              
            currCopy = Node(curr.val)
            currCopy.next = curr.next
            curr.next=currCopy
            curr = currCopy.next
        curr=head

        while(curr!=None):                         
            currCopy = curr.next
            if (curr.random):
                currCopy.random = curr.random.next
            curr = currCopy.next
        curr=head

        copynode = curr.next
        currCopy=curr.next
        while(curr.next!=None):                     
            if(currCopy.next==None): break
            curr.next=curr.next.next
            currCopy.next = currCopy.next.next
            curr=curr.next
            currCopy=currCopy.next

        return copynode