#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        if head == None:
            return None
        curr = head
        while curr:
            newnode = Node(curr.val)
            newnode.next = curr.next
            curr.next = newnode
            curr = curr.next.next
            
        curr = head
        
        while curr:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        curr = head
        deepcopy = head.next
        copycurr = deepcopy
        
        while curr.next.next:
            curr.next = curr.next.next
            deepcopy.next = deepcopy.next.next
            curr = curr.next
            deepcopy  = deepcopy.next
            
            
        return copycurr
            
        
            
            