class Solution {
    public Node copyRandomList(Node head) {
        Node n = head;
        while(n!=null){
            Node c = new Node(n.val);
            c.next = n.next;
            n.next = c;
            n = n.next.next;
        }
        n = head;
        while(n!=null){
            if(n.random!=null){
            Node c = n.next;
            c.random = n.random.next;}
            n = n.next.next;
        }

        
        Node aa;
        if(head != null){
        aa = head.next;
        }else{
            aa = head;
        }
        n = head;
        while(n!=null){
            Node a = n.next;
            n.next = a.next;
            if(a.next != null){
            a.next = a.next.next;}
            n = n.next;
        }
        return aa;
    }
}
//tc=O(n)
//sc=O(1)
