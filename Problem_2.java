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

// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// 1) Create deep copy Node and put it next to each current node. and becuase of that move curr= curr.next.next.
// 2) Set all the copy's random to the actual random using curr.next.random = curr.random.next; take care of null case as curr.random may be null
// 3) remvoe the linking of curr and the copy node and return the actual copy result. take care of null case as currCopy.next may be null.
// Your code here along with comments explaining your approach
// without using hashmap
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // make a copy node
        while(curr != null){
            Node newCurr = new Node(curr.val);
            newCurr.next = curr.next;
            curr.next = newCurr;
            curr = curr.next.next;
        }
        curr = head;
        // make a random node
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        // remove the connections;
        curr = head;
        Node currCopy = head.next;
        Node result = head.next;
        while(curr !=null){
            curr.next = curr.next.next;
            if(currCopy.next != null)
                currCopy.next = currCopy.next.next;
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create a hashMap to store the node to clone mapping; then create a helper function which can be used to give the node from the map if present if not then create a new One and give to new one, then gothrough the curr head and find its next and random value and set it to the new cloned values.
//
// Using HashMap
// Your code here along with comments explaining your approach
// class Solution {
//     HashMap<Node, Node> hm;
//     public Node copyRandomList(Node head) {
//         if(head == null) return null;
//         hm = new HashMap<>();
//         Node result = clone(head);
//         Node ans = result;
//         Node curr = head;
//         while(curr != null){
//             //next
//             result.next = clone(curr.next);
//             //random
//             result.random = clone(curr.random);
//             curr = curr.next;
//             result = result.next;
//         }
//         return ans;
//     }

//     private Node clone(Node node){
//         if(node == null) return null;
//         if(hm.containsKey(node)) return hm.get(node);
//         Node newNode = new Node(node.val);
//         hm.put(node, newNode);
//         return newNode;
//     }
// }