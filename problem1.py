#Time O(n), space O(1)
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        if head is None:
            return None
#Creating new list node        
        cur=head
        while cur:
            newnode = Node(cur.val,None,None)
            newnode.next=cur.next
            cur.next=newnode
            cur=newnode.next
   
#Copying random pointers
        p=head
        while p:
            if p.random:
                p.next.random=p.random.next
            else: 
                None
            p=p.next.next
 
#Assigning next pointers
        p=head
        q=head.next
        newnode=q
        while p:
            p.next=p.next.next
            if q.next:
                q.next=q.next.next
            p=p.next
            q=q.next
            
            
        return newnode
            
