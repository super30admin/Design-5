
//TC:O(N)
//SC:O(N)


class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null) return null;
        
        //if(head.next==null) return new Node(head.val);
        
        HashMap<Node,Node> map = new HashMap<>();
        
        Node dummy = new Node(-1);
        
        Node p =dummy;
        
        Node cur = head;
        
        while(head!=null)
        {
          dummy.next = new Node(head.val);
          dummy=dummy.next; 
          map.put(head,dummy);
          head=head.next;
        }
        dummy = p.next;
        while(cur!=null)
        {
          if(cur.random!=null)
           dummy.random = map.get(cur.random); 
 
           cur=cur.next;
           dummy = dummy.next;
        }
        
        return p.next;
    }
}