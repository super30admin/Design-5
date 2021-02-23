#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    hmap=None
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if(head==None):
            return head
        
        curr=head
        while(curr!=None):
            currCopy=Node(curr.val)
            currCopy.next=curr.next
            curr.next=currCopy
            curr=currCopy.next
        
        curr=head
        while(curr!=None):
            if(curr.random!=None):
                curr.next.random=curr.random.next
            curr=curr.next.next
    
        curr=head
        currCopy=curr.next
        currHead=currCopy

        while(curr!=None):
            curr.next=curr.next.next
            if(currCopy.next!=None):
                currCopy.next=currCopy.next.next
            curr=curr.next
            currCopy=currCopy.next
        return currHead
    
    
#         currCopy=Node(head.val)
#         copyHead=currCopy
#         curr=head
#         self.hmap={}
#         self.hmap[head]=currCopy
#         while(curr!=None):
#             currCopy.next=self.copy(curr.next)
#             currCopy.random=self.copy(curr.random)
#             curr=curr.next
#             currCopy=currCopy.next
        
#         return copyHead
    
#     def copy(self,node):
#         if(node):
#             if(node not in self.hmap):
#                 self.hmap[node]=Node(node.val)
#             return self.hmap[node]
#         return None
        
        
        