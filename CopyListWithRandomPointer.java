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
// Approach : In two pass
// Time : O(2n)
// Space : O(n) // Store all the original nodes in the HashMap
class Solution {
    HashMap<Node , Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        this.map = new HashMap<>();
        Node curr = head;
        Node copyCurr = clone(head); // creates copy current
        // first pass
        while(curr.next!=null){
            copyCurr.next = clone(curr.next);
            curr = curr.next;
            copyCurr=copyCurr.next;
        }
        // second pass - make the random pointers point to copied Nodes
        curr = head;
        copyCurr = map.get(curr);
        while(curr!=null){
            if(curr.random != null){
                copyCurr.random = clone(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return map.get(head);

    }
    private Node clone(Node node){
        // creates a deep copy and returns the cloned node
        if(node == null) return null;
        if(!map.containsKey(node)){
            // creates a deepcopy of the original node and put it inside the map
            map.put(node,new Node(node.val));
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
// Approach : In one  pass but with extra space
// Time : O(n)
// Space : O(n) 
class Solution {
    HashMap<Node , Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        this.map = new HashMap<>();
        Node curr = head;
        Node copyCurr = clone(head); // creates copy current

        while(curr!=null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);

            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return map.get(head);

    }
    private Node clone(Node node){
        // creates a deep copy and returns the cloned node
        if(node == null) return null;
        if(!map.containsKey(node)){
            // creates a deepcopy of the original node and put it inside the map
            map.put(node,new Node(node.val));
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
// Approach : In three  pass but without extra space
// Time : O(3n)
// Space : O(1) 
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;

        // first pass make deep copies and place the copyCurr in between the original LL and form the connections
        while(curr!=null){
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next; // land on copyCurr's next
        }

        // Second pass created the random pointer
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr=curr.next.next;
        }
        
        // Third pass we seperate from original LL
        curr = head;
        Node copyCurr = curr.next; 
        Node copyHead = copyCurr;
        while(curr!=null){
            curr.next = curr.next.next;
            if(copyCurr.next!=null){
                copyCurr.next = copyCurr.next.next;
            }
            // keep moving the curr & copyCurr
            curr=curr.next;
            copyCurr = copyCurr.next;

        }
        return copyHead;
    }
}