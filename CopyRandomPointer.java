// Time Complexity : O(3n) where n - number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
        if(head == null) return null;
        Node curr = head;
        // creating adjacent new nodes
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
        // split the linked list
        curr = head;
        Node copy = head.next;
        Node copyHead = head.next;
        while(curr !=null){
            curr.next = curr.next.next;
            if(copy.next != null)
                copy.next = copy.next.next;
            curr = curr.next;
            copy = copy.next;
        }
        return copyHead;
    }
}

//Approach 2 : O(n) - space complexity
// Time Complexity : O(n) where n - number of nodes
// Space Complexity : O(n) for using HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(map.containsKey(head))
            return map.get(head);
        Node newNode = new Node(head.val,null,null);
        map.put(head,newNode);
        
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
