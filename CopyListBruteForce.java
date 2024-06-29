// Time Complexity : O(2n) where 'n' is the length of the string.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/copy-list-with-random-pointer/
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
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        map.put(head,copyHead);
        Node curr = head.next;
        Node copyCurr = copyHead;
        //make next pointers
        while(curr!=null){
            Node copyNext = new Node(curr.val);
            map.put(curr,copyNext);
            copyCurr.next = copyNext;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        // random pointers
        curr = head;
        copyCurr = copyHead;
        while(curr!=null){
            if(curr.random!=null){
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}
