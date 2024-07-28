/*
    LC - 138. Copy List with Random Pointer
    TC - O(n)
    SC - O(1)
    Approach -  
        1. Create copy of the node, and place the copy next to the original node
        2. Fill the random pointer of each copy
        3. Break the linked list into two linked lists
*/

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
        if(head == null) {
            return null;
        }
        // 1. Create copy of the node, and place the copy next to the original node
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // 2. Fill the random pointer of each copy
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // 3. Break the linked list into two linked lists
        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;
        while(curr != null) {
            curr.next = copyCurr.next;
            if(copyCurr.next == null) {
                break;
            }
            copyCurr.next= copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}

/*
    LC - 138. Copy List with Random Pointer
    TC - O(n)
    SC - O(n) for hashmap
    Approach -
            Logic - Using Hashmap, Create a clone and store in Hashmap.
            So look up is O(1)

*/


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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr != null) {
            Node copyNode = clone(curr.next);
            copyCurr.next = copyNode;
            Node copyRandom = clone(curr.random);
            copyCurr.random = copyRandom;
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        return copyHead;
    }
    private Node clone(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}