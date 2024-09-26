//Time Complexity : O(n)
//Space Complexity : O(n)

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
        
        if(head==null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Node curr=head;
        Node head1=new Node(0);
        Node curr1=head1;
        
        while(curr!=null){
           curr1.next = new Node(curr.val);
           map.put(curr,curr1.next);
           curr1 = curr1.next;
           curr = curr.next; 
        }
        
        curr=head;
        curr1=head1.next;
        while(curr!=null && curr1!=null){
            curr1.random = map.get(curr.random); 
            curr=curr.next;
            curr1=curr1.next;
        }
        
        
        return head1.next;
    }
}