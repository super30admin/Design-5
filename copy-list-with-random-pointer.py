# 2 pass solution with extra space
# Time O(2n)
# Space O(n)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        nodeMap = {}
        curr = head
        copyHead = Node(-1)
        currCopy = copyHead
        # create copy list first
        while curr != None:
            currCopy.next = Node(curr.val)
            nodeMap[curr] = currCopy.next
            curr = curr.next
            currCopy = currCopy.next
        # update random links
        curr = head
        currCopy = copyHead.next
        while curr != None:
            if curr.random != None:
                currCopy.random = nodeMap[curr.random]
            curr = curr.next
            currCopy = currCopy.next
        return copyHead.next
    
# Single pass solution with extra space
# Time O(n)
# Space O(n)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        nodeMap = {}
        curr = head
        copyHead = Node(-1)
        currCopy = copyHead
        while curr != None:
            # process curr
            if curr not in nodeMap:
                nodeMap[curr] = Node(curr.val)
            currCopy.next = nodeMap[curr]

            # process random
            if curr.random is not None:
                if curr.random not in nodeMap:
                    nodeMap[curr.random] = Node(curr.random.val)    
                currCopy.next.random = nodeMap[curr.random]
            curr = curr.next
            currCopy = currCopy.next
        
        return copyHead.next

# 3 pass solution with NO extra space
# Time O(3n)
# Space O(1)
class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head == None: return head
        curr = head
        currCopy = None
        while curr != None:
            # add copied element in between two original elements in original list
            temp = curr.next
            currCopy = Node(curr.val)
            curr.next = currCopy
            currCopy.next = temp
            # move to next ele in original list
            curr = curr.next.next

        # Add random pointers to copied elements
        curr = head
        while curr != None: 
            if curr.random != None:
                curr.next.random = curr.random.next
            curr = curr.next.next
        
        # Separate original list from new list
        resultNode = head.next
        currCopy = head.next
        curr = head
        while curr != None:
            curr.next = curr.next.next
            if curr.next != None:
                currCopy.next = curr.next.next
            currCopy = currCopy.next
            curr = curr.next

        return resultNode