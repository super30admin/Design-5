"""
FAANMG Problem #113 {Medium} 

138. Copy List with Random Pointer


 Time : O(n) 
 Space : O(n)

Did this code successfully run on Leetcode : Yes

 traverse through the old list, create new node and map old to new node in a hashma


@name: Rahul Govindkumar
""" 


"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def clone(self, node):
        # if Node is None then return None
        if not node:
            return None
        
        # if node is present in the Hashmap, then just return it's corresponding value
        if node in self.map:
            return self.map[node]
        
        # if not, then create a deep copy and add the node to the hashmap
        newNode = Node(node.val)
        self.map[node] = newNode
        
        return newNode
        
        
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        if not head:
            return
        
        #maintain a hashmap to map old node to the new node
        self.map = {}
        
        #start with the head
        curr = head
        
        #clone the head
        copyHead = self.clone(head)
        copyCurr = copyHead
        
        #traverse the entire list
        while curr:
            
            #clone the next and the random pointer node and point the next to the same
            copyCurr.next = self.clone(curr.next)
            copyCurr.random = self.clone(curr.random)
            
            #move the pointers 
            curr= curr.next
            copyCurr = copyCurr.next
            
        #return head on the new list
        return copyHead
    


"""
FAANMG Problem #113 {Medium} 

138. Copy List with Random Pointer


 Time : O(n) 
 Space : O(1)

Did this code successfully run on Leetcode : Yes

 traverse through the old list, create new node and map old to new node then split it


@name: Rahul Govindkumar
"""

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
        
        if not head:
            return

        
        #start with the head
        curr = head
        
        
        #traverse the entire list
        while curr:
            # Create a new node with the same value as the current node
            new_node = Node(curr.val)
            
            # Link the new node to the next node
            new_node.next = curr.next
            
            # Link the current node to the new node
            curr.next = new_node
            
            # Move the pointer to the next node
            curr = new_node.next
            
        # Set the pointers for the random nodes
        curr= head
        
        while curr:
            #check if curr node has random pointer
            if curr.random:
                #link the new random pointer to the copied node
                curr.next.random = curr.random.next
                
            # Move the pointer to the next node
            curr = curr.next.next
            
        #splitting the list
        #Creating pointer for the old and new node
        curr = head
        copyHead = head.next
        
        #create curr node for copy  list
        currCopy = copyHead
        
        while curr:
            
            #link the old node to next old node
            curr.next = curr.next.next
            
            if currCopy.next:
                #link the new node to next old node
                currCopy.next = currCopy.next.next
        
            #move both the pointers
            curr = curr.next
            currCopy = currCopy.next
        
        return copyHead
            
            
            
            
            
            
            
            

            
            
        
            
            
            
        
        