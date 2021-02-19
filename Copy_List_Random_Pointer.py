# Time : O(N)
# Space: O(1)
"""
Approach: 
3 - step algorithm

1. Create a deep copy nodes next to my original nodes
2. Create the random pointers
3. Split the lists


"""
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
