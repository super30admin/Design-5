class Solution(object):
    
    def __init__(self):
        self.visitedHash = {}
    def copyRandomList(self, head):
        if head == None:
            return None
        if head in self.visitedHash:
            return self.visitedHash[head]
        node = Node(head.val, None, None)
        self.visitedHash[head] = node
        node.next = self.copyRandomList(head.next)
        node.random = self.copyRandomList(head.random)
        return node
#Time_Complexity: O(N)
#Space-complexity: O(N)