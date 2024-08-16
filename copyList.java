// TC:O(n), sc:O(n)

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
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr.next!=null){
            Node copyNode = new Node(curr.next.val);
            map.put(curr.next,copyNode);
            copyCurr.next = copyNode;
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        curr = head;
        copyCurr = copyHead;
        while(curr!=null){
           if(curr.random!=null){
            copyCurr.random = map.get(curr.random);
           }
           curr=curr.next;
           copyCurr=copyCurr.next; 
        }
        return copyHead;
    }

}