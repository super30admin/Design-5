#Copy list with random pointer

# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None: return head
        curr=head
        currCopy=None
        
        while(curr!=None):                              #first, copy the nodes and set the new node's value to the next of the old one
            currCopy = Node(curr.val)
            currCopy.next = curr.next
            curr.next=currCopy
            curr = currCopy.next
        curr=head
        
        while(curr!=None):                          # now set the random pointers of the node, we know that random point of the old node lies one behind the one of the current node
            currCopy = curr.next
            if (curr.random):
                currCopy.random = curr.random.next
            curr = currCopy.next
        curr=head
        
        copynode = curr.next
        currCopy=curr.next
        while(curr.next!=None):                        #now separate the old and new nodes so that you can just return the new one
            if(currCopy.next==None): break
            curr.next=curr.next.next
            currCopy.next = currCopy.next.next
            curr=curr.next
            currCopy=currCopy.next

        return copynode
            