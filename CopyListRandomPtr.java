// In this approach, using a hashmap to to store the node and it's copy node. Keep two pointers, one on head of original and other
// on head of copy linkedlist (curr and copycurr). Then check if curr.next in map, no means there is no copy of that next node, 
// so create it and store in map and set the next pointer of the copycurr node to this newnode. Then check if curr.random in map
// if not do same.

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // Hashmap for storing original node and it's corresponding copy node
    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        // Base case
        if (head == null) {
            return null;
        }
        // Initialize map
        map = new HashMap<>();
        // Create the copy of the head node
        Node copyHead = clone(head);
        // Two pointers, one on head of original ll
        Node curr = head;
        // Other on head of copy ll
        Node copyCurr = copyHead;
        // Loop till curr is not null
        while (curr != null) {
            // Create the copy of curr's next node if not else get the created one
            Node node = clone(curr.next);
            // Set the copy's next to that node
            copyCurr.next = node;
            // Create the copy of curr's random node if not else get the created one
            node = clone(curr.random);
            // Set the copy's random to that node
            copyCurr.random = node;
            // Move both pointers
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    private Node clone(Node node) {
        // If null return null
        if (node == null) {
            return null;
        }
        // Else check if the copy is already created, if it is than return that from the
        // map
        if (map.containsKey(node)) {
            return map.get(node);
        }
        // Else create a newnode
        Node newNode = new Node(node.val);
        // Put in map
        map.put(node, newNode);
        // Return that newnode
        return newNode;
    }
}

// O(1) space solution - In this approach, creating the copy of each node
// initially and placing next to it's corresponding original node. Then setting
// the random pointers for copy node. Then splitting the two LL.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public Node copyRandomList(Node head) {
        // Base case
        if (head == null) {
            return null;
        }
        // Set the pointer on the head
        Node curr = head;
        // For creating copy of each node and placing the copy next to it's original
        // node
        while (curr != null) {
            // Create a new node
            Node newNode = new Node(curr.val);
            // Original LL -: 1->2->3->4->5
            // Set the next of this newnode to next of curr (1`->2)
            newNode.next = curr.next;
            // Then place the copy node next to it's original node (1->1`) ...It will become
            // 1->1`->2->2`...
            curr.next = newNode;
            // Now move curr to node 2
            curr = curr.next.next;
        }
        // For setting the random pointers of copy nodes
        // Reset curr to head
        curr = head;
        // Loop till curr is not null
        while (curr != null) {
            // If curr.random is not null
            if (curr.random != null) {
                // Set the copy node's(which is present next to curr) random current's random's
                // next (which has a random's copy node)
                curr.next.random = curr.random.next;
            }
            // Then move to node 2
            curr = curr.next.next;
        }
        // For splitting the two linkedlists
        // Reset curr
        curr = head;
        // Create a head of copy LL
        Node copyHead = curr.next;
        // Put a pointer on it
        Node copyCurr = copyHead;
        // While curr is not null
        while (curr != null) {
            // Set 1.next = 1.next.next i.e. 2 .... LL previously looked like
            // 1->1`->2->2`... so make it 1->2
            curr.next = curr.next.next;
            // If we are at last node, break
            if (copyCurr.next == null) {
                break;
            }
            // Else make 1`->2`
            copyCurr.next = copyCurr.next.next;
            // Move both pointers
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        // Return the head of the copy list
        return copyHead;
    }
}