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
-10^4 <= Node.val <= 10^4
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
In the first pass, traverse through the nodes of original list. During traversal, create a clone of the original node. Add each original node as a key to a hash map and the corresponding value as the cloned node.

In the second pass, traverse through the nodes of original list. During traversal, populate the next and random pointers of the cloned nodes using
clone = map[original]
clone.next = map[original.next]
clone.random = map[original.random]

Finally, return map[head] as the head of the deep copy version.
Time: O(2N) = O(N), Space: O(N)
https://youtu.be/RpaJCO7oUik?t=328


2. Deep copy w/ Hash map using only one pass
Similar to Solution #1 but we create a copy of the original node and the random node and make both connections (by setting next and random pointer) in the same pass.
Time: O(N), Space: O(N)
https://youtu.be/RpaJCO7oUik?t=876


3. Deep copy w/o Hash map
This can be done in 3 passes
Pass 1: Create copies of the original nodes and juxtapose the copied node
next to the original node
Eg:
original list: 1 --> 2 --> 3 --> 4 --> Null
new list: 1 -> 1' --> 2 --> 2' --> 3 --> 3' --> 4 --> 4' --> Null
Pass 2: Connect the random pointers of the copied nodes. At this point both the original and copied list co-exist as a single list.
Pass 3: Disconnect the original list and copied list
Time: O(3N) = O(N), Space: O(1)
https://youtu.be/RpaJCO7oUik?t=1877

'''
from typing import Optional
from collections import defaultdict
from copy import deepcopy as dcp
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

    def __repr__(self):
        # Extracts the last 4 digits of the hex address
        short_addr = hex(id(self))[-4:]
        return f"{short_addr}, {self.val}"

# helper function 1
def build_list_with_random_pointer(input_list):
    """
    Helper function which builds a linked list with random pointers from LeetCode's input format.
    Example input: [[7, None], [13, 0], [11, 4], [10, 2], [1, 0]]
    """
    if not input_list:
        return None

    # Step 1: Create all nodes and store them in an array for index-based access
    nodes = [Node(val) for val, _ in input_list]

    # Step 2: Wire up the next and random pointers
    for i, (_, random_idx) in enumerate(input_list):
        # Connect next pointer (if not the last node)
        if i < len(nodes) - 1:
            nodes[i].next = nodes[i + 1]

        # Connect random pointer using the index
        if random_idx is not None:
            nodes[i].random = nodes[random_idx]

    return nodes[0] if nodes else None

# helper function 2
def print_list(head):
    """
    Helper function which traverses the list to print values, next nodes, and random nodes. Also tracks nodes in a list to map references back to their 0-indexed positions.
    """
    if not head:
        print("List is empty")
        return

    # First pass: map node references to their 0-indexed positions for clear printing
    node_to_idx = {}
    curr = head
    idx = 0
    while curr:
        node_to_idx[curr] = idx
        curr = curr.next
        idx += 1

    # Second pass: print out the structure
    curr = head
    while curr:
        curr_idx = node_to_idx[curr]
        next_idx = node_to_idx[curr.next] if curr.next else "None"
        random_idx = node_to_idx[curr.random] if curr.random else "None"

        print(f"Node [{curr_idx}] ({curr}): val = {curr.val}, next -> [{next_idx}] ({curr.next}), random -> [{random_idx}] ({curr.random})")
        curr = curr.next

# helper function 3
def verify_deep_copy(original: Optional[Node], replica: Optional[Node]) -> bool:
    """
    Verifies that replica is a true deep copy of original.
    Checks structural identity (values, next, random positions)
    and ensures complete isolation in memory (no mixed node references).
    """
    if not original and not replica:
        return True
    if not original or not replica:
        print("❌ Failure: One list is empty while the other is not.")
        return False

    # 1. Map original nodes and replica nodes to their respective positional indices
    orig_nodes = []
    curr = original
    while curr:
        orig_nodes.append(curr)
        curr = curr.next

    repl_nodes = []
    curr = replica
    while curr:
        repl_nodes.append(curr)
        curr = curr.next

    # Check structural length mismatch
    if len(orig_nodes) != len(repl_nodes):
        print(f"❌ Failure: Length mismatch. Original: {len(orig_nodes)}, Replica: {len(repl_nodes)}")
        return False

    # Create pointer-to-index lookup maps
    orig_to_idx = {node: i for i, node in enumerate(orig_nodes)}
    repl_to_idx = {node: i for i, node in enumerate(repl_nodes)}

    # 2. Structural and Address Separation Verification Pass
    for i in range(len(orig_nodes)):
        o_node = orig_nodes[i]
        r_node = repl_nodes[i]

        # Strict Memory Isolation Check: Ensure clone doesn't share old references
        if o_node is r_node:
            print(f"❌ Failure at index {i}: Node addresses overlap! (Not a deep copy)")
            return False

        # Value Check
        if o_node.val != r_node.val:
            print(f"❌ Failure at index {i}: Value mismatch. Original: {o_node.val}, Replica: {r_node.val}")
            return False

        # Next Pointer Target Validation
        o_next_idx = orig_to_idx.get(o_node.next, None)
        r_next_idx = repl_to_idx.get(r_node.next, None)
        if o_next_idx != r_next_idx:
            print(f"❌ Failure at index {i}: 'next' pointer target mismatch.")
            return False

        # Random Pointer Target Validation
        o_rand_idx = orig_to_idx.get(o_node.random, None)
        r_rand_idx = repl_to_idx.get(r_node.random, None)
        if o_rand_idx != r_rand_idx:
            print(f"❌ Failure at index {i}: 'random' pointer target mismatch.")
            return False

    return True


def copyRandomList_1(head: 'Optional[Node]') -> 'Optional[Node]':
    ''' Solution #1
        Time: O(2N), Space: O(N)
    '''
    if not head:
        return None
    h = {}

    # Pass 1: Create all the new nodes (clones) with just their values
    # next and random pointers of the new nodes remain None
    curr = head
    while curr:
        h[curr] = Node(curr.val)
        curr = curr.next

    # Pass 2: Populate the next and random pointers of the clones
    curr = head
    while curr:
        clone = h[curr]
        clone.next = h.get(curr.next, None)
        clone.random = h.get(curr.random, None)
        curr = curr.next

    return h[head]

def copyRandomList_2(head: 'Optional[Node]') -> 'Optional[Node]':
    ''' Solution #2
        Time: O(N), Space: O(N)
    '''
    # Helper function to get the clone if it exists,
    # or instantly create it if it doesn't
    def get_clone(node):
        if not node:
            return None
        if node not in h:
            h[node] = Node(node.val)
        return h[node]

    if not head:
        return None
    h = {}

    curr = head

    # this works
    # while curr:
    #     if curr not in h:
    #         h[curr] = Node(curr.val)
    #     clone = h[curr]

    #     if curr.next and curr.next not in h:
    #         h[curr.next] = Node(curr.next.val)
    #     clone.next = h.get(curr.next, None)

    #     if curr.random and curr.random not in h:
    #         h[curr.random] = Node(curr.random.val)
    #     clone.random = h.get(curr.random, None)

    #     curr = curr.next

    # but this is easier to follow
    while curr:
        # 1. Get or create the clone for the current node
        clone = get_clone(curr)

        # 2. Get or create next clone and random clone
        clone.next = get_clone(curr.next)
        clone.random = get_clone(curr.random)

        # 3. Go to the next node
        curr = curr.next

    return h[head]



# def copyRandomList_3(head: 'Optional[Node]') -> 'Optional[Node]':
#     ''' Solution #3
#         Time: O(N), Space: O(1)
#     '''
#     if not head:
#         return None
#     curr = head
#     # Step 1: Create copies of the original nodes and juxtapose the copied node
#     # next to the original node
#     # original list: 1 --> 2 --> 3 --> 4 --> Null
#     # new list: 1 -> 1' --> 2 --> 2' --> 3 --> 3' --> 4 --> 4' --> Null
#     while curr:
#         next = curr.next
#         new = Node(curr.val)
#         curr.next = new
#         new.next = next
#         curr = next

