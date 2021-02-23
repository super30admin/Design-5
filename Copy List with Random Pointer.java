// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    //create the master hashmap
    HashMap<Node, Node> hash;
    public Node copyRandomList(Node head) {
        //edge 
        if(head == null) return null;
        //initialize the map
        hash = new HashMap<>();
        //set a node that copies the head by calling our clone fucntion
        Node copyHead = clone(head);
        //set the current to head
        Node cur = head;
        //and a copy of the current
        Node copyCur = copyHead;
        //start a while loop to iterate through the node
        while(cur != null){
            //set the cur copy next to the clonded next
            copyCur.next = clone(cur.next);
            //set cur copy random to clone random
            copyCur.random = clone(cur.random);
            //move cur
            cur = cur.next;
            //move cur copy
            copyCur = copyCur.next;
        }
        return copyHead;
    }
    private Node clone(Node node){
        //check if null
        if(node == null) return null;
        //check if the map contains the node
        if(hash.containsKey(node)){
            //get the node and return it
            return hash.get(node);
        }
        //if it is not in the map make an entry in the map
        Node newNode = new Node(node.val);
        //put node in the map
        hash.put(node, newNode);
        //return the node
        return newNode;
    }
}