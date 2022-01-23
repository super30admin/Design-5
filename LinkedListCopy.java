//Time complexity:O(n)
//Space complexity:O(1)

class Solution {
    
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;
        while(curr!=null){
            Node cpynode=new Node(curr.val);
            cpynode.next=curr.next;
            curr.next=cpynode;
            curr=curr.next.next;
        }
        //setting the random pointers
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
                
            }
            curr=curr.next.next;  
        }
        //splitting the linkedlist
        curr=head;
        Node cpyhead=curr.next;
        Node currcpy=cpyhead;
        while(curr!=null){
            curr.next=curr.next.next;
            if(currcpy.next==null) break;
            currcpy.next=currcpy.next.next;
            curr=curr.next;
            currcpy=currcpy.next;
        }
        return cpyhead;
    }
 
}