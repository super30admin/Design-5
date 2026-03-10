# Time Complexity : O(n), n = number of nodes in the list
# Space Complexity : O(n), for hash map mapping original nodes to copied nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Traverse the original list and create a copy of each node.
# 2. Use a hashmap to map original nodes to their copied nodes.
# 3. Update the next and random pointers of copied nodes using the hashmap.
# 4. Return the head of the copied list.

# Definition for a Node.
# class Node:
#     def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
#         self.val = int(x)
#         self.next = next
#         self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        # Step 1: Create copies of all nodes
        old_to_new = {}
        curr = head
        while curr:
            old_to_new[curr] = Node(curr.val)
            curr = curr.next

        # Step 2: Assign next and random pointers
        curr = head
        while curr:
            old_to_new[curr].next = old_to_new.get(curr.next)
            old_to_new[curr].random = old_to_new.get(curr.random)
            curr = curr.next

        return old_to_new[head]