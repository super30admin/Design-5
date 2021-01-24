"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

"""
Approach: Using hashmap

Here we will use a hashmap to keep account of the nodes that has been created. If a node has been created while assigning it to random pointer of a node or to next pointer of the node, then we will store that node in the hashmap. 

So every time before assigning any node to next or random pointer of a current node we will check in the hashmap if the node is already created or not. 

TC: O(n)
SC: O(n)
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        self.hmap = {}
        
        if head == None:
            return head
        
        curr = head
        newList = self.clone(head)
        newHead = newList
        
        while curr:
            newList.next = self.clone(curr.next)
            newList.random = self.clone(curr.random)
            curr = curr.next
            newList = newList.next
            
        return newHead
        
    def clone(self, head):
        if head == None:
            return head
        
        if head in self.hmap:
            return self.hmap[head]
        
        newNode = Node(head.val)
        self.hmap[head] = newNode
        return newNode  

"""
Approach: 

Unlike the previous apporach we will not use a hashmap but instead maintain a linkedlist alongside our current linkedlist. So it will look something like this.

ex: 7 -> 7' -> 13 -> 13' -> 11 -> 11' -> 10 -> 10' -> 1 -> 1' -> None

Do perform this we need to do 3 things:
1) Create new list and attach
2) Set random ptrs
3) Break/split two lists: This will convert the above list into two lists:
     7 -> 13 -> 11 -> 10 -> 1 -> None
     7'-> 13'-> 11' -> 10'->1'-> None

TC: O(n)
SC: O(1)
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head == None:
            return head
        
        # 1) Create new list and attach
        curr = head
        while curr:
            temp = curr.next
            curr.next = Node(curr.val)
            curr.next.next = temp
            curr = curr.next.next
            
        # 2) Set random ptrs
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
                
            curr = curr.next.next
            
        # 3) Break/split two lists
        curr = head
        newList = curr.next
        newHead = newList
        
        while curr:
            curr.next = curr.next.next
            if newList.next:
                newList.next = newList.next.next
                
            curr = curr.next
            newList = newList.next
            
        return newHead
            
            
        