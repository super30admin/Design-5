package Design5;
//Time complexity : O(n)
//Space complexity: O(n)
import java.util.HashMap;

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
public class CopyListWithRandomPointer {
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node newHead = copy(head);
        Node curr = head;
        Node currCopy = newHead;

        while(curr != null){
            currCopy.next = copy(curr.next);
            currCopy.random = copy(curr.random);
            currCopy = currCopy.next;
            curr = curr.next;
        }
        return newHead;
    }

    private Node copy(Node node){
        if(node==null) return null;
        if(map.containsKey(node))
            return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}
