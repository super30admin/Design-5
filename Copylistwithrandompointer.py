# Time Complexity : O(N).
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to create a map with new node references and clone using it.

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if(head == None): 
            return None
        self.mp={}
        copyhead = Node(head.val)
        self.mp[head]=copyhead
        curr,copycurr= head,copyhead
        while(curr != None):
            copycurr.next=self.clone(curr.next)
            copycurr.random=self.clone(curr.random)
            curr=curr.next
            copycurr=copycurr.next
        return copyhead

    def clone(self,node):
        if node==None:
            return None
        
        if node not in self.mp:
            newnode=Node(node.val)
            self.mp[node]=newnode
        
        return self.mp[node]