// Time Complexity : O(3N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node curr = head;

        // creates deep copies adjacent to its nodes
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        // assign random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        //split them
        curr = head;
        Node copyCurr = curr.next;
        Node copyHead = copyCurr;

        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}

// Time Complexity : O(2N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node copyHead = new Node(head.val);
        HashMap<Node,Node> map = new HashMap<>();

        // Two pointers
        Node curr = head;
        Node copyCurr = copyHead;

        map.put(head, copyHead);
        // one pass - to create deep copy
        while(curr.next != null){
            copyCurr.next = new Node(curr.next.val);
            map.put(curr.next, copyCurr.next);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        curr = head;
        copyCurr = copyHead;
        // second pass - to map random pointers
        while(curr != null){
            if(curr.random != null){
                copyCurr.random =  map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(N)
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {

        if(head == null) return null;
        Node copyHead = new Node(head.val);
        Node curr = head;
        Node copyCurr = copyHead;

        this.map = new HashMap<>();
        map.put(head, copyHead);
        // one pass solution
        while(curr != null) {
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;

        }

        return copyHead;
    }

    private Node clone(Node node) {
        if(node == null) return node;

        if(!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }

        return map.get(node);
    }
}




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
