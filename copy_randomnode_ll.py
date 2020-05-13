"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to store the reference to deep copy for each node in a map
and copy the random and next from the original list
"""


"""
# Definition for a Node.
class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        def cloneNode(original):
            if not original:
                return None
            copy = copy_map.get(original)
            if not copy:
                copy = Node(original.val)
                copy_map[original] = copy
            return copy
        
        copy_map = {}
        curr = head

        #getting the clone of the head for the deepcopy
        copy_curr = cloneNode(head)
        while curr:
            #updating random reference using copy from the map
            copy_curr.random = cloneNode(curr.random)

            #updating next reference using copy from the map
            copy_curr.next = cloneNode(curr.next)

            #iterating original list
            curr = curr.next

            #iterating deepcopy list
            copy_curr = copy_curr.next
        return copy_map.get(head)