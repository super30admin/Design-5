"""
Problem 2: Copy List with Random Pointer

https://leetcode.com/problems/copy-list-with-random-pointer/


"""

# Approach - 1

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
        """
        traverse through the ol list, create new node and map old to new node in a hashmap
        TC: O(N) N no of nodes
        SC:O(N)
        """
        if head == None: return None 
        # hashmap to store the nodes with their deep copy nodes {oldNode : newNode}
        node_map = {}
        copy_head = self.copyNode(head, node_map)
        curr = head
        temp = copy_head
        # first pass: to add the nodes in the hashmap, create new_nodes 
        while curr is not None:
            temp.next = self.copyNode(curr.next, node_map)
            temp.random = self.copyNode(curr.random, node_map)
            
            curr = curr.next
            temp = temp.next
            
        return copy_head
            
    def copyNode(self, node, node_map):
        """
        helper function to copy the node and map it in the hashmap
        """
        if node == None: return None
        
        if node in node_map:
            return node_map.get(node)
        
        new_node = Node(node.val, node_map)
        node_map[node] = new_node
        
        return new_node
            
# Approach - 2

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
        """
        TC : O(N)
        SC : O(1)
        """
        if head == None: return None 
        
        curr = head
        # create new node right after the orginal node
        while curr is not None:
            new_node = Node(curr.val)
            new_node.next = curr.next
            curr.next = new_node
            curr = curr.next.next
                              
        # map the random pointer 
        curr = head
        while curr is not None:
            if curr.random is not None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
                
        # remove the links and make it two seperate lists
        curr = head
        new_head = head.next
        temp = new_head
        while curr is not None:
            
            curr.next = curr.next.next
            if temp.next is not None:
                temp.next = temp.next.next
            curr = curr.next
            temp = temp.next
            
        return new_head
            
        
            
        
        