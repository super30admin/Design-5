class Node:
    def __init__(self, val=0, next=None, random=None):
        self.val = val
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: Node) -> Node:
        if not head:
            return None
        
        # Step 1: Insert copy nodes
        current = head
        while current:
            new_node = Node(current.val, current.next)
            current.next = new_node
            current = new_node.next
        
        # Step 2: Assign random pointers
        current = head
        while current:
            if current.random:
                current.next.random = current.random.next
            current = current.next.next
        
        # Step 3: Separate the two lists
        original = head
        copy_head = head.next
        copy_current = copy_head
        
        while original:
            original.next = original.next.next
            if copy_current.next:
                copy_current.next = copy_current.next.next
            original = original.next
            copy_current = copy_current.next
        
        return copy_head

# Example usage:
# Creating a sample list for testing
# Original list: 1 -> 2 -> 3, with random pointers (1->3, 2->1, 3->2)
node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node1.next = node2
node2.next = node3
node1.random = node3
node2.random = node1
node3.random = node2

# Copying the list
solution = Solution()
copied_list_head = solution.copyRandomList(node1)

#time = O(n)
#space = O(1)