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

        #Method 1 - Iterate over original take care of .next links and iterate again and take care of .random links. - TC and SC -O(n)
        # if not head: return None

        # map={}
        # copyhead=Node(head.val)
        # map[head]=copyhead
        # curr=head
        # copycurr=copyhead

        # while curr.next: #taking care of .next and store stuff in map so it can be reused to get links whie doing .random links.
        #     copycurr.next=Node(curr.next.val)
        #     map[curr.next]=copycurr.next
        #     curr=curr.next
        #     copycurr=copycurr.next

        # curr=head
        # copycurr=copyhead

        # while curr: #handlling .random links
        #     if curr.random:
        #         copycurr.random=map[curr.random] #reuse stuff from .next map
        #     curr=curr.next
        #     copycurr=copycurr.next
        
        # return copyhead

        #Method 2 - Add new LL inbetween old LL nodes and then seperate them in the end.
        #TC - O(n) and SC - O(1)
        if not head: return None

        #adding new LL between old LL - handling .next links
        curr=head
        while curr:
            newNode=Node(curr.val)
            newNode.next=curr.next
            curr.next=newNode
            curr=curr.next.next

        #handling .random links
        curr=head
        copycurr=head.next #this is pointing new LL's 1st node
        copyhead=head.next  #this is pointing new LL's 1st node-> this is done cause in the end you'll need to return the head of new LL.
        print(copycurr.val)

        while curr:
            if curr.random:
                copycurr.random=curr.random.next
            else:
                copycurr.random=None
            curr=curr.next.next #distance between old nodes is 2
            if copycurr.next: #this is needed in the case of last new node, it'll be  poining to null, so below line can't be done. ->Edge case
                copycurr=copycurr.next.next #distance between new nodes is 2

        
        #splitting new and old LLs
        curr=head
        copycurr=head.next
        while curr:
            curr.next=curr.next.next #remove the .next to new LL
            if copycurr.next:#this is needed in the case of last new node, it'll be  poining to null, so below line can't be done. ->Edge case
                copycurr.next=copycurr.next.next #remove the .next to old LL

            curr=curr.next #normal iteration
            copycurr=copycurr.next  #normal iteration
        
        return copyhead




        
        
