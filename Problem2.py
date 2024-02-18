'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Using a hashmap here where the key is the primary node and the value holds the deep copy. We traverse thru the list 2 times, first time we
create the nodes and second time we draw the random connections

'''


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
        ref = {None:None}

        cur = head
        while cur:
            copy = Node(cur.val)
            ref[cur] = copy
            cur = cur.next

        cur = head
        while cur:
            copy = ref[cur]
            copy.next = ref[cur.next]
            copy.random = ref[cur.random]
            cur = cur.next

        return ref[head]


