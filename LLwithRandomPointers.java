// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);
        Node curr = head.next;
        Node copyCurr = copyHead;

        while(curr != null){
            Node copyNext = new Node(curr.val);
            map.put(curr, copyNext);
            copyCurr.next = copyNext;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        curr = head;
        copyCurr = copyHead;
        while(curr != null){
            if(curr.random != null){
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}