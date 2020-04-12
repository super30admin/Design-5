// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we need to do a deep copy on the given linked list which means that another copy of the same lined list should be formed.so we first clone the head and assigned another random pointer then we clone all the next and random pointers for every current node.In this way we do this for each and every node in the linked list till we reach the end.


# Time complexity --> o(n)
# space complexity --> o(n)
"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def __init__(self):
        self.d={}
    def clone(self,orgnode):
        if orgnode==None:
            return None
        if orgnode not in self.d:
            self.d[orgnode]=Node(orgnode.val)
        return self.d[orgnode]
        
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        cursor=head
        resultcursor=self.clone(head)
        while cursor!=None:
            resultcursor.random=self.clone(cursor.random)
            resultcursor.next=self.clone(cursor.next)
            resultcursor=resultcursor.next
            cursor=cursor.next
        return self.clone(head)
        
        