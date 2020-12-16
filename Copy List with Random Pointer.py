
# Definition for a Node.
class Node:
    def __init__(self, x, next=None, random=None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        headcopy=head
        while(head):
            tmp=head.next
            head.next=Node(head.val)
            head.next.next=tmp
            head=head.next.next
        head=headcopy
        while(head):
            if head.random:
                head.next.random=head.random.next
            head=head.next.next
        head=headcopy
        head=head.next
        while(head and head.next):
            head.next=head.next.next
            head=head.next
        return headcopy.next
        

sol=Solution()
Node7=Node(7)
Node11=Node(11)
Node10=Node(10)
Node1=Node(1)
Node13=Node(13)
print(Node7)
print(Node13)
print(Node11)
print(Node10)
print(Node1)
Node7.next=Node13
Node13.next=Node11
Node13.random=Node7
Node11.next=Node10
Node11.random=Node1
Node10.next=Node1

sol=Solution()
head=sol.copyRandomList(Node7)
while(head):
    print(head)
    head=head.next



