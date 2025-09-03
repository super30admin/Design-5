
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

# class Solution:
#     def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
#         oldtonew = {}
#         if not head : return head
#         curr = head
#         copyhead = Node(curr.val)
#         copycurr = copyhead
#         oldtonew[curr] = copycurr
#         # 1st pass build the clones and put oldtonew in hashmap
#         while curr.next:
#             copynode = Node(curr.next.val)
#             copycurr.next = copynode
#             oldtonew[curr.next] = copynode
#             curr = curr.next
#             copycurr = copycurr.next

#         # 2nd pass
#         curr = head 
#         copycurr = copyhead
#         while curr:
#             if curr.random:
#                 copycurr.random = oldtonew.get(curr.random)
#             curr = curr.next
#             copycurr = copycurr.next
#         return copyhead

# class Solution:

#     def clone(self, curr, hm):
#         if not curr : return curr
#         if curr in hm:
#             return hm[curr]
#         hm[curr] = Node(curr.val)
#         return hm[curr]

#     def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
#         if not head : return head
#         curr  = head
#         hm = {}
#         copyhead = self.clone(curr, hm)
#         copycurr = copyhead
#         while curr:
#             copycurr.next = self.clone(curr.next, hm)
#             copycurr.random = self.clone(curr.random,hm)
#             curr = curr.next
#             copycurr = copycurr.next
#         return copyhead

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head : return None
        # create deep copy put copy next to curr
        curr = head
        copycurr = None
        while curr:
            copycurr = Node(curr.val)
            copycurr.next = curr.next
            curr.next = copycurr
            curr = curr.next.next
        # create random pointers
        curr = head
        copycurr = head.next
        while curr:
            if curr.random:
                copycurr.random = curr.random.next
            curr = curr.next.next
            if copycurr.next:
                copycurr = copycurr.next.next
        curr = head 
        copycurr = head.next
        copyhead = head.next
        while curr:
            curr.next = curr.next.next
            if copycurr.next:
                copycurr.next = copycurr.next.next
            curr = curr.next
            copycurr = copycurr.next
        return copyhead
        


                

        

        
            


        