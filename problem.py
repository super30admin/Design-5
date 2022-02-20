#Time Complexity O(N)
#Space Complexity O(1)

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        if head == None:
            return None
        curr = head
        while curr != None:
            newNode = Node(curr.val)
            newNode.next = curr.next
            curr.next = newNode
            curr = curr.next.next
        curr = head
        while curr!= None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
        curr = head
        copyHead = head.next
        copyCurr = copyHead
        while(curr != None):
            curr.next = curr.next.next
            if copyCurr.next != None:
                copyCurr.next = copyCurr.next.next
            curr = curr.next
            copyCurr = copyCurr.next
        return copyHead
