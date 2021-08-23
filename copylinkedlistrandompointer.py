class Solution:
    def __init__(self):
        self.d={}
    def getClonedNode(self,node:'Node'):
            if node:
                if node in self.d:
                    return self.d[node]
                else:
                    self.d[node]=Node(node.val,None,None)
                    return self.d[node]
            return None
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None
        old_node=head
        new_node=Node(old_node.val,None,None)
        self.d[old_node]=new_node
        
        while old_node:
            new_node.next=self.getClonedNode(old_node.next)
            new_node.random=self.getClonedNode(old_node.random)
            old_node=old_node.next
            new_node=new_node.next
        return self.d[head]