# As taught in class creating deep copy of node putting them adjacent to original node, create random pointer mapping and split lists
# Time Complexity: O(n)
# Space Complexity: O(n) 
def copyRandomList(self, head: 'Node') -> 'Node':
    if head is None:
        return 
    curr = head
    while curr is not None:
        currCopy = Node(curr.val)
        temp = curr.next
        curr.next = currCopy
        currCopy.next = temp
        curr = curr.next.next
    curr = head
    while curr is not None:
        if curr.random is not None:
            curr.next.random = curr.random.next
        curr=curr.next.next
    curr = head
    copyHead = curr.next
    currCopy = copyHead
    while curr is not None:
        curr.next = curr.next.next
        if currCopy.next is not None:
            currCopy.next = currCopy.next.next
        curr = curr.next
        currCopy = currCopy.next
    return copyHead