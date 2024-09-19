# Time complexity - O(n)
# Space complexity - O(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: return head
        cur = head
        # copy each node in one pass and link new nodes next to each other
        while cur:
            copy_cur = Node(cur.val)
            copy_cur.next = cur.next
            cur.next = copy_cur
            cur = cur.next.next

        # initialize to iterate and connect the next pointers
        cur = head
        copy_head = head.next
        copy_cur = copy_head
        while cur:
            if cur.random:
                copy_cur.random = cur.random.next
            cur = cur.next.next
            if copy_cur.next:
                copy_cur = copy_cur.next.next

        # initialize and iterate to split the nodes
        cur = head
        copy_cur = copy_head = head.next
        while cur:
            cur.next = cur.next.next
            if copy_cur.next:
                copy_cur.next = copy_cur.next.next
            cur = cur.next
            copy_cur = copy_cur.next
        return copy_head

    

# Time and Space complexit - O(n)

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
	 # node_mapping = {}

        # orig_head = head
        # new_head = prev = Node(-1)

        # while orig_head:
        #     n = Node(orig_head.val)
        #     node_mapping[orig_head] = n
        #     prev.next = n
        #     prev = n
        #     orig_head = orig_head.next

        # prev = new_head.next
        # while head:
        #     if head.random:
        #         prev.random = node_mapping[head.random]
        #     prev = prev.next
        #     head = head.next

        # return new_head.next


















