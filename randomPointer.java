// Time Complexity : O(n)
// Space Complexity : Approach 1: O(n), Approach 2: O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Single pass, O(n) space complexity solution
class Solution {
    Map<Node, Node> map;
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        map = new HashMap<Node, Node>();

        Node curr = head;
        Node new_curr = clone(head);
        Node return_head = new_curr;

        while (curr != null) {
            if(curr.random != null) {
                new_curr.random = clone(curr.random);
            }

            new_curr.next = clone(curr.next);

            curr = curr.next;
            new_curr = new_curr.next;
        }

        return return_head;
    }

    private Node clone(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node new_head = new Node(head.val);
        map.put(head, new_head);
        return new_head;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Triple pass, O(1) space complexity solution
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;

        Node curr = head;

        // Pass 1: To attach clones next to each element
        while(curr != null) {
            Node copyNode = new Node(curr.val);
            copyNode.next = curr.next;
            curr.next = copyNode;
            curr = curr.next.next;
        }

        // Pass 2: To add the random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Pass 3: To break the two Lists
        curr = head;
        Node returnNode = head.next;
        Node temp = curr.next;

        while (curr != null) {
            temp = curr.next;
            curr.next = temp.next;
            if (temp.next != null) {
                temp.next = curr.next.next;
            }
            curr = curr.next;
            temp = temp.next;
        }

        return returnNode;
    }
}