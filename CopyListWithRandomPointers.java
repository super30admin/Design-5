// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointers {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //1. create a map to store all nodes and their copies
        //2. Assign new node's next and random by calling recursive functions

        if(map.containsKey(head)){
            return map.get(head);
        }

        Node node = new Node(head.val, null, null);

        map.put(head,node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
