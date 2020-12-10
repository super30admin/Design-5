#Time: O(N)
#space: O(1)

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':

        if head is None:
            return

        l1=head
        h={}

        while(l1):
            l2 = Node(l1.val,None,None)
            h[l1]=l2
            l1=l1.next

        cur=head
        while(cur):
            l2 = h[cur]
            l2.next = h.get(cur.next,None)
            l2.random = h.get(cur.random,None)
            cur=cur.next

        return h[head]
