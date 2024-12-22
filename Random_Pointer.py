# Approach:
# To create a deep copy of the linked list, we will use a two-pass approach. 
# First, we create a copy of each node and place it next to its original node in the original list.
# Second, we update the `random` pointers for the copied nodes.
# Finally, we separate the copied nodes from the original nodes to create the deep copy list.

# Time Complexity: O(n) - Each node is visited twice.
# Space Complexity: O(1) - We use no additional data structures; in-place modifications.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None  # Return None if the original list is empty

        # Step 1: Create a copy of each node and place it next to the original node
        current = head
        while current:
            # Create a new node with the same value as the current node
            new_node = Node(current.val)
            # Insert the new node right after the original node
            new_node.next = current.next
            current.next = new_node
            # Move to the next original node
            current = new_node.next
        
        # Step 2: Update the random pointers of the new nodes
        current = head
        while current:
            if current.random:
                # Set the random pointer of the copied node
                current.next.random = current.random.next
            current = current.next.next  # Move to the next original node
        
        # Step 3: Separate the copied nodes from the original list
        current = head
        new_head = head.next  # Head of the copied list
        while current:
            # Extract the copied node
            copied_node = current.next
            # Restore the next pointer of the original node
            current.next = copied_node.next
            # Restore the next pointer of the copied node
            if copied_node.next:
                copied_node.next = copied_node.next.next
            # Move to the next original node
            current = current.next
        
        return new_head  # Return the head of the deep copied list
