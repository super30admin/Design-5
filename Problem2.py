## Problem 2: Copy List with Random Pointer

# https://leetcode.com/problems/copy-list-with-random-pointer/
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
        # =========================================================================
        # SOLUTION 1: Hash Map / Recursion with Memoization
        # 
        # LOGIC:
        # 1. Use a hash map `d` to map original nodes to their cloned copies.
        # 2. `copyNode(node)` recursively creates a copy of a node if it hasn't
        #    been created yet, or returns the existing copy from `d`.
        # 3. Iterate through the linked list, copying and wiring up the `next` 
        #    and `random` pointers for each node.
        #
        # COMPLEXITY:
        # - Time Complexity:  O(N) — Each node in the list is visited a constant
        #                     number of times.
        # - Space Complexity: O(N) — Hash map `d` stores up to N node mappings.
        # =========================================================================
        # if not head:
        #     return None
        #
        # d = {}
        #
        # def copyNode(node):
        #     if not node:
        #         return None
        #     if node in d:
        #         return d[node]
        #     
        #     copy = Node(node.val)
        #     d[node] = copy
        #     return copy
        #
        # curr = head
        # copyHead = copyNode(head)
        # copyCurr = copyHead
        #
        # while curr:
        #     copyCurr.next = copyNode(curr.next)
        #     copyCurr.random = copyNode(curr.random)
        #     curr = curr.next
        #     copyCurr = copyCurr.next
        #
        # return copyHead

        # =========================================================================
        # SOLUTION 2: In-Place Interleaving Nodes (O(1) Auxiliary Space)
        # 
        # LOGIC:
        # Step 1: Interleave cloned nodes directly after original nodes.
        #         Original: A -> B -> C
        #         After Step 1: A -> A' -> B -> B' -> C -> C'
        #
        # Step 2: Set the `random` pointers for the cloned nodes.
        #         If `curr.random` exists, then `curr.next.random` (which is A') 
        #         points to `curr.random.next` (the cloned copy of A's random node).
        #
        # Step 3: Separate/unweave the interleaved list back into the original 
        #         list and the cloned list.
        #
        # COMPLEXITY:
        # - Time Complexity:  O(N) — Three separate linear traversals over the list.
        # - Space Complexity: O(1) — No extra data structures (hash map) used.
        # =========================================================================
        if not head:
            return None

        curr = head

        # Step 1: Create copy nodes for each node and place it directly after original
        while curr:
            copyCurr = Node(curr.val)
            copyCurr.next = curr.next
            curr.next = copyCurr
            curr = curr.next.next

        # Step 2: Set the random pointers for the copied nodes
        curr = head
        while curr:
            copyCurr = curr.next
            if curr.random:
                copyCurr.random = curr.random.next
            curr = curr.next.next

        # Step 3: Unweave the interleaved list to restore original and extract copied list
        curr = head
        copyHead = head.next
        copyCurr = copyHead

        while curr:
            curr.next = curr.next.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next

            curr = curr.next
            copyCurr = copyCurr.next

        return copyHead