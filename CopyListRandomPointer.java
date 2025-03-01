import java.util.HashMap;

//Time Complexity: O(n)
// Space Complexity: O(n)

public class CopyListRandomPointer {
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
    HashMap<Node,Node> hmap;
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        hmap = new HashMap<>();
        Node copyhead = clone(head);
        Node copyCurr = copyhead;
        Node curr = head;
        while(curr != null){
            Node newNext = clone(curr.next);
            copyCurr.next = newNext;
            Node nr = clone(curr.random);
            if(nr != null){
                copyCurr.random = nr;
            }
            copyCurr = newNext;
            curr = curr.next;
        }
        return copyhead;
    }

    public Node clone(Node node){
        if(node == null){
            return null;
        }
        if(hmap.containsKey(node)){
            return hmap.get(node);
        }
        Node newNode = new Node(node.val);
        hmap.put(node, newNode);
        return newNode;
    }
}
