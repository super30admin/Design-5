// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First we will make copy of the original nodes and place them next to the original nodes
// in alternate fashion, original node then clone node then ...
// Now we will iterate over this and assign the random to the clone nodes
// random of clone nodes would be next of random of original nodes
// Now we will seperate the original and clone nodes and return the head of cloneLinkedList
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
        if(head == null){
            return null;
        }
        Node cur = head;
        // form original to clone
        while(cur != null){
            Node copyNode = new Node(cur.val);
            Node temp = cur.next;
            cur.next = copyNode;
            copyNode.next = temp;
            cur = temp;
        }
        //Set random for clone nodes
        cur = head;
        while(cur != null){
            if(cur.random != null)
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // Seperate original and clone
        cur = head;
        Node cloneHead = cur.next;
        while(cur != null){
            Node cloneNode = cur.next;
            cur.next = cloneNode.next;
            if(cloneNode.next != null)
                cloneNode.next = cloneNode.next.next;
            cur = cur.next;
        }
        return cloneHead;
    }
}