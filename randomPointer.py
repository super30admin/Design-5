#Time Complexity: O(N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return head
        # create a deep copy nodes next to my original nodes
        curr = head
        while curr != None:
            currCopy = Node(curr.val)
            currCopy.next = curr.next
            curr.next = currCopy
            curr = curr.next.next
            
        # create the random pointers
        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        # Split the lists
        curr = head
        copyHead = head.next # since I will be moving curr and currCopy so I am making copyHead for reference
        currCopy = head.next  # c'
        while curr != None:
            curr.next = curr.next.next
            if currCopy.next != None:
                currCopy.next = currCopy.next.next
            # moving my c and c' pointer
            curr = curr.next 
            currCopy = currCopy.next
            
        return copyHead