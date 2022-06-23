'''
Time Complexxity: 0(n)
Space Complexity : 0(n) -- dictionary
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
        self.cpy_dict = {}
    
    def cpyNode(self,currentNode,cpy_currentNode):
        
        # 1. chk for the currentNode
        if currentNode != None and currentNode not in self.cpy_dict:
            
            # create a cpy
            objNewNode = Node(currentNode.val,currentNode.next,currentNode.random)
            
            # add to the dictionary
            self.cpy_dict[currentNode] = objNewNode
            
            # base-case--chk the headNode of cpy_linkedList
            if self.cpy_head == None:
                self.cpy_head = objNewNode
            
            # assign the cpy_currentNode to the objNewNode
            cpy_currentNode = objNewNode
        
        # 2. chk for the currentNode.next
        if currentNode.next != None and currentNode.next not in self.cpy_dict:
            
            # create a cpy
            objNewNode = Node(currentNode.next.val)
            if currentNode.next != None and currentNode.next.next != None:
                objNewNode.next = currentNode.next.next
            if currentNode.next != None and currentNode.next.random != None:
                objNewNode.random = currentNode.next.random
            
            # add to the dictionary
            self.cpy_dict[currentNode.next] = objNewNode
            
            # assign the cpy_currentNode.next to objNewNode
            cpy_currentNode.next = objNewNode
            
        elif currentNode.next != None and currentNode.next in self.cpy_dict:
            # assign the cpy_currentNode.next to dictionary[key] i.e. value of a key
            cpy_currentNode.next = self.cpy_dict[currentNode.next]
        
        # 3. chk for the currentNode.random
        if currentNode.random != None and currentNode.random not in self.cpy_dict:
            
            # create a cpy
            objNewNode = Node(currentNode.random.val)
            if currentNode.random != None and currentNode.random.next != None:
                objNewNode.next = currentNode.random.next
            if currentNode.random != None and currentNode.random.random != None:
                objNewNode.random = currentNode.random.random
            
            # add to the dictionary
            self.cpy_dict[currentNode.random] = objNewNode
            
            # assign the cpy_currentNode.random to objNewNode
            cpy_currentNode.random = objNewNode
        
        elif currentNode.random != None and currentNode.random in self.cpy_dict:
            # assign the cpy_currentNode.random to dictionary[key] i.e. value of a key
            cpy_currentNode.random = self.cpy_dict[currentNode.random]
        
        # return 
        return cpy_currentNode.next
    
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        # ptr currentNode to the head
        currentNode = head
        
        # ptr cpy_currentNode to the cpy_head
        cpy_currentNode = self.cpy_head
        
        while currentNode != None:
        
            # pass to the function cpyNode
            cpy_currentNode = self.cpyNode(currentNode,cpy_currentNode)
            
            # update the currentNode
            currentNode = currentNode.next
        '''end of while loop'''
        
        '''
        TO TEST
        # print the cpy linked list
        nodeRfr = self.cpy_head
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
        return self.cpy_head