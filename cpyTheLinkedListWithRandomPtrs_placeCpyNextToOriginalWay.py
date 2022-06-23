'''
Time Complexxity: 0(n)
Space Complexity : 0(1)
Run on Leecode : Yes
'''
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    
    def __init__(self): 
        self.cpy_head = None
    
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        # create a rfr to head
        currentNode = head
        
        # Step 1: Create a copy of node and place it next to the original
        while currentNode != None:
            
            # create a cpy of node
            objNewNode = Node(currentNode.val)
            
            # base--case self.cpy_head == None
            if self.cpy_head == None:
                self.cpy_head = objNewNode
            
            # update the objNewNode.next
            objNewNode.next = currentNode.next
            
            # update the currentNode.next to objNewNode
            currentNode.next = objNewNode
             
            # update the currentNode.next.next
            if currentNode.next != None:
                currentNode = currentNode.next.next
            else:
                currentNode = currentNode.next
        
        # Step 2: Update the node.random rfr's
        currentNode = head
        cpy_currentNode = self.cpy_head
        
        while currentNode != None:
            
            # chk on the basis of currentNode.random value
            if currentNode.random != None:
                
                # assign cpy_currentNode.random the currentNode.random.next value
                cpy_currentNode.random = currentNode.random.next
            
            # update the rfr of cpy_currentNode
            if cpy_currentNode.next != None:
                cpy_currentNode = cpy_currentNode.next.next
            else:
                cpy_currentNode = cpy_currentNode.next
                
            # update the rfr of currentNode
            currentNode = currentNode.next.next
            
        
        # Step 3: update the next rfr of original and cpyNodes
        currentNode = head
        cpy_currentNode = self.cpy_head
        while currentNode != None:
            
            # create a temp variable
            originalNext = cpy_currentNode.next
            
            # update the cpy_currentNode.next
            if cpy_currentNode.next != None:
                cpy_currentNode.next = cpy_currentNode.next.next
            
            # update the currentNode.next
            currentNode.next = originalNext
            
            # update the currentNode and cpy_currentNode
            cpy_currentNode = cpy_currentNode.next 
            currentNode = currentNode.next
            
        '''
        # TO TEST
        # print the cpy linked list
        nodeRfr = head
        while nodeRfr != None:
            
            print("\n----------")
            print('Value is:\t',nodeRfr.val)
            
            if nodeRfr.next != None:
                print('Next is:\t',vars(nodeRfr.next))
            else:
                print('Next is:\t',nodeRfr.next)
            
            if nodeRfr.random != None:
                print("Random is:\t",vars(nodeRfr.random))
            else:
                print('Random is:\t',nodeRfr.random)
            
            nodeRfr = nodeRfr.next
        '''
        # return the result
        return self.cpy_head