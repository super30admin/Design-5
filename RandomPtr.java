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
public class RandomPtr {
    //TC = O(3n) SC = O(1)
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        //Step1
        Node curr = head;
        while(curr!=null){
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }
        //Step2
        curr = head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        //Step3:return new list
        curr = head;
        Node newHead = head.next;
        Node copyCurr = newHead;
        while(curr!=null){
            curr.next = curr.next.next;
            if(copyCurr.next!=null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return newHead;

    }
}
