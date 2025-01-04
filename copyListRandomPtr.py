# Time:O(n); 2 pass logic
# Space:O(n) for all original value deep copies in hmap
# Leetcode: Yes
# Issues:self.hmap[node] = Node(node.val)  store the Node as LinkedList not just value

class Solution:
    def __init__(self):
        self.hmap = {}

    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        curr = head
        #pass 1 copy the original pointers (n)
        while curr:
            self.clone(curr) 
            curr = curr.next
        #pass 2 add next and random to deepcopy
        curr = head                                     # reset
        while curr:
            copyCurr = self.hmap[curr]
            copyCurr.next = self.clone(curr.next)
            copyCurr.random = self.clone(curr.random)
            curr = curr.next

        return self.hmap[head]

    def clone(self, node):
        if not node: return 

        if node not in self.hmap:
            self.hmap[node] = Node(node.val)                # LL here not just val

        return self.hmap[node]
