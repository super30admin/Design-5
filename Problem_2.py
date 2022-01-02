# Using extra space
# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return head
        self.hashmap = {}
        curr = head
        currCopy = self.clone(curr)
        while curr != None:
            currCopy.next = self.clone(curr.next)
            currCopy.random = self.clone(curr.random)
            curr = curr.next
            currCopy = currCopy.next
        return self.hashmap[head]
        
        
    def clone(self, node):
        if node == None:
            return None
        if node in self.hashmap:
            return self.hashmap[node]
        newNode = Node(node.val)
        self.hashmap[node] = newNode
        return newNode


# Without Using extra space - 3 pass algorithm
# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None:
            return head
        curr = head
        while curr != None:
            currCopy = Node(curr.val)
            currCopy.next = curr.next
            curr.next = currCopy
            curr = curr.next.next
            
        curr = head
        while curr != None:
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
            
        curr = head
        copyHead = head.next
        currCopy = head.next
        while curr != None:
            curr.next = curr.next.next
            if currCopy.next != None:
                currCopy.next = currCopy.next.next
            curr = curr.next
            currCopy = currCopy.next
        return copyHead
            
        
        