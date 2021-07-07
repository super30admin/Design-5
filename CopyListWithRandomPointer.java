// Time Complexity : O(n), n - > length of current list
// Space Complexity : O(n), will require n nodes as keys and n nodes as values in a map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I need to make a deep copy of the list with a random pointer.
// If we iterate and create another node, we can get reference of the next element. 
// However, random pointer can point anywhere. For instance, node 2 can point to the last node. Using this approach, newly created node cannot be assigned the random pointer as it may not exist at that point of time.
// Therefore, we need an alternate approach wherein we can save the original node for getting references to next and random nodes.
// Hence, using a hashmap to store original node as key and new node as value.

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
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node newList = head, newNode = null;
        while(curr != null) {
            newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(newList);
    }
}

