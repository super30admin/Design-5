'''
Solution:
1.  Use a HashMap to store all nodes which are cloned where key is the node that needs to be cloned and the value
    would be the new node that is created.
2.  If node to be cloned already exits in the HashMap, it means its already cloned; otherwise create a new Node.
3.  Traverse the original Linkedlist and update randome and next pointers in parallel for the new nodes.

Time Complexity:    O(N)    |   Space Complexity:   O(N)

--- Passed all testcases on Leetcode successfully.
'''


# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Globals:

    #   Use a class to store global variables --> here it is the HashMap
    def __init__(self):
        self.clonedNodesDict = {}

class CopyRandomList:
    def copyRandomList(self, head: 'Node') -> 'Node':

        #   initialize the HashMap
        globalVars = Globals()

        #   start both actual and resultant(clone it) from the head
        cursor = head
        resultantCursor = self.__clone(head, globalVars)

        #   iterate till the tail node.
        while (cursor != None):

            #   clone next and random pointer nodes for the current node
            resultantCursor.next = self.__clone(cursor.next, globalVars)
            resultantCursor.random = self.__clone(cursor.random, globalVars)

            #   move to the next node.
            resultantCursor = self.__clone(cursor.next, globalVars)
            cursor = cursor.next

        return self.__clone(head, globalVars)

    def __clone(self, nodeToClone: 'Node', globalVars: 'Globals') -> 'Node':

        #   edge case check
        if (nodeToClone == None):
            return None

        #   if already present, just return the value of the key in the HashMap
        if (nodeToClone in globalVars.clonedNodesDict):
            return globalVars.clonedNodesDict[nodeToClone]

        #   else add it to the HashMap
        else:
            newNode = Node(nodeToClone.val)
            globalVars.clonedNodesDict[nodeToClone] = newNode
            return newNode