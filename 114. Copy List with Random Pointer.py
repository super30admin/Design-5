class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        # Checking if the head is None and returning None if true
        if not head:
            return None

        curr = head 
        old_to_new = {}

        # Creating a mapping from original nodes to their copies
        while curr:
            node = Node(x=curr.val)  # Creating a new node with the same value
            old_to_new[curr] = node  # Storing the mapping
            curr = curr.next

        curr = head

        # Setting the next and random pointers for the copied nodes
        while curr:
            new_node = old_to_new[curr]
            new_node.next = old_to_new[curr.next] if curr.next else None  # Assigning next pointer
            new_node.random = old_to_new[curr.random] if curr.random else None  # Assigning random pointer
            curr = curr.next 
        
        # Returning the head of the copied list
        return old_to_new[head]

# Time Complexity (TC): O(N), where N is the number of nodes in the list (traversing the list twice)
# Space Complexity (SC): O(N), for storing the mapping from original nodes to their copies