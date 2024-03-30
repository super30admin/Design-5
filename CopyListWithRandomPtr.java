// Time Complexity : O(N) ,
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Approach : Maintain copy and deepcopy in the map to avoid search iteration and them make the list while iterating over original list.

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
        if(head == null) return head;

        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;

        while(curr != null){
            Node newNode = clone(curr,map);
            newNode.next = clone(curr.next,map);
            newNode.random = clone(curr.random,map);

            curr = curr.next;
        }

        return map.get(head);
    }

    private Node clone(Node node, HashMap<Node,Node> map){
        if(node == null) return node;
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }

        return map.get(node);
    }
}

// Time Complexity : O(N) ,
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Approach : Maintain deep copy node next to original node of the list.

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
        //create deep copy of list
        if(head == null) return head;

        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = curr.next.next;
        }

        // create random pointers
        curr = head;
        Node newCurr= curr.next;
        while(curr != null){
            if(curr.random != null){
                newCurr.random = curr.random.next;
            }

            curr = curr.next.next;
            if(newCurr.next != null)
                newCurr = newCurr.next.next;
        }

        //seperate the list
        curr = head;
        Node newHead = curr.next;
        newCurr = newHead;

        while(curr != null){
            curr.next = curr.next.next;
            if(newCurr.next != null)
                newCurr.next = newCurr.next.next;
            
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}