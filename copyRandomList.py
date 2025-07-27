# TimeComplexity:O(3n)
# SpaceComplexity:O(1)
# Approach:BF would be create a new list for each node copy random pointer with lenght
# Optimal would be for each node make dummy node next to it with same val then while assigning random head2.next.random=ran.next
# After that delete orginal nodes





"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
"""
for each node make adummy ode next to it add randompointer then dele orginla pointers
"""
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        dummy=Node(-1)
        dummy.next=head
        head2=head
        head3=head
        if head==None :return head


        while(head ):
            #head.val
            temp=head.next
            head.next=Node(head.val)
            head.next.next=temp
            
            
            head=head.next.next
        
        while(head2 and head2.next):

            ran=head2.random
            # if  ran!=None:
            #     print(ran.val)
            if ran==None:
                head2.next.random=None
            else:

                head2.next.random=ran.next
            head2=head2.next.next
        mainh=head3.next
        mainh2=Node(-1)
        mainh2.next=mainh

        while(mainh and  mainh.next):
            mainh.next= mainh.next.next
            mainh=mainh.next
            # print(mainh.next.val)
        

        

        return mainh2.next
