# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We do 3 passes:
# 1: Copy each element in the list and add it as the next element to the original element
# 2: Assign the random pointer to the copy of the original random
# 3: Separate both the list.

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return None
        curr = head
        while curr:
            c_dash = Node(curr.val, curr.next, curr.random)
            curr.next = c_dash
            curr = c_dash.next
            
        curr = head.next
        while curr:
            if curr.random:
                curr.random = curr.random.next
            if curr.next:
                curr = curr.next.next
            else:
                curr = None
                
        curr = head
        c_dash = head.next
        dash_head = c_dash
        
        while c_dash:
            curr.next = c_dash.next
            curr = curr.next
            if curr:
                c_dash.next = curr.next
                c_dash = c_dash.next
            else:
                c_dash = None
                
        return dash_head
