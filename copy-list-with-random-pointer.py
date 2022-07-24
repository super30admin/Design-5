"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    # def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
    #     if head==None: return None
    #     hmap={}
    #     curr=head
    #     def clone(node):
    #         if node==None: return None
    #         if node not in hmap:
    #             hmap[node]=Node(node.val)  
    #         return hmap[node]
    #     currClone=clone(head)  
    #     while curr!=None:
    #         currClone.next=clone(curr.next)
    #         if curr.random!=None:
    #             currClone.random=clone(curr.random)
    #         curr=curr.next
    #         currClone=currClone.next
    #     return hmap[head]
# Time Complexity: O(n)
# Space Complexity: O(1)
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head==None: return head
        curr=head
        while curr!=None:
            new_node=Node(curr.val)
            new_node.next=curr.next
            curr.next=new_node
            curr=curr.next.next
        curr=head
        while curr!=None:
            if curr.random!=None:   
                curr.next.random=curr.random.next
            curr=curr.next.next
        curr=head
        currClone=head.next
        result=currClone
        while curr!=None:
            curr.next=curr.next.next
            if currClone.next!=None:
                currClone.next=currClone.next.next
            curr=curr.next
            currClone=currClone.next
        return result
            