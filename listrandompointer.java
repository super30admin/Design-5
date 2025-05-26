

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
public class listrandompointer {
    public Node copyRandomList(Node head) {
        if(head==null)
        {
            return head;
        }
        Node curr = head;

        // create new node and add it after curr node
        while(curr!=null){ // 1 -> 1' ->2 ->2'
            Node newnode = new Node(curr.val);
            newnode.next = curr.next;
            curr.next = newnode;
            curr = newnode.next;
        }

        // fill random pointer
            curr = head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
             curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        //break LL
        curr=head;
        Node newcurr = curr.next;
        Node newcopy = newcurr;
        while (curr !=null){
            curr.next = curr.next.next;
            if(newcopy.next ==null){
                break;
            }
            newcopy.next = newcopy.next.next;
            curr = curr.next;
            newcopy = newcopy.next;
        }
        return newcurr;
    }
}

