#TC - O(N)
#SC - O(N)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        oldToNew = {None:None}
        curr = head
        while curr:
            oldToNew[curr] = Node(curr.val)
            curr = curr.next
        curr = head
        while curr:
            oldToNew[curr].next = oldToNew[curr.next]
            oldToNew[curr].random = oldToNew[curr.random]
            curr = curr.next
        return oldToNew[head]

            

