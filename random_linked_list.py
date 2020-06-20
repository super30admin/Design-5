#Time Complexity: O(n)
#Space Complexity: O(n)
'''
We keep a hashmap with the original node as key and the copy as value.
we iterate through the original, while creating a copy for its next node
and random node. Everytime we check if it is present in the hashmap before copying
(no need to create another copy). We return hash[head] to get the head of the copy.
'''
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        def copy(curr):
            
            if curr.next:
                if curr.next not in copies:
                    copies[curr.next]=Node(curr.next.val)
                copies[curr].next=copies[curr.next]
            if curr.random:
                if curr.random not in copies:
                    copies[curr.random]=Node(curr.random.val)
                copies[curr].random=copies[curr.random]

        cop=Node(head.val)
        copies={head:cop}
        curr=head
        while curr:
            copy(curr)
            curr=curr.next
        return copies[head]
