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
        #Approach: Adjacent deep copies
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        if not head:
            return head
        
        #Step 1: Creating adjacent copies
        curr = head
        while curr:
            curr.next = Node(curr.val, next = curr.next)
            curr = curr.next.next
        
        #Step 2: Creating 'random' connections
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        #Step 3: Splitting copy from the original
        curr = head
        newHead = newCurr = head.next
        while curr:
            curr.next = curr.next.next
            if curr.next:
                newCurr.next = newCurr.next.next
            
            curr = curr.next
            newCurr = newCurr.next
        
        return newHead
        
    
    #Solution 2
    """
    def copyRandomList(self, head: 'Node') -> 'Node':
        #Approach: HashMap
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        
        if not head:
            return head
        
        nodeMap = {}
        
        curr = head
        newHead = newCurr = nodeMap[curr] = Node(curr.val)
        while curr:
            if curr.next and curr.next not in nodeMap:
                nodeMap[curr.next] = Node(curr.next.val)
            if curr.random and curr.random not in nodeMap:
                nodeMap[curr.random] = Node(curr.random.val)
            
            newCurr.next = nodeMap.get(curr.next, None)
            newCurr.random = nodeMap.get(curr.random, None)
            
            curr = curr.next
            newCurr = newCurr.next
            
        return newHead
    """