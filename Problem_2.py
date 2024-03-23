'''
Time Complexity - O(n). 3n to be exact, once iterate all nodes to create the duplicate, second iteration to populate random pointers, 3rd to separate clone list from original list. 
Space Complexity - O(n) for Brute force, O(1) for optimized

works on Leetcode
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

        #BRUTE FORCE
        # hashMap = {}
        # curr = head
        ##Create the duplicate nodes and store in HashMap 
        # while curr != None:
        #     if curr not in hashMap:
        #         hashMap[curr] = Node(curr.val)
        #     curr = curr.next
        
        ##Populate the random pointers and also create the copy list
        # cpyHead = hashMap.get(head)
        # curr = head
        # currCpy = cpyHead
        # while curr != None:
        #     if curr.random != None:
        #         currCpy.random = hashMap.get(curr.random)
        #     currCpy.next = hashMap.get(curr.next)
        #     curr = curr.next
        #     currCpy = currCpy.next
        # return cpyHead

        #OPTIMIZED APPROACH


        if head == None:
            return None
        curr = head
        #create the new node, make the duplicate node next of the original
        while curr!= None:
            cpyNode = Node(curr.val)
            cpyNode.next = curr.next
            curr.next = cpyNode
            curr = curr.next.next
        
        curr = head
        #populate the random pointers in the duplicate nodes
        while curr!= None:
            print(f"{curr.next.val}")
            if curr.random != None:
                curr.next.random = curr.random.next
            if curr.next!=None:
                curr = curr.next.next
        
        cpyHead = head.next
        currCpy = cpyHead
        curr = head

        #separate the duplicate list from the original list, make the original list back to same as input List
        while curr!=None:
            # print(f"{curr.val} {currCpy.val}")
            
            
            curr.next= curr.next.next
            if currCpy.next!= None:
                currCpy.next = currCpy.next.next
            curr = curr.next
            currCpy = currCpy.next
        return cpyHead

        