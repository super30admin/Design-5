//TC will be O(n)
//SC will be O(n)

import java.util.HashMap;

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


class CopyListRanPointer {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }

        map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr != null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        return copyHead;
    }

    private Node clone(Node node){
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node copynode = new Node(node.val);
        map.put(node, copynode);
        return copynode;
    }


    public static void main(String[] args) {
        CopyListRanPointer obj = new CopyListRanPointer();

        // Create a mapping of indices to Node objects
        Node[] nodes = new Node[5];

        int[][] input = {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};

        for (int i = 0; i < input.length; i++) {
            nodes[i] = new Node(input[i][0]);
        }

        for (int i = 0; i < input.length; i++) {
            int randomIndex = input[i][1];
            nodes[i].random = (randomIndex == -1) ? null : nodes[randomIndex];
        }

        for (int i = 0; i < input.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Call the copyRandomList method with the head of the linked list
        Node copiedHead = obj.copyRandomList(nodes[0]);

        // You can work with the copied linked list as needed
    }

}