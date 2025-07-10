"""
Clone each node and interleave it with the original list
Assign random pointers using original.random.next
Split the interleaved list into original and copied
"""
"""
Time Complexity : O(n) – 3 linear passes
Space Complexity : O(1) – no extra space
"""


class Node:
    def __init__(self, val: int, next: 'Node' = None, random: 'Node' = None):
        self.val = val
        self.next = next
        self.random = random

class copyListRandom:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head:
            return None


        curr = head
        while curr:
            copy = Node(curr.val, curr.next)
            curr.next = copy
            curr = copy.next


        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next


        curr = head
        pseudo_head = head.next
        while curr:
            copy = curr.next
            curr.next = copy.next
            if copy.next:
                copy.next = copy.next.next
            curr = curr.next

        return pseudo_head

def print_list(head):
    curr = head
    while curr:
        rand = curr.random.val if curr.random else None
        print(f"Node({curr.val}, Random: {rand})")
        curr = curr.next

if __name__ == "__main__":

    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node1.next = node2
    node2.next = node3
    node1.random = node3
    node2.random = node1
    node3.random = node2

    obj = copyListRandom()
    copied = obj.copyRandomList(node1)
    print_list(copied)
