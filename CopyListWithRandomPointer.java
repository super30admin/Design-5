import java.util.HashMap;
import java.util.Map;

// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class CopyListWithRandomPointer {

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

    class Solution {
        public Node copyRandomList(Node head) {

            Map<Node,Node> map = new HashMap<>();
            Node dummy = new Node(-1);//temp node to keep track of head
            dummy.next = head;

            //iterate over linkedlist and make copy of node head and it's value in map, then advance head to next node
            while(head != null){
                Node copyNode = new Node(head.val);
                map.put(head,copyNode);
                head = head.next;
            }

            //iterate over linked list and assign next and random to copyNode, then advance head to next node
            head = dummy.next;
            while(head != null){
                Node copyNode = map.get(head);
                copyNode.next = map.get(head.next);
                copyNode.random = map.get(head.random);
                head = head.next;
            }
            return map.get(dummy.next);
        }
    }


}
