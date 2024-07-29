#I used a dictionary to map each original node to its corresponding copy. The approach involves two passes through the list. In the first pass, I create a new node for each original node and store the mapping in a dictionary. In the second pass, I update the next and random pointers of each new node by referencing the dictionary for the correct copied nodes. This ensures that the new list replicates the structure and random pointers of the original list. The time complexity of this solution is O(N), where N is the number of nodes in the list, as each node is processed twice. The space complexity is also O(N) due to the additional storage required for the dictionary holding the node mappings.

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
            return head
        d={}
        curr = head
        while curr:
            d[curr] = Node(curr.val)
            curr = curr.next
        curr = head
        while curr:
            d[curr].next = d.get(curr.next)
            d[curr].random = d.get(curr.random)
            curr = curr.next
        return d[head]