"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
# brute force solution - without using hash maps
# STEPS:
# Traverse the list using next pointer and create a copy of the linked list while traversing the list.
# In the second pass, set the random pointer to the corresponding nodes in the random pointer of the first list.
# Time complexity - O(n^2)
# Space complexity - O(n)
# Did this solution run on leetcode? - no (error - Solution has no attribute 'copyRandomList' -- looks like leetcode error)
class Solution:
    def __deepcopy__(self, head):
        if not head: return []
        first_node = head
        copy_root = None
        prev = None
        
        # O(n)
        while first_node:
            node = Node(first_node.val)
            # if the root of the second linked list is None, set the root.
            if not copy_root:
                copy_root = node
            
            if prev:
                prev.next = node    # point the current node to the next of the previous node
            prev = node             # keep track of the nodes
            first_node = first_node.next
        
        # O(n^2)
        first_node = head
        second_node = copy_root
        while first_node:
            # set the random pointer of the second node.
            second_node.random = self.findRandom(head, copy_root, first_node.random)
            
            # traverse both the linked lists at once.
            first_node = first_node.next
            second_node = second_node.next
        
        return copy_root
    
    def findRandom(self, firstHead, copyHead, firstRandom):
        # edge case
        # if the random points to null.
        if not firstRandom:
            return firstRandom
        
        while firstHead:
            # if the node matches with the node in the actual linked list, return the corresponding node from the copy list.
            if firstHead == firstRandom:
                return copyHead
            firstHead = firstHead.next
            copyHead = copyHead.next
            
        return None # code will never reach here.


# Using a hash map
# STEPS:
# Traverse the first linked list using next pointer and create nodes of the second linked list at the same time. 
# similarly create node which is referred by the random pointer.
# store the reference of new node in the form (firstnode: secondnode)
# Before creating a node, check if it is already present in the hash map.
# If the node is present, return the node from the dictionary. 
# Time complexity - O(n)
# Space complexity - O(n)
# Did this solution run on leetcode? - no (error - Solution has no attribute 'copyRandomList' -- looks like leetcode error)
class Solution:
    def __deepcopy__(self, head):
        # edge case
        if not head: return []
        
        self.nodesHash = dict()
        firstNode = head
        secondHead = secondNode = self.createNode(head)
        
        while firstNode:
            if firstNode.next not in self.nodesHash:
                secondNode.next = self.createNode(firstNode.next)
            else:
                secondNode.next = self.nodesHash[firstNode.next]
            
            if firstNode.random is not None:
                if firstNode.random not in self.nodesHash:
                    secondNode.random = self.createNode(firstNode.random)
                else:
                    secondNode.random = self.nodesHash[firstNode.random]
            else:
                secondNode.random = None
            
            firstNode = firstNode.next
            secondNode = secondNode.next
        
        return secondHead
        
    
    # store the reference of the nodes in the dictionary
    def createNode(self, firstNode):
        secondNode = Node(firstNode.val)
        self.nodesHash[firstNode] = secondNode
        return secondNode
