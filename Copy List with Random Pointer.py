#  Time Complexity : O(N)   
#  Space Complexity : O(1)  
#  Did this code successfully run on Leetcode : Yes
#  Three line explanation of solution in plain english: We create a deep copy of the current node and place it next to the current node. We point the random of the node copy to deep copy of the random of the current node. Then we disassociate both the lists to create two seperate lists. We return the head of the deepcopy list. 

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        # TC: O(n) SC: O(1)
        if head is None:
            return None
        
        curr = head

        while curr is not None:  #Create Deep Copies
            copyCurr = Node(curr.val)
            copyCurr.next = curr.next
            curr.next = copyCurr

            curr = curr.next.next
        
        curr = head
        #Take care of random pointers

        while curr is not None:
            if curr.random is not None:
                curr.next.random = curr.random.next
            
            curr = curr.next.next
        
        curr = head
        copyCurr = curr.next
        copyHead = copyCurr

        while curr is not None:
            curr.next = curr.next.next
            if copyCurr.next is not None:
                copyCurr.next = copyCurr.next.next
            
            curr = curr.next
            copyCurr = copyCurr.next
        
        return copyHead