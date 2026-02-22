#------ Solution 1 : Hashmap - Two pass---------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: return None
        hashmap = {}
        curr = head
        copycurr = Node(curr.val)
        newhead = copycurr
        hashmap[curr] = copycurr
        while curr.next:
            newnode = Node(curr.next.val)
            hashmap[curr.next] = newnode
            copycurr.next = newnode
            
            curr = curr.next
            copycurr = copycurr.next
        
        curr = head
        while curr:
            if curr.random:
                cc = hashmap[curr]
                cc.random = hashmap[curr.random]
            curr = curr.next
        
        return newhead

#------ Solution 2 : No hashmaps---------
''' Time Complexity : O(n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: return None
        curr = head
        #create deep copy
        while curr:
            newnode = Node(curr.val)
            newnode.next = curr.next
            curr.next = newnode

            curr = curr.next.next
        #create random pointers
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        #seperate the list
        curr = head
        copycurr = curr.next
        newhead = curr.next
        while curr:
            curr.next = copycurr.next
            if copycurr.next:
                copycurr.next = copycurr.next.next

            curr = curr.next
            copycurr = copycurr.next
        
        return newhead