// Time Complexity : The time complexity is O(n) where n is the number of nodes
// Space Complexity : The space complexity is O(1)
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

        if(head == null){
            return null;
        }

        Node cur = head;

        // create a clone and append it to its original
        while(cur != null){

            Node copy = new Node(cur.val);

            copy.next = cur.next;
            cur.next = copy;

            cur = copy.next;

        }

        cur = head;

        // create clones random pointer
        while(cur != null){

            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        Node actualHead = head;
        Node newHead = head.next;

        Node oldCur = head;
        Node newCur = head.next;

        // separate original and clone
        while(oldCur != null){

            oldCur.next = newCur.next;
            if(newCur.next != null){
                newCur.next = newCur.next.next;
            }

            oldCur = oldCur.next;
            newCur = newCur.next;
        }

        return newHead;


    }
}