"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
'''
Solution 1: HashMap of {old_node : new_node}
    - Iterate over the list, create new nodes. Keep a map of 
      old_nodes - new_nodes
    - Assign the random pointer by either extracting already existing newly created
      node or create a new node.
Time Complexity: O(N)
Space Complexity: O(N)
'''
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        listMap = dict() # {old_node : New_node}
        new_head = self.cloneNode(head,listMap)
        copyHead = new_head
        
        while head!=None:
            copyHead.next = self.cloneNode(head.next,listMap)
            copyHead.random = self.cloneNode(head.random,listMap)
            head = head.next
            copyHead = copyHead.next
        
        return new_head
    
    def cloneNode(self,node,listMap):
        if node==None:
            return None
        if node in listMap:
            return listMap[node]
        new_node = Node(node.val)
        listMap[node] = new_node

        return new_node


'''
Solution 2: Place newly created nodes beside old nodes
    - 7 ->7' ->13-> 11->11'->10->10'->1->1'->null
    - Make clone of nodes and place them next to old nodes
    - Assign random of cloned nodes
    - Separate the old nodeList and cloned nodes list
Time Complexity: O(N)
Space Complexity: O(1)
'''
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head==None:
            return None
        # create copies of nodes
        node = head
        while node!=None:
            # 1. Create a new node
            new_node = self.clone(node)
            # 2. Store original list next node in temp
            temp = node.next
            # 3. place cloned node next to original node
            node.next = new_node
            new_node.next = temp
            # 4. Move ahead
            node = temp
        
        # assign random pointer of cloned nodes
        node = head
        while node!=None:
            if node.random!=None:
                node.next.random = node.random.next
            node = node.next.next
        
        # separate the cloned nodes from original
        node = head
        cloned_head = head.next
        cloned_node = head.next

        while node!=None:
            node.next = node.next.next
            if cloned_node.next!=None:
                cloned_node.next = cloned_node.next.next
            node = node.next
            cloned_node = cloned_node.next
        
        return cloned_head

    def clone(self,node):
        new_node = Node(node.val)
        return new_node
