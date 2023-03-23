"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

#All TC passed on leetcode

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':

         #Time complexity - O(3n) - 3 pass as we create new nodes and connect new node to its random pointers and finally split the L.L. to point to their respective next node.
        #Space complexity - O(1) - 
        if not head:
            return head

        cur = head

        #create deep copy of cur and place it beside cur
        while cur:
            node = Node(cur.val)
            node.next = cur.next
            cur.next = node
            cur = node.next
        
        #now point the deep copy node to its random
        cur = head
        while cur:
            if cur.random != None:
                cur.next.random = cur.random.next
            cur = cur.next.next

        #now split the 2 lists by pointing them to their respective next pointers 
        cur = head
        copyHead = head.next
        curCopy = head.next
        while cur:
            cur.next = cur.next.next
            if curCopy.next:
                curCopy.next = curCopy.next.next
            cur = cur.next
            curCopy = curCopy.next

        return copyHead
        
        


#------------------------------------OR-----------------------------


        
        #Time complexity - O(n) - 1 pass as we create new nodes and connect new node to its next and random pointer in the same pass.
        #Space complexity - O(n) - dictionary holding nodes
        dict = {None:None}
        cur = head

        while cur:

            #create node if its not created already
            if cur not in dict:
                node = Node(cur.val)
                dict[cur] = node

            node = dict[cur]

            #fetch the cur node's next and random pointers
            nodeNext = cur.next
            nodeRandom = cur.random

            #create next node if its not created already
            if nodeNext not in dict:
                nodeNextNew = Node(nodeNext.val)
                dict[nodeNext] = nodeNextNew

             #create random node if its not created already
            if nodeRandom not in dict:
                nodeRandomNew = Node(nodeRandom.val)
                dict[nodeRandom] = nodeRandomNew

            #point the cur node's new copy to its next and random pointers
            node.next = dict[nodeNext]
            node.random = dict[nodeRandom] 
                
            cur = cur.next

        return dict[head]

#------------------------------------OR-----------------------------

        #Time complexity - O(2n) - 2 pass as we create new nodes and then traverse to connect new nodes to their next and random pointer.
        #Space complexity - O(n) - dictionary holding nodes
        dict = {None:None}

        cur = head
        while cur:
            node = Node(cur.val)
            dict[cur] = node
            cur = cur.next

        cur = head
        while cur:
            node = dict[cur]
            node.next = dict[cur.next]
            node.random = dict[cur.random]
            cur = cur.next

        return dict[head]
        