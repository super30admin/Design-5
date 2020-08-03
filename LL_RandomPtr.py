"""
// Time Complexity : o(n)
// Space Complexity : o(n), dictionary
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
from collections import defaultdict
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head :
            return None
        d = defaultdict(Node) #for mapping original list to copy
        copy = Node(head.val) #creating copy of the head
        
        cur = head #cur ptr to iterate
        
        d[head] = copy #mapping of head
        
        while cur:
            
            if cur.random: #if cur has a random ptr
                if cur.random not in d: #if copy hasnt been created yet, create node and add to dictionary
                    d[cur.random] = Node(cur.random.val)
                    
                copy.random = d[cur.random] #create copy of node
                           
            if cur.next:
                if cur.next not in d: #similarly for next pointer
                    d[cur.next] = Node(cur.next.val)
                    
                copy.next = d[cur.next]
                
            cur = cur.next #increment
            copy = copy.next
             
        return d[head]