# Time Complexity :
# O(N)  - Size of the Linked List

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We create a deep copy of a node and add it next to the original node in the linked list. Then we go through this updated linked list and add random pointer links
#After that is done, we decouple the new nodes from the original linked list and return

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None :
            return None

        curr = head
        while curr != None :
            new_node = Node(curr.val)
            new_node.next = curr.next
            curr.next = new_node
            curr = curr.next.next

        curr = head
        while curr!= None :
            if curr.random != None :
                curr.next.random = curr.random.next
            curr = curr.next.next
            

        new_head = head.next
        copy_curr = head.next
        curr = head

        while (curr != None ):
            curr.next = curr.next.next
            if copy_curr.next != None :
                copy_curr.next = copy_curr.next.next
            curr = curr.next
            copy_curr = copy_curr.next
        
        return new_head
