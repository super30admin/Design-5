'''
138. Copy List with Random Pointer
https://leetcode.com/problems/copy-list-with-random-pointer/

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.

Your code will only be given the head of the original linked list.

Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


Constraints:
0 <= n <= 1000
-104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.

Solution:
Consider the following list:
       ------------
      |           |
      |           V
1 --> 2 --> 3 --> 4 --> 5 --> 6 --> 7
      ^     ^     |     |
      |     |     |     |
      |     ------      |
      |                 |
       -----------------
1.[next = 2,    random = None]
2.[next = 3,    random = 4]
3.[next = 4,    random = None]
4.[next = 5,    random = 3]
5.[next = 6,    random = 3]
6.[next = 7,    random = None]
7.[next = None, random = None]

1. Deep copy w/ Hash map using two passes
In the first pass, traverse through the nodes of original list by checking the next pointer. As we traverse, create a copy of the original nodes and add them to the new list (deep copy of original). Maintain a hash map where the key is the original node and the value is the copy node.

In the second pass, traverse through the nodes of original list by checking the random pointer. As we traverse, we read the random pointer of the original list to get the orignal random node, use the hash map to fetch the copy of random node, set the random pointer in the new list to the copy of random node.
https://youtu.be/RpaJCO7oUik?t=328
Time: O(2N) = O(N), Space: O(N)

2. Deep copy w/ Hash map using only one pass
Similar to Solution #1 but we create a copy of the original node and the random node and make both connections (by setting next and random pointer) in the same pass.
https://youtu.be/RpaJCO7oUik?t=876
Time: O(N), Space: O(N)

3. Deep copy w/o Hash map
This can be done in 3 passes
Pass 1: Create copies of the original nodes and juxtapose the copied node
next to the original node
Eg:
original list: 1 --> 2 --> 3 --> 4 --> Null
new list: 1 -> 1' --> 2 --> 2' --> 3 --> 3' --> 4 --> 4' --> Null
Pass 2: Connect the random pointers of the copied nodes. At this point both the original and copied list co-exist as a single list.
Pass 3: Disconnect the original list and copied list
https://youtu.be/RpaJCO7oUik?t=1877
Time: O(3N) = O(N), Space: O(1)

'''
from typing import Optional
from collections import defaultdict
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

def copyRandomList_2(head: 'Optional[Node]') -> 'Optional[Node]':
    ''' Solution #2
        Time: O(N), Space: O(N)
    '''
    def clone(node, map):
        if not node:
            return None
        if node in map:
            return map[node]
        else:
            new = Node(node.val)
            map[node] = new
            return new

    # hash map with <key,value> = <original node, copy of original node>
    h = defaultdict(Node)
    if not head:
        return None

    curr = head
    copy_head = clone(head, h)
    copy_curr = copy_head
    while curr:
        copy_curr.next = clone(curr.next, h)
        copy_curr.random = clone(curr.random, h)
        curr = curr.next
        copy_curr = copy_curr.next

    return copy_head

def copyRandomList_3(head: 'Optional[Node]') -> 'Optional[Node]':
    ''' Solution #3
        Time: O(N), Space: O(1)
    '''
    if not head:
        return None
    curr = head
    # Step 1: Create copies of the original nodes and juxtapose the copied node
    # next to the original node
    # original list: 1 --> 2 --> 3 --> 4 --> Null
    # new list: 1 -> 1' --> 2 --> 2' --> 3 --> 3' --> 4 --> 4' --> Null
    while curr:
        next = curr.next
        new = Node(curr.val)
        curr.next = new
        new.next = next
        curr = next

    # Step 2: Connect the random pointers of the copied nodes
    curr = head
    while curr:
        if curr.random:
            curr.next.random = curr.random.next
        curr = curr.next.next

    # Step 3: Disconnect the original list and copied list
    curr = head
    copy_head = curr.next
    copy_curr = copy_head
    # Note: In the while loop, we reach curr's Null before we reach copy_curr's
    # Null. Hence, exit the loop once we hit copy_curr's Null
    while curr:
        curr.next = curr.next.next
        if copy_curr.next:
            copy_next = copy_curr.next.next
        else: # next node of copy_curr is Null
            # copy_next = None # not reqd
            break
        copy_curr.next = copy_next

        curr = curr.next
        copy_curr = copy_curr.next

    return copy_head