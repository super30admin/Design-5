
public class CopyListWithRandoPointer {
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

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
    class Solution {
        Map<Node, Node> map;
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            map = new HashMap<>();
            Node curr = head;
            Node deepHead = clone(head);
            Node deepCurr = deepHead;
            while(curr != null) {
                deepCurr.next = clone(curr.next);
                deepCurr.random = clone(curr.random);
                curr = curr.next;
                deepCurr = deepCurr.next;
            }
            return deepHead;
        }

        private Node clone(Node node) {
            if(node == null) return node;
            if(!map.containsKey(node))
                map.put(node, new Node(node.val));
            return map.get(node);
        }
    }

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    class Solution1 {
        public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node curr = head;

            //Step 1: append deep node after its original node
            while(curr != null) {
                Node newNode = new Node(curr.val);
                newNode.next = curr.next;
                curr.next = newNode;
                curr = curr.next.next;
            }

            //step 2: make random pointers from original to respective deep nodes
            curr = head;
            while(curr != null) {
                if(curr.random !=  null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            //step 3: seperate origal and deep nodes
            curr = head;
            Node copyCurr = head.next;
            Node copyHead = copyCurr;
            while(curr != null){
                curr.next = curr.next.next;
                if(copyCurr.next!=null)
                    copyCurr.next = copyCurr.next.next;
                curr = curr.next;
                copyCurr = copyCurr.next;
            }
            return copyHead;
        }
    }
}
