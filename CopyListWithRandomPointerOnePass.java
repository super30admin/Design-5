import java.util.HashMap;

public class CopyListWithRandomPointerOnePass {

        // ONE PASS - TIME O(N) AND SPACE O(N)

        // map original nodes to copy nodes
        HashMap< Node, Node > map = new HashMap<>();  // O(N) space

        public Node copyRandomList(Node head) {

            // null case
            if(head == null)     return null;

            // deep cody of head
            Node deepHead = new Node(head.val);

            // first entry in map
            map.put(head, deepHead);

            // keep pointers of head of list and (deep) head of copy list
            Node curr = head;
            Node currCopy = deepHead;

            // single pass
            // until we reach the end of list
            while(curr != null) {           // O(N) exactly

                // get deep copy of next pointer of current node
                currCopy.next = clone(curr.next);

                // get deep copy of random pointer of current node
                currCopy.random = clone(curr.random);

                // move current and current copy pointers ahead
                curr = curr.next;
                currCopy = currCopy.next;

            }

            // output head of copy list
            return deepHead;
        }

        // clone method to retrieve values from map
        private Node clone(Node node) {

            if(node == null)     return null;

            // if node is already present in map, return its value
            if(map.containsKey(node))    return map.get(node);

            // add node and its deep copy to map newly
            Node deepNode = new Node(node.val);

            map.put(node, deepNode);

            return deepNode;
        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(N)
*/