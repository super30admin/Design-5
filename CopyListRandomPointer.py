class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
class Globals:
    def __init__(self):
        self.clonedNodesDict = {}
class CopyRandomList:
    def copyRandomList(self, head: 'Node') -> 'Node':
        globalVars = Globals()
        cursor = head
        resultantCursor = self.__clone(head, globalVars)
        while (cursor != None):
            resultantCursor.next = self.__clone(cursor.next, globalVars)
            resultantCursor.random = self.__clone(cursor.random, globalVars)
            resultantCursor = self.__clone(cursor.next, globalVars)
            cursor = cursor.next
        return self.__clone(head, globalVars)
    def __clone(self, nodeToClone: 'Node', globalVars: 'Globals') -> 'Node':
        if (nodeToClone == None):
            return None
        if (nodeToClone in globalVars.clonedNodesDict):
            return globalVars.clonedNodesDict[nodeToClone]
        else:
            newNode = Node(nodeToClone.val)
            globalVars.clonedNodesDict[nodeToClone] = newNode
            return newNode