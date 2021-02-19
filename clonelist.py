"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    
    """
    Description: Construct a deep copy of list with random pointers
    
    Time Complexity: O(n) for both
    Space Complexity: O(n) for 2 pass solution and O(1) for 3 pass solution
    
    Approach: 2 pass solution
    - Create a hash table with node as key and it's value as value (first - pass)
    - Use the hash table (keeps all copies of each node) to find next and random pointers for each (second - pass)
    
    Approach: 3 pass solution:
    - first pass: rewire the next node for every node to copied node
    - second pass: rewire the random pointers
    - third pass: restore the original linked list
    """
    
    from collections import defaultdict
    
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        if head == None: return None
        
        list_map = defaultdict(lambda: Node(0))
        
        temp = head
        while temp:
            list_map[temp] = Node(temp.val)
            temp = temp.next
        
        for node in list_map:
            if node.next:
                list_map[node].next = list_map[node.next]
            if node.random:
                list_map[node].random = list_map[node.random]
        
        return list_map[head]
        
        
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        if head == None: return None
  
        curr = head
        while curr:
            tnext = curr.next
            copy = Node(curr.val)
            curr.next = copy
            copy.next =  tnext
            curr = tnext
            
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
                
        original = head
        copy = head.next
        clone = copy
        
        while original:
            original.next = copy.next
            original = original.next
            if copy.next:
                copy.next= original.next
                copy = copy.next
        
        return clone     
      
