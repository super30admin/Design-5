#Time Complexity:O(N), where N is the number of nodes in the linked list, as we iterate through the list twice.
#Space Complexity: O(N), for the hash map storing the mapping of original nodes to their copies.
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        #Initialise a hashmap with one value None: Mapped to None, this is to handle when the last node is pointing to null or any node's random pointer in pointing to null 
        oldtonew = {None:None}
        curr = head
        #First pass to creating a copy of each node and store it in the hashmap
        while(curr!=None):
            copy = Node(curr.val)
            oldtonew[curr] = copy
            curr = curr.next
        curr = head
        #Second pass to add next and random pointers for copied nodes
        while(curr!=None):
            copy = oldtonew[curr]
            copy.next = oldtonew[curr.next]
            copy.random = oldtonew[curr.random]
            curr=curr.next
        return oldtonew[head]