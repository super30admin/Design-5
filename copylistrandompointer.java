// tc: O(3n) -> O(n)
// sc: O(1)

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node dummy = new Node(2);
        Node cd = dummy;
        
        while(curr!=null){
            Node copy = new Node(curr.val);
            copy.next=curr.next;
            curr.next=copy;
            curr=curr.next.next;
     
        }
        
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr=curr.next.next;
        }
        curr = head;
        while(curr!=null){
            dummy.next = curr.next;
            dummy=dummy.next;
            curr.next=curr.next.next;
            curr=curr.next;
        }
        return cd.next;
    }
}
