# Time Complexity : O(n)
# Space Complexity : O(n)

class Node:
    def __init__(self, val=0, next=None, random=None):
        self.val = val
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head):
        if head is None:
            return head
        temp = head
        node_map = {}

        while temp is not None:
            if temp not in node_map:
                node_map[temp] = Node(temp.val)
            new_node = node_map[temp]
            if temp.next is not None:
                if temp.next not in node_map:
                    node_map[temp.next] = Node(temp.next.val)
                new_node.next = node_map[temp.next]
            if temp.random is not None:
                if temp.random not in node_map:
                    node_map[temp.random] = Node(temp.random.val)
                new_node.random = node_map[temp.random]
            temp = temp.next

        return node_map[head]

    def printList(self, head) : # Function to print the list values
        print("==============================================================")
        while head is not None:
            print(head.val)
            head = head.next

# Example 1
# Expected Output for all 3 examples: A new list with the same values and random pointers as the original list
# Creating the list: 1 -> 2 -> 3 with random pointers
node1 = Node(1)
node2 = Node(2)
node3 = Node(3)
node1.next = node2
node2.next = node3
node1.random = node3
node2.random = node1

solution = Solution()
copied_list = solution.copyRandomList(node1)
solution.printList(node1)
solution.printList(copied_list)

# Example 2
# Creating the list: 7 -> 13 -> 11 -> 10 -> 1 with random pointers
node7 = Node(7)
node13 = Node(13)
node11 = Node(11)
node10 = Node(10)
node1 = Node(1)
node7.next = node13
node13.next = node11
node11.next = node10
node10.next = node1
node13.random = node7
node11.random = node1
node10.random = node11

solution = Solution()
copied_list = solution.copyRandomList(node7)
solution.printList(node7)
solution.printList(copied_list)

# Example 3
# Creating the list: 4 with random pointers
node4 = Node(4)
node4.random = node4

solution = Solution()
copied_list = solution.copyRandomList(node4)
solution.printList(node4)
solution.printList(copied_list)