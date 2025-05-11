# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

# Time Complexity : O(3n)
# Space Complexity : O(1)
# Approach :
# 1. Create a copy of each node and insert it next to the original node in the first pass
# 2. In the second pass, set the random pointers of the copied nodes
# 3. In the third pass, separate the copied nodes from the original nodes
# 4. Return the head of the copied list
class Solution:
    def copyRandomList(self, head):
        # Check if the head is None. If it is, return None
        if not head: return head
        # Current pointer pointing to the head
        curr = head
        # First pass: Create a copy of each node and insert it next to the original node
        while curr:
            # Create a new node with the same value as the current node
            copyNode = Node(curr.val)
            # Change pointers to insert the copy node next to the current node
            copyNode.next = curr.next
            curr.next = copyNode
            # Move to the next original node
            curr = curr.next.next
        # Second pass: Set the random pointers of the copied nodes
        curr = head
        # Iterate through the list again
        while curr:
            # If the current node has a random pointer, set the random pointer of the copy node
            # to the next node of the random pointer of the original node
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next
        # Third pass: Separate the copied nodes from the original nodes
        curr = head
        copyCurr = curr.next
        # Create a dummy node to hold the head of the copied list
        dummy = Node(0)
        dummy.next = copyCurr
        # Iterate through the list again
        while curr:
            # Set the next pointers of the original and copied nodes to separate them
            curr.next = curr.next.next
            if copyCurr.next:
                copyCurr.next = copyCurr.next.next
            # Move to the next original and copied nodes
            curr = curr.next
            copyCurr = copyCurr.next
        # Return the head of the copied list
        return dummy.next

# Time Complexity : O(n)
# Space Complexity : O(n)
# Approach :
# 1. Create a hash map to store the mapping between original and copied nodes
# 2. Clone the nodes and store them in the hash map, including the next and random pointers
class Solution:
    def copyRandomList(self, head):
        # Check if the head is None. If it is, return None
        if not head: return head
        # Create a hash map to store the mapping between original and copied nodes
        copyMap = {}
        # Function to clone a node
        def clone(node):
            # If the node is None, return None
            if not node: return None
            # If the node is not in the hash map, create a new node and store it in the hash map
            if node not in copyMap:
                copyNode = Node(node.val)
                copyMap[node] = copyNode
            # Return the copied node from the hash map
            return copyMap[node]

        curr = head
        # Create a copy of the head node and store it in the hash map
        copyCurr = clone(curr)
        # Iterate through the list
        while curr:
            # Create a copy of the next and random nodes and store them in the hash map
            copyCurr.next = clone(curr.next)
            copyCurr.random = clone(curr.random)
            # Move to the next original and copied nodes
            copyCurr = copyCurr.next
            curr = curr.next
        # Return the head of the copied list from the hash map
        return copyMap[head]

# Time Complexity : O(2n)
# Space Complexity : O(n)
# Approach :
# 1. Create a hash map to store the mapping between original and copied nodes
# 2. Clone the nodes and store them in the hash map. We will end up with a copy of the original list without random pointers, along wiht their mapping stored in the hashMap
# 3. Iterate through the original list again and set the random pointers of the copied nodes using the hash map
# 4. Return the head of the copied list
class Solution:
    def copyRandomList(self, head):
        # Check if the head is None. If it is, return None
        if not head: return None
        # Create a hash map to store the mapping between original and copied nodes
        # The hash map will store the original node as the key and the copied node as the value
        copyMap = {}
        # Current pointer pointing to the head
        curr = head
        # Copy the first node and store it in the hash map
        # The copy node will be the first node in the copied list
        copyNode = Node(curr.val)
        # copyCurr points to the first node in the copied list
        copyCurr = copyNode
        copyMap[curr] = copyNode
        curr = curr.next
        # First pass : Iterate through the original list and create copies of each node
        while curr:
            # Create a new node with the same value as the current node
            copyNode = Node(curr.val)
            # Insert the copy node in the hash map
            copyMap[curr] = copyNode
            # Set the next pointer of the previous copy node to the current copy node
            copyCurr.next = copyNode
            # Move to the next original and copied nodes
            curr = curr.next
            copyCurr = copyCurr.next
        # Second pass : Iterate through the original list again and set the random pointers of the copied nodes
        # Reset the current pointer to the head of the original list
        curr = head
        copyCurr = copyMap[head]
        while curr:
            # If the current node has a random pointer, set the random pointer of the copy node
            # to the next node of the random pointer of the original node
            # The random pointer of the copied node will point to the copied node in the hash map
            if curr.random:
                copyCurr.random = copyMap[curr.random]
            # Move to the next original and copied nodes
            curr = curr.next
            copyCurr = copyCurr.next
        # Return the head of the copied list from the hash map
        return copyMap[head]