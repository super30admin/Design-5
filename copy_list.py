# tome: O(n)
# space : O(1) 
"""
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution(object):
    def copyRandomList(self, head):
        maph = {}
        ptr = head
        cnt = 0
        if not head:
            return None
        while ptr:
            new_node = Node(ptr.val)
            if cnt == 0:
                new_head = new_node
            maph[ptr] = new_node
            ptr = ptr.next
            cnt += 1

        ptr = head
        while ptr:
            new1 = maph[ptr]
            new2 = None
            if ptr.next:
                new2 = maph[ptr.next]
            rand1 = None
            if ptr.random:
                rand1 = maph[ptr.random]
            new1.next = new2
            if rand1:
                new1.random = rand1
            ptr = ptr.next
        return new_head
        