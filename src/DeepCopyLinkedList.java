import java.util.HashMap;
import java.util.Map;

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


class DeepCopyLinkedList {
    public Node copyRandomList(Node head) {
        Map<Node,Node> store = new HashMap<>();
        Node tmpHead = head;
        while(head!=null){
            Node current = clone(head,store);
            current.next = clone(head.next,store);
            current.random = clone(head.random,store);
            head = head.next;
        }
        return store.get(tmpHead);
    }
    private Node clone(Node original,Map<Node,Node> store ){
        if (original==null) return null;
        Node current = store.get(original);
        if(current ==null){
            Node tmp = new Node(original.val);
            store.put(original,tmp);
        }
        return store.get(original);

    }
}