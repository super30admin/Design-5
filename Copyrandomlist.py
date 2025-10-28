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
        # cretae a deep copy and have a hashmap savign the node and the key being the deep copy node, once we create this hashmap
        # we have created thr reference of all the required nodes , now lets parse again and add the next and random pointers 
        # tc : O(n), sc : o(n)
        # ran successfully on leetcode

        # base condtion
        if head == None:
            return None

        old_to_new = {None:None} # sc of O(n)

        curr = head

        while curr is not None: # tc O(n)
            if curr not in old_to_new:
                old_to_new[curr] = Node(curr.val)
            if curr.next not in old_to_new:
                old_to_new[curr.next] = Node(curr.next.val)
            if curr.random not in old_to_new:
                old_to_new[curr.random] = Node(curr.random.val)
            
            copy = old_to_new[curr]
            copy.next = old_to_new[curr.next]
            copy.random = old_to_new[curr.random]
            curr = curr.next

        return old_to_new[head]


            



