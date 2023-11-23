# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# i will bedoing 2 passes- first pass to make copy of LL with next ptr. second pass to get the random pointers of LL. the hmap will keep mapping between old and new nodes
class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if(head is None):
            return None
        hmap={None:None}
        curr=head
        while(curr):
            copy=Node(curr.val)
            hmap[curr]=copy
            curr=curr.next
        curr=head
        while(curr):
            copy=hmap[curr]
            copy.next=hmap[curr.next]
            copy.random=hmap[curr.random]
            curr=curr.next
        return hmap[head]



