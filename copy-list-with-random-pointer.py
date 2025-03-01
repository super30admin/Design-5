# tc O(n), sc O(1).
if not head:
    return None

# attach the two list
curr = head
while curr:
    copy = Node(curr.val)
    nxt = curr.next
    curr.next = copy
    copy.next = nxt
    curr = nxt

# update random pointers here
curr = head
while curr:
    curr.next.random = curr.random.next if curr.random else None
    curr = curr.next.next

# detach two lists
curr = head
copyHead = head.next

while curr:
    nxt = curr.next
    curr.next = nxt.next
    nxt.next = nxt.next.next if nxt.next else None

    curr = curr.next

return copyHead