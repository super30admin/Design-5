# Time complexity: O(n)
# Space complexity: O(n)

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        
        node_dict = {}
        curr = head
        
        # First pass: create a copy of each node and store it in the dictionary
        while curr:
            node_dict[curr] = Node(curr.val)
            curr = curr.next
        
        curr = head
        
        # Second pass: update the next and random pointers of the copied nodes
        while curr:
            if curr.next:
                node_dict[curr].next = node_dict[curr.next]
            if curr.random:
                node_dict[curr].random = node_dict[curr.random]
            curr = curr.next
        
        return node_dict[head]