#     # Step 2: Connect the random pointers of the copied nodes
#     curr = head
#     while curr:
#         if curr.random:
#             curr.next.random = curr.random.next
#         curr = curr.next.next

#     # Step 3: Disconnect the original list and copied list
#     curr = head
#     copy_head = curr.next
#     copy_curr = copy_head
#     # Note: In the while loop, we reach curr's Null before we reach copy_curr's
#     # Null. Hence, exit the loop once we hit copy_curr's Null
#     while curr:
#         curr.next = curr.next.next
#         if copy_curr.next:
#             copy_next = copy_curr.next.next
#         else: # next node of copy_curr is Null
#             # copy_next = None # not reqd
#             break
#         copy_curr.next = copy_next

#         curr = curr.next
#         copy_curr = copy_curr.next

#     return copy_head


def copyRandomList_3(head: 'Optional[Node]') -> 'Optional[Node]':
    ''' Solution #3
        Time: O(3N), Space: O(1)
    '''
    if not head:
        return None

    # Step 1: Interleave the original and cloned nodes
    # original list: 1 --> 2 --> 3 --> 4 --> Null
    # interleaved list: 1 -> 1' --> 2 --> 2' --> 3 --> 3' --> 4 --> 4' --> Null
    curr = head
    while curr:
        clone = Node(curr.val)
        clone.next = curr.next
        curr.next = clone
        curr = curr.next.next
    #print(f"Interleaved:")
    #print_list(head)

    # Step 2: Assign the random pointers of the clones
    curr = head
    while curr:
        clone = curr.next
        clone.random = curr.random.next if curr.random else None
        curr = curr.next.next
    #print(f"Random pointers for cloned nodes:")
    #print_list(head)

    # Step 3: separate the original and cloned nodes from
    # the interleaved chain
    curr = head
    head_clone = curr.next
    while curr:
        clone = curr.next
        curr.next = clone.next
        curr = curr.next
        clone.next = curr.next if curr else None
    return head_clone




def run_tests():
    tests = [([[7, None], [13, 0], [11, 4], [10, 2], [1, 0]]),
             ([[10, 2], [20, None], [30, 0], [40, 3], [50, 1]]),
    ]
    for test in tests:
            head = test
            original = build_list_with_random_pointer(head)
            print(f"\n\n")
            for method in [1, 2, 3]:
                if method == 1:
                    replica = copyRandomList_1(dcp(original))
                elif method == 2:
                    replica = copyRandomList_2(dcp(original))
                elif method == 3:
                    replica = copyRandomList_3(dcp(original))
                print(f"\nMethod {method}:")
                print(f"Original List: {head}")
                print(f"Original Nodes:"); print_list(original)
                print(f"Replica Nodes:"); print_list(replica)
                passed = verify_deep_copy(original, replica)
                assert passed == True, f"Test case failed"
                print(f"Pass: {passed}")
    print(f"\nDONE")
run_tests()

# Example Usage matching LeetCode's Example 1:
# Input: [[7, null], [13, 0], [11, 4], [10, 2], [1, 0]]
#lc_input = [[7, None], [13, 0], [11, 4], [10, 2], [1, 0]]
#head = build_list_with_random_pointer(lc_input)
#print_list(head)
#head_d = copyRandomList_3(head)
#print(f"Clone")
#print_list(head_d)