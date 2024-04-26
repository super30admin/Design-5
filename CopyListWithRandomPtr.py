#Time Complexity: O(n)
#Space Complexity: O(n)

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        # check if there is no LL
        if head == None:
            return None
        dict = {}
        curr = head
        while curr != None:
            dict[curr] = Node(curr.val)
            curr = curr.next
        curr = head
        while curr != None:
            dict[curr].next = dict.get(curr.next)
            dict[curr].random = dict.get(curr.random)
            curr = curr.next
        return dict[head]