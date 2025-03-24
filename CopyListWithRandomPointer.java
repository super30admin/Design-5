// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(n) - HashMap // PREFERRED
    // HashMap<Node, Node> map;
    // public Node copyRandomList(Node head) {
    //     if(head == null) return null;
    //     map = new HashMap<>();
    //     Node copyHead = clone(head);
    //     Node curr = head;
    //     Node copyCurr = copyHead;
    //     while(curr != null) {
    //         Node node = clone(curr.next);
    //         copyCurr.next = node; // mapping next
    //         node = clone(curr.random);
    //         copyCurr.random = node; // mapping random
    //         curr = curr.next; // moving original head
    //         copyCurr = copyCurr.next; // moving copied head
    //     }
    //     return copyHead;
    // }
    // private Node clone(Node node) { // if the node exists, return that or else create it, put it in the hashmap & return that
    //     if(node == null) return null;
    //     if(map.containsKey(node)) return map.get(node);
    //     Node newNode = new Node(node.val);
    //     map.put(node, newNode);
    //     return newNode;
    // }

    // TC = O(n), SC = O(1)
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        // 1. Create a copy of all nodes & place it to the next of original node
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        // 2. Set the random pointers of the copy nodes
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;  
        }
        // 3. Split the LL into 2 parts
        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;
        while(curr != null) {
            curr.next = curr.next.next;
            if(copyCurr.next == null) { // this is the last node, cant go copyCurr.next.next
                break;
            }
            copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}