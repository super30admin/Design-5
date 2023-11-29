// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class CopyListRandomPointer {
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
            if(head == null)
                return head;

            Node curr = head;

            //create adjacent copy in original
            while(curr != null){
                Node newNode = new Node(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;

                curr = curr.next.next;
            }

            //assign random pointers
            curr = head;
            while(curr != null){
                if(curr.random != null){
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            //demodify the original list
            curr = head;
            Node copyHead = curr.next;
            Node copyCurr = copyHead;
            while(curr != null){
                curr.next = copyCurr.next;
                if(copyCurr.next != null)
                    copyCurr.next = copyCurr.next.next;

                curr = curr.next;
                copyCurr = copyCurr.next;
            }
            return copyHead;
        }
    }
}
