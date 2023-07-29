#Time complexity is O(n)
#Space complexity is O(1)
#No issues faced while coding
#Code ran successfully on leetcode

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
        """
        :type head: Node
        :rtype: Node
        """
        if(head==None):
            return
        #Creating deep copy
        #pointing curr to the head 
        curr=head
        #Iterating through the linked list and adding ddep copy nodes after each node
        while(curr!=None):
            #Creating a deep copy nide
            newNode=Node(curr.val)
            #inserting between the original nodes
            newNode.next=curr.next
            curr.next=newNode
            #Moving the current pointer to the next node
            curr=curr.next.next
        #Assigning random pointer
        #initializing the required variables
        curr=head
        copycurr=head.next
        copyhead=head.next
        while(curr!=None):
            #Assigning the random reference fot the deep copy nodes
            if(curr.random!=None):
                copycurr.random=curr.random.next
            #moving the curr reference to the next node
            curr=curr.next.next
            #Moving the copycurr reference to the next depp copy node
            #Here we are handling the deep copy condition also
            if(copycurr.next!=None):
                copycurr=copycurr.next.next
        #Split the list finally
        curr=head
        copycurr=head.next
        #here we are going to seperate the original copy and deep copy lists seperately
        while(curr!=None):
            curr.next=curr.next.next
            if(copycurr.next!=None):
                copycurr.next=copycurr.next.next
            curr=curr.next
            copycurr=copycurr.next
        #Finally wea are returning the deep copy list head reference
        return copyhead


