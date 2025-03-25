

/*
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
*/
// Time Complexity: O(N) where N is number of nodes

class CopyList {

    // Space Complexity: O(N) for HashMap
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node curr = head;

        Map<Node, Node> map = new HashMap<>();

        while(curr != null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;

        while(curr != null){
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    // Space Complexity: O(1)
    public Node copyRandomListWithoutSpace(Node head) {
        if(head == null){
            return null;
        }

        // Create new nodes
        Node curr = head;

        while(curr != null){
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }

        // create random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // split the lists
        curr = head;
        Node copyCurr = head.next;
        Node copyHead = head.next;

        while(curr != null){
            curr.next = curr.next.next;

            if(copyCurr.next != null){
                //copyCurr.next = curr.next;
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        return copyHead;
    }
}

