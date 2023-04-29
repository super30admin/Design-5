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
// travel through linked list by making a copy of its next and random if its already not created
//TC-O(N),SC-O(N)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node deephead = new Node(head.val);
        Node curr = head;
        Node copycurr=deephead;
        HashMap<Node,Node> hm = new HashMap<>();
        hm.put(curr,deephead);
        while(curr!=null){
            if(curr.next!=null && !hm.containsKey(curr.next)){
                Node copy = new Node(curr.next.val);
                copycurr.next = copy;
                hm.put(curr.next,copy);
            }
            else{
                copycurr.next = hm.get(curr.next);
            }
            if(curr.random!=null){
                if(!hm.containsKey(curr.random)){
                    copycurr.random = new Node(curr.random.val);
                    hm.put(curr.random,copycurr.random);
                }
                else{
                    copycurr.random = hm.get(curr.random);
                }
        }
            curr=curr.next;
            copycurr=copycurr.next;
        }

    return deephead;
    }
}