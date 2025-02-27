//TC: O(n)
//SC: O(1)
//approach: copy each node and place it next to its original node,
// then assign randoms in next iteration, then separate the two lists

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(null == head) return null;
        Node curr = head;
        while(null != curr){
            Node newnode = new Node(curr.val);
            newnode.next = curr.next;
            curr.next = newnode;
            curr = newnode.next;
        }

        curr = head;
        while(null != curr){
            if(null != curr.random){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node headCopy = head.next;
        Node currCopy = curr.next;
        while(null != curr){
            curr.next = curr.next.next;
            curr = curr.next;
            if (currCopy.next != null) {
                currCopy.next = currCopy.next.next;
                currCopy = currCopy.next;
            }
        }
        return headCopy;
    }
}

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
