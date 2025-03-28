# Optimized 3 pass approach -
# TC - O(n)
# SC - O(1)

"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None: return None

        curr = head

        # Step 1: set copy nodes next to original nodes in original LL
        while curr is not None:
            # create new copyCurrNode
            copyCurr = Node(curr.val)
            copyCurr.next = curr.next
            curr.next = copyCurr
            # at this point the LL will become - 1->1'->2
            # move curr (to node 2 based on above eg.)
            curr = curr.next.next

        # Now the LL is 1->1'->2->2'->3->3'->4->4'->5->5'
        # Step 2: assign random pointers
        # rewind curr to head
        curr = head
        while curr is not None:
            if curr.random is not None:
                curr.next.random = curr.random.next
            curr = curr.next.next

        # Step 3: Split LL
        # rewind curr to head
        curr = head
        # copyHead and copyCurr are same. We create a new variable(node) copyHead since
        # we want to return copyHead in the end
        copyHead = curr.next
        copyCurr = curr.next
        while curr is not None:
            # 1 will point to 2 i.e. 1-- 1'->2
            #                           |    ^
            #                           -----|
            curr.next = copyCurr.next
            if copyCurr.next is None: break  # i.e. when we reach end of the list
            copyCurr.next = copyCurr.next.next
            # move curr and copyCurr
            curr = curr.next
            copyCurr = copyCurr.next

        return copyHead