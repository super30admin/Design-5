#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldToNew = {None : None}
        curr = head
# this while loops solo purpose is to make a copy and store it in hashmap
        while curr:
            copy = ListNode(curr.val)
            oldToNew[curr] = copy
            curr = curr.next
# this while is to copy the pointers 
        curr = head
        while curr:
            copy = oldToNew[curr]
            copy.next = oldToNew[curr.next]
            copy.random = oldToNew[curr.random]
            curr = curr.next
        return oldToNew[head]